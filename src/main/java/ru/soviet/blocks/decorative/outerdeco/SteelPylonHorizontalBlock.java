package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.utils.ModelShapeBuilder;

public class SteelPylonHorizontalBlock extends ConnectingPylonBlock {
    private static final String BASE_MODEL = "soviet:block/structural/steel_pylon_horizontal";
    private static final String CONN_X_MODEL = "soviet:block/structural/steel_pylon_horizontal_conn_x";
    private static final String CONN_Z_MODEL = "soviet:block/structural/steel_pylon_horizontal_conn_z";
    private static final String DOWN_MODEL = "soviet:block/structural/steel_pylon_horizontal_down";

    public SteelPylonHorizontalBlock(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey);
    }

    @Override
    protected boolean shouldConnect(BlockGetter level, BlockPos pos, Direction dir, BlockState state) {
        BlockPos neighborPos = pos.relative(dir);
        BlockState neighborState = level.getBlockState(neighborPos);
        Block neighborBlock = neighborState.getBlock();

        if (neighborBlock instanceof SteelPylonBlock) {
            Direction.Axis myAxis = state.getValue(AXIS);
            Direction.Axis neighborAxis = neighborState.getValue(AXIS);
            boolean isAlongAxis = (myAxis == Direction.Axis.X && (dir == Direction.WEST  || dir == Direction.EAST)) ||
                    (myAxis == Direction.Axis.Z && (dir == Direction.NORTH || dir == Direction.SOUTH));
            return !isAlongAxis || myAxis == neighborAxis;
        }

        if (neighborBlock instanceof SteelPylonHorizontalBlock) {
            Direction.Axis myAxis = state.getValue(AXIS);
            Direction.Axis neighborAxis = neighborState.getValue(AXIS);
            return myAxis != neighborAxis;
        }

        Direction.Axis axis = state.getValue(AXIS);
        boolean isAlongAxis = (axis == Direction.Axis.X && (dir == Direction.WEST  || dir == Direction.EAST)) ||
                (axis == Direction.Axis.Z && (dir == Direction.NORTH || dir == Direction.SOUTH));
        if (isAlongAxis) {
            return neighborState.isSolid() && neighborState.isCollisionShapeFullBlock(level, neighborPos);
        }
        return false;
    }

    @Override
    protected VoxelShape buildShape(BlockState state) {
        Direction.Axis axis = state.getValue(AXIS);
        boolean isX = (axis == Direction.Axis.X);
        ModelShapeBuilder builder = new ModelShapeBuilder(VOLUME_THRESHOLD);

        double baseRotY = isX ? 90 : 0;
        builder.addModel(BASE_MODEL, baseRotY, 0, 0);

        addConnectionModels(builder, state, isX, DOWN_MODEL, CONN_X_MODEL, CONN_Z_MODEL);

        return builder.build();
    }
}