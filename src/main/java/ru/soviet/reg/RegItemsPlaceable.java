package ru.soviet.reg;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.core.SovietEra;
import ru.soviet.items.BaseItem;

import java.util.function.Supplier;

public class RegItemsPlaceable {
    /*
    public static final DeferredRegister<Block> ITEMS_PLACEABLE = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);


    public static final RegistryObject<Item> SUGAR = ITEMS_PLACEABLE.register("sugar", () -> new BaseItem(new Item.Properties().stacksTo(1), "info.sugar"));
    public static final RegistryObject<Item> CONDENSED_MILK = ITEMS_PLACEABLE.register("condensed_milk", () -> new BaseItem(new Item.Properties().stacksTo(1), "info.condensed_milk"));


    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = ITEMS_PLACEABLE.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
     */
}
