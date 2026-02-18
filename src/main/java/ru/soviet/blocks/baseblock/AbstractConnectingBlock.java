package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.utils.YShapeRotator;

import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractConnectingBlock<C extends Enum<C> & StringRepresentable> extends RotatedBlock {
    protected final Map<C, VoxelShape> shapesByConnection;
    protected final EnumProperty<C> connectionProperty;
    protected abstract C getDefaultConnection();
    protected abstract C getConnectionType(BlockGetter level, BlockPos pos, Direction facing);

    public AbstractConnectingBlock(Properties properties, String hoverTextKey, Class<C> connectionEnum, EnumProperty<C> connectionProperty, Map<C, VoxelShape> shapes) {
        super(properties, hoverTextKey, null);
        this.connectionProperty = connectionProperty;
        this.shapesByConnection = new EnumMap<>(shapes);
        this.registerDefaultState(this.stateDefinition.any().setValue(connectionProperty, getDefaultConnection()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(connectionProperty);
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) return null;
        Direction facing = getFacing(state);
        return state.setValue(connectionProperty, getConnectionType(context.getLevel(), context.getClickedPos(), facing));
    }

    @Override
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState,
                                           @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        Direction facing = getFacing(state);
        C newConnection = getConnectionType(level, pos, facing);
        if (newConnection != state.getValue(connectionProperty)) {
            return state.setValue(connectionProperty, newConnection);
        }
        return state;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return YShapeRotator.rotateShape(shapesByConnection.get(state.getValue(connectionProperty)), getFacing(state));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShape(state, world, pos, context);
    }
}