package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.BaseBlock;
import ru.soviet.utils.ShapeRotator;
import net.minecraft.tags.BlockTags;

import java.util.WeakHashMap;

public class BarbWire extends BaseBlock {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    private final VoxelShape baseShape;
    private final VoxelShape connectionShape;

    // Кэши не статические: у каждого блока свои формы
    private final VoxelShape[] outlineCache = new VoxelShape[16];
    private final VoxelShape[] sidesCache = new VoxelShape[16];

    private static final WeakHashMap<Entity, Long> LAST_DAMAGE_TIME = new WeakHashMap<>();
    private static final WeakHashMap<Entity, Boolean> WAS_IN_DANGER_ZONE = new WeakHashMap<>();
    private static final WeakHashMap<Entity, BlockPos> PREVIOUS_POS = new WeakHashMap<>();

    public BarbWire(Properties properties, VoxelShape baseShape, VoxelShape connectionShape) {
        super(properties.noOcclusion(), "info.connectable");
        this.baseShape = baseShape;
        this.connectionShape = connectionShape;
        registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST);
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
        BlockState newState = currentState;
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            boolean shouldConnect = shouldConnectTo(level, pos, direction);
            newState = newState.setValue(getProperty(direction), shouldConnect);
        }
        return newState;
    }

    private boolean shouldConnectTo(Level level, BlockPos pos, Direction direction) {
        BlockPos neighborPos = pos.relative(direction);
        BlockState neighborState = level.getBlockState(neighborPos);
        Block neighborBlock = neighborState.getBlock();

        if (neighborBlock instanceof BarbWire) return true;
        if (neighborBlock instanceof net.minecraft.world.level.block.FenceBlock) return true;
        if (neighborBlock instanceof net.minecraft.world.level.block.IronBarsBlock) return true;
        if (neighborState.is(BlockTags.FENCES)) return true;
        if (neighborState.is(BlockTags.WALLS)) return true;

        VoxelShape collisionShape = neighborState.getCollisionShape(level, neighborPos);
        return collisionShape == Shapes.block();
    }

    private BooleanProperty getProperty(Direction direction) {
        return switch (direction) {
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            case EAST -> EAST;
            default -> NORTH;
        };
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        int index = getShapeIndex(state);
        VoxelShape cached = outlineCache[index];
        if (cached == null) {
            cached = createCombinedShape(state, baseShape, connectionShape);
            outlineCache[index] = cached;
        }
        return cached;
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return baseShape;
    }

    private static int getShapeIndex(BlockState state) {
        int index = 0;
        if (state.getValue(NORTH)) index |= 1 << 0;
        if (state.getValue(EAST)) index |= 1 << 1;
        if (state.getValue(SOUTH)) index |= 1 << 2;
        if (state.getValue(WEST)) index |= 1 << 3;
        return index;
    }

    private VoxelShape createCombinedShape(BlockState state, VoxelShape base, VoxelShape connection) {
        VoxelShape shape = base;
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (state.getValue(getProperty(direction))) {
                VoxelShape rotated = ShapeRotator.rotateShape(connection, direction.getOpposite());
                shape = Shapes.or(shape, rotated);
            }
        }
        return shape.optimize();
    }

    private VoxelShape getSidesOnlyShape(BlockState state) {
        int index = getShapeIndex(state);
        VoxelShape cached = sidesCache[index];
        if (cached == null) {
            cached = createSidesOnlyShape(state);
            sidesCache[index] = cached;
        }
        return cached;
    }

    private VoxelShape createSidesOnlyShape(BlockState state) {
        VoxelShape shape = Shapes.empty();
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (state.getValue(getProperty(direction))) {
                VoxelShape rotated = ShapeRotator.rotateShape(connectionShape, direction.getOpposite());
                shape = Shapes.or(shape, rotated);
            }
        }
        return shape.optimize();
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        // Урон и замедление считает сервер: статические карты ниже не рассчитаны на два потока
        if (level.isClientSide || !(entity instanceof LivingEntity living)) return;

        VoxelShape sidesShape = getSidesOnlyShape(state);
        AABB entityBox = entity.getBoundingBox();
        boolean inDangerZone = false;
        for (AABB aabb : sidesShape.toAabbs()) {
            if (entityBox.intersects(aabb.move(pos.getX(), pos.getY(), pos.getZ()))) {
                inDangerZone = true;
                break;
            }
        }

        Boolean wasInZone = WAS_IN_DANGER_ZONE.get(entity);
        boolean firstContact = !Boolean.TRUE.equals(wasInZone) && inDangerZone;

        if (inDangerZone) {
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 5, false, false, false));

            BlockPos currentBlockPos = entity.blockPosition();
            BlockPos prevPos = PREVIOUS_POS.get(entity);
            boolean moving = prevPos == null || !prevPos.equals(currentBlockPos);
            PREVIOUS_POS.put(entity, currentBlockPos);

            long currentTime = level.getGameTime();
            Long lastDamage = LAST_DAMAGE_TIME.get(entity);

            if (firstContact) {
                entity.hurt(level.damageSources().cactus(), 1.0F);
                LAST_DAMAGE_TIME.put(entity, currentTime);
            }
            else if (moving && (lastDamage == null || currentTime - lastDamage >= 60)) {
                entity.hurt(level.damageSources().cactus(), 1.0F);
                LAST_DAMAGE_TIME.put(entity, currentTime);
            }
        } else {
            // Замедление длится 5 тиков и спадает само; снимать его нельзя — это может быть эффект зелья
            PREVIOUS_POS.remove(entity);
        }

        WAS_IN_DANGER_ZONE.put(entity, inDangerZone);
    }
}