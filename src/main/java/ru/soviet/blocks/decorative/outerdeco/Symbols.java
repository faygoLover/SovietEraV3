package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import ru.soviet.blocks.baseblock.HDMBlock;

public class Symbols extends HDMBlock {
    private static final VoxelShape DEFAULT_SHAPE  = Shapes.or(
            Shapes.box(
                    0.125, 0, 0.8125,
                    0.875, 0.9375, 0.9375),
            Shapes.box(
                    0.125, 0, 0.3125,
                    0.875, 0.5, 0.8125)
    );

    public Symbols(VoxelShape shape) {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(3F, 8F),
                shape);
    }

    public Symbols() {
        this(DEFAULT_SHAPE);
    }
}