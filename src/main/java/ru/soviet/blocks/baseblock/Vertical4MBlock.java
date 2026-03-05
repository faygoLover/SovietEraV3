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

public class Vertical4MBlock extends Directional4MBlock {
    public static final EnumProperty<ConnectionType> CONNECTION = EnumProperty.create("connection", ConnectionType.class);

    public enum ConnectionType implements StringRepresentable {
        NONE("none"), TOP("top"), BOTTOM("bottom"), CENTER("center");

        private final String name;

        ConnectionType(String name) { this.name = name; }

        @Override
        public @NotNull String getSerializedName() { return name; }
    }

    private final Map<ConnectionType, VoxelShape> shapesByConnection;

    public Vertical4MBlock(Properties properties, String hoverTextKey, VoxelShape noneShape, VoxelShape topShape, VoxelShape bottomShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, null);
        this.shapesByConnection = new EnumMap<>(ConnectionType.class);
        shapesByConnection.put(ConnectionType.NONE, noneShape != null ? noneShape : Shapes.block());
        shapesByConnection.put(ConnectionType.TOP, topShape != null ? topShape : Shapes.block());
        shapesByConnection.put(ConnectionType.BOTTOM, bottomShape != null ? bottomShape : Shapes.block());
        shapesByConnection.put(ConnectionType.CENTER, centerShape != null ? centerShape : Shapes.block());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CONNECTION, ConnectionType.NONE));
    }

    public Vertical4MBlock(Properties properties, VoxelShape noneShape, VoxelShape topShape, VoxelShape bottomShape, VoxelShape centerShape) {
        this(properties, "info.connectable", noneShape, topShape, bottomShape, centerShape);
    }

    public Vertical4MBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        this(properties, hoverTextKey, shape, shape, shape, shape);
    }

    public Vertical4MBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, Shapes.block(), Shapes.block(), Shapes.block(), Shapes.block());
    }

    public Vertical4MBlock(Properties properties, VoxelShape shape) {
        this(properties, "info.connectable", shape, shape, shape, shape);
    }

    public Vertical4MBlock(Properties properties) {
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
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        ConnectionType newConnection = getConnectionType(level, pos, state.getValue(FACING));
        if (newConnection != state.getValue(CONNECTION)) {
            return state.setValue(CONNECTION, newConnection);
        }
        return state;
    }

    private ConnectionType getConnectionType(BlockGetter level, BlockPos pos, Direction facing) {
        boolean up = hasNeighbour(level, pos, Direction.UP, facing);
        boolean down = hasNeighbour(level, pos, Direction.DOWN, facing);

        if (up && down) return ConnectionType.CENTER;
        if (up) return ConnectionType.BOTTOM;
        if (down) return ConnectionType.TOP;
        return ConnectionType.NONE;
    }

    protected boolean hasNeighbour(BlockGetter level, BlockPos pos, Direction dir, Direction facing) {
        BlockState neighbour = level.getBlockState(pos.relative(dir));
        return neighbour.is(this) && neighbour.getValue(FACING) == facing;
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