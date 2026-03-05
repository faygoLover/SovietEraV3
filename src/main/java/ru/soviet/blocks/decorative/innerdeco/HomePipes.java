package ru.soviet.blocks.decorative.innerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.DirectionalCornerBlock;
import ru.soviet.reg.RegBlocksInner;

public class HomePipes extends DirectionalCornerBlock {

    public HomePipes(Properties properties, String hoverTextKey, VoxelShape straightShape, VoxelShape leftCornerShape, VoxelShape rightCornerShape) {
        super(properties, hoverTextKey, straightShape, leftCornerShape, rightCornerShape);
    }

    public HomePipes(Properties properties, VoxelShape straightShape, VoxelShape leftCornerShape, VoxelShape rightCornerShape) {
        this(properties, "info.connectable", straightShape, leftCornerShape, rightCornerShape);
    }

    public HomePipes(Properties properties, String hoverTextKey, VoxelShape shape) {
        this(properties, hoverTextKey, shape, shape, shape);
    }

    public HomePipes(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, Shapes.block(), Shapes.block(), Shapes.block());
    }

    public HomePipes(Properties properties, VoxelShape shape) {
        this(properties, "info.connectable", shape, shape, shape);
    }

    public HomePipes(Properties properties) {
        this(properties, "info.connectable", Shapes.block(), Shapes.block(), Shapes.block());
    }

    @Override
    protected CornerType getTargetCorner(BlockState state, BlockGetter world, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockState backState = world.getBlockState(pos.relative(facing.getOpposite()));
        if (backState.getBlock() == this || backState.getBlock() == RegBlocksInner.HOME_PIPES_BATTERY.get()) {
            Direction backFacing = backState.getValue(FACING);
            if (backFacing.getAxis() != facing.getAxis()) {
                if (backFacing == facing.getCounterClockWise()) {
                    return CornerType.LEFT;
                } else if (backFacing == facing.getClockWise()) {
                    return CornerType.RIGHT;
                }
            }
        }
        return CornerType.NOT;
    }
}