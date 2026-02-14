package ru.soviet.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;


public class ItemBurnable extends BaseItem {
    private final int burnTime;

    public ItemBurnable(BaseItem.Properties properties, int burnTime, String hoverTextKey) {
        super(properties, hoverTextKey);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
