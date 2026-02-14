package ru.soviet.reg;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.core.SovietEra;


public class RegTabs extends CreativeModeTab {

    protected RegTabs(Builder builder) {
        super(builder);
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SovietEra.MODID);


    public static final RegistryObject<CreativeModeTab> TAB_MAIN = CREATIVE_MODE_TABS.register("main_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(RegBlocksMain.CONCRETE_GRAY.get()))
            .title(Component.translatable("creative_tab.main"))
            .displayItems((parameters, output) -> {
                RegBlocksMain.BLOCKS_MAIN.getEntries().forEach(block ->
                        output.accept(block.get())
                );
            })
            .build()
    );

    public static final RegistryObject<CreativeModeTab> TAB_INNER_DECO = CREATIVE_MODE_TABS.register("inner_deco_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(RegBlocksInner.SAFE.get()))
            .title(Component.translatable("creative_tab.inner_deco"))
            .displayItems((parameters, output) -> {
                output.accept(RegBlocksInner.SAFE.get());
                RegBlocksInner.BLOCKS_INNER.getEntries().forEach(block ->
                        output.accept(block.get())
                );
            })
            .build()
    );

    public static final RegistryObject<CreativeModeTab> TAB_OUTER_DECO = CREATIVE_MODE_TABS.register("outer_deco_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(RegBlocksOuter.CONCRETE_FENCE_BASE.get()))
            .title(Component.translatable("creative_tab.outer_deco"))
            .displayItems((parameters, output) -> {
                output.accept(RegBlocksOuter.CONCRETE_FENCE_BASE.get());
                RegBlocksOuter.BLOCKS_OUTER.getEntries().forEach(block ->
                        output.accept(block.get())
                );
            })
            .build()
    );

    public static final RegistryObject<CreativeModeTab> TAB_SYMBOLS = CREATIVE_MODE_TABS.register("symbols_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(RegBlocksSymbols.EX_PO.get()))
            .title(Component.translatable("creative_tab.symbols"))
            .displayItems((parameters, output) -> {
                output.accept(RegBlocksSymbols.EX_PO.get());
                RegBlocksSymbols.BLOCKS_SYMBOLS.getEntries().forEach(block ->
                        output.accept(block.get())
                );
            })
            .build()
    );

    public static final RegistryObject<CreativeModeTab> TAB_ITEMS = CREATIVE_MODE_TABS.register("items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(RegItems.ARMATURE.get()))
            .title(Component.translatable("creative_tab.items"))
            .displayItems((parameters, output) -> {
                RegItems.ITEMS.getEntries().forEach(block ->
                        output.accept(block.get())
                );
            })
            .build()
    );
}
