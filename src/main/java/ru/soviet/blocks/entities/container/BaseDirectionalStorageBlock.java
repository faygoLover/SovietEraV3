package ru.soviet.blocks.entities.container;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.Directional4MBlock;
import ru.soviet.reg.RegSounds;
import ru.soviet.utils.BlockEntityDrop;

import java.util.function.Supplier;

public abstract class BaseDirectionalStorageBlock extends Directional4MBlock implements EntityBlock {
    protected final Supplier<BlockEntityType<?>> blockEntityType;

    public BaseDirectionalStorageBlock(Properties properties, String hoverTextKey, VoxelShape shape,
                                       Supplier<BlockEntityType<?>> blockEntityType) {
        super(properties, hoverTextKey, shape);
        this.blockEntityType = blockEntityType;
    }

    public BaseDirectionalStorageBlock(Properties properties, String hoverTextKey,
                                       Supplier<BlockEntityType<?>> blockEntityType) {
        this(properties, hoverTextKey, null, blockEntityType);
    }

    public BaseDirectionalStorageBlock(Properties properties, VoxelShape shape,
                                       Supplier<BlockEntityType<?>> blockEntityType) {
        this(properties, "info.storage", shape, blockEntityType);
    }

    public BaseDirectionalStorageBlock(Properties properties, Supplier<BlockEntityType<?>> blockEntityType) {
        this(properties, "info.storage", null, blockEntityType);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity == null) {
                blockEntity = newBlockEntity(pos, state);
                if (blockEntity != null) {
                    level.setBlockEntity(blockEntity);
                }
            }

            level.playSound(null, pos, RegSounds.WOOD_DOOR.get(), SoundSource.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            if (blockEntity instanceof MenuProvider menuProvider) {
                player.openMenu(menuProvider);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return blockEntityType.get().create(pos, state);
    }

    @Override
    public MenuProvider getMenuProvider(@NotNull BlockState state, Level level, @NotNull BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        return be instanceof MenuProvider ? (MenuProvider) be : null;
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                         BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntityDrop.dropContents(level, pos, level.getBlockEntity(pos));
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}