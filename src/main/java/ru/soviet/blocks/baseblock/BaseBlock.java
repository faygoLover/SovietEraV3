package ru.soviet.blocks.baseblock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BaseBlock extends Block {
    public final ThreadLocalRandom tr = ThreadLocalRandom.current();
    public boolean canProvidePower(BlockState state) {return true;}
    public String info;

    public BaseBlock(Properties properties, String info) {
        super(properties);
        this.info = info;
    }

    public BaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerDestroy(Level worldIn, Player player, BlockPos pos, BlockState state, @Nullable net.minecraft.world.level.block.entity.BlockEntity blockEntity, ItemStack stack) {
        player.awardStat(Stats.BLOCK_MINED.get(this));
        player.causeFoodExhaustion(0.005F);
        this.spawnDestroyParticles(worldIn, player, pos, state);
        super.playerDestroy(worldIn, player, pos, state, blockEntity, stack);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter worldIn, @NotNull List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        if(info == null) {
            return;
        }
        tooltip.add(Component.translatable(info));
    }
}
