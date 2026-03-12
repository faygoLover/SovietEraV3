package ru.soviet.blocks.entities.clock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.Directional4MBlock;
import ru.soviet.reg.RegSounds;

public class ClockBroken extends Directional4MBlock {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public ClockBroken(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties.lightLevel(state -> state.getValue(POWERED) ? 5 : 0), hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false)
        );
    }

    public ClockBroken(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public ClockBroken(Properties properties, VoxelShape shape) {
        this(properties, "info.enableable", shape);
    }

    public ClockBroken(Properties properties) {
        this(properties, "info.enableable", null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            if (state.getValue(POWERED) != level.hasNeighborSignal(pos)) {
                level.setBlock(pos, state.setValue(POWERED, level.hasNeighborSignal(pos)), 3);
                if (!state.getValue(POWERED)) {
                    level.playSound(null, pos, RegSounds.SPARKING.get(), SoundSource.BLOCKS, 0.1F, 1.5F);
                }
            }
        }
    }

    @Override
    public void onPlace(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !oldState.is(state.getBlock())) {
            if (level.hasNeighborSignal(pos) != state.getValue(POWERED)) {
                level.setBlock(pos, state.setValue(POWERED, level.hasNeighborSignal(pos)), 3);
                if (!state.getValue(POWERED)) {
                    level.playSound(null, pos, RegSounds.SPARKING.get(), SoundSource.BLOCKS, 0.1F, 1.5F);
                }
            }
        }
    }
}