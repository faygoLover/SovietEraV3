package ru.soviet.blocks.entities.clock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.Directional4MBlock;
import ru.soviet.reg.RegBlockEntities;
import ru.soviet.reg.RegSounds;

public class ClockDisplay extends Directional4MBlock implements EntityBlock {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public ClockDisplay(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false)
        );
    }

    public ClockDisplay(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public ClockDisplay(Properties properties, VoxelShape shape) {
        this(properties, "info.enableable", shape);
    }

    public ClockDisplay(Properties properties) {
        this(properties, "info.enableable", null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 5 : 0;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ClockBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        if (level.isClientSide) return null;
        return createTickerHelper(type, RegBlockEntities.CLOCK.get(),
                (lvl, pos, st, be) -> ((ClockBlockEntity) be).tick());
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(
            BlockEntityType<A> type, BlockEntityType<E> expectedType, BlockEntityTicker<? super E> ticker) {
        return expectedType == type ? (BlockEntityTicker<A>) ticker : null;
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos,
                                @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            boolean powered = level.hasNeighborSignal(pos);
            if (state.getValue(POWERED) != powered) {
                BlockState newState = state.setValue(POWERED, powered);
                level.setBlock(pos, newState, 3);

                if (level.getBlockEntity(pos) instanceof ClockBlockEntity be) {
                    be.onPoweredChanged(powered);
                }

                if (powered) {
                    level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.1F, 1.5F);
                }
            }
        }
    }

    @Override
    public void onPlace(@NotNull BlockState state, Level level, @NotNull BlockPos pos,
                        @NotNull BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !oldState.is(state.getBlock())) {
            boolean powered = level.hasNeighborSignal(pos);
            if (powered != state.getValue(POWERED)) {
                BlockState newState = state.setValue(POWERED, powered);
                level.setBlock(pos, newState, 3);

                if (level.getBlockEntity(pos) instanceof ClockBlockEntity be) {
                    be.onPoweredChanged(powered);
                }

                if (powered) {
                    level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.1F, 1.5F);
                }
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof ClockBlockEntity be) {
                be.removeDisplayEntity();
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }
}