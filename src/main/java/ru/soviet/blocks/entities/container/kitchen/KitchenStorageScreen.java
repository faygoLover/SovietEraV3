package ru.soviet.blocks.entities.container.kitchen;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import ru.soviet.blocks.entities.container.BaseStorageScreen;
import ru.soviet.core.SovietEra;

public class KitchenStorageScreen extends BaseStorageScreen<KitchenStorageMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SovietEra.MODID, "textures/gui/kitchen_table_gui.png");

    public KitchenStorageScreen(KitchenStorageMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, TEXTURE);
    }
}