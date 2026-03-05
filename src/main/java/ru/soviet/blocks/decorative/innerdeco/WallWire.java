package ru.soviet.blocks.decorative.innerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.DirectionalCornerBlock;
import ru.soviet.reg.RegBlocksInner;

import java.util.EnumSet;
import java.util.Set;

public class WallWire extends DirectionalCornerBlock {
    public static final IntegerProperty POWER = RedStoneWireBlock.POWER;

    public WallWire(Properties properties, String hoverTextKey, VoxelShape straightShape, VoxelShape leftCornerShape, VoxelShape rightCornerShape) {
        super(properties, hoverTextKey, straightShape, leftCornerShape, rightCornerShape);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(CORNER, CornerType.NOT)
                .setValue(POWER, 0));
    }

    public WallWire(Properties properties, VoxelShape straightShape, VoxelShape leftCornerShape, VoxelShape rightCornerShape) {
        this(properties, "info.connectable", straightShape, leftCornerShape, rightCornerShape);
    }

    public WallWire(Properties properties, String hoverTextKey, VoxelShape shape) {
        this(properties, hoverTextKey, shape, shape, shape);
    }

    public WallWire(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, Shapes.block(), Shapes.block(), Shapes.block());
    }

    public WallWire(Properties properties, VoxelShape shape) {
        this(properties, "info.connectable", shape, shape, shape);
    }

    public WallWire(Properties properties) {
        this(properties, "info.connectable", Shapes.block(), Shapes.block(), Shapes.block());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWER);
    }

    // Определяет, может ли блок соединяться (принимать/передавать сигнал) в указанном направлении,
    // исходя из его текущего состояния (FACING и CORNER).

    public boolean canConnectTo(BlockState state, Direction side) {
        if (side.getAxis().isVertical()) return false; // вертикальных соединений нет
        Direction facing = state.getValue(FACING);
        CornerType corner = state.getValue(CORNER);
        Set<Direction> allowed = EnumSet.noneOf(Direction.class);
        switch (corner) {
            case NOT:
                // прямой: проводит слева и справа
                allowed.add(facing.getCounterClockWise());
                allowed.add(facing.getClockWise());
                break;
            case LEFT:
                // левый угол: проводит назад и налево
                allowed.add(facing.getOpposite()); // назад
                allowed.add(facing.getClockWise()); // лево
                break;
            case RIGHT:
                // правый угол: проводит назад и направо
                allowed.add(facing.getOpposite()); // назад
                allowed.add(facing.getCounterClockWise()); // право
                break;
        }
        return allowed.contains(side);
    }

    // Вычисляет новую мощность сигнала на основе соседей только в разрешённых направлениях.
    private int computePower(Level level, BlockPos pos, BlockState state) {
        int power = 0;

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            if (!canConnectTo(state, dir)) continue;

            BlockPos neighborPos = pos.relative(dir);
            BlockState neighborState = level.getBlockState(neighborPos);
            Block neighborBlock = neighborState.getBlock();

            if (neighborBlock == this) {
                int neighborPower = neighborState.getValue(POWER);
                if (neighborPower > 0) {
                    power = Math.max(power, neighborPower - 1);
                }
            } else if (neighborBlock == Blocks.REDSTONE_WIRE) {
                int neighborPower = neighborState.getValue(RedStoneWireBlock.POWER);
                if (neighborPower > 0) {
                    power = Math.max(power, neighborPower - 1);
                }
            } else {
                // Непроводной источник: сигнал, который он излучает в нашу сторону
                int signal = level.getSignal(neighborPos, dir.getOpposite());
                if (signal > power) {
                    power = signal;
                }
            }
        }
        return power;
    }

    // Обновляет мощность блока, если она изменилась, и уведомляет соседей.
    private void updatePower(Level level, BlockPos pos, BlockState state) {
        int oldPower = state.getValue(POWER);
        int newPower = computePower(level, pos, state);
        if (oldPower != newPower) {
            level.setBlock(pos, state.setValue(POWER, newPower), 3);
            // Уведомляем соседей об изменении сигнала
            level.updateNeighborsAt(pos, this);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
        // После возможного обновления угла (в super) пересчитываем мощность
        BlockState newState = level.getBlockState(pos);
        if (newState.getBlock() == this) {
            updatePower(level, pos, newState);
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        BlockState newState = level.getBlockState(pos);
        if (newState.getBlock() == this) {
            updatePower(level, pos, newState);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state != null) {
            Level level = context.getLevel();
            BlockPos pos = context.getClickedPos();
            int power = computePower(level, pos, state);
            state = state.setValue(POWER, power);
        }
        return state;
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWER);
    }

    @Override
    public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0; // провод не даёт прямой сигнал
    }

    @Override
    protected CornerType getTargetCorner(BlockState state, BlockGetter world, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockState backState = world.getBlockState(pos.relative(facing.getOpposite()));
        if (backState.getBlock() == this || backState.getBlock() == RegBlocksInner.SWITCH_REDSTONE_WIRE.get()) {
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

    @Override
    public boolean isSignalSource(@NotNull BlockState state) {
        return true; // блок может излучать сигнал (как и обычный провод)
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction side) {
        // Проверяем, может ли блок взаимодействовать с этой стороной
        if (side == null || side.getAxis().isVertical()) return false;
        return canConnectTo(state, side);
    }
}