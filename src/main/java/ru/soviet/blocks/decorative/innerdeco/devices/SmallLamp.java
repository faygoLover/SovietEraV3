package ru.soviet.blocks.decorative.innerdeco.devices;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.baseblock.Toggleable6MBlock;
import ru.soviet.reg.RegSounds;

public class SmallLamp extends Toggleable6MBlock {

    public SmallLamp(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties.lightLevel(state -> state.getValue(TOGGLED) ? 10 : 0), hoverTextKey, shape);
        this.registerDefaultState(this.defaultBlockState().setValue(TOGGLED, false));
    }

    public SmallLamp(Properties properties, String hoverTextKey) {
        this(properties, hoverTextKey, null);
    }

    public SmallLamp(Properties properties, VoxelShape shape) {
        this(properties, "info.toggleable", shape);
    }

    public SmallLamp(Properties properties) {
        this(properties, "info.toggleable", null);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            boolean newToggled = !state.getValue(TOGGLED);
            level.setBlock(pos, state.setValue(TOGGLED, newToggled), 3);
            if (newToggled) {
                level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.2F, 1.0F);
            } else {
                level.playSound(null, pos, RegSounds.SNAP.get(), SoundSource.BLOCKS, 0.2F, 0.8F);
            }

            level.updateNeighborsAt(pos, this);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}