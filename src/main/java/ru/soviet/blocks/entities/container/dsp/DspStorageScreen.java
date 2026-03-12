package ru.soviet.blocks.entities.container.dsp;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import ru.soviet.blocks.entities.container.BaseStorageScreen;
import ru.soviet.core.SovietEra;

public class DspStorageScreen extends BaseStorageScreen<DspStorageMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SovietEra.MODID, "textures/gui/dsp_tumb_gui.png");

    public DspStorageScreen(DspStorageMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, TEXTURE);
    }
}