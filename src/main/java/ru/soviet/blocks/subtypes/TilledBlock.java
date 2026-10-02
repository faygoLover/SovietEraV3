package ru.soviet.blocks.subtypes;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.BaseBlock;

import java.util.List;
import java.util.function.Supplier;

public class TilledBlock extends BaseBlock {

    // Заданы только у битых вариантов: во что блок превращается при починке и какой плиткой чинится
    @Nullable
    private final Supplier<? extends Block> repaired;
    @Nullable
    private final Supplier<? extends Item> repairTile;

    public TilledBlock(String hoverTextKey, @Nullable Supplier<? extends Block> repaired, @Nullable Supplier<? extends Item> repairTile) {
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
            .requiresCorrectToolForDrops()
            .strength(5.5F, 15F)
        ,hoverTextKey);
        this.repaired = repaired;
        this.repairTile = repairTile;
    }
    public TilledBlock(String hoverTextKey) {
        this(hoverTextKey, null, null);
    }
    public TilledBlock() {
        this(null, null, null);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (repaired == null || repairTile == null) return InteractionResult.PASS;
        ItemStack stack = player.getItemInHand(hand);
        if (!stack.is(repairTile.get())) return InteractionResult.PASS;

        if (!level.isClientSide) {
            level.setBlock(pos, repaired.get().defaultBlockState(), 3);
            level.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 1.2F);
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (repairTile != null) {
            tooltip.add(Component.translatable("info.tile_repair", repairTile.get().getDescription()));
        }
    }
}
