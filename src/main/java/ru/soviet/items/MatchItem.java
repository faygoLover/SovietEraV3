package ru.soviet.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

public class MatchItem extends BaseItem {
    private static final Random RANDOM = new Random();

    public MatchItem(Properties properties, String hoverTextKey) {
        super(properties.durability(60), hoverTextKey);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        // Шанс считает только сервер, иначе клиент и сервер бросают кубик по отдельности и расходятся
        if (level.isClientSide) return InteractionResult.SUCCESS;
        boolean success = RANDOM.nextFloat() < 0.5f; // 50% шанс успеха

        if (success) {
            // Пытаемся поджечь как огниво
            boolean ignited = false;
            if (state.getBlock() instanceof CampfireBlock) {
                level.setBlock(pos, state.setValue(CampfireBlock.LIT, true), 11);
                ignited = true;
            } else if (state.getBlock() instanceof TntBlock) {
                TntBlock.explode(level, pos);
                level.removeBlock(pos, false);
                ignited = true;
            } else {
                BlockPos firePos = pos.relative(context.getClickedFace());
                if (BaseFireBlock.canBePlacedAt(level, firePos, context.getHorizontalDirection())) {
                    level.setBlock(firePos, BaseFireBlock.getState(level, firePos), 11);
                    ignited = true;
                }
            }

            if (ignited) {
                // Успешно зажгли
                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
                context.getItemInHand().hurtAndBreak(1, context.getPlayer(), (p) -> p.broadcastBreakEvent(context.getHand()));
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                // Не удалось поджечь — ничего не тратим
                return InteractionResult.PASS;
            }
        } else {
            // Спичка сломалась (огонь не появляется)
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 1.0f, 1.0f);
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), (p) -> p.broadcastBreakEvent(context.getHand()));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }
}