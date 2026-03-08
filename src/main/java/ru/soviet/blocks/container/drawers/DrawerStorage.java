package ru.soviet.blocks.container.drawers;

import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.container.BaseLinearStorageBlock;
import ru.soviet.reg.RegBlockEntities;

public class DrawerStorage extends BaseLinearStorageBlock {
    public DrawerStorage(Properties properties, String hoverTextKey,
                         VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, noneShape, leftShape, rightShape, centerShape,
                () -> RegBlockEntities.DRAWER_STORAGE.get());
    }

    public DrawerStorage(Properties properties, VoxelShape noneShape, VoxelShape leftShape,
                         VoxelShape rightShape, VoxelShape centerShape) {
        this(properties, "info.storage.connectable", noneShape, leftShape, rightShape, centerShape);
    }

    public DrawerStorage(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, () -> RegBlockEntities.DRAWER_STORAGE.get());
    }

    public DrawerStorage(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, () -> RegBlockEntities.DRAWER_STORAGE.get());
    }

    public DrawerStorage(Properties properties, VoxelShape shape) {
        super(properties, shape, () -> RegBlockEntities.DRAWER_STORAGE.get());
    }

    public DrawerStorage(Properties properties) {
        super(properties, () -> RegBlockEntities.DRAWER_STORAGE.get());
    }
}