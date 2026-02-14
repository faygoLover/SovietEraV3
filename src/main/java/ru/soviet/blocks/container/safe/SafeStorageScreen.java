package ru.soviet.blocks.container.safe;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import ru.soviet.blocks.container.BaseStorageScreen;
import ru.soviet.core.SovietEra;

public class SafeStorageScreen extends BaseStorageScreen<SafeStorageMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SovietEra.MODID, "textures/gui/safe_gui.png");

    public SafeStorageScreen(SafeStorageMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, TEXTURE);
    }
}