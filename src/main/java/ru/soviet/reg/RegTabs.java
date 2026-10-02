package ru.soviet.reg;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;

public class RegTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SovietEra.MODID);

    private static RegistryObject<CreativeModeTab> registerTabBefore(
            String name,
            Supplier<ItemStack> icon,
            String translationKey,
            String beforeTabId,
            CreativeModeTab.DisplayItemsGenerator displayItems) {
        return CREATIVE_MODE_TABS.register(name, () -> CreativeModeTab.builder()
                .icon(icon)
                .title(Component.translatable(translationKey))
                .withTabsBefore(new ResourceLocation(SovietEra.MODID, beforeTabId))
                .displayItems(displayItems)
                .build()
        );
    }

    public static final RegistryObject<CreativeModeTab> TAB_MAIN = CREATIVE_MODE_TABS.register("main_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(RegBlocksMain.CONCRETE_GRAY.get()))
                    .title(Component.translatable("creative_tab.main"))
                    .displayItems((params, out) -> RegBlocksMain.BLOCKS_MAIN.getEntries().forEach(block -> out.accept(block.get()))
                    )
                    .build()
    );

    public static final RegistryObject<CreativeModeTab> TAB_INNER_DECO = registerTabBefore(
            "inner_deco_tab",
            () -> new ItemStack(RegBlocksInner.SAFE.get()),
            "creative_tab.inner_deco",
            "main_tab",
            (params, out) -> RegBlocksInner.BLOCKS_INNER.getEntries().forEach(block -> out.accept(block.get()))
    );

    public static final RegistryObject<CreativeModeTab> TAB_OUTER_DECO = registerTabBefore(
            "outer_deco_tab",
            () -> new ItemStack(RegBlocksOuter.CONCRETE_FENCE_BASE.get()),
            "creative_tab.outer_deco",
            "inner_deco_tab",
            (params, out) -> RegBlocksOuter.BLOCKS_OUTER.getEntries().forEach(block -> out.accept(block.get()))
    );

    public static final RegistryObject<CreativeModeTab> TAB_SYMBOLS = registerTabBefore(
            "symbols_tab",
            () -> new ItemStack(RegBlocksSymbols.EX_PO.get()),
            "creative_tab.symbols",
            "outer_deco_tab",
            (params, out) -> RegBlocksSymbols.BLOCKS_SYMBOLS.getEntries().forEach(block -> out.accept(block.get()))
    );

    public static final RegistryObject<CreativeModeTab> TAB_ITEMS = registerTabBefore(
            "items_tab",
            () -> new ItemStack(RegItems.ARMATURE.get()),
            "creative_tab.items",
            "symbols_tab",
            (params, out) -> RegItems.ITEMS.getEntries().forEach(item -> out.accept(item.get()))
    );
}