package ru.soviet.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CondensedMilkItem extends BaseItem {
    public CondensedMilkItem(Properties properties, String hoverTextKey) {
        super(properties.stacksTo(1), hoverTextKey);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 100; // 5 секунд
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        if (entity instanceof Player player) {
            int foodLevel = player.getFoodData().getFoodLevel();
            if (foodLevel >= 10) {
                // Насыщаем полностью
                player.getFoodData().setFoodLevel(20);
                player.getFoodData().setSaturation(20.0f);
            } else {
                // Наказываем
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0)); // тошнота 10 сек
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));   // слабость
            }
            stack.shrink(1);
        }
        return stack;
    }
}