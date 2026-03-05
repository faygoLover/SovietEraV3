package ru.soviet.reg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.core.SovietEra;

public class RegSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SovietEra.MODID);

    public static final RegistryObject<SoundEvent> MOTION_SENSOR = SOUND_EVENTS.register("motion_sensor", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "motion_sensor")));
    public static final RegistryObject<SoundEvent> RAD_ALARM = SOUND_EVENTS.register("rad_alarm", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "rad_alarm")));
    public static final RegistryObject<SoundEvent> CHEM_ALARM = SOUND_EVENTS.register("chem_alarm", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "chem_alarm")));
    public static final RegistryObject<SoundEvent> BIO_ALARM = SOUND_EVENTS.register("bio_alarm", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "bio_alarm")));
    public static final RegistryObject<SoundEvent> AIRLOCK_DOOR = SOUND_EVENTS.register("airlock_door", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "airlock_door")));
    public static final RegistryObject<SoundEvent> CONTAINMENT_DOOR = SOUND_EVENTS.register("containment_door", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "containment_door")));
    public static final RegistryObject<SoundEvent> ALM_DOOR = SOUND_EVENTS.register("alm_door", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "alm_door")));
    public static final RegistryObject<SoundEvent> WOOD_DOOR = SOUND_EVENTS.register("wood_door", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "wood_door")));
    public static final RegistryObject<SoundEvent> RUSTY_LEVER = SOUND_EVENTS.register("rusty_lever", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "rusty_lever")));
    public static final RegistryObject<SoundEvent> LOCKED = SOUND_EVENTS.register("locked", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "locked")));
    public static final RegistryObject<SoundEvent> METAL_DOOR = SOUND_EVENTS.register("metal_door", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "metal_door")));
    public static final RegistryObject<SoundEvent> SPARKING = SOUND_EVENTS.register("sparking", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "sparking")));
    public static final RegistryObject<SoundEvent> CRUSHER = SOUND_EVENTS.register("crusher", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "crusher")));
    public static final RegistryObject<SoundEvent> DEVICE_ENABLE = SOUND_EVENTS.register("device_enable", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "device_enable")));
    public static final RegistryObject<SoundEvent> SNAP = SOUND_EVENTS.register("snap", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "snap")));
    public static final RegistryObject<SoundEvent> RELAY = SOUND_EVENTS.register("relay", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "relay")));
    public static final RegistryObject<SoundEvent> FLUO_LAMP = SOUND_EVENTS.register("fluo_lamp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "fluo_lamp")));
    public static final RegistryObject<SoundEvent> AFFINAGE = SOUND_EVENTS.register("affinage", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "affinage")));
    public static final RegistryObject<SoundEvent> GRINDER_IDLE = SOUND_EVENTS.register("grinder_idle", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "grinder_idle")));
    public static final RegistryObject<SoundEvent> GRINDER_WORK = SOUND_EVENTS.register("grinder_work", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "grinder_work")));
    public static final RegistryObject<SoundEvent> DEMONT = SOUND_EVENTS.register("demont", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SovietEra.MODID, "demont")));
}