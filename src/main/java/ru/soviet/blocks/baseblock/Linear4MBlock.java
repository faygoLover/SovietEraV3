package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.utils.ShapeRotator;

import java.util.EnumMap;
import java.util.Map;

public class Linear4MBlock extends Directional4MBlock {
    public static final EnumProperty<ConnectionType> CONNECTION = EnumProperty.create("connection", ConnectionType.class);

    public enum ConnectionType implements StringRepresentable {
        NONE("none"), LEFT("left"), RIGHT("right"), CENTER("center");

        private final String name;

        ConnectionType(String name) { this.name = name; }

        @Override
        public @NotNull String getSerializedName() { return name; }
    }

    private enum Side { LEFT, RIGHT }

    private final Map<ConnectionType, VoxelShape> shapesByConnection;

    public Linear4MBlock(Properties properties, String hoverTextKey,
                         VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, null);
        this.shapesByConnection = new EnumMap<>(ConnectionType.class);
        shapesByConnection.put(ConnectionType.NONE, noneShape != null ? noneShape : Shapes.block());
        shapesByConnection.put(ConnectionType.LEFT, leftShape != null ? leftShape : Shapes.block());
        shapesByConnection.put(ConnectionType.RIGHT, rightShape != null ? rightShape : Shapes.block());
        shapesByConnection.put(ConnectionType.CENTER, centerShape != null ? centerShape : Shapes.block());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CONNECTION, ConnectionType.NONE));
    }

    public Linear4MBlock(Properties properties, VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        this(properties, "info.connectable", noneShape, leftShape, rightShape, centerShape);
    }

    public Linear4MBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        this(properties, hoverTextKey, shape, shape, shape, shape);
    }

    public Linear4MBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, Shapes.block(), Shapes.block(), Shapes.block(), Shapes.block());
    }

    public Linear4MBlock(Properties properties, VoxelShape shape) {
        this(properties, "info.connectable", shape, shape, shape, shape);
    }

    public Linear4MBlock(Properties properties) {
        this(properties, "info.connectable", Shapes.block(), Shapes.block(), Shapes.block(), Shapes.block());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CONNECTION);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) return null;
        Direction facing = state.getValue(FACING);
        ConnectionType connection = getConnectionType(context.getLevel(), context.getClickedPos(), facing);
        return state.setValue(CONNECTION, connection);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState,
                                           @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        Direction facing = state.getValue(FACING);
        ConnectionType newConnection = getConnectionType(level, pos, facing);
        if (newConnection != state.getValue(CONNECTION)) {
            return state.setValue(CONNECTION, newConnection);
        }
        return state;
    }

    private ConnectionType getConnectionType(BlockGetter level, BlockPos pos, Direction facing) {
        boolean left = hasNeighbour(level, pos, facing, Side.LEFT);
        boolean right = hasNeighbour(level, pos, facing, Side.RIGHT);

        if (left && right) return ConnectionType.CENTER;
        if (right) return ConnectionType.RIGHT;
        if (left) return ConnectionType.LEFT;
        return ConnectionType.NONE;
    }

    private boolean hasNeighbour(BlockGetter level, BlockPos pos, Direction facing, Side side) {
        BlockPos offset = getOffsetPos(facing, side);
        BlockState neighbour = level.getBlockState(pos.offset(offset));
        return neighbour.is(this) && neighbour.getValue(FACING) == facing;
    }

    private BlockPos getOffsetPos(Direction facing, Side side) {
        return switch (facing) {
            case NORTH -> side == Side.LEFT ? new BlockPos(-1, 0, 0) : new BlockPos(1, 0, 0);
            case SOUTH -> side == Side.LEFT ? new BlockPos(1, 0, 0) : new BlockPos(-1, 0, 0);
            case EAST  -> side == Side.LEFT ? new BlockPos(0, 0, -1) : new BlockPos(0, 0, 1);
            case WEST  -> side == Side.LEFT ? new BlockPos(0, 0, 1) : new BlockPos(0, 0, -1);
            default -> BlockPos.ZERO;
        };
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return ShapeRotator.rotateShape(shapesByConnection.get(state.getValue(CONNECTION)), state.getValue(FACING));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShape(state, world, pos, context);
    }
}