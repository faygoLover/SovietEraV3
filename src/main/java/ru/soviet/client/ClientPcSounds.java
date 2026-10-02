package ru.soviet.client;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import ru.soviet.blocks.entities.devices.PCs;
import ru.soviet.blocks.entities.devices.PcBlockEntity;
import ru.soviet.reg.RegSounds;

import java.util.HashMap;
import java.util.Map;

// Гул включённых компьютеров. Класс клиентский: на выделенном сервере он не должен загружаться,
// поэтому PcBlockEntity обращается к нему только при level.isClientSide.
public final class ClientPcSounds {
    private static final Map<BlockPos, LoopingSound> PLAYING = new HashMap<>();

    private ClientPcSounds() {
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PcBlockEntity blockEntity) {
        boolean powered = state.getValue(PCs.POWERED);
        LoopingSound sound = PLAYING.get(pos);
        boolean active = sound != null && Minecraft.getInstance().getSoundManager().isActive(sound);
        if (powered && !active) {
            sound = new LoopingSound(RegSounds.DEVICE_ENABLE.get(), SoundSource.BLOCKS, 0.3f, 1.0f, pos);
            PLAYING.put(pos.immutable(), sound);
            Minecraft.getInstance().getSoundManager().play(sound);
        } else if (!powered && sound != null) {
            stop(pos);
        }
    }

    public static void stop(BlockPos pos) {
        LoopingSound sound = PLAYING.remove(pos);
        if (sound != null) {
            sound.stop();
        }
    }
}
