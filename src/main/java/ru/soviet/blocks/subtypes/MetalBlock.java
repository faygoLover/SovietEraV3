package ru.soviet.blocks.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

public class MetalBlock extends BaseBlock {
    public MetalBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
            .requiresCorrectToolForDrops()
            .strength(3.0F, 8.0F)
        );
    }
}
