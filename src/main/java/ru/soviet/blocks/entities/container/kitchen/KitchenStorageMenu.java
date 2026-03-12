package ru.soviet.blocks.entities.container.kitchen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import ru.soviet.blocks.entities.container.BaseStorageMenu;
import ru.soviet.reg.RegMenuTypes;

public class KitchenStorageMenu extends BaseStorageMenu {

    public KitchenStorageMenu(int id, Inventory playerInventory, IItemHandler itemHandler) {
        super(RegMenuTypes.KITCHEN_STORAGE.get(), id, playerInventory, itemHandler);
    }

    public KitchenStorageMenu(int id, Inventory playerInventory, FriendlyByteBuf buf) {
        this(id, playerInventory, new ItemStackHandler(12));
    }

    @Override
    protected void addBlockSlots() {
        int slotSize = 18;
        int index = 0;

        // Левая группа: верхняя часть (два столбца, один ряд)
        int startXLeft = 44;
        int startYTop = 12;
        for (int col = 0; col < 2; col++) {
            this.addSlot(new SlotItemHandler(itemHandler, index++, startXLeft + col * slotSize, startYTop));
        }

        // Левая группа: нижняя часть (два столбца, два ряда)
        int startYBottom = 38;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                this.addSlot(new SlotItemHandler(itemHandler, index++, startXLeft + col * slotSize, startYBottom + row * slotSize));
            }
        }

        // Правая группа: верхняя часть (два столбца, один ряд)
        int startXRight = 99;
        for (int col = 0; col < 2; col++) {
            this.addSlot(new SlotItemHandler(itemHandler, index++, startXRight + col * slotSize, startYTop));
        }

        // Правая группа: нижняя часть (два столбца, два ряда)
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                this.addSlot(new SlotItemHandler(itemHandler, index++, startXRight + col * slotSize, startYBottom + row * slotSize));
            }
        }
    }
}