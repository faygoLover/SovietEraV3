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
import ru.soviet.blocks.baseblock.Directional4MBlock;
import ru.soviet.reg.RegSounds;

public class BigTumbler extends Directional4MBlock {
    public static final BooleanProperty TOGGLED = BooleanProperty.create("toggled");

    public BigTumbler(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.defaultBlockState().setValue(TOGGLED, false));
    }

    public BigTumbler(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public BigTumbler(Properties properties, VoxelShape shape) {
        this(properties, "info.toggleable", shape);
    }

    public BigTumbler(Properties properties) {
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
            boolean newToggled = !state.getValue(TOGGLED);
            level.setBlock(pos, state.setValue(TOGGLED, newToggled), 3);

            float pitch = !state.getValue(TOGGLED) ? 1.0F : 0.8F;
            level.playSound(null, pos, RegSounds.RUSTY_LEVER.get(), SoundSource.BLOCKS, 0.3F, pitch);

            level.updateNeighborsAt(pos, this);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public boolean isSignalSource(@NotNull BlockState state) {
        return true;
    }

    @Override
    public int getSignal(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return state.getValue(TOGGLED) ? 15 : 0;
    }
}
