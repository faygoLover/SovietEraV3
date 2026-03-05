package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.utils.ShapeRotator;

public class DirectionalCornerBlock extends Directional4MBlock {
    public enum CornerType implements StringRepresentable {
        NOT("not"),
        LEFT("left"),
        RIGHT("right");

        private final String name;

        CornerType(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getSerializedName() {
            return name;
        }
    }
    public static final EnumProperty<CornerType> CORNER = EnumProperty.create("corner", CornerType.class);

    private final VoxelShape straightShape;
    private final VoxelShape leftCornerShape;
    private final VoxelShape rightCornerShape;

    public DirectionalCornerBlock(Properties properties, String hoverTextKey, VoxelShape straightShape, VoxelShape leftCornerShape, VoxelShape rightCornerShape) {
        super(properties, hoverTextKey, straightShape);
        this.straightShape = straightShape;
        this.leftCornerShape = leftCornerShape;
        this.rightCornerShape = rightCornerShape;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CORNER, CornerType.NOT));
    }

    public DirectionalCornerBlock(Properties properties, VoxelShape straightShape, VoxelShape leftCornerShape, VoxelShape rightCornerShape) {
        this(properties, "info.connectable", straightShape, leftCornerShape, rightCornerShape);
    }

    public DirectionalCornerBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        this(properties, hoverTextKey, shape, shape, shape);
    }

    public DirectionalCornerBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, Shapes.block(), Shapes.block(), Shapes.block());
    }

    public DirectionalCornerBlock(Properties properties, VoxelShape shape) {
        this(properties, "info.connectable", shape, shape, shape);
    }

    public DirectionalCornerBlock(Properties properties) {
        this(properties, "info.connectable", Shapes.block(), Shapes.block(), Shapes.block());
    }

    protected  CornerType getTargetCorner(BlockState state, BlockGetter world, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockState backState = world.getBlockState(pos.relative(facing.getOpposite()));
        if (backState.getBlock() == this) {
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

    private void updateCorner(BlockState state, Level level, BlockPos pos) {
        CornerType target = getTargetCorner(state, level, pos);
        if (target != state.getValue(CORNER)) {
            level.setBlock(pos, state.setValue(CORNER, target), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CORNER);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
        return state.setValue(CORNER, getTargetCorner(state, context.getLevel(), context.getClickedPos()));
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
        updateCorner(state, level, pos);
    }

    @Override
    public void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        updateCorner(state, level, pos);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape baseShape = switch (state.getValue(CORNER)) {
            case LEFT -> leftCornerShape;
            case RIGHT -> rightCornerShape;
            default -> straightShape;
        };
        return ShapeRotator.rotateShape(baseShape, state.getValue(FACING));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShape(state, world, pos, context);
    }
}