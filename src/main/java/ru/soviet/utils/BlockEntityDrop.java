package ru.soviet.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import java.util.Random;

public class BlockEntityDrop {
    private static final Random RANDOM = new Random();

    public static void dropContents(Level level, BlockPos pos, BlockEntity blockEntity) {
        if (blockEntity == null) return;

        blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack stack = handler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    // Центр блока
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + 0.5;
                    double z = pos.getZ() + 0.5;

                    ItemEntity itemEntity = new ItemEntity(level, x, y, z, stack.copy());

                    // Случайное движение для эффекта разлёта
                    double motionX = (RANDOM.nextDouble() - 0.5) * 0.8;
                    double motionY = RANDOM.nextDouble() * 0.4 + 0.0;
                    double motionZ = (RANDOM.nextDouble() - 0.5) * 0.8;

                    itemEntity.setDeltaMovement(motionX, motionY, motionZ);
                    itemEntity.setPickUpDelay(40);

                    level.addFreshEntity(itemEntity);
                }
            }
        });
    }
}