package ru.soviet.blocks.baseblock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.utils.YShapeRotator;

public abstract class HorizontalDirectionalModelBlock extends ModelBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public HorizontalDirectionalModelBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public HorizontalDirectionalModelBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public HorizontalDirectionalModelBlock(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public HorizontalDirectionalModelBlock(Properties properties) {
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
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return YShapeRotator.rotateShape(shape, state.getValue(FACING));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return YShapeRotator.rotateShape(shape, state.getValue(FACING));
    }
}