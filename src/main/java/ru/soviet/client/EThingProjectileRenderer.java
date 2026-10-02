package ru.soviet.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import ru.soviet.entity.EThingProjectile;
import ru.soviet.reg.RegItems;

public class EThingProjectileRenderer extends EntityRenderer<EThingProjectile> {
    private final ItemRenderer itemRenderer;

    public EThingProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(EThingProjectile entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light) {
        poseStack.pushPose();
        float age = entity.tickCount + partialTicks;
        // Только вращение вокруг оси X (фронтальная ось)
        poseStack.mulPose(Axis.XP.rotationDegrees(age * 30.0f));
        poseStack.scale(0.75f, 0.75f, 0.75f);
        ItemStack stack = new ItemStack(RegItems.E_THING.get());
        itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, light, OverlayTexture.NO_OVERLAY, poseStack, buffer, entity.level(), 0);
        poseStack.popPose();
        super.render(entity, yaw, partialTicks, poseStack, buffer, light);
    }

    @Override
    public ResourceLocation getTextureLocation(EThingProjectile entity) {
        return null; // используем модель предмета
    }
}