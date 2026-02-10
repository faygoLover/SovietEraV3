package ru.soviet.blocks.baseblock.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

public class GlassBlock extends BaseBlock {
    public GlassBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GLASS)
                .requiresCorrectToolForDrops()
                .strength(1.0F, 2.0F)
                //.forceSolidOff()
                .noOcclusion());
    }
}

