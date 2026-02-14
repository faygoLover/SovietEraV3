package ru.soviet.blocks.drawers;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import ru.soviet.blocks.baseblock.BaseStorageScreen;
import ru.soviet.core.SovietEra;

public class DrawerStorageScreen extends BaseStorageScreen<DrawerStorageMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SovietEra.MODID, "textures/gui/drawers_table.png");

    public DrawerStorageScreen(DrawerStorageMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, TEXTURE);
    }
}