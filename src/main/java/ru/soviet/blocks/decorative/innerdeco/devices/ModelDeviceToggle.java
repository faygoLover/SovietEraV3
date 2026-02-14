package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.HDMBlock;

public class ModelDeviceToggle extends HDMBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public ModelDeviceToggle() {
        this(Shapes.block());
    }

    public ModelDeviceToggle(VoxelShape shape) {
        super(Properties.copy(Blocks.IRON_BLOCK)
                        .requiresCorrectToolForDrops()
                        .strength(3F, 8F)
                        .noOcclusion(),
                shape);
        this.registerDefaultState(this.defaultBlockState().setValue(OPEN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
    }
}