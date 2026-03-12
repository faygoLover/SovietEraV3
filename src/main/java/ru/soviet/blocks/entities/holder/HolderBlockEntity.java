package ru.soviet.blocks.entities.holder;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.soviet.reg.RegBlockEntities;

public class HolderBlockEntity extends BlockEntity {

    private BlockState storedBlock = Blocks.AIR.defaultBlockState();
    private int rotation = 0; // угол поворота в градусах (0–360, кратен 30)

    public HolderBlockEntity(BlockPos pos, BlockState state) {
        super(RegBlockEntities.HOLDER.get(), pos, state);
    }

    public boolean isEmpty() {
        return storedBlock.isAir();
    }

    @Nullable
    public BlockState getStoredBlock() {
        return storedBlock.isAir() ? null : storedBlock;
    }

    public void setStoredBlock(@Nullable BlockState state) {
        this.storedBlock = state == null ? Blocks.AIR.defaultBlockState() : state;
        this.rotation = 0; // сбрасываем поворот при установке нового блока
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation % 360;
        if (this.rotation < 0) this.rotation += 360;
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    public void rotate() {
        setRotation(rotation + 30);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        if (!storedBlock.isAir()) {
            tag.putInt("stored_block", Block.getId(storedBlock));
        }
        tag.putInt("rotation", rotation);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        if (tag.contains("stored_block")) {
            storedBlock = Block.stateById(tag.getInt("stored_block"));
        } else {
            storedBlock = Blocks.AIR.defaultBlockState();
        }
        rotation = tag.getInt("rotation");
        // нормализация, если вдруг сохранено некорректное значение
        rotation = (rotation / 30) * 30;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }
}