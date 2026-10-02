package ru.soviet.blocks.paint;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.decorative.outerdeco.BaseStairs;
import ru.soviet.core.SovietEra;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * Перекраска железобетона: блоки, ступени и плиты девяти цветов, каждый в двух состояниях —
 * свежая краска и старая (облезшая). У блоков старое состояние — отдельный блок с суффиксом _br,
 * у ступеней и плит — свойство damaged.
 */
public final class ConcretePaint {
    public static final String GRAY = "gray";
    public static final List<String> COLORS = List.of("red", "orange", "yellow", "green", "blue", GRAY, "beige", "beige2", "white");

    public enum Kind { BLOCK, STAIRS, STAIRS_FULL, SLAB }

    // wornBlock имеет смысл только для Kind.BLOCK: это блок с суффиксом _br
    public record Entry(Kind kind, String color, boolean wornBlock) {}

    private static Map<Block, Entry> entries;

    private ConcretePaint() {
    }

    private static Block block(Kind kind, String color, boolean worn) {
        String path = switch (kind) {
            case BLOCK -> "concrete/concrete_" + color + (worn ? "_br" : "");
            case STAIRS -> "stairs/concrete_" + color + "_stairs";
            case STAIRS_FULL -> "stairs/concrete_" + color + "_stairs_full";
            case SLAB -> "slabs/concrete_slab_" + color;
        };
        ResourceLocation id = new ResourceLocation(SovietEra.MODID, path);
        if (!ForgeRegistries.BLOCKS.containsKey(id)) {
            throw new IllegalStateException("Concrete block is not registered: " + id);
        }
        return ForgeRegistries.BLOCKS.getValue(id);
    }

    private static Map<Block, Entry> entries() {
        if (entries == null) {
            Map<Block, Entry> map = new IdentityHashMap<>();
            for (String color : COLORS) {
                map.put(block(Kind.BLOCK, color, false), new Entry(Kind.BLOCK, color, false));
                map.put(block(Kind.BLOCK, color, true), new Entry(Kind.BLOCK, color, true));
                for (Kind kind : List.of(Kind.STAIRS, Kind.STAIRS_FULL, Kind.SLAB)) {
                    map.put(block(kind, color, false), new Entry(kind, color, false));
                }
            }
            entries = map;
        }
        return entries;
    }

    /** Описание блока, если его можно красить, иначе null. */
    @Nullable
    public static Entry get(BlockState state) {
        return entries().get(state.getBlock());
    }

    /** Старая (облезшая) краска или потрескавшийся бетон. */
    public static boolean isWorn(BlockState state, Entry entry) {
        return entry.kind() == Kind.BLOCK ? entry.wornBlock() : state.getValue(BaseStairs.DAMAGED);
    }

    /** Тот же блок (с тем же поворотом и формой), но другого цвета и состояния краски. */
    public static BlockState convert(BlockState state, Entry entry, String color, boolean worn) {
        BlockState result = block(entry.kind(), color, entry.kind() == Kind.BLOCK && worn).defaultBlockState();
        for (Property<?> property : state.getProperties()) {
            result = copyProperty(state, result, property);
        }
        if (entry.kind() != Kind.BLOCK) {
            // у BaseSlab своё свойство damaged, но оно равно свойству ступеней (то же имя и значения)
            result = result.setValue(BaseStairs.DAMAGED, worn);
        }
        return result;
    }

    private static <T extends Comparable<T>> BlockState copyProperty(BlockState from, BlockState to, Property<T> property) {
        return to.hasProperty(property) ? to.setValue(property, from.getValue(property)) : to;
    }
}
