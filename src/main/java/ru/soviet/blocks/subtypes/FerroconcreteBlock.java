package ru.soviet.blocks.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.BaseBlock;

public class FerroconcreteBlock extends BaseBlock {
    public FerroconcreteBlock(@Nullable String hoverTextKey) {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                .requiresCorrectToolForDrops()
                .strength(6F, 16F)
                ,hoverTextKey
        );
    }
}
