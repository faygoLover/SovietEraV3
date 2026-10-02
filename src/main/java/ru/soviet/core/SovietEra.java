package ru.soviet.core;

//import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
//import org.slf4j.Logger;
import ru.soviet.reg.*;

@Mod(SovietEra.MODID)
public class SovietEra {

    public static final String MODID = "soviet";
    //private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public SovietEra() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegTabs.CREATIVE_MODE_TABS.register(modEventBus);
        RegBlocksInner.BLOCKS_INNER.register(modEventBus);
        RegBlocksOuter.BLOCKS_OUTER.register(modEventBus);
        RegBlocksMain.BLOCKS_MAIN.register(modEventBus);
        RegBlocksSymbols.BLOCKS_SYMBOLS.register(modEventBus);
        RegBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        RegEntities.ENTITIES.register(modEventBus);
        RegMenuTypes.MENUS.register(modEventBus);
        RegSounds.SOUND_EVENTS.register(modEventBus);
        RegItems.ITEMS.register(modEventBus);
        RegItems.BLOCK_ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        // Register the commonSetup method for mod loading
        // modEventBus.addListener(this::commonSetup);
    }

    //private void commonSetup(final FMLCommonSetupEvent event) {}
}
