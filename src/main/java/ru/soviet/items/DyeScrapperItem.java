package ru.soviet.items;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.paint.ConcretePaint;

import java.util.List;

/**
 * Шпатель для очистки: снимает краску с железобетона. Свежая краска сходит до чистого серого бетона,
 * под старой (облезшей) остаётся потрескавшийся серый бетон — его потом заделывают раствором.
 */
public class DyeScrapperItem extends PaintToolItem {

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockState state = level.getBlockState(context.getClickedPos());

        ConcretePaint.Entry entry = ConcretePaint.get(state);
        if (entry == null || entry.color().equals(ConcretePaint.GRAY)) return InteractionResult.PASS;

        if (!level.isClientSide) {
            boolean worn = ConcretePaint.isWorn(state, entry);
            apply(context, state, ConcretePaint.convert(state, entry, ConcretePaint.GRAY, worn), SoundEvents.AXE_SCRAPE, true);
        }
        return done(level);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("info.dye_scrapper"));
    }
}
