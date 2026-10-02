package ru.soviet.client;

import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class LoopingSound extends AbstractSoundInstance implements TickableSoundInstance {
    private boolean stopped;

    public LoopingSound(SoundEvent event, SoundSource source, float volume, float pitch, BlockPos pos) {
        super(event, source, SoundInstance.createUnseededRandom());
        this.volume = volume;
        this.pitch = pitch;
        this.x = pos.getX() + 0.5;
        this.y = pos.getY() + 0.5;
        this.z = pos.getZ() + 0.5;
        this.looping = true;
        this.delay = 0;
    }

    @Override
    public boolean isStopped() {
        return stopped;
    }

    @Override
    public void tick() {
        // Здесь можно добавить логику изменения звука со временем
    }

    public void stop() {
        this.stopped = true;
    }
}
