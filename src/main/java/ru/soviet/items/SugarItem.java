package ru.soviet.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SugarItem extends BaseItem {
    private static final int MAX_DAMAGE = 60;

    public SugarItem(Properties properties, String hoverTextKey) {
        super(properties.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).build())
                .durability(MAX_DAMAGE), hoverTextKey);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 16;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        if (entity instanceof Player player) {
            // Восстанавливаем голод и насыщение
            player.getFoodData().eat(1, 0.1f);
            // Уменьшаем прочность
            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
            if (stack.isEmpty()) {
                return ItemStack.EMPTY;
            }
        }
        return stack;
    }
}