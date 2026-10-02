package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.ModelBlock;


public class BaseSlab extends ModelBlock {
    public static final BooleanProperty DAMAGED = BooleanProperty.create("damaged");

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    private static final VoxelShape SHAPE_UP = Shapes.box(0, 0.5, 0, 1, 1, 1);   // снизу (лицевая сторона сверху)
    private static final VoxelShape SHAPE_DOWN = Shapes.box(0, 0, 0, 1, 0.5, 1); // сверху
    private static final VoxelShape SHAPE_NORTH = Shapes.box(0, 0, 0, 1, 1, 0.5);
    private static final VoxelShape SHAPE_SOUTH = Shapes.box(0, 0, 0.5, 1, 1, 1);
    private static final VoxelShape SHAPE_WEST = Shapes.box(0, 0, 0, 0.5, 1, 1);
    private static final VoxelShape SHAPE_EAST = Shapes.box(0.5, 0, 0, 1, 1, 1);

    public BaseSlab(Properties properties, String hoverTextKey) {
        super(properties.noOcclusion(), hoverTextKey);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        this.registerDefaultState(this.defaultBlockState().setValue(DAMAGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, DAMAGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getClickedFace().getOpposite());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case UP -> SHAPE_UP;
            case DOWN -> SHAPE_DOWN;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShape(state, level, pos, context);
    }
}