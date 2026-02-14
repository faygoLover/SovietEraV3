/*
package ru.soviet.utils;

import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import ru.soviet.blocks.container.BaseStorageBlockEntity;

public class BlockEntityDrop {
    public static void dropContents(Level level, BlockPos pos, BlockEntity blockEntity) {
        if (blockEntity instanceof BaseStorageBlockEntity storage) {
            IItemHandler handler = storage.getItemHandler();
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack stack = handler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), stack);
                }
            }
        }
    }
}
*/

package ru.soviet.utils;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import ru.soviet.blocks.container.BaseStorageBlockEntity;

import java.util.Random;

public class BlockEntityDrop {
    private static final Random RANDOM = new Random();

    public static void dropContents(Level level, BlockPos pos, BlockEntity blockEntity) {
        if (blockEntity instanceof BaseStorageBlockEntity storage) {
            IItemHandler handler = storage.getItemHandler();
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack stack = handler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    // Центр блока
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + 0.5;
                    double z = pos.getZ() + 0.5;

                    // Создаём сущность предмета
                    ItemEntity itemEntity = new ItemEntity(level, x, y, z, stack.copy());

                    // Задаём случайное движение для эффекта разлета
                    double motionX = (RANDOM.nextDouble() - 0.5) * 0.8; // разброс по горизонтали
                    double motionY = RANDOM.nextDouble() * 0.4 + 0.0;   // подскок вверх
                    double motionZ = (RANDOM.nextDouble() - 0.5) * 0.8;

                    itemEntity.setDeltaMovement(motionX, motionY, motionZ);

                    // Небольшая задержка перед возможностью подобрать
                    itemEntity.setPickUpDelay(40);

                    level.addFreshEntity(itemEntity);
                }
            }
        }
    }
}