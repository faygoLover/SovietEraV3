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
import ru.soviet.utils.YShapeRotator;

import java.util.EnumMap;
import java.util.Map;


//HCMBlock = HorizontalConnectingModelBlock
public class HCMBlock extends HDMBlock {
    public static final EnumProperty<ConnectionType> CONNECTION = EnumProperty.create("connection", ConnectionType.class);

    public enum ConnectionType implements StringRepresentable {
        NONE("none"),
        LEFT("left"),
        RIGHT("right"),
        CENTER("center");

        private final String name;

        ConnectionType(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getSerializedName() {
            return name;
        }
    }

    private enum Side {
        SLEFT, SRIGHT
    }

    private final Map<ConnectionType, VoxelShape> shapesByConnection;

    public HCMBlock(Properties properties, String hoverTextKey, VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, null); // shape не используется, передаём null
        this.shapesByConnection = new EnumMap<>(ConnectionType.class);
        shapesByConnection.put(ConnectionType.NONE, noneShape != null ? noneShape : Shapes.block());
        shapesByConnection.put(ConnectionType.LEFT, leftShape != null ? leftShape : Shapes.block());
        shapesByConnection.put(ConnectionType.RIGHT, rightShape != null ? rightShape : Shapes.block());
        shapesByConnection.put(ConnectionType.CENTER, centerShape != null ? centerShape : Shapes.block());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CONNECTION, ConnectionType.NONE));
    }

    public HCMBlock(Properties properties, VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        this(properties, "info.connectable", noneShape, leftShape, rightShape, centerShape);
    }

    public HCMBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        this(properties, hoverTextKey, shape, shape, shape, shape);
    }

    public HCMBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null, null, null, null);
    }

    public HCMBlock(Properties properties, VoxelShape shape) {
        this(properties, "info.connectable", shape, shape, shape, shape);
    }

    public HCMBlock(Properties properties) {
        this(properties, "info.connectable", null, null, null, null);
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
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        Direction facing = state.getValue(FACING);
        ConnectionType newConnection = getConnectionType(level, pos, facing);
        if (newConnection != state.getValue(CONNECTION)) {
            return state.setValue(CONNECTION, newConnection);
        }
        return state;
    }

    private ConnectionType getConnectionType(BlockGetter level, BlockPos pos, Direction facing) {
        boolean leftConnected = hasNeighbour(level, pos, facing, Side.SLEFT);
        boolean rightConnected = hasNeighbour(level, pos, facing, Side.SRIGHT);

        if (leftConnected && rightConnected) {
            return ConnectionType.CENTER;
        } else if (rightConnected) {
            return ConnectionType.RIGHT;
        } else if (leftConnected) {
            return ConnectionType.LEFT;
        } else {
            return ConnectionType.NONE;
        }
    }

    private boolean hasNeighbour(BlockGetter level, BlockPos pos, Direction facing, Side side) {
        BlockState neighbourState = level.getBlockState(getOffsetPos(facing, side).offset(pos));
        return neighbourState.is(this) && neighbourState.getValue(FACING) == facing;
    }

    private BlockPos getOffsetPos(Direction facing, Side side) {
        return switch (facing) {
            case NORTH -> side == Side.SLEFT ? new BlockPos(-1, 0, 0) : new BlockPos(1, 0, 0);
            case SOUTH -> side == Side.SLEFT ? new BlockPos(1, 0, 0) : new BlockPos(-1, 0, 0);
            case EAST -> side == Side.SLEFT ? new BlockPos(0, 0, -1) : new BlockPos(0, 0, 1);
            case WEST -> side == Side.SLEFT ? new BlockPos(0, 0, 1) : new BlockPos(0, 0, -1);
            default -> BlockPos.ZERO;
        };
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return YShapeRotator.rotateShape(shapesByConnection.get(state.getValue(CONNECTION)), state.getValue(FACING));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return YShapeRotator.rotateShape(shapesByConnection.get(state.getValue(CONNECTION)), state.getValue(FACING));
    }
}