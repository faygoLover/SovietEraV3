package ru.soviet.core;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.entities.container.drawers.DrawerStorageScreen;
import ru.soviet.blocks.entities.container.safe.SafeStorageScreen;
import ru.soviet.blocks.entities.container.dsp.DspStorageScreen;
import ru.soviet.blocks.entities.container.kitchen.KitchenStorageScreen;
import ru.soviet.blocks.entities.holder.HolderBlockRenderer;
import ru.soviet.reg.RegBlockEntities;
import ru.soviet.reg.RegMenuTypes;
import ru.soviet.reg.RegEntities;

@Mod.EventBusSubscriber(modid = SovietEra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(RegMenuTypes.DRAWER_STORAGE.get(), DrawerStorageScreen::new);
            MenuScreens.register(RegMenuTypes.SAFE_STORAGE.get(), SafeStorageScreen::new);
            MenuScreens.register(RegMenuTypes.DSP_STORAGE.get(), DspStorageScreen::new);
            MenuScreens.register(RegMenuTypes.KITCHEN_STORAGE.get(), KitchenStorageScreen::new);
            BlockEntityRenderers.register(RegBlockEntities.HOLDER.get(), HolderBlockRenderer::new);
        });
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(RegEntities.SEAT.get(), (EntityRendererProvider.Context context) ->
                new EntityRenderer<Entity>(context) {
                    @Override
                    public void render(Entity entity, float entityYaw, float partialTicks,
                                       com.mojang.blaze3d.vertex.PoseStack poseStack,
                                       net.minecraft.client.renderer.MultiBufferSource buffer,
                                       int packedLight) {

                    }

                    @Override
                    public ResourceLocation getTextureLocation(@NotNull Entity entity) {
                        return null;
                    }
                }
        );
    }
}