package ru.soviet.blocks.baseblock.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

public class TilledBlock extends BaseBlock {

    public TilledBlock(String info) {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
            .requiresCorrectToolForDrops()
            .strength(5.5F, 15F)
        , info);
    }
    public TilledBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                .requiresCorrectToolForDrops()
                .strength(5.5F, 15F)
        );
    }
}
