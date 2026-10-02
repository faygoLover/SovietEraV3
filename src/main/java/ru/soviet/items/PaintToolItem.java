package ru.soviet.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/**
 * Общая часть кисти и шпателей: запас краски/раствора в NBT, подсказки игроку, звук и расход.
 */
public abstract class PaintToolItem extends Item {
    public static final String USES_NBT = "uses";
    // На сколько блоков хватает одного ведра
    public static final int USES_PER_BUCKET = 128;

    protected PaintToolItem() {
        super(new Item.Properties().durability(1200).setNoRepair());
    }

    public static int getUses(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag == null ? 0 : tag.getInt(USES_NBT);
    }

    public static void setUses(ItemStack stack, int uses) {
        stack.getOrCreateTag().putInt(USES_NBT, Math.max(uses, 0));
    }

    protected static boolean isCreative(@Nullable Player player) {
        return player != null && player.getAbilities().instabuild;
    }

    /** Сообщение над хотбаром; вызывать только на сервере. */
    protected static void hint(@Nullable Player player, String key) {
        if (player != null) {
            player.displayClientMessage(Component.translatable(key), true);
        }
    }

    /** Заменяет блок, проигрывает звук и тратит прочность инструмента. Вызывать только на сервере. */
    protected static void apply(UseOnContext context, BlockState oldState, BlockState newState, SoundEvent sound, boolean debris) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        level.setBlock(pos, newState, 3);
        level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (debris && level instanceof ServerLevel serverLevel) {
            Vec3 hit = context.getClickLocation();
            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, oldState), hit.x, hit.y, hit.z, 12, 0.15, 0.15, 0.15, 0.0);
        }
        if (player != null && !isCreative(player)) {
            context.getItemInHand().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));
        }
    }

    protected static InteractionResult done(Level level) {
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
