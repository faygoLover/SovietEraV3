package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.Directional4MBlock;
import ru.soviet.reg.RegSounds;

public class Infotable extends Directional4MBlock {
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 5);
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public Infotable(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(VARIANT, 0)
                .setValue(POWERED, false)
        );
    }

    public Infotable(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public Infotable(Properties properties, VoxelShape shape) {
        this(properties, "info.enableable.variants", shape);
    }

    public Infotable(Properties properties) {
        this(properties, "info.enableable.variants", null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(VARIANT,POWERED);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 5 : 0;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(VARIANT, 0);
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {

            if (state.getValue(POWERED) != level.hasNeighborSignal(pos)) {
                level.setBlock(pos, state.setValue(POWERED, level.hasNeighborSignal(pos)), 3);
                level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.2F, 1.2F);
            }
        }
    }

    @Override
    public void onPlace(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !oldState.is(state.getBlock())) {
            if (level.hasNeighborSignal(pos) != state.getValue(POWERED)) {

                level.setBlock(pos, state.setValue(POWERED, level.hasNeighborSignal(pos)), 3);
                level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.2F, 1.2F);
            }
        }
    }
}