package ru.soviet.reg;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.core.SovietEra;
import ru.soviet.blocks.entities.chair.SeatEntity;

public class RegEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SovietEra.MODID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT =
            ENTITIES.register("seat",
                    () -> EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC)
                            .sized(0.0f, 0.0f)   // невидимая
                            .build("seat"));
}