package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.Directional4H2x2VMBlock;

public class FluoLamp extends Directional4H2x2VMBlock {

    public FluoLamp(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
    }

    public FluoLamp(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public FluoLamp(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public FluoLamp(Properties properties) {
        this(properties, null, null);
    }
}
