package ru.soviet.blocks.decorative.innerdeco;

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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.BaseBlock;
import ru.soviet.blocks.baseblock.Directional4H2x2VMBlock;
import ru.soviet.reg.RegBlocksInner;
import ru.soviet.utils.ExtendedDirection4H2x2V;
import ru.soviet.utils.ShapeRotator;

import java.util.EnumMap;
import java.util.Map;

public class Ventpipe extends BaseBlock {

    public static final BooleanProperty DEFAULT = BooleanProperty.create("default");
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    // Маппинг направления на свойство
    private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = new EnumMap<>(Direction.class);
    static {
        PROPERTY_BY_DIRECTION.put(Direction.DOWN, DOWN);
        PROPERTY_BY_DIRECTION.put(Direction.UP, UP);
        PROPERTY_BY_DIRECTION.put(Direction.NORTH, NORTH);
        PROPERTY_BY_DIRECTION.put(Direction.SOUTH, SOUTH);
        PROPERTY_BY_DIRECTION.put(Direction.WEST, WEST);
        PROPERTY_BY_DIRECTION.put(Direction.EAST, EAST);
    }

    // Формы
    private static final VoxelShape SHAPE_DEFAULT = Shapes.or(
            Shapes.box(0.375, 0.3125, 0.375, 0.625, 0.6875, 0.625),
            Shapes.box(0.375, 0.375, 0.3125, 0.625, 0.625, 0.6875),
            Shapes.box(0.3125, 0.375, 0.375, 0.6875, 0.625, 0.625)
    );
    private static final VoxelShape SHAPE_SIDE_NORTH = Shapes.or(
            Shapes.box(0.28125, 0.28125, 0.265625, 0.71875, 0.71875, 0.375),
            Shapes.box(0.3125, 0.375, 0, 0.6875, 0.625, 0.265625),
            Shapes.box(0.375, 0.3125, 0, 0.625, 0.6875, 0.265625)
    );

    // Кэш комбинированных форм для всех возможных состояний (64 комбинации)
    private static final VoxelShape[] SHAPE_CACHE = new VoxelShape[64];

    public Ventpipe(Properties properties) {
        super(properties.noOcclusion(), "info.connectable");
        registerDefaultState(this.stateDefinition.any()
                .setValue(DEFAULT, true)
                .setValue(DOWN, false)
                .setValue(UP, false)
                .setValue(NORTH, false)
                .setValue(SOUTH, false)
                .setValue(EAST, false)
                .setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DEFAULT, DOWN, UP, NORTH, SOUTH, EAST, WEST);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        return getUpdatedState(level, pos, defaultBlockState());
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean isMoving) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, isMoving);
        BlockState newState = getUpdatedState(level, pos, state);
        if (!newState.equals(state)) {
            level.setBlock(pos, newState, Block.UPDATE_ALL);
        }
    }

    @Override
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (level instanceof Level l) {
            BlockState newState = getUpdatedState(l, pos, state);
            if (!newState.equals(state)) {
                return newState;
            }
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    private BlockState getUpdatedState(Level level, BlockPos pos, BlockState currentState) {
        BlockState newState = currentState.setValue(DEFAULT, true);
        for (Direction direction : Direction.values()) {
            BooleanProperty prop = PROPERTY_BY_DIRECTION.get(direction);
            if (prop != null) {
                boolean shouldConnect = shouldConnectTo(level, pos, direction);
                newState = newState.setValue(prop, shouldConnect);
            }
        }
        return newState;
    }

    private boolean shouldConnectTo(Level level, BlockPos pos, Direction direction) {
        BlockPos neighborPos = pos.relative(direction);
        BlockState neighborState = level.getBlockState(neighborPos);
        Block neighborBlock = neighborState.getBlock();

        // Соединение с таким же блоком
        if (neighborBlock instanceof Ventpipe) {
            return true;
        }

        // Соединение с базовым блоком трубы
        if (neighborBlock == RegBlocksInner.VENTPIPE_BASE.get()) {
            return true;
        }

        // Соединение с фильтром (только сверху/снизу)
        if (neighborBlock == RegBlocksInner.VENTPIPE_FILTER.get()) {
            return direction == Direction.UP || direction == Direction.DOWN;
        }

        // Соединение с круглым фильтром (стандартное свойство FACING)
        if (neighborBlock == RegBlocksInner.CIRCLE_FILTER.get()) {
            Direction filterFacing = neighborState.getValue(BlockStateProperties.FACING);
            return filterFacing.getOpposite() == direction;
        }

        // Соединение с прямоугольным фильтром (использует ExtendedDirection4H2x2V)
        if (neighborBlock == RegBlocksInner.REST_FILTER.get()) {
            ExtendedDirection4H2x2V extFacing = neighborState.getValue(Directional4H2x2VMBlock.FACING);
            Direction filterDir = convertExtendedDirectionToDirection(extFacing);
            return filterDir != null && filterDir.getOpposite() == direction;
        }

        return false;
    }

    @Nullable
    private Direction convertExtendedDirectionToDirection(ExtendedDirection4H2x2V extDir) {
        return switch (extDir) {
            case NORTH -> Direction.NORTH;
            case SOUTH -> Direction.SOUTH;
            case EAST -> Direction.EAST;
            case WEST -> Direction.WEST;
            case UP_X, UP_Z -> Direction.UP;
            case DOWN_X, DOWN_Z -> Direction.DOWN;
        };
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        int index = getShapeIndex(state);
        VoxelShape cached = SHAPE_CACHE[index];
        if (cached == null) {
            cached = createCombinedShape(state);
            SHAPE_CACHE[index] = cached;
        }
        return cached;
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShape(state, level, pos, context);
    }

    /**
     * Вычисляет индекс в кэше на основе активных сторон.
     * Бит 0: DOWN, бит 1: UP, бит 2: NORTH, бит 3: SOUTH, бит 4: WEST, бит 5: EAST.
     */
    private static int getShapeIndex(BlockState state) {
        int index = 0;
        if (state.getValue(DOWN)) index |= 1 << 0;
        if (state.getValue(UP)) index |= 1 << 1;
        if (state.getValue(NORTH)) index |= 1 << 2;
        if (state.getValue(SOUTH)) index |= 1 << 3;
        if (state.getValue(WEST)) index |= 1 << 4;
        if (state.getValue(EAST)) index |= 1 << 5;
        return index;
    }

    /**
     * Создаёт объединённую форму для данного состояния.
     */
    private static VoxelShape createCombinedShape(BlockState state) {
        VoxelShape shape = SHAPE_DEFAULT;
        for (Map.Entry<Direction, BooleanProperty> entry : PROPERTY_BY_DIRECTION.entrySet()) {
            if (state.getValue(entry.getValue())) {
                VoxelShape rotated = ShapeRotator.rotateShape(SHAPE_SIDE_NORTH, entry.getKey());
                shape = Shapes.or(shape, rotated);
            }
        }
        return shape;
    }
}