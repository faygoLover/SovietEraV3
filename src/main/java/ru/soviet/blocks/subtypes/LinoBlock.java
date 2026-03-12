package ru.soviet.blocks.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

public class LinoBlock extends BaseBlock {
    public LinoBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)
            .requiresCorrectToolForDrops()
            .strength(1.0F, 2.0F)
            //.sound(SoundType.WOOL)
        );
    }
}
