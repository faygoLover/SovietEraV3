package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

// Абстрактный класс для блоков, крепящихся к стене
public abstract class WallAttachedBlock extends Directional4MBlock {
    public WallAttachedBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace().getOpposite();
        if (clickedFace.getAxis().isHorizontal()) {
            BlockState state = this.defaultBlockState().setValue(FACING, clickedFace);
            if (state.canSurvive(context.getLevel(), context.getClickedPos())) {
                return state;
            }
        }
        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                BlockState state = this.defaultBlockState().setValue(FACING, direction);
                if (state.canSurvive(context.getLevel(), context.getClickedPos())) {
                    return state;
                }
            }
        }
        return null;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockPos behindPos = pos.relative(facing);
        return level.getBlockState(behindPos).isFaceSturdy(level, behindPos, facing);
    }

    @Override
    public BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (direction == state.getValue(FACING) && !state.canSurvive(level, pos)) {
            if (!level.isClientSide() && level instanceof Level serverLevel) {
                serverLevel.destroyBlock(pos, true);
            }
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
}
