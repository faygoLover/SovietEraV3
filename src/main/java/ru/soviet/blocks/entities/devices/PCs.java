package ru.soviet.blocks.entities.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
import ru.soviet.client.ClientPcSounds;
import ru.soviet.reg.RegBlockEntities;

public class PCs extends Directional4MBlock implements EntityBlock {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public PCs(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape); // <-- убрали lightLevel
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false));
    }

    public PCs(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public PCs(Properties properties, VoxelShape shape) {
        this(properties, "info.enableable", shape);
    }

    public PCs(Properties properties) {
        this(properties, "info.enableable", null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 5 : 0;
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos,
                                @NotNull net.minecraft.world.level.block.Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            boolean currentlyPowered = state.getValue(POWERED);
            boolean hasSignal = level.hasNeighborSignal(pos);

            if (currentlyPowered != hasSignal) {
                level.setBlock(pos, state.setValue(POWERED, hasSignal), 3);
                // Звук теперь управляется через BlockEntity на клиенте
            }
        }
    }

    @Override
    public void onPlace(@NotNull BlockState state, Level level, @NotNull BlockPos pos,
                        @NotNull BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !oldState.is(state.getBlock())) {
            boolean hasSignal = level.hasNeighborSignal(pos);
            boolean currentlyPowered = state.getValue(POWERED);

            if (currentlyPowered != hasSignal) {
                level.setBlock(pos, state.setValue(POWERED, hasSignal), 3);
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new PcBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        // Серверу тикать нечего: блок-сущность нужна только для звука на клиенте
        if (!level.isClientSide || type != RegBlockEntities.PC.get()) return null;
        return (lvl, pos, st, be) -> ClientPcSounds.tick(lvl, pos, st, (PcBlockEntity) be);
    }
}