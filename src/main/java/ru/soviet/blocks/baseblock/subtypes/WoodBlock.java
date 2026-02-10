package ru.soviet.blocks.baseblock.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;

import java.util.function.Consumer;

public class WoodBlock extends BaseBlock {
    public WoodBlock(Consumer<Properties> modifier) {
        super(createProperties(modifier));
    }

    public WoodBlock() {
        this(props -> {});
    }

    private static BlockBehaviour.Properties createProperties(Consumer<BlockBehaviour.Properties> modifier) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)
                .requiresCorrectToolForDrops();
        modifier.accept(props);
        return props;
    }
}