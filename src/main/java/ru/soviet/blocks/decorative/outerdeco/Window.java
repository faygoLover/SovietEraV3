package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.soviet.blocks.baseblock.Vertical4MBlock;

public class Window extends Vertical4MBlock {

    public Window(Properties properties, String hoverTextKey, VoxelShape noneShape, VoxelShape topShape, VoxelShape bottomShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, noneShape, topShape, bottomShape, centerShape);
    }

    public Window(Properties properties, VoxelShape noneShape, VoxelShape topShape, VoxelShape bottomShape, VoxelShape centerShape) {
        this(properties, "info.connectable", noneShape, topShape, bottomShape, centerShape);
    }

    public Window(Properties properties, String hoverTextKey, VoxelShape shape) {
        this(properties, hoverTextKey, shape, shape, shape, shape);
    }

    public Window(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, Shapes.block(), Shapes.block(), Shapes.block(), Shapes.block());
    }

    public Window(Properties properties, VoxelShape shape) {
        this(properties, "info.connectable", shape, shape, shape, shape);
    }

    public Window(Properties properties) {
        this(properties, "info.connectable", Shapes.block(), Shapes.block(), Shapes.block(), Shapes.block());
    }

    @Override
    protected boolean hasNeighbour(BlockGetter level, BlockPos pos, Direction dir, Direction facing) {
        BlockState neighbour = level.getBlockState(pos.relative(dir));
        return neighbour.getBlock() instanceof Window && neighbour.getValue(FACING) == facing;
    }
}
