package ru.soviet.blocks.dsp;

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
import org.jetbrains.annotations.Nullable;
import ru.soviet.blocks.baseblock.HorizontalConnectingModelBlock;
import ru.soviet.utils.BlockEntityDrop;

public class DspStorageTable extends HorizontalConnectingModelBlock implements EntityBlock {

    public DspStorageTable(Properties properties, String hoverTextKey, VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, hoverTextKey, noneShape, leftShape, rightShape, centerShape);
    }

    public DspStorageTable(Properties properties, VoxelShape noneShape, VoxelShape leftShape, VoxelShape rightShape, VoxelShape centerShape) {
        super(properties, null, noneShape, leftShape, rightShape, centerShape);
    }

    public DspStorageTable(Properties properties, String hoverTextKey, VoxelShape shape) {
        super(properties, hoverTextKey, shape, shape, shape, shape);
    }

    public DspStorageTable(Properties properties, String hoverTextKey) {
        super(properties, hoverTextKey, null, null, null, null);
    }

    public DspStorageTable(Properties properties, VoxelShape shape) {
        super(properties, null, shape, shape, shape, shape);
    }

    public DspStorageTable(Properties properties) {
        super(properties, null, null, null, null, null);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            // Если блочная сущность по какой-то причине отсутствует (например, ошибка регистрации), создаём её вручную
            if (blockEntity == null) {
                blockEntity = new DspStorageBlockEntity(pos, state);
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
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DspStorageBlockEntity(pos, state);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        return blockEntity instanceof MenuProvider ? (MenuProvider) blockEntity : null;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            BlockEntityDrop.dropContents(level, pos, blockEntity);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}