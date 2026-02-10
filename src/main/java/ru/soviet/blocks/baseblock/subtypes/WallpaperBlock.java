package ru.soviet.blocks.baseblock.subtypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ru.soviet.blocks.baseblock.BaseBlock;
import net.minecraft.world.level.block.SoundType;

public class WallpaperBlock extends BaseBlock {
    public WallpaperBlock(String info) {
        super(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)
            .strength(1.5F, 2.0F)
            .sound(SoundType.WOOL)
        ,info);
    }
}
