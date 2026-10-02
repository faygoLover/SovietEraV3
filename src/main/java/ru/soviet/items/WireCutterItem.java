package ru.soviet.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import ru.soviet.blocks.decorative.innerdeco.WallWire;

/**
 * Кусачки: ПКМ по настенному проводу мгновенно снимает его.
 */
public class WireCutterItem extends BaseItem {

    public WireCutterItem() {
        super(new Item.Properties().durability(3750).setNoRepair(), "info.wire_cutter");
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        if (!(state.getBlock() instanceof WallWire)) return InteractionResult.PASS;

        if (!level.isClientSide) {
            Player player = context.getPlayer();
            boolean creative = player != null && player.getAbilities().instabuild;
            level.destroyBlock(pos, !creative, player);
            if (player != null && !creative) {
                context.getItemInHand().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
