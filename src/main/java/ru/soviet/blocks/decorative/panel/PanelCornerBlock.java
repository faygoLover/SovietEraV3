package ru.soviet.blocks.decorative.panel;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import ru.soviet.blocks.baseblock.BaseBlock;

// Угловой фрагмент панели: поворот по горизонтали и верхний/нижний угол
public class PanelCornerBlock extends BaseBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    // значения upper/lower, как в blockstate
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public PanelCornerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction looking = context.getNearestLookingDirection();
        DoubleBlockHalf half;
        if (looking == Direction.UP) {
            half = DoubleBlockHalf.LOWER;
        } else if (looking == Direction.DOWN) {
            half = DoubleBlockHalf.UPPER;
        } else {
            // смотрим в стену: угол выбирается по высоте точки клика
            double hitY = context.getClickLocation().y - context.getClickedPos().getY();
            half = hitY > 0.5 ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER;
        }
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection())
                .setValue(HALF, half);
    }
}
