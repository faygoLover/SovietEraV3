package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.WallAttachedBlock;
import ru.soviet.reg.RegSounds;

public class SmallTumbler extends WallAttachedBlock {
    public static final BooleanProperty TOGGLED = BooleanProperty.create("toggled");

    public SmallTumbler(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.defaultBlockState().setValue(TOGGLED, false));
    }

    public SmallTumbler(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public SmallTumbler(Properties properties, VoxelShape shape) {
        this(properties, "info.toggleable", shape);
    }

    public SmallTumbler(Properties properties) {
        this(properties, "info.toggleable", null);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(TOGGLED);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            Direction facing = state.getValue(FACING); // запоминаем сторону крепления
            boolean newToggled = !state.getValue(TOGGLED);
            level.setBlock(pos, state.setValue(TOGGLED, newToggled), 3);

            float pitch = newToggled ? 0.6F : 0.8F;
            level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.3F, pitch);

            // Обновляем соседей вокруг блока и вокруг блока стены
            level.updateNeighborsAt(pos, this);
            level.updateNeighborsAt(pos.relative(facing), this);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public int getSignal(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        if (state.getValue(TOGGLED) && direction == state.getValue(FACING).getOpposite()) {
            return 15;
        }
        return 0;
    }

    @Override
    public int getDirectSignal(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return getSignal(state, level, pos, direction);
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!level.isClientSide) {
            Direction facing = state.getValue(FACING);
            level.updateNeighborsAt(pos, this);
            level.updateNeighborsAt(pos.relative(facing), this);
        }
    }

}