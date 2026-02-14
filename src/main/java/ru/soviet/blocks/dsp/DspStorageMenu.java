package ru.soviet.blocks.dsp;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import ru.soviet.blocks.baseblock.BaseStorageMenu;
import ru.soviet.reg.RegMenuTypes;

public class DspStorageMenu extends BaseStorageMenu {

    public DspStorageMenu(int id, Inventory playerInventory, IItemHandler itemHandler) {
        super(RegMenuTypes.DSP_STORAGE.get(), id, playerInventory, itemHandler);
    }

    public DspStorageMenu(int id, Inventory playerInventory, FriendlyByteBuf buf) {
        this(id, playerInventory, new ItemStackHandler(8));
    }

    @Override
    protected void addBlockSlots() {
        int startX = 52;
        int startY = 18;
        int slotSize = 18;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 4; col++) {
                int index = row * 4 + col;
                this.addSlot(new SlotItemHandler(itemHandler, index, startX + col * slotSize, startY + row * (slotSize + 13)));
            }
        }
    }
}