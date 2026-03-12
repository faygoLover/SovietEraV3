package ru.soviet.blocks.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

public class BrickBlock extends BaseBlock {
    public BrickBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                .requiresCorrectToolForDrops()
                .strength(3F, 8F)
        );
    }
}
