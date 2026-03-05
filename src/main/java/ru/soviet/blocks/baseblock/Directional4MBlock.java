package ru.soviet.blocks.baseblock;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Directional4MBlock extends RotatedBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public Directional4MBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public Directional4MBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public Directional4MBlock(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public Directional4MBlock(Properties properties) {
        this(properties, null, null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    protected Direction getFacing(BlockState state) {
        return state.getValue(FACING);
    }

    @Override
    protected BlockState setFacing(BlockState state, Direction facing) {
        return state.setValue(FACING, facing);
    }
}