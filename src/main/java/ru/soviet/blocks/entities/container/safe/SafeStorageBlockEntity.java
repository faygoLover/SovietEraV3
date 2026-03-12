package ru.soviet.blocks.entities.container.safe;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.entities.container.BaseStorageBlockEntity;
import ru.soviet.reg.RegBlockEntities;

public class SafeStorageBlockEntity extends BaseStorageBlockEntity<SafeStorageMenu> {
    public SafeStorageBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.SAFE_STORAGE.get(), pos, state, Component.translatable("storage.safe"),8);
    }

    @Override
    public SafeStorageMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new SafeStorageMenu(id, inventory, this.itemHandler);
    }
}