package ru.soviet.blocks.safe;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import ru.soviet.blocks.baseblock.BaseStorageBlockEntity;
import ru.soviet.reg.RegBlockEntities;

public class SafeStorageBlockEntity extends BaseStorageBlockEntity<SafeStorageMenu> {
    public SafeStorageBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.SAFE_STORAGE.get(), pos, state, Component.translatable("storage.safe"));
    }

    @Override
    public SafeStorageMenu createMenu(int id, Inventory inventory, Player player) {
        return new SafeStorageMenu(id, inventory, this.itemHandler);
    }
}