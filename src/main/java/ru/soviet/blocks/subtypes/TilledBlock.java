package ru.soviet.blocks.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

public class TilledBlock extends BaseBlock {

    public TilledBlock(String hoverTextKey) {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
            .requiresCorrectToolForDrops()
            .strength(5.5F, 15F)
        ,hoverTextKey);
    }
    public TilledBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                .requiresCorrectToolForDrops()
                .strength(5.5F, 15F)
        );
    }
}
