package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.BaseBlock;
import ru.soviet.utils.ModelShapeBuilder;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ConnectingPylonBlock extends BaseBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    protected static final double VOLUME_THRESHOLD = 0.006;

    protected static final Map<Direction, BooleanProperty> DIR_TO_PROP = new EnumMap<>(Direction.class);
    static {
        DIR_TO_PROP.put(Direction.NORTH, NORTH);
        DIR_TO_PROP.put(Direction.SOUTH, SOUTH);
        DIR_TO_PROP.put(Direction.WEST, WEST);
        DIR_TO_PROP.put(Direction.EAST, EAST);
        DIR_TO_PROP.put(Direction.UP, UP);
        DIR_TO_PROP.put(Direction.DOWN, DOWN);
    }

    private final Map<Integer, VoxelShape> shapeCache = new ConcurrentHashMap<>();

    public ConnectingPylonBlock(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey);
        registerDefaultState(stateDefinition.any()
                .setValue(AXIS, Direction.Axis.Z)
                .setValue(NORTH, false).setValue(SOUTH, false)
                .setValue(WEST, false).setValue(EAST, false)
                .setValue(UP, false).setValue(DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, NORTH, SOUTH, WEST, EAST, UP, DOWN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction.Axis axis = context.getHorizontalDirection().getAxis();
        BlockState state = defaultBlockState().setValue(AXIS, axis);
        for (Direction dir : Direction.values()) {
            state = state.setValue(DIR_TO_PROP.get(dir), shouldConnect(level, pos, dir, state));
        }
        return state;
    }

    @Override
    public BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState,
                                  @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        boolean shouldConnect = shouldConnect(level, pos, direction, state);
        if (state.getValue(DIR_TO_PROP.get(direction)) != shouldConnect) {
            return state.setValue(DIR_TO_PROP.get(direction), shouldConnect);
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                                @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean isMoving) {
        int dx = neighborPos.getX() - pos.getX();
        int dy = neighborPos.getY() - pos.getY();
        int dz = neighborPos.getZ() - pos.getZ();
        Direction dir = Direction.fromDelta(dx, dy, dz);
        if (dir == null) return;

        boolean shouldConnect = shouldConnect(level, pos, dir, state);
        if (state.getValue(DIR_TO_PROP.get(dir)) != shouldConnect) {
            level.setBlock(pos, state.setValue(DIR_TO_PROP.get(dir), shouldConnect), 3);
        }
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, isMoving);
    }

    protected abstract boolean shouldConnect(BlockGetter level, BlockPos pos, Direction dir, BlockState state);

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                        @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShapeForState(state);
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level,
                                                 @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShapeForState(state);
    }

    private VoxelShape getShapeForState(BlockState state) {
        int hash = getShapeHash(state);
        return shapeCache.computeIfAbsent(hash, h -> buildShape(state));
    }

    private int getShapeHash(BlockState state) {
        int hash = (state.getValue(AXIS) == Direction.Axis.X ? 1 : 0);
        hash |= (state.getValue(NORTH) ? 1 << 1 : 0);
        hash |= (state.getValue(SOUTH) ? 1 << 2 : 0);
        hash |= (state.getValue(WEST)  ? 1 << 3 : 0);
        hash |= (state.getValue(EAST)  ? 1 << 4 : 0);
        hash |= (state.getValue(UP)    ? 1 << 5 : 0);
        hash |= (state.getValue(DOWN)  ? 1 << 6 : 0);
        return hash;
    }

    protected abstract VoxelShape buildShape(BlockState state);

    protected void addConnectionModels(ModelShapeBuilder builder, BlockState state, boolean isX,
                                       String downModel, String connXModel, String connZModel) {
        for (Direction dir : Direction.values()) {
            if (!state.getValue(DIR_TO_PROP.get(dir))) continue;

            String model;
            double rotY = 0, rotX = 0, rotZ = 0;

            if (dir == Direction.DOWN) {
                model = downModel;
                rotY = isX ? 90 : 0;
            } else if (dir == Direction.UP) {
                model = downModel;
                rotY = isX ? 90 : 0;
                rotX = 180;
            } else {
                if ((!isX && (dir == Direction.EAST || dir == Direction.WEST)) ||
                        (isX && (dir == Direction.NORTH || dir == Direction.SOUTH))) {
                    model = connXModel;
                } else {
                    model = connZModel;
                }

                if (!isX) {
                    switch (dir) {
                        case EAST, NORTH:  rotY = 0;   break;
                        case WEST, SOUTH:  rotY = 180; break;
                        default: break;
                    }
                } else {
                    switch (dir) {
                        case EAST, SOUTH:  rotY = 90;  break;
                        case WEST, NORTH:  rotY = 270; break;
                        default: break;
                    }
                }
            }
            builder.addModel(model, rotY, rotX, rotZ);
        }
    }
}