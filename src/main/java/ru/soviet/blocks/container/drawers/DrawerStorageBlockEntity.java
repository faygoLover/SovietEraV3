package ru.soviet.blocks.container.drawers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.container.BaseStorageBlockEntity;
import ru.soviet.reg.RegBlockEntities;

public class DrawerStorageBlockEntity extends BaseStorageBlockEntity<DrawerStorageMenu> {
    public DrawerStorageBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.DRAWER_STORAGE.get(), pos, state, Component.translatable("storage.drawer"), 16);
    }

    @Override
    public DrawerStorageMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new DrawerStorageMenu(id, inventory, this.itemHandler);
    }
}