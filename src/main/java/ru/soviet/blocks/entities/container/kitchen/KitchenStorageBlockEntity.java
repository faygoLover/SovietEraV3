package ru.soviet.blocks.entities.container.kitchen;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.entities.container.BaseStorageBlockEntity;
import ru.soviet.reg.RegBlockEntities;

public class KitchenStorageBlockEntity extends BaseStorageBlockEntity<KitchenStorageMenu> {
    public KitchenStorageBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.KITCHEN_STORAGE.get(), pos, state, Component.translatable("storage.kitchen"),12);
    }

    @Override
    public KitchenStorageMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new KitchenStorageMenu(id, inventory, this.itemHandler);
    }
}