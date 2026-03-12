package ru.soviet.blocks.entities.container.dsp;

import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.entities.container.BaseDirectionalStorageBlock;
import ru.soviet.reg.RegBlockEntities;

public class DspStorage extends BaseDirectionalStorageBlock {
    public DspStorage(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, () -> RegBlockEntities.DSP_STORAGE.get());
    }

    public DspStorage(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, () -> RegBlockEntities.DSP_STORAGE.get());
    }

    public DspStorage(Properties properties, VoxelShape shape) {
        super(properties, shape, () -> RegBlockEntities.DSP_STORAGE.get());
    }

    public DspStorage(Properties properties) {
        super(properties, () -> RegBlockEntities.DSP_STORAGE.get());
    }
}