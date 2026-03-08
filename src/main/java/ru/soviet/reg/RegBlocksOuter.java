package ru.soviet.reg;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.baseblock.*;
import ru.soviet.blocks.decorative.outerdeco.Symbols;
import ru.soviet.blocks.decorative.outerdeco.Window;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;

public class RegBlocksOuter {
    public static final DeferredRegister<Block> BLOCKS_OUTER = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);

    public static final RegistryObject<Block> CONCRETE_FENCE_BASE = registerBlock("outerdeco/fences/concrete_fence_base", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //Окна
    public static final RegistryObject<Block> MODERN_WINDOW_EMPTY = registerBlock("innerdeco/windows/modern_window_empty", () -> new Window(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625)
                    ))
    );
    public static final RegistryObject<Block> MODERN_WINDOW = registerBlock("innerdeco/windows/modern_window", () -> new Window(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.1875)
            )
    );
    public static final RegistryObject<Block> MODERN_WINDOW_LEAF = registerBlock("innerdeco/windows/modern_window_leaf", () -> new Window(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.1875)
            )
    );
    public static final RegistryObject<Block> MODERN_WINDOW_LEAF_EMPTY = registerBlock("innerdeco/windows/modern_window_leaf_empty", () -> new Window(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.375, 0.03125,
                            1, 0.4375, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.3125, 0.03125,
                            1, 0.375, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.625, 0.03125,
                            1, 0.6875, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.375, 0.03125,
                            1, 0.4375, 0.15625)
            ))
    );
    public static final RegistryObject<Block> WOOD_WINDOW_EMPTY = registerBlock("innerdeco/windows/wood_window_empty", () -> new Window(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625)
            ))
    );
    public static final RegistryObject<Block> WOOD_WINDOW = registerBlock("innerdeco/windows/wood_window", () -> new Window(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.1875)
            )
    );
    public static final RegistryObject<Block> WOOD_WINDOW_LEAF = registerBlock("innerdeco/windows/wood_window_leaf", () -> new Window(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.1875)
            )
    );
    public static final RegistryObject<Block> WOOD_WINDOW_LEAF_EMPTY = registerBlock("innerdeco/windows/wood_window_leaf_empty", () -> new Window(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.375, 0.03125,
                            1, 0.4375, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0.875, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.3125, 0.03125,
                            1, 0.375, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            1, 0.125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.625, 0.03125,
                            1, 0.6875, 0.15625)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.03125,
                            0.125, 1, 0.15625),
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.875, 0, 0.03125,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.375, 0.03125,
                            1, 0.4375, 0.15625)
            ))
    );
    public static final RegistryObject<Block> FACTORY_WINDOW = registerBlock("outerdeco/factory_window", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.125)
            )
    );
    public static final RegistryObject<Block> FACTORY_WINDOW_EMPTY = registerBlock("outerdeco/factory_window_empty", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.03125, 0.125),
                    Shapes.box(
                            0, 0, 0,
                            0.03125, 1, 0.125),
                    Shapes.box(
                            0.96875, 0, 0,
                            1, 1, 0.125),
                    Shapes.box(
                            0, 0.96875, 0,
                            1, 1, 0.125)
            ))
    );

    public static final RegistryObject<Block> GRID_HALF_CIRCLE = registerBlock("outerdeco/streetdeco/grid_half_circle", () -> new Directional4H4x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.03125)
            )
    );
    public static final RegistryObject<Block> GRID_DIAGONAL = registerBlock("outerdeco/streetdeco/grid_diagonal", () -> new Directional4H4x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.03125)
            )
    );
    public static final RegistryObject<Block> GRID_FULL_DIAGONAL = registerBlock("outerdeco/streetdeco/grid_full_diagonal", () -> new Directional4H4x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.03125)
            )
    );
    public static final RegistryObject<Block> GRID_FULL_DIAGONAL_INVERT = registerBlock("outerdeco/streetdeco/grid_full_diagonal_invert", () -> new Directional4H4x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.03125)
            )
    );
    public static final RegistryObject<Block> MOSS = registerBlock("outerdeco/block_moss", () -> new Directional6MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.001)
            )
    );
    public static final RegistryObject<Block> MOSS_FULL = registerBlock("outerdeco/block_moss_full", () -> new Directional6MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.046875)
            )
    );
    public static final RegistryObject<Block> MOULD = registerBlock("outerdeco/block_mould", () -> new Directional6MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.03125)
            )
    );

    //Поручни
    public static final RegistryObject<Block> HANDHOLD = registerBlock("innerdeco/handhold/street_handhold", () -> new DirectionalCornerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.125),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.125),
                    Shapes.box(
                            0, 0, 0.125,
                            0.125, 1, 1)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.125),
                    Shapes.box(
                            0.875, 0, 0.125,
                            1, 1, 1)
            ))
    );
    public static final RegistryObject<Block> RUSTY_HANDHOLD = registerBlock("innerdeco/handhold/rusty_handhold", () -> new DirectionalCornerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.1875),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0, 0, 0.1875,
                            0.1875, 1, 1)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.1875),
                    Shapes.box(
                            0.8125, 0, 0.1875,
                            1, 1, 1)
            ))
    );
    public static final RegistryObject<Block> BALCONY_HANDHOLD = registerBlock("innerdeco/handhold/balcony_handhold", () -> new DirectionalCornerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, -0.015625,
                    1, 1, 0.078125),
            Shapes.or(
                    Shapes.box(
                            -0.015625, 0, -0.015625,
                            1, 1, 0.078125),
                    Shapes.box(
                            -0.015625, 0, 0.078125,
                            0.078125, 1, 1)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, -0.015625,
                            1, 1, 0.078125),
                    Shapes.box(
                            0.921875, 0, 0.078125,
                            1.015625, 1, 1.015625)
            ))
    );

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS_OUTER.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
