package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.HorizontalDirectionalModelBlock;

public class ModelDeviceEnable extends HorizontalDirectionalModelBlock {
    public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");

    public ModelDeviceEnable() {
        this(Shapes.block());
    }

    public ModelDeviceEnable(VoxelShape shape) {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                        .requiresCorrectToolForDrops()
                        .strength(3F, 8F)
                        .noOcclusion()
                        .lightLevel(state -> state.getValue(ENABLED) ? 5 : 0),
                shape);
        this.registerDefaultState(this.defaultBlockState().setValue(ENABLED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ENABLED);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {

            if (state.getValue(ENABLED) != level.hasNeighborSignal(pos)) {
                level.setBlock(pos, state.setValue(ENABLED, level.hasNeighborSignal(pos)), 3);
            }
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && !oldState.is(state.getBlock())) {
            if (level.hasNeighborSignal(pos) != state.getValue(ENABLED)) {
                level.setBlock(pos, state.setValue(ENABLED, level.hasNeighborSignal(pos)), 3);
            }
        }
    }
}