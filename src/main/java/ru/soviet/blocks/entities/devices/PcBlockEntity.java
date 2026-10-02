package ru.soviet.blocks.entities.devices;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ru.soviet.reg.RegBlockEntities;
import ru.soviet.reg.RegSounds;
import ru.soviet.utils.LoopingSound;

public class PcBlockEntity extends BlockEntity {
    private SoundInstance playingSound;

    public PcBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.PC.get(), pos, state);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) {
            boolean powered = state.getValue(PCs.POWERED);
            if (powered && (playingSound == null || !Minecraft.getInstance().getSoundManager().isActive(playingSound))) {
                startSound();
            } else if (!powered && playingSound != null && Minecraft.getInstance().getSoundManager().isActive(playingSound)) {
                stopSound();
            }
        }
    }

    private void startSound() {
        if (level == null || !level.isClientSide) return;

        playingSound = new LoopingSound(
                RegSounds.DEVICE_ENABLE.get(),
                SoundSource.BLOCKS,
                0.3f, 1.0f,
                worldPosition
        );
        Minecraft.getInstance().getSoundManager().play(playingSound);
    }

    private void stopSound() {
        if (playingSound != null) {
            if (playingSound instanceof LoopingSound) {
                ((LoopingSound) playingSound).stop();
            } else {
                Minecraft.getInstance().getSoundManager().stop(playingSound);
            }
            playingSound = null;
        }
    }

    @Override
    public void setRemoved() {
        if (level != null && level.isClientSide) {
            stopSound();
        }
        super.setRemoved();
    }
}