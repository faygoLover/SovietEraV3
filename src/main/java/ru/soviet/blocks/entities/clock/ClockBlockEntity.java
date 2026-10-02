package ru.soviet.blocks.entities.clock;

import com.mojang.math.Transformation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import ru.soviet.reg.RegBlockEntities;

import java.util.List;
import java.util.UUID;

public class ClockBlockEntity extends BlockEntity {
    // Метка на сущности-дисплее: по ней часы находят свой дисплей, даже если UUID потерялся
    private static final String DISPLAY_TAG = "soviet_clock";

    private UUID displayEntityId;
    private int updateCounter = 0;
    private String shownTime = "";

    public ClockBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.CLOCK.get(), pos, state);
    }

    public void tick() {
        if (!(level instanceof ServerLevel serverLevel)) return;

        BlockState state = getBlockState();
        if (!state.hasProperty(ClockDisplay.POWERED)) return;

        if (!state.getValue(ClockDisplay.POWERED)) {
            if (displayEntityId != null) removeDisplayEntity();
            return;
        }

        // Сущности чанка подгружаются отдельно от блоков. Пока они не загружены, дисплей "не найден",
        // и создавать новый нельзя, иначе после загрузки их станет два.
        if (!serverLevel.areEntitiesLoaded(ChunkPos.asLong(worldPosition))) return;

        Display.TextDisplay display = findDisplay(serverLevel);
        if (display == null) {
            createDisplayEntity(serverLevel, state);
        } else if (++updateCounter >= 20) {
            updateCounter = 0;
            updateDisplayText(display);
        }
    }

    @Nullable
    private Display.TextDisplay findDisplay(ServerLevel serverLevel) {
        if (displayEntityId != null && serverLevel.getEntity(displayEntityId) instanceof Display.TextDisplay display
                && !display.isRemoved()) {
            return display;
        }
        // UUID не подошёл: ищем помеченные дисплеи в блоке, лишние убираем
        List<Display.TextDisplay> found = taggedDisplays(serverLevel);
        if (found.isEmpty()) return null;
        for (int i = 1; i < found.size(); i++) {
            found.get(i).discard();
        }
        Display.TextDisplay display = found.get(0);
        displayEntityId = display.getUUID();
        setChanged();
        return display;
    }

    private List<Display.TextDisplay> taggedDisplays(ServerLevel serverLevel) {
        return serverLevel.getEntitiesOfClass(Display.TextDisplay.class, new AABB(worldPosition),
                e -> e.getTags().contains(DISPLAY_TAG));
    }

    private void createDisplayEntity(ServerLevel serverLevel, BlockState state) {
        Display.TextDisplay display = new Display.TextDisplay(EntityType.TEXT_DISPLAY, serverLevel);

        Direction facing = state.getValue(ClockDisplay.FACING).getOpposite();
        double x = worldPosition.getX() + 0.5;
        double y = worldPosition.getY() + 0.345;
        double z = worldPosition.getZ() + 0.5;

        switch (facing) {
            case NORTH: z += 0.359; break;
            case SOUTH: z -= 0.359; break;
            case WEST:  x += 0.359; break;
            case EAST:  x -= 0.359; break;
            default: break;
        }

        // Горизонтальное смещение (HORIZONTAL_OFFSET = 0.0128)
        switch (facing) {
            case NORTH: x += 0.0128; break;
            case SOUTH: x -= 0.0128; break;
            case WEST:  z -= 0.0128; break;
            case EAST:  z += 0.0128; break;
            default: break;
        }

        display.setPos(x, y, z);
        display.setYRot(facing.toYRot());
        display.setXRot(0);
        display.setNoGravity(true);
        display.setInvulnerable(true);
        display.addTag(DISPLAY_TAG);

        // Сеттеры Display приватные, а их имена в собранном моде другие (SRG), поэтому рефлексия по именам
        // работает только в IDE. Настраиваем дисплей через NBT, как это делает /data merge.
        // billboard и text_opacity оставлены по умолчанию (fixed и 255).
        String time = formatTime();
        CompoundTag tag = display.saveWithoutId(new CompoundTag());
        tag.putInt("background", 0);
        tag.putInt("line_width", 200);
        Transformation transformation = new Transformation(new Vector3f(), new Quaternionf(), new Vector3f(1.05f, 1.05f, 1.05f), new Quaternionf());
        Transformation.EXTENDED_CODEC.encodeStart(NbtOps.INSTANCE, transformation)
                .result().ifPresent(encoded -> tag.put("transformation", encoded));
        tag.putString("text", Component.Serializer.toJson(buildText(time)));
        display.load(tag);

        serverLevel.addFreshEntity(display);
        displayEntityId = display.getUUID();
        shownTime = time;
        setChanged();
    }

    public void removeDisplayEntity() {
        if (!(level instanceof ServerLevel serverLevel)) return;
        if (displayEntityId != null) {
            Entity e = serverLevel.getEntity(displayEntityId);
            if (e != null) e.discard();
            displayEntityId = null;
            setChanged();
        }
        taggedDisplays(serverLevel).forEach(Entity::discard);
        shownTime = "";
    }

    private String formatTime() {
        long time = level == null ? 0 : level.getDayTime() % 24000L;
        long totalMinutes = (time * 1440L) / 24000L;
        int hour = (int) ((totalMinutes / 60) + 6) % 24;
        int minute = (int) (totalMinutes % 60);
        return String.format("%02d%02d", hour, minute);
    }

    private static MutableComponent buildText(String time) {
        Style digit = Style.EMPTY.withColor(TextColor.fromRgb(0x2E8B57));
        Style gap = Style.EMPTY.withColor(TextColor.fromRgb(0x000000));
        return Component.literal("")
                .append(Component.literal(time.substring(0, 1)).withStyle(digit))
                .append(Component.literal(".").withStyle(gap))
                .append(Component.literal(time.substring(1, 2)).withStyle(digit))
                .append(Component.literal(".").withStyle(gap))
                .append(Component.literal(".").withStyle(digit))
                .append(Component.literal(".").withStyle(gap))
                .append(Component.literal(time.substring(2, 3)).withStyle(digit))
                .append(Component.literal(".").withStyle(gap))
                .append(Component.literal(time.substring(3, 4)).withStyle(digit));
    }

    private void updateDisplayText(Display.TextDisplay display) {
        String time = formatTime();
        if (time.equals(shownTime)) return;
        CompoundTag tag = display.saveWithoutId(new CompoundTag());
        tag.putString("text", Component.Serializer.toJson(buildText(time)));
        display.load(tag);
        shownTime = time;
    }

    public void onPoweredChanged(boolean powered) {
        if (!(level instanceof ServerLevel serverLevel)) return;
        if (!powered) {
            removeDisplayEntity();
        } else if (findDisplay(serverLevel) == null) {
            createDisplayEntity(serverLevel, getBlockState());
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        if (displayEntityId != null) tag.putUUID("DisplayEntity", displayEntityId);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        displayEntityId = tag.hasUUID("DisplayEntity") ? tag.getUUID("DisplayEntity") : null;
    }
}
