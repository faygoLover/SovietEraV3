package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.reg.RegSounds;

public class Toggleable4MBlock extends Directional4MBlock {
    public static final BooleanProperty TOGGLED = BooleanProperty.create("toggled");

    public Toggleable4MBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
        this.registerDefaultState(this.defaultBlockState().setValue(TOGGLED, false));
    }

    public Toggleable4MBlock(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public Toggleable4MBlock(Properties properties, VoxelShape shape) {
        this(properties, "info.toggleable", shape);
    }

    public Toggleable4MBlock(Properties properties) {
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
            level.setBlock(pos, state.setValue(TOGGLED, !state.getValue(TOGGLED)), 3);

            float pitch = !state.getValue(TOGGLED) ? 1.0F : 0.8F;
            level.playSound(null, pos, RegSounds.RELAY.get(), SoundSource.BLOCKS, 0.3F, pitch);

            level.updateNeighborsAt(pos, this);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}