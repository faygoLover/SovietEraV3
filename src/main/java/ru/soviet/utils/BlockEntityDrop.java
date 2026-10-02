package ru.soviet.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.concurrent.ThreadLocalRandom;

public class BlockEntityDrop {
    public static void dropContents(Level level, BlockPos pos, BlockEntity blockEntity) {
        if (level.isClientSide || blockEntity == null) return;

        blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack stack = handler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + 0.5;
                    double z = pos.getZ() + 0.5;

                    ItemEntity itemEntity = new ItemEntity(level, x, y, z, stack.copy());

                    var random = ThreadLocalRandom.current();
                    double motionX = (random.nextDouble() - 0.5) * 0.8;
                    double motionY = random.nextDouble() * 0.4;
                    double motionZ = (random.nextDouble() - 0.5) * 0.8;

                    itemEntity.setDeltaMovement(motionX, motionY, motionZ);
                    itemEntity.setPickUpDelay(40);

                    level.addFreshEntity(itemEntity);

                    // Слот очищаем: иначе у игрока с открытым меню останутся те же предметы (дюп)
                    if (handler instanceof IItemHandlerModifiable modifiable) {
                        modifiable.setStackInSlot(i, ItemStack.EMPTY);
                    }
                }
            }
        });
    }
}