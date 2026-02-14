package ru.soviet.blocks.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseStorageMenu extends AbstractContainerMenu {

    protected final IItemHandler itemHandler;

    protected BaseStorageMenu(@Nullable MenuType<?> menuType, int id, Inventory playerInventory, IItemHandler itemHandler) {
        super(menuType, id);
        this.itemHandler = itemHandler;

        // Слоты блока добавляются в конструкторе наследника через вызов addBlockSlots()
        addBlockSlots();

        // Инвентарь игрока (3 строки по 9)
        int playerInvStartX = 8;
        int playerInvStartY = 84;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, playerInvStartX + col * 18, playerInvStartY + row * 18));
            }
        }
        // Хотбар (1 строка)
        int hotbarStartY = 142;
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, playerInvStartX + col * 18, hotbarStartY));
        }
    }

    protected abstract void addBlockSlots();


    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < itemHandler.getSlots()) { // из слота блока в инвентарь игрока
                if (!this.moveItemStackTo(itemstack1, itemHandler.getSlots(), 36 + itemHandler.getSlots(), true)) {
                    return ItemStack.EMPTY;
                }
            } else { // из инвентаря в блок
                if (!this.moveItemStackTo(itemstack1, 0, itemHandler.getSlots(), false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return true;
    }
}