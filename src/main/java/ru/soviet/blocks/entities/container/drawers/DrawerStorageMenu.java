package ru.soviet.blocks.entities.container.drawers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import ru.soviet.blocks.entities.container.BaseStorageMenu;
import ru.soviet.reg.RegMenuTypes;

public class DrawerStorageMenu extends BaseStorageMenu {

    public DrawerStorageMenu(int id, Inventory playerInventory, IItemHandler itemHandler) {
        super(RegMenuTypes.DRAWER_STORAGE.get(), id, playerInventory, itemHandler);
    }

    public DrawerStorageMenu(int id, Inventory playerInventory, FriendlyByteBuf buf) {
        this(id, playerInventory, new ItemStackHandler(16));
    }

    @Override
    protected void addBlockSlots() {
        int startY = 18;
        int slotSize = 18;

        // Первая группа (0-7)
        int startX1 = 14;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 4; col++) {
                int index = row * 4 + col;
                this.addSlot(new SlotItemHandler(itemHandler, index, startX1 + col * slotSize, startY + row * slotSize));
            }
        }
        // Вторая группа (8-15)
        int startX2 = 93;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 4; col++) {
                int index = 8 + row * 4 + col;
                this.addSlot(new SlotItemHandler(itemHandler, index, startX2 + col * slotSize, startY + row * slotSize));
            }
        }
    }
}