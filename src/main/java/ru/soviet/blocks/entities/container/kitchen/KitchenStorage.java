package ru.soviet.blocks.entities.container.kitchen;

import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.entities.container.BaseDirectionalStorageBlock;
import ru.soviet.reg.RegBlockEntities;

public class KitchenStorage extends BaseDirectionalStorageBlock {
    public KitchenStorage(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, RegBlockEntities.KITCHEN_STORAGE::get);
    }

    public KitchenStorage(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, () -> RegBlockEntities.KITCHEN_STORAGE.get());
    }

    public KitchenStorage(Properties properties, VoxelShape shape) {
        super(properties, shape, () -> RegBlockEntities.KITCHEN_STORAGE.get());
    }

    public KitchenStorage(Properties properties) {
        super(properties, () -> RegBlockEntities.KITCHEN_STORAGE.get());
    }
}