package ru.soviet.reg;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.dsp.DspStorageBlockEntity;
import ru.soviet.blocks.safe.SafeStorageBlockEntity;
import ru.soviet.core.SovietEra;
import ru.soviet.blocks.drawers.DrawerStorageBlockEntity;

public class RegBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SovietEra.MODID);

    // Единый тип для всех столов с инвентарём
    public static final RegistryObject<BlockEntityType<DrawerStorageBlockEntity>> DRAWER_STORAGE =
            BLOCK_ENTITIES.register("drawer",
                    () -> BlockEntityType.Builder.of(
                            DrawerStorageBlockEntity::new,
                            RegBlocksInner.BIOLAB_TABLE4.get(),
                            RegBlocksInner.BIOLAB_TABLE.get(),
                            RegBlocksInner.CHEMLAB_TABLE.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<SafeStorageBlockEntity>> SAFE_STORAGE =
            BLOCK_ENTITIES.register("safe",
                    () -> BlockEntityType.Builder.of(
                            SafeStorageBlockEntity::new,
                            RegBlocksInner.SAFE.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<DspStorageBlockEntity>> DSP_STORAGE =
            BLOCK_ENTITIES.register("dsp",
                    () -> BlockEntityType.Builder.of(
                            DspStorageBlockEntity::new,
                            RegBlocksInner.DSP_TUMB.get(),
                            RegBlocksInner.DSP_TABLE.get()
                    ).build(null));
}