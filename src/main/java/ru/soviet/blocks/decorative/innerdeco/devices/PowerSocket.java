package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.WallAttachedBlock;

public class PowerSocket extends WallAttachedBlock {
    public PowerSocket(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
    }

    public PowerSocket(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public PowerSocket(Properties properties, VoxelShape shape) {
        this(properties, "info.toggleable", shape);
    }

    public PowerSocket(Properties properties) {
        this(properties, "info.toggleable", null);
    }
}
