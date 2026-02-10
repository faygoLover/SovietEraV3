package ru.soviet.reg;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.soviet.core.SovietEra;

public class RegFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SovietEra.MODID);

    //public static final ResourceLocation TOXIC_WATER_STILL_RL = new ResourceLocation(SovietEra.MODID, "block/toxic_water_still");
    //public static final ResourceLocation TOXIC_WATER_FLOWING_RL = new ResourceLocation(SovietEra.MODID, "block/toxic_water_flow");
    //public static final ResourceLocation TOXIC_WATER_OVERLAY_RL = new ResourceLocation(SovietEra.MODID, "block/toxic_water_overlay");


}
