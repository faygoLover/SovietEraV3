package ru.soviet.reg;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.decorative.outerdeco.Symbols;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;

public class RegBlocksSymbols {
    public static final DeferredRegister<Block> BLOCKS_SYMBOLS = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);


    public static final RegistryObject<Block> SYMBOL_A = registerBlock("outerdeco/symbols/a", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_B = registerBlock("outerdeco/symbols/b", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_V = registerBlock("outerdeco/symbols/v", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_G = registerBlock("outerdeco/symbols/g", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_D = registerBlock("outerdeco/symbols/d", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_E = registerBlock("outerdeco/symbols/e", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_GE = registerBlock("outerdeco/symbols/ge", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_Z = registerBlock("outerdeco/symbols/z", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_I = registerBlock("outerdeco/symbols/i", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_IA = registerBlock("outerdeco/symbols/ia", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_K = registerBlock("outerdeco/symbols/k", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_L = registerBlock("outerdeco/symbols/l", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_M = registerBlock("outerdeco/symbols/m", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_N = registerBlock("outerdeco/symbols/n", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_O = registerBlock("outerdeco/symbols/o", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_P = registerBlock("outerdeco/symbols/p", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_R = registerBlock("outerdeco/symbols/r", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_S = registerBlock("outerdeco/symbols/s", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_T = registerBlock("outerdeco/symbols/t", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_U = registerBlock("outerdeco/symbols/u", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_F = registerBlock("outerdeco/symbols/f", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_H = registerBlock("outerdeco/symbols/h", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_CH = registerBlock("outerdeco/symbols/ch", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_SH = registerBlock("outerdeco/symbols/sh", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_SHC = registerBlock("outerdeco/symbols/shc", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_UI = registerBlock("outerdeco/symbols/ui", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_BI = registerBlock("outerdeco/symbols/bi", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_UE = registerBlock("outerdeco/symbols/ue", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_UY = registerBlock("outerdeco/symbols/uy", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_YA = registerBlock("outerdeco/symbols/ya", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_DASH = registerBlock("outerdeco/symbols/dash", () -> new Symbols (
            Shapes.box(
                    0.125, 0, 0.3125,
                    0.875, 0.5, 0.9375)
            )
    );
    public static final RegistryObject<Block> SYMBOL_ZERO = registerBlock("outerdeco/symbols/zero", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_ONE = registerBlock("outerdeco/symbols/one", () -> new Symbols (
            Shapes.or(
                    Shapes.box(
                            0.25, 0, 0.8125,
                            0.5625, 0.9375, 0.9375),
                    Shapes.box(
                            0.125, 0, 0.3125,
                            0.875, 0.5, 0.8125)
            )
    ));
    public static final RegistryObject<Block> SYMBOL_TWO = registerBlock("outerdeco/symbols/two", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_THREE = registerBlock("outerdeco/symbols/three", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_FOUR = registerBlock("outerdeco/symbols/four", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_FIVE = registerBlock("outerdeco/symbols/five", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_SIX = registerBlock("outerdeco/symbols/six", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_SEVEN = registerBlock("outerdeco/symbols/seven", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_EIGHT = registerBlock("outerdeco/symbols/eight", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_NINE = registerBlock("outerdeco/symbols/nine", Symbols::new);
    public static final RegistryObject<Block> SYMBOL_NUM = registerBlock("outerdeco/symbols/num", () -> new Symbols (
            Shapes.or(
                    Shapes.box(
                            0.0625, 0, 0.8125,
                            0.9375, 0.9375, 0.9375),
                    Shapes.box(
                            0.125, 0, 0.3125,
                            0.875, 0.5, 0.8125)
            )
    ));
    public static final RegistryObject<Block> EX_PO = registerBlock("outerdeco/symbols/ex_po", () -> new Symbols (
            Shapes.or(
                    Shapes.box(
                            0.4375, 0, 0.8125,
                            0.5625, 0.9375, 0.9375),
                    Shapes.box(
                            0.125, 0, 0.3125,
                            0.875, 0.5, 0.8125)
            )
    ));


    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS_SYMBOLS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
