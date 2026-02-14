package ru.soviet.blocks.decorative.innerdeco.furniture;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.HorizontalDirectionalModelBlock;

public class ModelFurniture extends HorizontalDirectionalModelBlock {

    public ModelFurniture() {
        this(Shapes.block());
    }

    public ModelFurniture(VoxelShape shape) {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                        .requiresCorrectToolForDrops()
                        .strength(3F, 8F)
                        .noOcclusion(),
                shape);
    }
}