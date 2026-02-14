package ru.soviet.blocks.baseblock;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public abstract class ModelBlock extends BaseBlock {
    protected VoxelShape shape;

    public ModelBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties.noOcclusion(), hoverTextKey);
        this.shape = shape != null ? shape : Shapes.block();
    }

    public ModelBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, Shapes.block());
    }

    public ModelBlock(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public ModelBlock(Properties properties) {
        this(properties, null, Shapes.block());
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, net.minecraft.core.@NotNull BlockPos pos, @NotNull CollisionContext context) {
        return shape;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, net.minecraft.core.@NotNull BlockPos pos, @NotNull CollisionContext context) {
        return shape;
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
}