package ru.soviet.blocks.entities.container.safe;

import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.entities.container.BaseDirectionalStorageBlock;
import ru.soviet.reg.RegBlockEntities;

public class SafeStorage extends BaseDirectionalStorageBlock {
    public SafeStorage(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, () -> RegBlockEntities.SAFE_STORAGE.get());
    }

    public SafeStorage(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, () -> RegBlockEntities.SAFE_STORAGE.get());
    }

    public SafeStorage(Properties properties, VoxelShape shape) {
        super(properties, shape, () -> RegBlockEntities.SAFE_STORAGE.get());
    }

    public SafeStorage(Properties properties) {
        super(properties, () -> RegBlockEntities.SAFE_STORAGE.get());
    }
}