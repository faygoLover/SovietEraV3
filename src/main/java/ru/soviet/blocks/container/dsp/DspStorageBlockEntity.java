package ru.soviet.blocks.container.dsp;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.container.BaseStorageBlockEntity;
import ru.soviet.reg.RegBlockEntities;

public class DspStorageBlockEntity extends BaseStorageBlockEntity<DspStorageMenu> {
    public DspStorageBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.DSP_STORAGE.get(), pos, state, Component.translatable("storage.dsp"));
    }

    @Override
    public DspStorageMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new DspStorageMenu(id, inventory, this.itemHandler);
    }
}