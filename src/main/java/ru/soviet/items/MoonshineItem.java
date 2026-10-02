package ru.soviet.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MoonshineItem extends BaseItem {
    private static final int MAX_DAMAGE = 20;
    private static final int ATTACK_DAMAGE = 4;          // дополнительный урон
    private static final int DAMAGE_PER_ATTACK = 1;
    private static final int DAMAGE_PER_DRINK = 5;

    public MoonshineItem(Properties properties, String hoverTextKey) {
        super(properties.stacksTo(1).durability(MAX_DAMAGE), hoverTextKey);
    }

    // Урон при атаке этим предметом в главной руке
    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (attacker instanceof Player player && player.getMainHandItem() == stack) {
            // Наносим дополнительный урон (стандартный урон руки + этот)
            target.hurt(attacker.damageSources().playerAttack(player), ATTACK_DAMAGE);
            // Тратим прочность
            stack.hurtAndBreak(DAMAGE_PER_ATTACK, attacker, (p) -> p.broadcastBreakEvent(InteractionHand.MAIN_HAND));
            return true;
        }
        return false;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (hand == InteractionHand.OFF_HAND) {
            // Питьё
            player.startUsingItem(hand);
            return InteractionResultHolder.success(stack);
        }
        // В правой руке — просто оружие, не начинаем использование
        return InteractionResultHolder.pass(stack);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 32; // длительность питья
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        if (entity instanceof Player player) {
            // Эффекты на 2 минуты = 2400 тиков
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0));
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 2400, 0));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2400, 0));
            // Тратим прочность (5 единиц)
            stack.hurtAndBreak(DAMAGE_PER_DRINK, player, (p) -> p.broadcastBreakEvent(InteractionHand.OFF_HAND));
            if (stack.isEmpty()) {
                return ItemStack.EMPTY;
            }
        }
        return stack;
    }
}