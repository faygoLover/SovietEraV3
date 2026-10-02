package ru.soviet.reg;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.entities.container.drawers.DrawerStorageBlockEntity;
import ru.soviet.blocks.entities.container.dsp.DspStorageBlockEntity;
import ru.soviet.blocks.entities.container.kitchen.KitchenStorageBlockEntity;
import ru.soviet.blocks.entities.container.safe.SafeStorageBlockEntity;
import ru.soviet.blocks.entities.clock.ClockBlockEntity;
import ru.soviet.blocks.entities.devices.PcBlockEntity;
import ru.soviet.blocks.entities.holder.HolderBlockEntity;
import ru.soviet.core.SovietEra;

import java.util.Arrays;
import java.util.function.BiFunction;

public class RegBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SovietEra.MODID);

    @SafeVarargs
    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(
            String name,
            BiFunction<BlockPos, BlockState, T> factory,
            RegistryObject<? extends Block>... blocks) {
        return BLOCK_ENTITIES.register(name, () -> {
            Block[] blockArray = Arrays.stream(blocks).map(RegistryObject::get).toArray(Block[]::new);
            return BlockEntityType.Builder.of(factory::apply, blockArray).build(null);
        });
    }

    public static final RegistryObject<BlockEntityType<DrawerStorageBlockEntity>> DRAWER_STORAGE =
            register("drawer", DrawerStorageBlockEntity::new,
                    RegBlocksInner.BIOLAB_TABLE4,
                    RegBlocksInner.BIOLAB_TABLE,
                    RegBlocksInner.CHEMLAB_TABLE);

    public static final RegistryObject<BlockEntityType<SafeStorageBlockEntity>> SAFE_STORAGE =
            register("safe", SafeStorageBlockEntity::new,
                    RegBlocksInner.SAFE);

    public static final RegistryObject<BlockEntityType<DspStorageBlockEntity>> DSP_STORAGE =
            register("dsp", DspStorageBlockEntity::new,
                    RegBlocksInner.DSP_TUMB,
                    RegBlocksInner.DSP_TABLE);

    public static final RegistryObject<BlockEntityType<KitchenStorageBlockEntity>> KITCHEN_STORAGE =
            register("kitchen", KitchenStorageBlockEntity::new,
                    RegBlocksInner.KITCHEN_TABLE);

    public static final RegistryObject<BlockEntityType<HolderBlockEntity>> HOLDER =
            register("holder_block", HolderBlockEntity::new,
                    RegBlocksInner.CHEMLAB_TABLE_UP,
                    RegBlocksInner.BIOLAB_TABLE_UP);

    public static final RegistryObject<BlockEntityType<ClockBlockEntity>> CLOCK =
            register("clock", ClockBlockEntity::new,
                    RegBlocksInner.CLOCK_ELECTRINIKA_DISP);

    public static final RegistryObject<BlockEntityType<PcBlockEntity>> PC =
            register("pc", PcBlockEntity::new,
                    RegBlocksInner.SMALL_COMPUTER,
                    RegBlocksInner.COMPUTER,
                    RegBlocksInner.SPEC_MONITOR);
}