package ru.soviet.reg;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.container.dsp.DspStorageMenu;
import ru.soviet.blocks.container.kitchen.KitchenStorageMenu;
import ru.soviet.blocks.container.safe.SafeStorageMenu;
import ru.soviet.core.SovietEra;
import ru.soviet.blocks.container.drawers.DrawerStorageMenu;

public class RegMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, SovietEra.MODID);

    public static final RegistryObject<MenuType<DrawerStorageMenu>> DRAWER_STORAGE =
            MENUS.register("drawer", () -> IForgeMenuType.create(DrawerStorageMenu::new));

    public static final RegistryObject<MenuType<SafeStorageMenu>> SAFE_STORAGE =
            MENUS.register("safe", () -> IForgeMenuType.create(SafeStorageMenu::new));

    public static final RegistryObject<MenuType<DspStorageMenu>> DSP_STORAGE =
            MENUS.register("dsp", () -> IForgeMenuType.create(DspStorageMenu::new));

    public static final RegistryObject<MenuType<KitchenStorageMenu>> KITCHEN_STORAGE =
            MENUS.register("kitchen", () -> IForgeMenuType.create(KitchenStorageMenu::new));
}