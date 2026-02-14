package ru.soviet.blocks.baseblock;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class ModelBlock extends BaseBlock {
    protected VoxelShape shape;

    public ModelBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey);
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
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, net.minecraft.core.BlockPos pos, CollisionContext context) {
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, net.minecraft.core.BlockPos pos, CollisionContext context) {
        return shape;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}