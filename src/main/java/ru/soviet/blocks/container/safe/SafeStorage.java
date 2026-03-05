package ru.soviet.blocks.container.safe;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.Directional4MBlock;
import ru.soviet.utils.BlockEntityDrop;

public class SafeStorage extends Directional4MBlock implements EntityBlock {

    public SafeStorage(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape);
    }

    public SafeStorage(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, null);
    }

    public SafeStorage(Properties properties, VoxelShape shape) {
        super(properties, "info.storage", shape);
    }

    public SafeStorage(Properties properties) {
        super(properties, "info.storage", null);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            // Если блочная сущность по какой-то причине отсутствует (например, ошибка регистрации), создаём её вручную
            if (blockEntity == null) {
                blockEntity = new SafeStorageBlockEntity(pos, state);
                level.setBlockEntity(blockEntity);
            }
            if (blockEntity instanceof MenuProvider) {
                player.openMenu((MenuProvider) blockEntity);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new SafeStorageBlockEntity(pos, state);
    }

    @Override
    public MenuProvider getMenuProvider(@NotNull BlockState state, Level level, @NotNull BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        return blockEntity instanceof MenuProvider ? (MenuProvider) blockEntity : null;
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            BlockEntityDrop.dropContents(level, pos, blockEntity);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}