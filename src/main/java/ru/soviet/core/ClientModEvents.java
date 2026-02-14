
package ru.soviet.core;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import ru.soviet.blocks.container.drawers.DrawerStorageScreen;
import ru.soviet.blocks.container.safe.SafeStorageScreen;
import ru.soviet.blocks.container.dsp.DspStorageScreen;
import ru.soviet.reg.RegMenuTypes;

@Mod.EventBusSubscriber(modid = SovietEra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(RegMenuTypes.DRAWER_STORAGE.get(), DrawerStorageScreen::new);
            MenuScreens.register(RegMenuTypes.SAFE_STORAGE.get(), SafeStorageScreen::new);
            MenuScreens.register(RegMenuTypes.DSP_STORAGE.get(), DspStorageScreen::new);
        });
    }
}