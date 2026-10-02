package ru.soviet.blocks.entities.container;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseStorageBlockEntity<T extends AbstractContainerMenu> extends BlockEntity implements MenuProvider {
    protected final ItemStackHandler itemHandler;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Component displayName;

    public BaseStorageBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, Component displayName, int inventorySize) {
        super(type, pos, state);
        this.displayName = displayName;
        this.itemHandler = new StorageHandler(inventorySize);
    }

    // Хранилище, которое знает свою блок-сущность: меню по нему проверяет, что блок ещё на месте
    public class StorageHandler extends ItemStackHandler {
        private StorageHandler(int size) {
            super(size);
        }

        public BaseStorageBlockEntity<?> getOwner() {
            return BaseStorageBlockEntity.this;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    }

    public boolean stillValid(Player player) {
        if (isRemoved() || level == null || level.getBlockEntity(worldPosition) != this) return false;
        return player.distanceToSqr(worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5) <= 64.0;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return displayName;
    }

    @Nullable
    @Override
    public abstract T createMenu(int id, @NotNull Inventory inventory, @NotNull Player player);

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
    }
}