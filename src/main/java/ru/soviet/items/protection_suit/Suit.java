package ru.soviet.items.protection_suit;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Suit extends ArmorItem {
    public Suit(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Nullable
    //@Override
    @OnlyIn(Dist.CLIENT)
    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A _default) {
        //SuitModel model = new SuitModel(armorSlot);
        //model.copyPropertiesTo(_default);
        return null;// (A) model;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        String path = "";
        switch (slot) {
            case HEAD:
                path = "soviet:textures/suit/gasmask.png";
                break;
            case CHEST:
                path = "soviet:textures/suit/jacket_texture.png";
                break;
            case LEGS:
                path = "soviet:textures/suit/leggins_texture.png";
                break;
            case FEET:
                path = "soviet:textures/suit/boots_texture.png";
                break;
        }
        return path;
    }
}
