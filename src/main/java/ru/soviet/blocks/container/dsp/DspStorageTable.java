package ru.soviet.blocks.container.dsp;

import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.container.BaseLinearStorageBlock;
import ru.soviet.reg.RegBlockEntities;

public class DspStorageTable extends BaseLinearStorageBlock {
    public DspStorageTable(Properties properties, String hoverTextKey,
                           VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, noneShape, leftShape, rightShape, centerShape,
                () -> RegBlockEntities.DSP_STORAGE.get());
    }

    public DspStorageTable(Properties properties, VoxelShape noneShape, VoxelShape leftShape,
                           VoxelShape rightShape, VoxelShape centerShape) {
        this(properties, "info.storage.connectable", noneShape, leftShape, rightShape, centerShape);
    }

    public DspStorageTable(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, () -> RegBlockEntities.DSP_STORAGE.get());
    }

    public DspStorageTable(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, () -> RegBlockEntities.DSP_STORAGE.get());
    }

    public DspStorageTable(Properties properties, VoxelShape shape) {
        super(properties, shape, () -> RegBlockEntities.DSP_STORAGE.get());
    }

    public DspStorageTable(Properties properties) {
        super(properties, () -> RegBlockEntities.DSP_STORAGE.get());
    }
}