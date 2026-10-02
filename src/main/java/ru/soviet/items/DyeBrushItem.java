package ru.soviet.items;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
 * Кисть: набирает краску из ведра и красит чистый (не облезший и не потрескавшийся) железобетон.
 */
public class DyeBrushItem extends PaintToolItem {
    public static final String COLOR_NBT = "color";

    public static String getColor(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag == null || getUses(stack) <= 0 ? "" : tag.getString(COLOR_NBT);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();

        if (state.getBlock() instanceof DyeBucketBlock) {
            BucketContent content = state.getValue(DyeBucketBlock.COLOR);
            if (!content.isPaint()) return InteractionResult.PASS;
            if (!level.isClientSide) {
                stack.getOrCreateTag().putString(COLOR_NBT, content.getConcreteColor());
                setUses(stack, USES_PER_BUCKET);
                level.setBlock(pos, state.setValue(DyeBucketBlock.COLOR, BucketContent.EMPTY), 3);
                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 0.8F);
            }
            return done(level);
        }

        ConcretePaint.Entry entry = ConcretePaint.get(state);
        if (entry == null) return InteractionResult.PASS;
        if (level.isClientSide) return InteractionResult.SUCCESS;

        String color = getColor(stack);
        if (color.isEmpty()) {
            hint(player, "message.soviet.brush_empty");
            return InteractionResult.FAIL;
        }
        if (ConcretePaint.isWorn(state, entry)) {
            hint(player, entry.color().equals(ConcretePaint.GRAY) ? "message.soviet.need_filler" : "message.soviet.need_scrape");
            return InteractionResult.FAIL;
        }
        if (entry.color().equals(color)) return InteractionResult.FAIL;

        apply(context, state, ConcretePaint.convert(state, entry, color, false), SoundEvents.BRUSH_GENERIC, false);
        if (!isCreative(player)) {
            setUses(stack, getUses(stack) - 1);
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("info.brush"));
        tooltip.add(Component.translatable("info.color").append(": ").append(Component.translatable("color." + getColor(stack))));
        tooltip.add(Component.translatable("info.count").append(": " + getUses(stack)));
    }
}
