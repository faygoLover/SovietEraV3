package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.utils.ModelShapeBuilder;

public class SteelPylonBlock extends ConnectingPylonBlock {
    private static final String BASE_MODEL = "soviet:block/structural/steel_pylon";
    private static final String CONN_X_MODEL = "soviet:block/structural/steel_pylon_conn_x";
    private static final String CONN_Z_MODEL = "soviet:block/structural/steel_pylon_conn_z";
    private static final String DOWN_MODEL = "soviet:block/structural/steel_pylon_down";

    public SteelPylonBlock(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey);
    }

    @Override
    protected boolean shouldConnect(BlockGetter level, BlockPos pos, Direction dir, BlockState state) {
        BlockPos neighborPos = pos.relative(dir);
        BlockState neighborState = level.getBlockState(neighborPos);
        Block neighborBlock = neighborState.getBlock();

        if (neighborBlock instanceof SteelPylonBlock) return false;

        if (neighborBlock instanceof SteelPylonHorizontalBlock) {
            Direction.Axis horizontalAxis = neighborState.getValue(AXIS);
            if (dir == Direction.UP || dir == Direction.DOWN) {
                return horizontalAxis != state.getValue(AXIS);
            }
            return true;
        }

        if (dir == Direction.UP || dir == Direction.DOWN) {
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