package ru.soviet.blocks.baseblock;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.utils.ExtendedDirection4H2x2V;
import ru.soviet.utils.ExtendedShapeRotator4H2x2V;

public class Directional4H2x2VMBlock extends ModelBlock {
    public static final EnumProperty<ExtendedDirection4H2x2V> FACING = EnumProperty.create("facing", ExtendedDirection4H2x2V.class);

    public Directional4H2x2VMBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, ExtendedDirection4H2x2V.NORTH));
    }

    public Directional4H2x2VMBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public Directional4H2x2VMBlock(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public Directional4H2x2VMBlock(Properties properties) {
        this(properties, null, null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        if (clickedFace.getAxis().isHorizontal()) {
            ExtendedDirection4H2x2V dir = switch (clickedFace) {
                case NORTH -> ExtendedDirection4H2x2V.SOUTH;
                case SOUTH -> ExtendedDirection4H2x2V.NORTH;
                case WEST -> ExtendedDirection4H2x2V.EAST;
                case EAST -> ExtendedDirection4H2x2V.WEST;
                default -> ExtendedDirection4H2x2V.NORTH;
            };
            return this.defaultBlockState().setValue(FACING, dir);
        } else if (clickedFace == Direction.DOWN) {
            Direction horizontal = context.getHorizontalDirection();
            if (horizontal.getAxis() == Direction.Axis.X) {
                return this.defaultBlockState().setValue(FACING, ExtendedDirection4H2x2V.UP_X);
            } else {
                return this.defaultBlockState().setValue(FACING, ExtendedDirection4H2x2V.UP_Z);
            }
        } else if (clickedFace == Direction.UP) {
            Direction horizontal = context.getHorizontalDirection();
            if (horizontal.getAxis() == Direction.Axis.X) {
                return this.defaultBlockState().setValue(FACING, ExtendedDirection4H2x2V.DOWN_X);
            } else {
                return this.defaultBlockState().setValue(FACING, ExtendedDirection4H2x2V.DOWN_Z);
            }
        }
        return this.defaultBlockState();
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull net.minecraft.core.BlockPos pos, @NotNull CollisionContext context) {
        return ExtendedShapeRotator4H2x2V.rotateShape(shape, state.getValue(FACING));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull net.minecraft.core.BlockPos pos, @NotNull CollisionContext context) {
        return ExtendedShapeRotator4H2x2V.rotateShape(shape, state.getValue(FACING));
    }
}