package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.Directional4MBlock;

public class ModelDevice extends Directional4MBlock {

    public ModelDevice(VoxelShape shape) {
        super(Properties.copy(Blocks.IRON_BLOCK)
                        .strength(3F, 8F),
                shape);
    }
    public ModelDevice() {
        super(Properties.copy(Blocks.IRON_BLOCK)
                        .strength(3F, 8F),
                null, null);
    }

}