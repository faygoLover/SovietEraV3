package ru.soviet.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;


public class ItemBurnable extends ItemInfo {
    private final int burnTime;

    public ItemBurnable(ItemInfo.Properties properties, int burnTime, String info) {
        super(properties, info);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
