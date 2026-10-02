package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.Vertical4MBlock;
import ru.soviet.reg.RegBlocksOuter;

public class Lightpost extends Vertical4MBlock {

    public Lightpost(Properties properties, String hoverTextKey, VoxelShape noneShape, VoxelShape topShape, VoxelShape bottomShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, noneShape, topShape, bottomShape, centerShape);
    }

    public Lightpost(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, shape, shape, shape);
    }

    public Lightpost(Properties properties, VoxelShape shape) {
        super(properties, "info.connectable", shape, shape, shape, shape);
    }

    @Override
    protected ConnectionType getConnectionType(BlockGetter level, BlockPos pos, Direction facing) {
        boolean up = hasNeighbour(level, pos, Direction.UP, facing) || hasLightpostNeighbour(level, pos, Direction.UP);
        boolean down = hasNeighbour(level, pos, Direction.DOWN, facing) || hasLightpostNeighbour(level, pos, Direction.DOWN) || hasConcreteFenceBaseBelow(level, pos);

        if (up && down) return ConnectionType.CENTER;
        if (up) return ConnectionType.BOTTOM;
        if (down) return ConnectionType.TOP;
        return ConnectionType.NONE;
    }

    private boolean hasLightpostNeighbour(BlockGetter level, BlockPos pos, Direction dir) {
        BlockPos neighbourPos = pos.relative(dir);
        Block neighbourBlock = level.getBlockState(neighbourPos).getBlock();
        return neighbourBlock instanceof Lightpost;
    }

    private boolean hasConcreteFenceBaseBelow(BlockGetter level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        return level.getBlockState(belowPos).is(RegBlocksOuter.CONCRETE_FENCE_BASE.get());
    }
}