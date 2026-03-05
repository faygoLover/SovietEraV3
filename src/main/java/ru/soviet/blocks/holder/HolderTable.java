package ru.soviet.blocks.holder;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.Linear4MBlock;

public class HolderTable extends Linear4MBlock implements EntityBlock {

    // Конструкторы (как в исходном коде)
    public HolderTable(Properties properties, String hoverTextKey, VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, noneShape, leftShape, rightShape, centerShape);
    }

    public HolderTable(Properties properties, VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, "info.holder.connectable", noneShape, leftShape, rightShape, centerShape);
    }

    public HolderTable(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, shape, shape, shape);
    }

    public HolderTable(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, null, null, null, null);
    }

    public HolderTable(Properties properties, VoxelShape shape) {
        super(properties, "info.holder.connectable", shape, shape, shape, shape);
    }

    public HolderTable(Properties properties) {
        super(properties, "info.holder.connectable", null, null, null, null);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new HolderBlockEntity(pos, state);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;
        if (!(level.getBlockEntity(pos) instanceof HolderBlockEntity holder)) return InteractionResult.PASS;
        ItemStack stack = player.getItemInHand(hand);

        // Если внутри есть блок, поворачиваем его (независимо от предмета в руке)
        if (!holder.isEmpty()) {
            holder.rotate();
            level.playSound(null, pos, SoundEvents.ITEM_FRAME_ROTATE_ITEM, SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.CONSUME;
        }

        // Если внутри пусто и в руке блок – помещаем его
        if (!stack.isEmpty() && stack.getItem() instanceof BlockItem blockItem) {
            float yaw = player.getYRot();
            int rotation = Math.round((yaw + 360) % 360 / 30) * 30; // начальный поворот по взгляду

            BlockState blockToPlace = blockItem.getBlock().defaultBlockState();
            holder.setStoredBlock(blockToPlace);
            holder.setRotation(rotation);

            if (!player.getAbilities().instabuild) stack.shrink(1);
            level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.CONSUME;
        }

        // Если внутри пусто и рука пуста – ничего не делаем
        return InteractionResult.PASS;
    }

    // Обработка левого клика (атаки) по блоку
    @Override
    public void attack(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player) {
        if (level.isClientSide) return;
        if (!(level.getBlockEntity(pos) instanceof HolderBlockEntity holder)) return;

        // Если внутри есть блок – выбрасываем его в мир и предотвращаем разрушение
        if (!holder.isEmpty()) {
            BlockState stored = holder.getStoredBlock();
            if (stored != null) {
                ItemStack stack = new ItemStack(stored.getBlock());
                popResource(level, pos, stack);
                holder.setStoredBlock(null);
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
            // Не вызываем super, чтобы блок не получил урон (атака обработана)
        } else {
            // Если внутри пусто, разрешаем стандартную атаку (разрушение блока)
            super.attack(state, level, pos, player);
        }
    }

    // При разрушении блока (например, взрывом) выбрасываем внутренний блок
    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof HolderBlockEntity holder && !holder.isEmpty()) {
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