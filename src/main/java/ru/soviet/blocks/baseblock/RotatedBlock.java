package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.utils.YShapeRotator;

public abstract class RotatedBlock extends ModelBlock {

    public RotatedBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
    }

    public RotatedBlock(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey);
    }

    public RotatedBlock(Properties properties, VoxelShape shape) {
        super(properties, shape);
    }

    public RotatedBlock(Properties properties) {
        super(properties);
    }

    protected abstract Direction getFacing(BlockState state);

    protected abstract BlockState setFacing(BlockState state, Direction facing);

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return YShapeRotator.rotateShape(shape, getFacing(state));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return YShapeRotator.rotateShape(shape, getFacing(state));
    }
}