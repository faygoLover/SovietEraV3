package ru.soviet.items;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

/**
 * Инструмент для крафта (ступка, пестик, сито): не расходуется в рецепте, а теряет единицу прочности.
 */
public class CraftingToolItem extends Item {
    private static final RandomSource RANDOM = RandomSource.createNewThreadLocalInstance();

    public CraftingToolItem(int durability) {
        super(new Item.Properties().durability(durability).setNoRepair());
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        ItemStack remaining = stack.copy();
        return remaining.hurt(1, RANDOM, null) ? ItemStack.EMPTY : remaining;
    }

    @Override
    public int getEnchantmentValue() {
        return 14;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.UNBREAKING || enchantment == Enchantments.MENDING;
    }
}
