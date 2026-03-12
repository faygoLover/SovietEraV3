/*
package ru.soviet.blocks.holder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.Directional4MBlock;

public class HolderBlock extends Directional4MBlock implements EntityBlock {

    public HolderBlock(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
    }

    public HolderBlock(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, null);
    }

    public HolderBlock(Properties properties, VoxelShape shape) {
        super(properties, "info.holder", shape);
    }

    public HolderBlock(Properties properties) {
        super(properties, "info.holder", null);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new HolderBlockEntity(pos, state);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos,
                                          @NotNull Player player, @NotNull InteractionHand hand,
                                          @NotNull BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof HolderBlockEntity holder)) return InteractionResult.PASS;

        ItemStack stack = player.getItemInHand(hand);

        if (!stack.isEmpty() && stack.getItem() instanceof BlockItem blockItem) {
            // Пытаемся поместить блок в пустой контейнер
            Block blockToPlace = blockItem.getBlock();
            if (holder.isEmpty()) {
                holder.setStoredBlock(blockToPlace.defaultBlockState());
                if (!player.getAbilities().instabuild) stack.shrink(1);
                return InteractionResult.CONSUME;
            }
        } else if (stack.isEmpty()) {
            // Извлекаем блок пустой рукой
            if (!holder.isEmpty()) {
                BlockState stored = holder.getStoredBlock();
                if (stored != null) {
                    ItemStack extractedStack = new ItemStack(stored.getBlock());
                    player.setItemInHand(hand, extractedStack);
                    holder.setStoredBlock(null);
                    return InteractionResult.CONSUME;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof HolderBlockEntity holder && !holder.isEmpty()) {
                // Выбросить внутренний блок при разрушении
                BlockState stored = holder.getStoredBlock();
                if (stored != null) {
                    ItemStack stack = new ItemStack(stored.getBlock());
                    popResource(level, pos, stack);
                }
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }
}
 */

