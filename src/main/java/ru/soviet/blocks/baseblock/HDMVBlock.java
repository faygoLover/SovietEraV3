package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.utils.YShapeRotator;


//HDMVBlock = HorizontalDirectionalModelVariantsBlock
public class HDMVBlock extends ModelBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty VARIANT = IntegerProperty.create("var", 0, 1); // диапазон 0–3

    public HDMVBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(VARIANT, 0));
    }

    public HDMVBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public HDMVBlock(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public HDMVBlock(Properties properties) {
        this(properties, null, null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, VARIANT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        int variant = context.getLevel().random.nextInt(2);
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection())
                .setValue(VARIANT, variant);
    }
}