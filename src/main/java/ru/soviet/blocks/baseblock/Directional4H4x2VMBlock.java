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
import ru.soviet.utils.ExtendedDirection4H4x2V;
import ru.soviet.utils.ExtendedShapeRotator4H4x2V;

public class Directional4H4x2VMBlock extends ModelBlock {
    public static final EnumProperty<ExtendedDirection4H4x2V> FACING = EnumProperty.create("facing", ExtendedDirection4H4x2V.class);

    public Directional4H4x2VMBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, ExtendedDirection4H4x2V.NORTH));
    }

    public Directional4H4x2VMBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public Directional4H4x2VMBlock(Properties properties, VoxelShape shape) {
        this(properties, null, shape);
    }

    public Directional4H4x2VMBlock(Properties properties) {
        this(properties, null, null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        Direction playerDir = context.getHorizontalDirection();

        // Горизонтальные грани (стены)
        if (clickedFace.getAxis().isHorizontal()) {
            ExtendedDirection4H4x2V dir = switch (clickedFace) {
                case NORTH -> ExtendedDirection4H4x2V.SOUTH;
                case SOUTH -> ExtendedDirection4H4x2V.NORTH;
                case WEST  -> ExtendedDirection4H4x2V.EAST;
                case EAST  -> ExtendedDirection4H4x2V.WEST;
                default    -> ExtendedDirection4H4x2V.NORTH; // не должно происходить
            };
            return this.defaultBlockState().setValue(FACING, dir);
        }

        // Нижняя грань (потолок)
        if (clickedFace == Direction.DOWN) {
            ExtendedDirection4H4x2V dir = switch (playerDir) {
                case NORTH -> ExtendedDirection4H4x2V.UP_NORTH;
                case SOUTH -> ExtendedDirection4H4x2V.UP_SOUTH;
                case WEST  -> ExtendedDirection4H4x2V.UP_WEST;
                case EAST  -> ExtendedDirection4H4x2V.UP_EAST;
                default    -> ExtendedDirection4H4x2V.UP_NORTH; // не должно происходить
            };
            return this.defaultBlockState().setValue(FACING, dir);
        }

        // Верхняя грань (пол)
        if (clickedFace == Direction.UP) {
            ExtendedDirection4H4x2V dir = switch (playerDir) {
                case NORTH -> ExtendedDirection4H4x2V.DOWN_SOUTH;
                case SOUTH -> ExtendedDirection4H4x2V.DOWN_NORTH;
                case WEST  -> ExtendedDirection4H4x2V.DOWN_WEST;
                case EAST  -> ExtendedDirection4H4x2V.DOWN_EAST;
                default    -> ExtendedDirection4H4x2V.DOWN_NORTH; // не должно происходить
            };
            return this.defaultBlockState().setValue(FACING, dir);
        }

        return this.defaultBlockState(); // не должно происходить
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull net.minecraft.core.BlockPos pos, @NotNull CollisionContext context) {
        return ExtendedShapeRotator4H4x2V.rotateShape(shape, state.getValue(FACING));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull net.minecraft.core.BlockPos pos, @NotNull CollisionContext context) {
        return ExtendedShapeRotator4H4x2V.rotateShape(shape, state.getValue(FACING));
    }
}