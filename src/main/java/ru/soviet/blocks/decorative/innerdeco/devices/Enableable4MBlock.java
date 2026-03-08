package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.Directional4MBlock;

public class Enableable4MBlock extends Directional4MBlock {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public Enableable4MBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties.lightLevel(state -> state.getValue(POWERED) ? 5 : 0), hoverTextKey, shape);
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false));
    }

    public Enableable4MBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public Enableable4MBlock(Properties properties, VoxelShape shape) {
        this(properties, "info.enableable", shape);
    }

    public Enableable4MBlock(Properties properties) {
        this(properties, "info.enableable", null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {

            if (state.getValue(POWERED) != level.hasNeighborSignal(pos)) {
                level.setBlock(pos, state.setValue(POWERED, level.hasNeighborSignal(pos)), 3);
            }
        }
    }

    @Override
    public void onPlace(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !oldState.is(state.getBlock())) {
            if (level.hasNeighborSignal(pos) != state.getValue(POWERED)) {
                level.setBlock(pos, state.setValue(POWERED, level.hasNeighborSignal(pos)), 3);
            }
        }
    }
}