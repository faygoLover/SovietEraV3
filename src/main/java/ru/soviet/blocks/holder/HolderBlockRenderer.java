package ru.soviet.blocks.holder;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HolderBlockRenderer implements BlockEntityRenderer<HolderBlockEntity> {

    public HolderBlockRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(HolderBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState storedState = blockEntity.getStoredBlock();
        if (storedState == null || storedState.getRenderShape() != RenderShape.MODEL) return;

        int rotation = blockEntity.getRotation();

        BlockRenderDispatcher dispatcher = Minecraft.getInstance().getBlockRenderer();

        poseStack.pushPose();
        // Перемещаем в центр блока
        poseStack.translate(0.5, 0.5, 0.5);
        // Поворачиваем вокруг вертикальной оси
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        // Масштабируем (уменьшаем в 2 раза)
        poseStack.scale(0.5f, 0.5f, 0.5f);
        // Возвращаемся в угол (0,0,0) для отрисовки блока
        poseStack.translate(-0.5, -1, -0.5);

        dispatcher.renderSingleBlock(storedState, poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }
}