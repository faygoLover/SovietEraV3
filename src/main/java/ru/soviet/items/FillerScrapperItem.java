package ru.soviet.items;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.paint.BucketContent;
import ru.soviet.blocks.paint.ConcretePaint;
import ru.soviet.blocks.paint.DyeBucketBlock;

import java.util.List;

/**
 * Шпатель: набирает бетонный раствор из ведра и заделывает им потрескавшийся серый железобетон.
 */
public class FillerScrapperItem extends PaintToolItem {

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();

        if (state.getBlock() instanceof DyeBucketBlock) {
            if (state.getValue(DyeBucketBlock.COLOR) != BucketContent.FILLER) return InteractionResult.PASS;
            if (!level.isClientSide) {
                setUses(stack, USES_PER_BUCKET);
                level.setBlock(pos, state.setValue(DyeBucketBlock.COLOR, BucketContent.EMPTY), 3);
                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 0.6F);
            }
            return done(level);
        }

        ConcretePaint.Entry entry = ConcretePaint.get(state);
        if (entry == null || !ConcretePaint.isWorn(state, entry)) return InteractionResult.PASS;
        if (level.isClientSide) return InteractionResult.SUCCESS;

        if (!entry.color().equals(ConcretePaint.GRAY)) {
            hint(player, "message.soviet.need_scrape");
            return InteractionResult.FAIL;
        }
        if (getUses(stack) <= 0 && !isCreative(player)) {
            hint(player, "message.soviet.scrapper_empty");
            return InteractionResult.FAIL;
        }

        apply(context, state, ConcretePaint.convert(state, entry, ConcretePaint.GRAY, false), SoundEvents.MUD_PLACE, false);
        if (!isCreative(player)) {
            setUses(stack, getUses(stack) - 1);
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("info.scrapper"));
        tooltip.add(Component.translatable("info.filler").append(": ").append(Component.translatable(getUses(stack) > 0 ? "fil.filler" : "fil.")));
        tooltip.add(Component.translatable("info.count").append(": " + getUses(stack)));
    }
}
