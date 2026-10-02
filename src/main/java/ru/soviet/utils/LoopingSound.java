package ru.soviet.utils;

import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

public class LoopingSound extends AbstractSoundInstance implements TickableSoundInstance {
    private boolean stopped;

    public LoopingSound(SoundEvent event, SoundSource source, float volume, float pitch, BlockPos pos) {
        super(event, source, RandomSource.create());
        this.volume = volume;
        this.pitch = pitch;
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
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
