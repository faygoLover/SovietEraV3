package ru.soviet.reg;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.baseblock.*;
import ru.soviet.blocks.decorative.outerdeco.*;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;

public class RegBlocksOuter {
    public static final DeferredRegister<Block> BLOCKS_OUTER = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);

    private static BlockBehaviour.Properties ironProps() {
        return BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK);
    }

    private static BlockBehaviour.Properties ConcreteProps() {
        return BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE);
    }

    private static BlockBehaviour.Properties darkOakWoodProps() {
        return BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD);
    }

    // Тонкая пластина толщиной 0.03125 (1/32 блока) – используется для решёток и плесени
    private static final VoxelShape SHAPE_THIN_PLATE = Shapes.box(0, 0, 0, 1, 1, 0.03125);
    // Пластина толщиной 0.125 (2/16 блока) – используется для окон, напольной решётки
    private static final VoxelShape SHAPE_THICK_PLATE_0_125 = Shapes.box(0, 0, 0, 1, 1, 0.125);
    // Пластина толщиной 0.5 (8/16 блока) – для бетонных перил
    private static final VoxelShape SHAPE_RAILING = Shapes.box(0, 0, 0, 1, 1, 0.5);

    // Формы для окон (полная рамка, без верха, без низа, только бока) – используются для двух типов окон
    private static final VoxelShape WINDOW_FULL_FRAME = Shapes.or(
            Shapes.box(0, 0, 0, 1, 0.0625, 0.1875),
            Shapes.box(0, 0, 0.03125, 1, 0.125, 0.15625),
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.9375, 0, 1, 1, 0.1875),
            Shapes.box(0, 0.875, 0.03125, 1, 1, 0.15625)
    );

    private static final VoxelShape WINDOW_NO_TOP_FRAME = Shapes.or(
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.9375, 0, 1, 1, 0.1875),
            Shapes.box(0, 0.875, 0.03125, 1, 1, 0.15625)
    );

    private static final VoxelShape WINDOW_NO_BOTTOM_FRAME = Shapes.or(
            Shapes.box(0, 0, 0, 1, 0.0625, 0.1875),
            Shapes.box(0, 0, 0.03125, 1, 0.125, 0.15625),
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625)
    );

    private static final VoxelShape WINDOW_SIDES_ONLY = Shapes.or(
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625)
    );

    // Формы для окон с перекладиной
    private static final VoxelShape WINDOW_FULL_FRAME_LEAF = Shapes.or(
            Shapes.box(0, 0, 0, 1, 0.0625, 0.1875),
            Shapes.box(0, 0, 0.03125, 1, 0.125, 0.15625),
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.9375, 0, 1, 1, 0.1875),
            Shapes.box(0, 0.875, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.375, 0.03125, 1, 0.4375, 0.15625)
    );

    private static final VoxelShape WINDOW_NO_TOP_FRAME_LEAF = Shapes.or(
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.9375, 0, 1, 1, 0.1875),
            Shapes.box(0, 0.875, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.3125, 0.03125, 1, 0.375, 0.15625)
    );

    private static final VoxelShape WINDOW_NO_BOTTOM_FRAME_LEAF = Shapes.or(
            Shapes.box(0, 0, 0, 1, 0.0625, 0.1875),
            Shapes.box(0, 0, 0.03125, 1, 0.125, 0.15625),
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.625, 0.03125, 1, 0.6875, 0.15625)
    );

    private static final VoxelShape WINDOW_SIDES_ONLY_LEAF = Shapes.or(
            Shapes.box(0, 0, 0, 0.0625, 1, 0.1875),
            Shapes.box(0, 0, 0.03125, 0.125, 1, 0.15625),
            Shapes.box(0.9375, 0, 0, 1, 1, 0.1875),
            Shapes.box(0.875, 0, 0.03125, 1, 1, 0.15625),
            Shapes.box(0, 0.375, 0.03125, 1, 0.4375, 0.15625)
    );

    private static final VoxelShape LIGHTPOST_SHAPE = Shapes.or(
            Shapes.box(0.3125, 0, 0.3125, 0.6875, 1, 0.6875)
    );

    private static final VoxelShape WINDPROOF_BETON_SHAPE = Shapes.or(
            Shapes.box(0.25, 0, 0, 0.75, 1, 0.25),
            Shapes.box(0.375, 0, 0.25, 0.625, 1, 1)
    );

    // Регистрация блоков
    public static final RegistryObject<Block> CONCRETE_FENCE_BASE = registerBlock("outerdeco/fences/concrete_fence_base",
            () -> new Directional4MBlock(ConcreteProps(),
                    Shapes.or(
                            Shapes.box(0, 0, 0, 1, 0.375, 1),
                            Shapes.box(0.0625, 0.375, 0.0625, 0.9375, 0.75, 0.9375),
                            Shapes.box(0.125, 0.75, 0.125, 0.875, 1, 0.875)
                    )));

    public static final RegistryObject<Block> STREET_LIGHTPOST = registerBlock("outerdeco/streetdeco/street_lightpost",
            () -> new Lightpost(ConcreteProps(), LIGHTPOST_SHAPE));

    public static final RegistryObject<Block> STREET_LIGHTPOST2 = registerBlock("outerdeco/streetdeco/street_lightpost2",
            () -> new Lightpost(ConcreteProps(), LIGHTPOST_SHAPE));

    // Окна
    public static final RegistryObject<Block> MODERN_WINDOW_EMPTY = registerBlock("innerdeco/windows/modern_window_empty",
            () -> new Window(ironProps(),
                    WINDOW_FULL_FRAME,
                    WINDOW_NO_TOP_FRAME,
                    WINDOW_NO_BOTTOM_FRAME,
                    WINDOW_SIDES_ONLY));

    public static final RegistryObject<Block> MODERN_WINDOW = registerBlock("innerdeco/windows/modern_window",
            () -> new Window(ironProps(), SHAPE_THICK_PLATE_0_125));

    public static final RegistryObject<Block> MODERN_WINDOW_LEAF = registerBlock("innerdeco/windows/modern_window_leaf",
            () -> new Window(ironProps(), SHAPE_THICK_PLATE_0_125));

    public static final RegistryObject<Block> MODERN_WINDOW_LEAF_EMPTY = registerBlock("innerdeco/windows/modern_window_leaf_empty",
            () -> new Window(ironProps(),
                    WINDOW_FULL_FRAME_LEAF,
                    WINDOW_NO_TOP_FRAME_LEAF,
                    WINDOW_NO_BOTTOM_FRAME_LEAF,
                    WINDOW_SIDES_ONLY_LEAF));

    public static final RegistryObject<Block> WOOD_WINDOW_EMPTY = registerBlock("innerdeco/windows/wood_window_empty",
            () -> new Window(darkOakWoodProps(),
                    WINDOW_FULL_FRAME,
                    WINDOW_NO_TOP_FRAME,
                    WINDOW_NO_BOTTOM_FRAME,
                    WINDOW_SIDES_ONLY));

    public static final RegistryObject<Block> WOOD_WINDOW = registerBlock("innerdeco/windows/wood_window",
            () -> new Window(darkOakWoodProps(), SHAPE_THICK_PLATE_0_125));

    public static final RegistryObject<Block> WOOD_WINDOW_LEAF = registerBlock("innerdeco/windows/wood_window_leaf",
            () -> new Window(darkOakWoodProps(), SHAPE_THICK_PLATE_0_125));

    public static final RegistryObject<Block> WOOD_WINDOW_LEAF_EMPTY = registerBlock("innerdeco/windows/wood_window_leaf_empty",
            () -> new Window(darkOakWoodProps(),
                    WINDOW_FULL_FRAME_LEAF,
                    WINDOW_NO_TOP_FRAME_LEAF,
                    WINDOW_NO_BOTTOM_FRAME_LEAF,
                    WINDOW_SIDES_ONLY_LEAF));

    public static final RegistryObject<Block> FACTORY_WINDOW = registerBlock("outerdeco/factory_window",
            () -> new Directional4MBlock(ironProps(), SHAPE_THICK_PLATE_0_125));

    public static final RegistryObject<Block> FACTORY_WINDOW_EMPTY = registerBlock("outerdeco/factory_window_empty",
            () -> new Directional4MBlock(ironProps(),
                    Shapes.or(
                            Shapes.box(0, 0, 0, 1, 0.03125, 0.125),
                            Shapes.box(0, 0, 0, 0.03125, 1, 0.125),
                            Shapes.box(0.96875, 0, 0, 1, 1, 0.125),
                            Shapes.box(0, 0.96875, 0, 1, 1, 0.125)
                    )));

    // Решётки
    public static final RegistryObject<Block> GRID_HALF_CIRCLE = registerBlock("outerdeco/streetdeco/grid_half_circle",
            () -> new Directional4H4x2VMBlock(ironProps(), SHAPE_THIN_PLATE));

    public static final RegistryObject<Block> GRID_DIAGONAL = registerBlock("outerdeco/streetdeco/grid_diagonal",
            () -> new Directional4H4x2VMBlock(ironProps(), SHAPE_THIN_PLATE));

    public static final RegistryObject<Block> GRID_FULL_DIAGONAL = registerBlock("outerdeco/streetdeco/grid_full_diagonal",
            () -> new Directional4H4x2VMBlock(ironProps(), SHAPE_THIN_PLATE));

    public static final RegistryObject<Block> GRID_FULL_DIAGONAL_INVERT = registerBlock("outerdeco/streetdeco/grid_full_diagonal_invert",
            () -> new Directional4H4x2VMBlock(ironProps(), SHAPE_THIN_PLATE));

    public static final RegistryObject<Block> FLOOR_GRID = registerBlock("innerdeco/floor_grid",
            () -> new Directional4H2x2VMBlock(ironProps(), SHAPE_THICK_PLATE_0_125));

    public static final RegistryObject<Block> SLATE = registerBlock("innerdeco/slate",
            () -> new Directional4H2x2VMBlock(ironProps(), Shapes.box(0, 0, 0, 1, 1, 0.09375)));

    public static final RegistryObject<Block> MOSS = registerBlock("outerdeco/block_moss",
            () -> new Directional6MBlock(ironProps(), Shapes.box(0, 0, 0, 1, 1, 0.001)));

    public static final RegistryObject<Block> MOSS_FULL = registerBlock("outerdeco/block_moss_full",
            () -> new Directional6MBlock(ironProps(), Shapes.box(0, 0, 0, 1, 1, 0.046875)));

    public static final RegistryObject<Block> MOULD = registerBlock("outerdeco/block_mould",
            () -> new Directional6MBlock(ironProps(), SHAPE_THIN_PLATE));

    public static final RegistryObject<Block> STREET_LAMP = registerBlock("innerdeco/lamp/street_lamp",
            () -> new Directional4MBlock(ConcreteProps(),
                    Shapes.or(
                            Shapes.box(0.3125, 0.125, 0, 0.6875, 0.375, 0.0625),
                            Shapes.box(0.4375, 0.6875, 0, 0.5625, 0.8125, 0.125),
                            Shapes.box(0.34375, 0.8125, 0.4375, 0.65625, 1, 1)
                    )));

    // Поручни
    public static final RegistryObject<Block> HANDHOLD = registerBlock("innerdeco/handhold/street_handhold",
            () -> new DirectionalCornerBlock(ironProps(),
                    Shapes.box(0, 0, 0, 1, 1, 0.125),
                    Shapes.or(
                            Shapes.box(0, 0, 0, 1, 1, 0.125),
                            Shapes.box(0, 0, 0.125, 0.125, 1, 1)
                    ),
                    Shapes.or(
                            Shapes.box(0, 0, 0, 1, 1, 0.125),
                            Shapes.box(0.875, 0, 0.125, 1, 1, 1)
                    )));

    public static final RegistryObject<Block> RUSTY_HANDHOLD = registerBlock("innerdeco/handhold/rusty_handhold",
            () -> new DirectionalCornerBlock(ironProps(),
                    Shapes.box(0, 0, 0, 1, 1, 0.1875),
                    Shapes.or(
                            Shapes.box(0, 0, 0, 1, 1, 0.1875),
                            Shapes.box(0, 0, 0.1875, 0.1875, 1, 1)
                    ),
                    Shapes.or(
                            Shapes.box(0, 0, 0, 1, 1, 0.1875),
                            Shapes.box(0.8125, 0, 0.1875, 1, 1, 1)
                    )));

    public static final RegistryObject<Block> BALCONY_HANDHOLD = registerBlock("innerdeco/handhold/balcony_handhold",
            () -> new DirectionalCornerBlock(ironProps(),
                    Shapes.box(0, 0, -0.015625, 1, 1, 0.078125),
                    Shapes.or(
                            Shapes.box(-0.015625, 0, -0.015625, 1, 1, 0.078125),
                            Shapes.box(-0.015625, 0, 0.078125, 0.078125, 1, 1)
                    ),
                    Shapes.or(
                            Shapes.box(0, 0, -0.015625, 1, 1, 0.078125),
                            Shapes.box(0.921875, 0, 0.078125, 1.015625, 1, 1.015625)
                    )));
    public static final RegistryObject<Block> RUSTY_BARS = registerBlock("innerdeco/rusty_bars",
            () -> new FenceBlock(ironProps(),
            Shapes.box(0.375, 0, 0.375, 0.625, 1, 0.625),
            Shapes.box(0.375, 0, 0, 0.625, 1, 0.375)
    ));

    public static final RegistryObject<Block> BARB_WIRE = registerBlock("outerdeco/streetdeco/barb_wire",
            () -> new BarbWire(ironProps(),
                    Shapes.box(0.46875, 0, 0.46875, 0.53125, 0.9375, 0.53125), // центральный штырь
                    Shapes.box(0.46875, 0.09375, 0.53125, 0.53125, 0.921875, 1) // сторона
            ));

    // Пилоны
    public static final RegistryObject<Block> STEEL_PYLON = registerBlock("structural/steel_pylon",
            () -> new SteelPylonBlock(ironProps(), "info.connectable"));
    public static final RegistryObject<Block> STEEL_PYLON_HORIZONTAL = registerBlock("structural/steel_pylon_horizontal",
            () -> new SteelPylonHorizontalBlock(ironProps(), "info.connectable"));

    // Бетонные перила
    public static final RegistryObject<Block> CONCRETE_RAILING_REG = registerBlock("structural/concrete_railing_red",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));
    public static final RegistryObject<Block> CONCRETE_RAILING_ORANGE = registerBlock("structural/concrete_railing_orange",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));
    public static final RegistryObject<Block> CONCRETE_RAILING_YELLOW = registerBlock("structural/concrete_railing_yellow",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));
    public static final RegistryObject<Block> CONCRETE_RAILING_GREEN = registerBlock("structural/concrete_railing_green",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));
    public static final RegistryObject<Block> CONCRETE_RAILING_BLUE = registerBlock("structural/concrete_railing_blue",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));
    public static final RegistryObject<Block> CONCRETE_RAILING_BEIGE = registerBlock("structural/concrete_railing_beige",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));
    public static final RegistryObject<Block> CONCRETE_RAILING_BEIGE2 = registerBlock("structural/concrete_railing_beige2",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));
    public static final RegistryObject<Block> CONCRETE_RAILING_WHITE = registerBlock("structural/concrete_railing_white",
            () -> new Directional4H2x2VMBlock(ConcreteProps(), SHAPE_RAILING));

    // Ветрозащитные бетонные блоки
    public static final RegistryObject<Block> WINDPROOF_BETON_RED = registerBlock("outerdeco/streetdeco/windproof_beton_red",
            () -> new Directional4MBlock(ConcreteProps(), WINDPROOF_BETON_SHAPE));
    public static final RegistryObject<Block> WINDPROOF_BETON_ORANGE = registerBlock("outerdeco/streetdeco/windproof_beton_orange",
            () -> new Directional4MBlock(ConcreteProps(), WINDPROOF_BETON_SHAPE));
    public static final RegistryObject<Block> WINDPROOF_BETON_YELLOW = registerBlock("outerdeco/streetdeco/windproof_beton_yellow",
            () -> new Directional4MBlock(ConcreteProps(), WINDPROOF_BETON_SHAPE));
    public static final RegistryObject<Block> WINDPROOF_BETON_GREEN = registerBlock("outerdeco/streetdeco/windproof_beton_green",
            () -> new Directional4MBlock(ConcreteProps(), WINDPROOF_BETON_SHAPE));
    public static final RegistryObject<Block> WINDPROOF_BETON_BLUE = registerBlock("outerdeco/streetdeco/windproof_beton_blue",
            () -> new Directional4MBlock(ConcreteProps(), WINDPROOF_BETON_SHAPE));
    public static final RegistryObject<Block> WINDPROOF_BETON_BEIGE = registerBlock("outerdeco/streetdeco/windproof_beton_beige",
            () -> new Directional4MBlock(ConcreteProps(), WINDPROOF_BETON_SHAPE));
    public static final RegistryObject<Block> WINDPROOF_BETON_BEIGE2 = registerBlock("outerdeco/streetdeco/windproof_beton_beige2",
            () -> new Directional4MBlock(ConcreteProps(), WINDPROOF_BETON_SHAPE));

    // Антенна и балки
    public static final RegistryObject<Block> ANTENN = registerBlock("structural/antenn",
            () -> new VerticalMBlock(ironProps(), Shapes.box(0.375, 0, 0.375, 0.625, 1, 0.625)));

    public static final RegistryObject<Block> IRON_BEAM = registerBlock("structural/iron_beam",
            () -> new Directional4H2x2VMBlock(ironProps()));

    public static final RegistryObject<Block> IRON_BEAM_THIN = registerBlock("structural/iron_beam_thin",
            () -> new Directional4H2x2VMBlock(ironProps()));

    public static final RegistryObject<Block> IRON_BEAM_CONCRETE = registerBlock("structural/iron_beam_concrete",
            () -> new Directional4H2x2VMBlock(ironProps()));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS_OUTER.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}