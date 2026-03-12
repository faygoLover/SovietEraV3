package ru.soviet.blocks.entities.clock;

import com.mojang.math.Transformation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import ru.soviet.reg.RegBlockEntities;

import java.lang.reflect.Method;
import java.util.UUID;

public class ClockBlockEntity extends BlockEntity {
    private UUID displayEntityId;
    private int updateCounter = 0;

    // Методы рефлексии (кэшируем один раз)
    private static Method SET_BILLBOARD_METHOD;
    private static Method SET_BG_COLOR_METHOD;
    private static Method SET_LINE_WIDTH_METHOD;
    private static Method SET_TEXT_OPACITY_METHOD;
    private static Method SET_TEXT_METHOD;
    private static Method SET_TRANSFORMATION_METHOD;

    static {
        try {
            SET_BILLBOARD_METHOD = Display.class.getDeclaredMethod("setBillboardConstraints", Display.BillboardConstraints.class);
            SET_BILLBOARD_METHOD.setAccessible(true);
            SET_BG_COLOR_METHOD = Display.TextDisplay.class.getDeclaredMethod("setBackgroundColor", int.class);
            SET_BG_COLOR_METHOD.setAccessible(true);
            SET_LINE_WIDTH_METHOD = Display.TextDisplay.class.getDeclaredMethod("setLineWidth", int.class);
            SET_LINE_WIDTH_METHOD.setAccessible(true);
            SET_TEXT_OPACITY_METHOD = Display.TextDisplay.class.getDeclaredMethod("setTextOpacity", byte.class);
            SET_TEXT_OPACITY_METHOD.setAccessible(true);
            SET_TEXT_METHOD = Display.TextDisplay.class.getDeclaredMethod("setText", Component.class);
            SET_TEXT_METHOD.setAccessible(true);
            SET_TRANSFORMATION_METHOD = Display.class.getDeclaredMethod("setTransformation", Transformation.class);
            SET_TRANSFORMATION_METHOD.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(); // единственное место, где может быть ошибка
        }
    }

    public ClockBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.CLOCK.get(), pos, state);
    }

    public void tick() {
        if (level == null || level.isClientSide) return;

        BlockState state = level.getBlockState(worldPosition);
        boolean powered = state.getValue(ClockDisplay.POWERED);

        if (!powered) {
            removeDisplayEntity();
            return;
        }

        Entity entity = getDisplayEntity();
        if (!(entity instanceof Display.TextDisplay textDisplay)) {
            createDisplayEntity(state);
        } else {
            if (++updateCounter >= 20) {
                updateCounter = 0;
                updateDisplayText(textDisplay);
            }
        }
    }

    @Nullable
    private Entity getDisplayEntity() {
        if (displayEntityId == null || !(level instanceof ServerLevel serverLevel)) return null;
        return serverLevel.getEntity(displayEntityId);
    }

    private void createDisplayEntity(BlockState state) {
        if (level == null || level.isClientSide) return;

        removeDisplayEntity();

        Display.TextDisplay display = new Display.TextDisplay(EntityType.TEXT_DISPLAY, level);

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

        safeInvoke(SET_BILLBOARD_METHOD, display, Display.BillboardConstraints.FIXED);
        safeInvoke(SET_BG_COLOR_METHOD, display, 0);
        safeInvoke(SET_LINE_WIDTH_METHOD, display, 200);
        safeInvoke(SET_TEXT_OPACITY_METHOD, display, (byte) 255);
        safeInvoke(SET_TRANSFORMATION_METHOD, display,
                new Transformation(new Vector3f(), new Quaternionf(), new Vector3f(1.05f, 1.05f, 1.05f), new Quaternionf()));

        updateDisplayText(display);

        level.addFreshEntity(display);
        displayEntityId = display.getUUID();
        setChanged();
    }

    private void safeInvoke(Method method, Object target, Object... args) {
        try {
            if (method != null) method.invoke(target, args);
        } catch (Exception ignored) {}
    }

    public void removeDisplayEntity() {
        if (displayEntityId != null && level instanceof ServerLevel serverLevel) {
            Entity e = serverLevel.getEntity(displayEntityId);
            if (e != null) e.remove(Entity.RemovalReason.DISCARDED);
            displayEntityId = null;
            setChanged();
        }
    }

    private void updateDisplayText(Display.TextDisplay display) {
        if (level == null) return;

        long time = level.getDayTime() % 24000L;
        long totalMinutes = (time * 1440L) / 24000L;
        int hour = (int) ((totalMinutes / 60) + 6) % 24;
        int minute = (int) (totalMinutes % 60);

        String h = String.format("%02d", hour);
        String m = String.format("%02d", minute);

        MutableComponent text = Component.literal("")
                .append(Component.literal(h.substring(0, 1)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x2E8B57))))
                .append(Component.literal(".").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x000000))))
                .append(Component.literal(h.substring(1, 2)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x2E8B57))))
                .append(Component.literal(".").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x000000))))
                .append(Component.literal(".").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x2E8B57))))
                .append(Component.literal(".").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x000000))))
                .append(Component.literal(m.substring(0, 1)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x2E8B57))))
                .append(Component.literal(".").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x000000))))
                .append(Component.literal(m.substring(1, 2)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x2E8B57))));
        safeInvoke(SET_TEXT_METHOD, display, text);
    }

    public void onPoweredChanged(boolean powered) {
        if (level == null || level.isClientSide) return;
        if (powered && getDisplayEntity() == null) createDisplayEntity(level.getBlockState(worldPosition));
        else if (!powered) removeDisplayEntity();
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

    @Override
    public void setRemoved() {
        removeDisplayEntity();
        super.setRemoved();
    }
}