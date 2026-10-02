package ru.soviet.reg;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.entity.EThingProjectile;
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

    public static final RegistryObject<EntityType<EThingProjectile>> E_THING_PROJECTILE = ENTITIES.register("e_thing_projectile",
            () -> EntityType.Builder.<EThingProjectile>of(EThingProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("e_thing_projectile")
    );
}