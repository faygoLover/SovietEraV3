package ru.soviet.blocks.baseblock.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

public class FerroconcreteBlock extends BaseBlock {
    public FerroconcreteBlock(String info) {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                .requiresCorrectToolForDrops()
                .strength(6F, 16F)
        );
    }
}
