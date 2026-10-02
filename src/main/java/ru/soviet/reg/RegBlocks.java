/*
package ru.soviet.reg;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.baseblock.subtypes.*;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;


public class RegBlocks {
public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);
public static final RegistryObject<Block> CONCRETE_RED_TEST = registerBlock("concrete/concrete_red_test", () -> new FerroconcreteBlock( "info.red"));

// REDSTONE_CABLE = registerOnlyCustomBlock("innerdeco/redstone_cable", () -> new RedstoneCable(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));


public static final RegistryObject<Block> TOXIC_AIR = registerBlockWithModel("toxic_air", () -> new ToxicAir(getP(Material.AIR, 0f,0f, null, 0, SoundType.WOOD, false, true)), null);

public static final RegistryObject<Block> RUSTY_FRAME = registerBlockWithModel("rusty_frames", () -> new RustyFrameBlock(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> DYE_BUCKET = registerOnlyCustomBlock("placeable/dye_bucket", () -> new BucketDye(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true), 1F));

public static final RegistryObject<Block> STEEL_PYLON = registerBlockWithModel("structural/steel_pylon", () -> new pPylonBlock(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> HORIZONTAL_STEEL_PYLON = registerBlockWithModel("structural/steel_pylon_horizontal", () -> new pPylonBlockH(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> ANTENNA = registerBlockWithModel("structural/antenna", () -> new Antenna(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));

//cleaned metal blocks
public static final RegistryObject<Block> CLEAN_IRON_BEAM_CONCRETE = registerBlockWithModel("cleaned/iron_beam_concrete", () -> new BlockRotatedAxisCustomModel(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid(), 0.5F));
public static final RegistryObject<Block> CLEAN_IRON_BEAM = registerBlockWithModel("cleaned/iron_beam", () -> new BlockRotatedAxisCustomModel(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid(), 0.5F));
public static final RegistryObject<Block> CLEAN_IRON_BEAM_THIN = registerBlockWithModel("cleaned/iron_beam_thin", () -> new BlockRotatedAxisCustomModel(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid(), 0.5F));
public static final RegistryObject<Block> CLEAN_RAILING_BLOCK = registerBlockWithModel("cleaned/railing_clean", () -> new RailingBlock(getP(Material.IRON, 0.5f,0.25f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), "info.railing", 0.5F));
public static final RegistryObject<Block> CLEAN_RAILING_DOOR = registerOnlyCustomBlock("cleaned/railing_door", () -> new RailingDoorBlock(getP(Material.IRON, 0.95f,1.1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEAN_RUSTY_BARS = registerBlockWithModel("cleaned/rusty_bars", () -> new RustyBars(getP(Material.IRON, 0.95f,1.1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_ANTENNA = registerBlockWithModel("cleaned/antenna", () -> new Antenna(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> CLEANED_STEEL_PYLON = registerBlockWithModel("cleaned/steel_pylon", () -> new pPylonBlock(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> CLEANED_HORIZONTAL_STEEL_PYLON = registerBlockWithModel("cleaned/steel_pylon_horizontal", () -> new PylonBlockH(getP(Material.IRON, 0.4f,0.6f, null, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> CLEANED_CONTAINMENT_TRAPDOOR = registerOnlyCustomBlock("cleaned/containment_trapdoor", () -> new ContainmentTrapdoor(getP(Material.ANVIL, 4.8f,12.0f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_CONTAINMENT_DOOR = registerOnlyCustomBlock("cleaned/containment_door", () -> new ContainmentDoor(getP(Material.ANVIL, 4.8f,12.0f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_RUSTY_IRON_DOOR = registerOnlyCustomBlock("cleaned/rusty_iron_door", () -> new RustyIronDoor(getP(Material.IRON, 1.0f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_HALF_CIRCLE_GRID = registerBlockWithModel("cleaned/half_circle_grid", () -> new WindowGrid(getP(Material.IRON, 1.6f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> CLEANED_DIAGONAL_GRID = registerBlockWithModel("cleaned/diagonal_grid", () -> new WindowGrid(getP(Material.IRON, 1.6f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> CLEANED_FULL_DIAGONAL_GRID = registerBlockWithModel("cleaned/full_diagonal_grid", () -> new WindowGrid(getP(Material.IRON, 1.4f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> CLEANED_FULL_DIAGONAL_GRID_INVERT = registerBlockWithModel("cleaned/full_diagonal_grid_invert", () -> new WindowGrid(getP(Material.IRON, 1.4f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> CLEANED_BARB_WIRE = registerBlockWithModel("cleaned/barb_wire", () -> new BarbWire(getP(Material.IRON, 0.65f,1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_SPIRAL_BARB_WIRE = registerBlockWithModel("cleaned/spiral_barb_wire", () -> new SpiralBarbWire(getP(Material.IRON, 0.9f,2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CLEANED_FLOOR_GRID = registerBlockWithModel("cleaned/floor_grid", () -> new FloorGrid(getP(Material.IRON, 0.78f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CLEANED_CHAIN = registerBlockWithModel("cleaned/chain", () -> new Chain(getP(Material.IRON, 0.3f,0.4f,ToolType.PICKAXE, 0, SoundType.METAL, true, true)) {});
public static final RegistryObject<Block> CLEANED_LADDER_1 = registerBlockWithModel("cleaned/ladder_1", () -> new BlockLadder(getP(Material.IRON, 0.8f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_LADDER_2 = registerBlockWithModel("cleaned/ladder_2", () -> new BlockLadder(getP(Material.IRON, 0.8f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_VENT_PIPE = registerBlockWithModel("cleaned/ventpipe", () -> new VentPipe(getP(Material.IRON, 0.5f,0.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_VENT_PIPE_BASE = registerBlockWithModel("cleaned/ventpipe_base", () -> new VentPipeBase(getP(Material.IRON, 1.5f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_VENT_PIPE_FILTER = registerBlockWithModel("cleaned/ventpipe_filter", () -> new VentPipeFilter(getP(Material.IRON, 1.5f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CLEANED_HOME_PIPES = registerBlockWithModel("cleaned/home_pipes", () -> new HomePipes(getP(Material.IRON, 1f,2f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CLEANED_HOME_PIPES_BATTERY = registerBlockWithModel("cleaned/home_pipes_battery", () -> new HomePipesBattery(getP(Material.IRON, 2f,4f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CLEANED_VENT_GRID = registerBlockWithModel("cleaned/vent_grid", () -> new VentGrid(getP(Material.IRON, 1.5f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLEANED_TUBING_HORIZONTAL = registerBlockWithModel("cleaned/tubing_horizontal", () -> new TubingBlock(getP(Material.IRON, 1.7f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true),0.6F));
public static final RegistryObject<Block> CLEANED_TUBING_VERTICAL = registerBlockWithModel("cleaned/tubing_vertical", () -> new TubingBlock(getP(Material.IRON, 1.7f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true),0.6F));
public static final RegistryObject<Block> CLEANED_METRO_RAIL = registerBlockWithModel("cleaned/metro_rail", () -> new MetroRail(0.6F));
public static final RegistryObject<Block> CLEANED_RUSTY_HANDHOLD = registerBlockWithModel("cleaned/rusty_handhold", () -> new RustyHandhold(getP(Material.IRON, 0.7f,1.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CLEANED_STREET_FENCE = registerBlockWithModel("cleaned/street_handhold", () -> new ThinHandhold(getP(Material.IRON, 0.7f,1.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));

//windows
public static final RegistryObject<Block> AbstractBlock.Properties WINDOW_PROPERTIES = getP(Material.IRON, 0.9f,1.9f,ToolType.PICKAXE, 0, SoundType.GLASS, true, true);
public static final RegistryObject<Block> AbstractBlock.Properties WINDOW_PROPERTIES_WOOD = getP(Material.WOOD, 0.9f,1.9f,ToolType.AXE, 0, SoundType.GLASS, true, true);
public static final RegistryObject<Block> WOOD_WINDOW = registerBlockWithModel("innerdeco/windows/wood_window", () -> new ModernWindow(WINDOW_PROPERTIES_WOOD));
public static final RegistryObject<Block> WOOD_WINDOW_EMPTY = registerBlockWithModel("innerdeco/windows/wood_window_empty", () -> new ModernWindow(WINDOW_PROPERTIES_WOOD));
public static final RegistryObject<Block> WOOD_WINDOW_LEAF = registerBlockWithModel("innerdeco/windows/wood_window_leaf", () -> new ModernWindow(WINDOW_PROPERTIES_WOOD));
public static final RegistryObject<Block> WOOD_WINDOW_LEAF_EMPTY = registerBlockWithModel("innerdeco/windows/wood_window_leaf_empty", () -> new ModernWindow(WINDOW_PROPERTIES_WOOD));
public static final RegistryObject<Block> MODERN_WINDOW = registerBlockWithModel("innerdeco/windows/modern_window", () -> new ModernWindow(WINDOW_PROPERTIES));
public static final RegistryObject<Block> MODERN_WINDOW_EMPTY = registerBlockWithModel("innerdeco/windows/modern_window_empty", () -> new ModernWindow(WINDOW_PROPERTIES));
public static final RegistryObject<Block> MODERN_WINDOW_LEAF = registerBlockWithModel("innerdeco/windows/modern_window_leaf", () -> new ModernWindow(WINDOW_PROPERTIES));
public static final RegistryObject<Block> MODERN_WINDOW_LEAF_EMPTY = registerBlockWithModel("innerdeco/windows/modern_window_leaf_empty", () -> new ModernWindow(WINDOW_PROPERTIES));
public static final RegistryObject<Block> BLOCK_MOSS = registerBlockWithModel("outerdeco/block_moss", () -> new BlockMoss());
public static final RegistryObject<Block> BLOCK_MOSS_FULL = registerBlockWithModel("outerdeco/block_moss_full", () -> new BlockMoss());
public static final RegistryObject<Block> BLOCK_MOULD = registerBlockWithModel("outerdeco/block_mould", () -> new BlockMoss());


public static final RegistryObject<Block> ALUM_WINDOW = registerBlockWithModel("innerdeco/windows/alum_window", () -> new AlumWindow(WINDOW_PROPERTIES));
public static final RegistryObject<Block> ALUM_WINDOW_EMPTY = registerBlockWithModel("innerdeco/windows/alum_window_empty", () -> new AlumWindow(WINDOW_PROPERTIES));

public static final RegistryObject<Block> ALUM_FRAMES_EMPTY = registerBlockWithModel("innerdeco/windows/alum_frame_empty", () -> new AlumFrame(WINDOW_PROPERTIES));
public static final RegistryObject<Block> ALUM_FRAMES = registerBlockWithModel("innerdeco/windows/alum_frame", () -> new AlumFrame(WINDOW_PROPERTIES));

//redstone devices
public static final RegistryObject<Block> SWITCH_REDSTONE_WIRE = registerBlockWithModel("innerdeco/devices/switch_redstone_wire", () -> new SwitchRedstoneWire(getP(Material.WOOL, 0.8f,1.1f,ToolType.AXE, 0, SoundType.CLOTH, true, true), 1F));
public static final RegistryObject<Block> HORIZONTAL_REDSTONE_WIRE = registerBlockWithModel("innerdeco/devices/horiz_redstone_wire", () -> new HorizontalRedstoneWire(getP(Material.WOOL, 0.8f,1.1f,ToolType.AXE, 0, SoundType.CLOTH, true, true)));
public static final RegistryObject<Block> REDSTONE_WIRE = registerBlockWithModel("innerdeco/devices/redstone_wire", () -> new BlockRedstoneWire(getP(Material.WOOL, 0.8f,1.1f,ToolType.AXE, 0, SoundType.CLOTH, true, true), 1F));
public static final RegistryObject<Block> RUSTY_TUMBLER = registerBlockWithModel("innerdeco/rusty_tumbler", () -> new RustyTumbler(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(1f,4f).notSolid().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 1F));
public static final RegistryObject<Block> RUSTY_TUMBLER2 = registerBlockWithModel("innerdeco/rusty_tumbler2", () -> new RustyTumbler(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(1f,4f).notSolid().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 1F));
public static final RegistryObject<Block> AMPLIFIER_REDSTONE_WIRE = registerBlockWithModel("innerdeco/devices/amplifier_redstone_wire", () -> new AmplifierRedstoneWire(getP(Material.WOOL, 0.8f,1.1f,ToolType.AXE, 0, SoundType.CLOTH, true, true), 1F));

//furniture
public static final RegistryObject<Block> AbstractBlock.Properties FURNITURE_PROPERTIES = getP(Material.WOOD, 1f,1.2f,ToolType.AXE, 0, SoundType.WOOD, true, true);
public static final RegistryObject<Block> AbstractBlock.Properties CLOTH_PROPERTIES = getP(Material.WOOL, 0.9f,0.8f,null, 0, SoundType.CLOTH, false, true);
public static final RegistryObject<Block> BIO_STILLAGE = registerBlockWithModel("innerdeco/bio_stillage", () -> new BioStillage(getP(Material.WOOD, 0.9f,1.1f,ToolType.AXE, 0, SoundType.GLASS, true, true)) {});
public static final RegistryObject<Block> CHEMLAB_TABLE = registerBlockWithModel("innerdeco/chemlab_table", () -> new LinearTableDrawers(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> CHEMLAB_TABLE_CASE = registerBlockWithModel("innerdeco/chemlab_table_up", () -> new LinearTable(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> BIOLAB_TABLE = registerBlockWithModel("innerdeco/biolab_table", () -> new LinearTableDrawers(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> BIOLAB_TABLE_CASE = registerBlockWithModel("innerdeco/biolab_table_up", () -> new LinearTable(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> BIOLAB_TABLE2 = registerBlockWithModel("innerdeco/biolab_table2", () -> new LinearTable(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> BIOLAB_TABLE3 = registerBlockWithModel("innerdeco/biolab_table3", () -> new LinearTable(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> BIOLAB_TABLE4 = registerBlockWithModel("innerdeco/biolab_table4", () -> new LinearTableDrawers(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> PURPLE_TABLE = registerBlockWithModel("innerdeco/furniture/purple_table", () -> new PurpleTable(FURNITURE_PROPERTIES) {});
public static final RegistryObject<Block> PURPLE_CHAIR = registerBlockWithModel("innerdeco/furniture/purple_chair", () -> new PurpleChair(CLOTH_PROPERTIES, 0.5F) {});
public static final RegistryObject<Block> PINK_CHAIR = registerBlockWithModel("innerdeco/furniture/pink_chair", () -> new Chair(CLOTH_PROPERTIES, 0.5F) {});
public static final RegistryObject<Block> STILLAGE = registerBlockWithModel("innerdeco/stillage", () -> new StillageBlock(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(1f,4f).notSolid().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

//other devices
public static final RegistryObject<Block> AbstractBlock.Properties DEVICES_PROPERTIES = getP(Material.IRON, 0.7f,1f,null, 0, SoundType.METAL, false, true);
public static final RegistryObject<Block> MOTION_SENSOR = registerBlockWithModel("innerdeco/devices/motion_sensor", () -> new EntitySensor(DEVICES_PROPERTIES) {});
public static final RegistryObject<Block> TURNSTILE = registerBlockWithModel("innerdeco/devices/turnstile_off", () -> new Turnstile(getP(Material.IRON, 1.0f,1.6f,null, 0, SoundType.METAL, false, true)) {});
public static final RegistryObject<Block> COMPUTER = registerBlockWithModel("innerdeco/devices/computer", () -> new Computer(DEVICES_PROPERTIES, 1F));
public static final RegistryObject<Block> SPEC_MONITOR = registerBlockWithModel("innerdeco/devices/spec_monitor", () -> new SpecMonitor(DEVICES_PROPERTIES, 1F));
public static final RegistryObject<Block> SMALL_COMPUTER = registerBlockWithModel("innerdeco/devices/small_computer", () -> new SmallComputer(DEVICES_PROPERTIES, 1F));
public static final RegistryObject<Block> SYS_BLOCK = registerBlockWithModel("innerdeco/devices/sys_block", () -> new SystemBlock(DEVICES_PROPERTIES, 1F));
public static final RegistryObject<Block> SIREN = registerBlockWithModel("innerdeco/devices/siren", () -> new Siren(DEVICES_PROPERTIES));
public static final RegistryObject<Block> TV = registerBlockWithModel("innerdeco/devices/tv", () -> new Tv(DEVICES_PROPERTIES, 1F));
public static final RegistryObject<Block> ELECTRICAL_PANEL = registerBlockWithModel("innerdeco/devices/electrical_panel", () -> new ElectricalPanel(getP(Material.IRON, 0.9f,1.1f,null, 0, SoundType.METAL, false, true), 1F));
public static final RegistryObject<Block> GAS_STOVE = registerBlockWithModel("innerdeco/furniture/gas_stove", () -> new GasStove(getP(Material.IRON, 1.0f,1.6f,ToolType.PICKAXE, 0, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CRYOCAPSULE = registerBlockWithModel("innerdeco/cryocapsule", () -> new Cryocapsule(getP(Material.IRON, 1.0f,1.6f,ToolType.PICKAXE, 0, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> BIOLAB_CHAIR = registerBlockWithModel("innerdeco/biolab_chair", () -> new BiolabChair(getP(Material.WOOD, 0.6f,1.6f,ToolType.AXE, 0, SoundType.WOOD, true, true), 1F));
public static final RegistryObject<Block> AUTOCLAVE = registerBlockWithModel("innerdeco/autoclave", () -> new Autoclave(getP(Material.IRON, 1.0f,1.6f,ToolType.PICKAXE, 0, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> COLD_BATTERY = registerBlockWithModel("innerdeco/radiator", () -> new ColdBattery(getP(Material.IRON, 0.5f,1.1f,ToolType.PICKAXE, 0, SoundType.METAL, true, true)));
public static final RegistryObject<Block> BIO_TUMBLER = registerBlockWithModel("innerdeco/furniture/bio_tumbler", () -> new PowerTumbler(DEVICES_PROPERTIES, 1F));
public static final RegistryObject<Block> BIO_POWER_SOCKET = registerBlockWithModel("innerdeco/furniture/bio_power_socket", () -> new PowerSocket(DEVICES_PROPERTIES, 1F));
public static final RegistryObject<Block> LAB_STOVE = registerBlockWithModel("innerdeco/devices/lab_stove", () -> new ChemDevices(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(1f,4f).notSolid().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 1F));
public static final RegistryObject<Block> DRY_CAB = registerBlockWithModel("innerdeco/devices/dry_cab", () -> new DryCab(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(1f,4f).notSolid().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 1F));
public static final RegistryObject<Block> MIXER = registerBlockWithModel("innerdeco/devices/mixer", () -> new ChemDevices(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(1f,4f).notSolid().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 1F));
public static final RegistryObject<Block> MAGNET_MIXER = registerBlockWithModel("innerdeco/devices/magnet_mixer", () -> new ChemDevices(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(1f,4f).notSolid().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL), 1F));
public static final RegistryObject<Block> TUMBLER = registerBlockWithModel("innerdeco/furniture/tumbler", () -> new PowerTumbler(DEVICES_PROPERTIES, 1F));

//fence
public static final RegistryObject<Block> CONCRETE_FENCE = registerOnlyCustomBlock("outerdeco/fences/concrete_fence", () -> new ConcreteFence(getP(Material.ROCK, 1.1f,1.3f, ToolType.PICKAXE, 1, SoundType.STONE, true, true)));
public static final RegistryObject<Block> CONCRETE_FENCE_HIGH = registerOnlyCustomBlock("outerdeco/fences/concrete_fence_high", () -> new ConcreteFenceHigh(getP(Material.ROCK, 1.1f,1.3f, ToolType.PICKAXE, 1, SoundType.STONE, true, true)));
public static final RegistryObject<Block> CONCRETE_FENCE_BASE = registerBlockWithModel("outerdeco/fences/concrete_fence_base", () -> new BlockSideWithModelCustomAABB(getP(Material.ROCK, 1.1f,2.5f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), BOX_CONCRETE_FENCE_BASE, true, 0.8F));
public static final RegistryObject<Block> ELECTRO_FENCE = registerBlockWithModel("outerdeco/fences/electro_fence", () -> new ElectroFence(getP(Material.IRON, 0.6f,0.7f,ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> ELECTRO_FENCE_TUMBLER = registerBlockWithModel("outerdeco/fences/electro_fence_tumbler", () -> new ElectroFenceTumbler(getP(Material.IRON, 1f,1.2f,ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> ELECTRO_FENCE_DOUBLE = registerBlockWithModel("outerdeco/fences/electro_fence_double", () -> new ElectroFenceDouble(getP(Material.IRON, 0.84f,1.2f,ToolType.PICKAXE, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> CONTACT_WIRE = registerOnlyCustomBlock("outerdeco/streetdeco/contact_wire", () -> new ContactWire(getP(Material.IRON, 0.5f,1f,ToolType.PICKAXE, 0, SoundType.METAL, false, true), 1F));
public static final RegistryObject<Block> CONTACT_WIRE_INNER = registerBlockWithModel("outerdeco/streetdeco/contact_wire_inner", () -> new ContactWireAngle(getP(Material.IRON, 0.5f,1f,ToolType.PICKAXE, 0, SoundType.METAL, false, true),1F));
public static final RegistryObject<Block> CONTACT_WIRE_OUTER = registerBlockWithModel("outerdeco/streetdeco/contact_wire_outer", () -> new ContactWireAngle(getP(Material.IRON, 0.5f,1f,ToolType.PICKAXE, 0, SoundType.METAL, false, true),1F));
public static final RegistryObject<Block> CONCRETE_WALL = registerBlockWithModel("outerdeco/fences/concrete_wall", () -> new ConcreteWall(getP(Material.ROCK, 1.1f,1.3f, ToolType.PICKAXE, 1, SoundType.STONE, true, true), 1F));

//post
public static final RegistryObject<Block> STREET_LIGHTPOST = registerBlockWithModel("outerdeco/streetdeco/street_lightpost", () -> new StreetLightpost(getP(Material.IRON, 0.7f,0.9f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> STREET_LIGHTPOST2 = registerBlockWithModel("outerdeco/streetdeco/street_lightpost2", () -> new StreetLightpost(getP(Material.IRON, 0.7f,0.9f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));


//lamp
     //   AbstractBlock.Properties LAMP_PROPERTIES = getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true);
public static final RegistryObject<Block> RED_LAMP = registerBlockWithModel("innerdeco/lamp/red_lamp", () -> new IncLamp(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> INC_LAMP = registerBlockWithModel("innerdeco/lamp/inc_lamp", () -> new IncLamp(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> FLUORESCENT_LAMP = registerBlockWithModel("innerdeco/lamp/fluo_lamp", () -> new FluoLamp(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> BROKEN_FLUORESCENT_LAMP = registerBlockWithModel("innerdeco/lamp/broken_fluo_lamp", () -> new BrokenFluoLamp(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> FLUORESCENT_LAMP2 = registerBlockWithModel("innerdeco/lamp/fluo_lamp2", () -> new FluoLamp2(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> BROKEN_FLUORESCENT_LAMP2 = registerBlockWithModel("innerdeco/lamp/broken_fluo_lamp2", () -> new BrokenFluoLamp2(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> FLUORESCENT_LAMP3 = registerBlockWithModel("innerdeco/lamp/fluo_lamp3", () -> new FluoLamp3(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> BROKEN_FLUORESCENT_LAMP3 = registerBlockWithModel("innerdeco/lamp/broken_fluo_lamp3", () -> new BrokenFluoLamp3(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true)));
public static final RegistryObject<Block> STREET_LAMP = registerBlockWithModel("innerdeco/lamp/street_lamp", () -> new StreetLamp(getP(Material.GLASS, 0.4f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, true, true), 1F));

//doors
public static final RegistryObject<Block> WOOD_DOOR_2 = registerOnlyCustomBlock("innerdeco/wood_door_2", () -> new WoodDoor(getP(Material.WOOD, 0.7f,0.9f, ToolType.AXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> WOOD_DOOR_1 = registerOnlyCustomBlock("innerdeco/wood_door_1", () -> new WoodDoor(getP(Material.WOOD, 0.7f,0.9f, ToolType.AXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> AIRLOCK_DOOR_CONTROLLER = registerBlockWithModel("innerdeco/airlock_door_controller", () -> new AirlockDoorController(getP(Material.IRON, 0.9f,1.1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> AIRLOCK_DOOR = registerOnlyCustomBlock("innerdeco/airlock_door", () -> new AirlockDoorBlock(getP(Material.IRON, 0.7f,1.1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CONTAINMENT_DOOR = registerOnlyCustomBlock("innerdeco/containment_door", () -> new ContainmentDoor(getP(Material.ANVIL, 4.8f,12.0f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> RUSTY_IRON_DOOR = registerOnlyCustomBlock("innerdeco/rusty_iron_door", () -> new RustyIronDoor(getP(Material.IRON, 1.0f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> ALUMINIUM_DOOR = registerOnlyCustomBlock("innerdeco/aluminium_door", () -> new AluminiumDoorBlock(getP(Material.IRON, 0.8f,0.6f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> RAILING_DOOR = registerOnlyCustomBlock("innerdeco/railing_door", () -> new RailingDoorBlock(getP(Material.IRON, 0.95f,1.1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CONTAINMENT_TRAPDOOR = registerOnlyCustomBlock("innerdeco/containment_trapdoor", () -> new ContainmentTrapdoor(getP(Material.ANVIL, 4.8f,12.0f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));


//circuits
public static final RegistryObject<Block> PLATE_GOLDEN_JACKS = registerOnlyCustomBlock("innerdeco/circuit/plate_golden_jack", () -> new PlateGoldenJack(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT2));
public static final RegistryObject<Block> PLATE_GOLDEN_JACKS_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/plate_golden_jack_empty", () -> new BlockCustomModel(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT2, 1F));
public static final RegistryObject<Block> PLATE_PLATINUM_JACKS = registerOnlyCustomBlock("innerdeco/circuit/plate_platinum_jack", () -> new PlatePlatinumJack(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT2));
public static final RegistryObject<Block> PLATE_PLATINUM_JACKS_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/plate_platinum_jack_empty", () -> new BlockCopperCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT2));
public static final RegistryObject<Block> COPPER_CIRCUIT = registerOnlyCustomBlock("innerdeco/circuit/copper_plate", () -> new BlockCopperCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT));
public static final RegistryObject<Block> COPPER_CIRCUIT_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/copper_plate_empty", () -> new BlockCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT, 1F));
public static final RegistryObject<Block> SILVER_CIRCUIT = registerOnlyCustomBlock("innerdeco/circuit/silver_plate", () -> new BlockSilverCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT));
public static final RegistryObject<Block> SILVER_CIRCUIT_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/silver_plate_empty", () -> new BlockCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT, 1F));
public static final RegistryObject<Block> GOLD_CIRCUIT = registerOnlyCustomBlock("innerdeco/circuit/gold_plate", () -> new BlockGoldCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT));
public static final RegistryObject<Block> GOLD_CIRCUIT_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/gold_plate_empty", () -> new BlockCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT, 1F));
public static final RegistryObject<Block> DIAMOND_CIRCUIT = registerOnlyCustomBlock("innerdeco/circuit/diamond_plate", () -> new BlockDiamondCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT));
public static final RegistryObject<Block> DIAMOND_CIRCUIT_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/diamond_plate_empty", () -> new BlockCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT, 1F));
public static final RegistryObject<Block> NETHERITE_CIRCUIT = registerOnlyCustomBlock("innerdeco/circuit/netherite_plate", () -> new BlockNetheriteCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT));
public static final RegistryObject<Block> NETHERITE_CIRCUIT_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/netherite_plate_empty", () -> new BlockCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT, 1F));
public static final RegistryObject<Block> PLATINUM_CIRCUIT = registerOnlyCustomBlock("innerdeco/circuit/platinum_plate", () -> new BlockPlatinumCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT));
public static final RegistryObject<Block> PLATINUM_CIRCUIT_EMPTY = registerOnlyCustomBlock("innerdeco/circuit/platinum_plate_empty", () -> new BlockCircuit(getP(Material.CORAL, 0.2f,0.1f, null, 1, SoundType.CLOTH, false, true), SHAPE_CIRCUIT, 1F));

//innerdeco
public static final RegistryObject<Block> TUBING_HORIZONTAL = registerBlockWithModel("innerdeco/tubing_horizontal", () -> new TubingBlock(getP(Material.IRON, 1.7f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true),0.6F));
public static final RegistryObject<Block> TUBING_VERTICAL = registerBlockWithModel("innerdeco/tubing_vertical", () -> new TubingBlock(getP(Material.IRON, 1.7f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true),0.6F));
public static final RegistryObject<Block> METRO_RAIL = registerBlockWithModel("innerdeco/metro_rail", () -> new MetroRail(0.6F));

public static final RegistryObject<Block> RUSTY_HANDHOLD = registerBlockWithModel("innerdeco/handhold/rusty_handhold", () -> new RustyHandhold(getP(Material.IRON, 0.7f,1.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> BALCONY_HANDHOLD = registerBlockWithModel("innerdeco/handhold/balcony_handhold", () -> new ThinHandhold(getP(Material.IRON, 0.7f,1.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> STREET_FENCE = registerBlockWithModel("innerdeco/handhold/street_handhold", () -> new ThinHandhold(getP(Material.IRON, 0.7f,1.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> HEAT_PIPES = registerBlockWithModel("innerdeco/heat_pipes", () -> new HeatPipes(getP(Material.IRON, 1.2f,2.5f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> HEAT_PIPES_CORNER = registerBlockWithModel("innerdeco/heat_pipes_corner", () -> new HeatPipesCorner(getP(Material.IRON, 1.2f,2.5f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> LAB_SINK = registerBlockWithModel("innerdeco/lab_sink", () -> new LabSink(getP(Material.IRON, 0.8f,1.5f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> KITCHEN_SINK = registerBlockWithModel("innerdeco/furniture/kitchen_sink", () -> new KitchenBlock(getP(Material.IRON, 0.8f,1.5f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> ELECTRO_STOVE = registerBlockWithModel("innerdeco/furniture/e_stove", () -> new GasStove(getP(Material.IRON, 1.1f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> KITCHEN_TABLE= registerBlockWithModel("innerdeco/furniture/kitchen_table", () -> new KitchenTable(getP(Material.WOOD, 1f,1.2f,ToolType.AXE, 1, SoundType.WOOD, true, true), 1F));
public static final RegistryObject<Block> SINK = registerBlockWithModel("innerdeco/furniture/sink", () -> new Sink(getP(Material.ROCK, 0.9f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, false, true), 1F));
public static final RegistryObject<Block> SMALL_SINK = registerBlockWithModel("innerdeco/furniture/small_sink", () -> new SmallSink(getP(Material.ROCK, 0.8f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, false, true), 1F));
public static final RegistryObject<Block> TOILET = registerBlockWithModel("innerdeco/furniture/toilet", () -> new Toilet(getP(Material.ROCK, 0.8f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, false, true), 1F));
public static final RegistryObject<Block> DSP_CHAIR = registerBlockWithModel("innerdeco/furniture/dsp_chair", () -> new DspChair(getP(Material.WOOD, 0.7f,0.8f,ToolType.AXE, 1, SoundType.WOOD, false, true), 1F));
public static final RegistryObject<Block> DSP_TABLE = registerBlockWithModel("innerdeco/furniture/dsp_table", () -> new DspTable(getP(Material.WOOD, 0.7f,0.8f,ToolType.AXE, 1, SoundType.WOOD, false, true)));
public static final RegistryObject<Block> DSP_TABLE2 = registerBlockWithModel("innerdeco/furniture/dsp_table_non_cloth", () -> new DspTable(getP(Material.WOOD, 0.7f,0.8f,ToolType.AXE, 1, SoundType.WOOD, false, true)));
public static final RegistryObject<Block> SAFE = registerBlockWithModel("innerdeco/furniture/safe", () -> new BlockSafe(getP(Material.IRON, 9.65f,43f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> DSP_TUMB = registerBlockWithModel("innerdeco/furniture/dsp_tumb", () -> new DspTumbBlock(getP(Material.WOOD, 1f,1.2f,ToolType.AXE, 1, SoundType.WOOD, false, true)));
public static final RegistryObject<Block> INFO_TABLE = registerBlockWithModel("innerdeco/devices/infotable", () -> new InfoTable(getP(Material.IRON, 0.6f,1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> SMALL_BUTTON = registerBlockWithModel("innerdeco/devices/small_button", () -> new SmallButton(getP(Material.IRON, 0.2f,0.3f,ToolType.PICKAXE, 1, SoundType.METAL, false, true)));
public static final RegistryObject<Block> FRIDGE = registerOnlyCustomBlock("innerdeco/furniture/fridge", () -> new Fridge(getP(Material.IRON, 1.0f,2f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> DRESS_CABIN = registerOnlyCustomBlock("innerdeco/dress_cabin", () -> new DressCabin(getP(Material.WOOD, 0.9f,1f,ToolType.AXE, 1, SoundType.CLOTH, false, true), 1F));
public static final RegistryObject<Block> HOME_PIPES = registerBlockWithModel("innerdeco/pipes/home_pipes", () -> new HomePipes(getP(Material.IRON, 1f,2f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> HOME_PIPES_BATTERY = registerBlockWithModel("innerdeco/pipes/home_pipes_battery", () -> new HomePipesBattery(getP(Material.IRON, 2f,4f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> CIRCLE_FILTER = registerBlockWithModel("innerdeco/circle_filter", () -> new VentFilter(getP(Material.IRON, 0.6f,1f,ToolType.PICKAXE, 0, SoundType.METAL, false, true)));
public static final RegistryObject<Block> REST_FILTER = registerBlockWithModel("innerdeco/rest_filter", () -> new VentFilterRest(getP(Material.IRON, 0.6f,1f,ToolType.PICKAXE, 0, SoundType.METAL, false, true)));
public static final RegistryObject<Block> IRON_BED = registerOnlyCustomBlock("innerdeco/furniture/iron_bed", () -> new IronBed(getP(Material.IRON, 1.1f,2.1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> BATH_TUBE = registerOnlyCustomBlock("innerdeco/furniture/bath_tube", () -> new BathTube(getP(Material.IRON, 0.8f,0.5f, ToolType.PICKAXE, 1, SoundType.GLASS, false, true)));
public static final RegistryObject<Block> DSP_PANEL = registerBlockWithModel("innerdeco/furniture/dsp_panel", () -> new DSPPanel(getP(Material.WOOD, 0.8f,0.5f, ToolType.AXE, 1, SoundType.WOOD, false, true), 1F));

//outerdeco
public static final RegistryObject<Block> HALF_CIRCLE_GRID = registerBlockWithModel("outerdeco/streetdeco/half_circle_grid", () -> new WindowGrid(getP(Material.IRON, 1.6f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> DIAGONAL_GRID = registerBlockWithModel("outerdeco/streetdeco/diagonal_grid", () -> new WindowGrid(getP(Material.IRON, 1.6f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> FULL_DIAGONAL_GRID = registerBlockWithModel("outerdeco/streetdeco/full_diagonal_grid", () -> new WindowGrid(getP(Material.IRON, 1.4f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> FULL_DIAGONAL_GRID_INVERT = registerBlockWithModel("outerdeco/streetdeco/full_diagonal_grid_invert", () -> new WindowGrid(getP(Material.IRON, 1.4f,3f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1));
public static final RegistryObject<Block> BARB_WIRE = registerBlockWithModel("outerdeco/streetdeco/barb_wire", () -> new BarbWire(getP(Material.IRON, 0.65f,1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> SPIRAL_BARB_WIRE = registerBlockWithModel("outerdeco/streetdeco/spiral_barb_wire", () -> new SpiralBarbWire(getP(Material.IRON, 0.9f,2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> FLOOR_GRID = registerBlockWithModel("innerdeco/floor_grid", () -> new FloorGrid(getP(Material.IRON, 0.78f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> FACTORY_WINDOW = registerBlockWithModel("outerdeco/factory_window", () -> new FactoryWindow( 1F));
public static final RegistryObject<Block> FACTORY_WINDOW_EMPTY = registerBlockWithModel("outerdeco/factory_window_empty", () -> new FactoryWindow( 1F));
public static final RegistryObject<Block> SLATE = registerBlockWithModel("innerdeco/slate", () -> new SlateBlock(getP(Material.ROCK, 0.8f,1.1f,ToolType.PICKAXE, 0, SoundType.STONE, true, true)) {});
public static final RegistryObject<Block> CHAIN = registerBlockWithModel("innerdeco/chain", () -> new Chain(getP(Material.IRON, 0.3f,0.4f,ToolType.PICKAXE, 0, SoundType.METAL, true, true)) {});
public static final RegistryObject<Block> LEAD_WALL = registerBlockWithModel("innerdeco/lead_wall", () -> new LeadWall(getP(Material.IRON, 2.8f,8.6f,ToolType.PICKAXE, 2, SoundType.STONE, true, true), 1F) {});
public static final RegistryObject<Block> THIN_LEAD_WALL = registerBlockWithModel("innerdeco/thin_lead_wall", () -> new LeadWall(getP(Material.IRON, 1.6f,6.6f,ToolType.PICKAXE, 2, SoundType.STONE, true, true), 1F) {});
public static final RegistryObject<Block> RUSTY_BARS = registerBlockWithModel("innerdeco/rusty_bars", () -> new RustyBars(getP(Material.IRON, 0.95f,1.1f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> LADDER_1 = registerBlockWithModel("innerdeco/ladder_1", () -> new BlockLadder(getP(Material.IRON, 0.8f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> LADDER_2 = registerBlockWithModel("innerdeco/ladder_2", () -> new BlockLadder(getP(Material.IRON, 0.8f,1.2f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> VENT_PIPE = registerBlockWithModel("innerdeco/pipes/ventpipe", () -> new VentPipe(getP(Material.IRON, 0.5f,0.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> VENT_PIPE_BASE = registerBlockWithModel("innerdeco/pipes/ventpipe_base", () -> new VentPipeBase(getP(Material.IRON, 1.5f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> VENT_PIPE_FILTER = registerBlockWithModel("innerdeco/pipes/ventpipe_filter", () -> new VentPipeFilter(getP(Material.IRON, 1.5f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true), 1F));
public static final RegistryObject<Block> VENT_GRID = registerBlockWithModel("innerdeco/pipes/vent_grid", () -> new VentGrid(getP(Material.IRON, 1.5f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));

//phys devices
public static final RegistryObject<Block> EM_METER = registerBlockWithModel("innerdeco/devices/phys/em_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> A_METER = registerBlockWithModel("innerdeco/devices/phys/a_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> P_METER = registerBlockWithModel("innerdeco/devices/phys/p_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> OM_METER = registerBlockWithModel("innerdeco/devices/phys/om_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> V_METER = registerBlockWithModel("innerdeco/devices/phys/v_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> W_METER = registerBlockWithModel("innerdeco/devices/phys/w_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> K_METER = registerBlockWithModel("innerdeco/devices/phys/k_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> M_METER = registerBlockWithModel("innerdeco/devices/phys/m_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> FREQUE_METER = registerBlockWithModel("innerdeco/devices/phys/freque_meter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> ASSIGNER_BLOCK = registerBlockWithModel("innerdeco/devices/phys/assigner_block", () -> new PhysDevices(1F));
public static final RegistryObject<Block> OSCILLOSCOPE = registerBlockWithModel("innerdeco/devices/phys/oscilloscope", () -> new PhysDevices(1F));
public static final RegistryObject<Block> CONTROLLER = registerBlockWithModel("innerdeco/devices/phys/controller", () -> new PhysDevices(1F));
public static final RegistryObject<Block> GEIGER_STATIC = registerBlockWithModel("innerdeco/devices/phys/geiger_static", () -> new PhysDevices(1F));
public static final RegistryObject<Block> FREQUE_ANALISATOR = registerBlockWithModel("innerdeco/devices/phys/freque_analisator", () -> new PhysDevices(1F));
public static final RegistryObject<Block> AUTOWRITER = registerBlockWithModel("innerdeco/devices/phys/autowriter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> STANDART_SIGNAL_GEN = registerBlockWithModel("innerdeco/devices/phys/standart_signal_gen", () -> new PhysDevices(1F));
public static final RegistryObject<Block> PULT = registerBlockWithModel("innerdeco/devices/pult", () -> new ControlBlock(1F));
public static final RegistryObject<Block> E_CONVERTER = registerBlockWithModel("innerdeco/devices/phys/e_converter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> E_TESTER = registerBlockWithModel("innerdeco/devices/phys/e_tester", () -> new PhysDevices(1F));
public static final RegistryObject<Block> SOUND_POWER_AMPLIFIER = registerBlockWithModel("innerdeco/devices/phys/sound_power_amplifier", () -> new PhysDevices(1F));
public static final RegistryObject<Block> COULOMETRIC_INTEGRATOR = registerBlockWithModel("innerdeco/devices/phys/coulometric_integrator", () -> new PhysDevices(1F));
public static final RegistryObject<Block> COULOMETRIC_INTEGRATOR2 = registerBlockWithModel("innerdeco/devices/phys/coulometric_integrator2", () -> new PhysDevices(1F));
public static final RegistryObject<Block> WELDING_MACHINE = registerBlockWithModel("innerdeco/devices/welding_machine", () -> new PhysDevices(1F));
public static final RegistryObject<Block> WAVEMETER = registerBlockWithModel("innerdeco/devices/phys/wavemeter", () -> new PhysDevices(1F));
public static final RegistryObject<Block> CONTROL_PANEL_UP = registerBlockWithModel("innerdeco/control_panel/cp_up", () -> new ControlTable(getP(Material.IRON, 1.3f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CONTROL_PANEL_DOWN = registerBlockWithModel("innerdeco/control_panel/cp_down", () -> new ControlTable(getP(Material.IRON, 1.3f,2.8f, ToolType.PICKAXE, 1, SoundType.METAL, true, true)));
public static final RegistryObject<Block> CLOCK_ELECTRONICA = registerBlockWithModel("innerdeco/devices/clock_electronika", () -> new ElectronicaClock(getP(Material.WOOD, 0.4f,1.1f,ToolType.AXE, 0, SoundType.METAL, true, true)));
public static final RegistryObject<Block> TRANSFORMATOR_COIL = registerBlockWithModel("innerdeco/devices/phys/coil", () -> new Coil(getP(Material.WOOD, 0.4f,1.1f,ToolType.AXE, 0, SoundType.METAL, true, true)));
public static final RegistryObject<Block> TRANSFORMATOR_BASE = registerBlockWithModel("innerdeco/devices/phys/transformator_base", () -> new PhysDevices(1F));
public static final RegistryObject<Block> TRANSFORMATOR_ISOLATORS = registerBlockWithModel("innerdeco/devices/phys/transformator_isolators", () -> new PhysDevices(1F));
public static final RegistryObject<Block> RADIOSTATION = registerBlockWithModel("innerdeco/devices/phys/radiostation", () -> new PhysDevices(1F));
public static final RegistryObject<Block> AUDIORECORDER = registerBlockWithModel("innerdeco/devices/phys/audiorecorder", () -> new PhysDevices(1F));
public static final RegistryObject<Block> AUDIORECORDER2 = registerBlockWithModel("innerdeco/devices/phys/audiorecorder2", () -> new PhysDevices(1F));
public static final RegistryObject<Block> SOLDERING_STATION = registerBlockWithModel("innerdeco/devices/phys/soldering_station", () -> new PhysDevices(1F));
public static final RegistryObject<Block> TELEGRAPH = registerBlockWithModel("innerdeco/devices/telegraph", () -> new PhysDevices(1F));
public static final RegistryObject<Block> DIG_MICROSCOPE = registerBlockWithModel("innerdeco/devices/phys/digital_ms_base", () -> new DigitalMicroscope(getP(Material.IRON, 0.6f,1f,ToolType.PICKAXE, 0, SoundType.METAL, true, true),1F));
public static final RegistryObject<Block> DIG_MICROSCOPE_CONTROL = registerBlockWithModel("innerdeco/devices/phys/digital_ms_control", () -> new DigitalMicroscope(getP(Material.IRON, 0.6f,1f,ToolType.PICKAXE, 0, SoundType.METAL, true, true),1F));
public static final RegistryObject<Block> DIG_MICROSCOPE_CALC_BLOCK = registerBlockWithModel("innerdeco/devices/phys/digital_ms_calcblock", () -> new DigitalMicroscope(getP(Material.IRON, 0.6f,1f,ToolType.PICKAXE, 0, SoundType.METAL, true, true),1F));

//mech
public static final RegistryObject<Block> CRUSHER = registerBlockWithModel("mech/crusher", () -> new BlockCrusher(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid()));
public static final RegistryObject<Block> AFFINAGE_FACTORY = registerBlockWithModel("mech/affinage", () -> new AffinageFactory(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid()));
public static final RegistryObject<Block> ENERGY_GENERATOR = registerBlockWithModel("mech/diesel_generator", () -> new DieselGenerator(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid(), BOX));
public static final RegistryObject<Block> DIESEL_TANK = registerBlockWithModel("mech/diesel_tank", () -> new DieselTank(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid()));
public static final RegistryObject<Block> DIESEL_E_GENERATOR = registerBlockWithModel("mech/diesel_electro_generator", () -> new DieselElectroGenerator(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid()));

public static final RegistryObject<Block> AbstractBlock.Properties WINDPROOF_PROPERTIES = getP(Material.ROCK, 2,1,ToolType.PICKAXE, 2, SoundType.STONE, true, true);
//windproof
public static final RegistryObject<Block> WINDPROOF_BETON_GRAY = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_gray", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.gray"));
public static final RegistryObject<Block> WINDPROOF_BETON_RED = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_red", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.red"));
public static final RegistryObject<Block> WINDPROOF_BETON_GREEN = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_green", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.green"));
public static final RegistryObject<Block> WINDPROOF_BETON_ORANGE = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_orange", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.orange"));
public static final RegistryObject<Block> WINDPROOF_BETON_BLUE = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_blue", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.blue"));
public static final RegistryObject<Block> WINDPROOF_BETON_YELLOW = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_yellow", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.yellow"));
public static final RegistryObject<Block> WINDPROOF_BETON_BEIGE = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_beige", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.beige"));
public static final RegistryObject<Block> WINDPROOF_BETON_BEIGE2 = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_beige2", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.beige2"));
public static final RegistryObject<Block> WINDPROOF_BETON_WHITE = registerBlockWithModelColored("outerdeco/streetdeco/windproof_beton_white", () -> new WindProofPanel(WINDPROOF_PROPERTIES, 1, "info.white"));



public static final RegistryObject<Block> AbstractBlock.Properties CONCRETE_RAILING_PROPERTIES = getP(Material.ROCK, 2,1,ToolType.PICKAXE, 2, SoundType.STONE, true, true);
//concrete_railing
public static final RegistryObject<Block> CONCRETE_RAILING_ORANGE = registerBlockWithModel("structural/concrete_railing_orange", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.orange", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_WHITE = registerBlockWithModel("structural/concrete_railing_white", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.white", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_GRAY = registerBlockWithModel("structural/concrete_railing_gray", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.gray", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_GREEN = registerBlockWithModel("structural/concrete_railing_green", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.green", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_RED = registerBlockWithModel("structural/concrete_railing_red", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.red", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_BLUE = registerBlockWithModel("structural/concrete_railing_blue", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.blue", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_BEIGE = registerBlockWithModel("structural/concrete_railing_beige", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.beige", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_BEIGE2 = registerBlockWithModel("structural/concrete_railing_beige2", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.beige2", 0.5F));
public static final RegistryObject<Block> CONCRETE_RAILING_YELLOW = registerBlockWithModel("structural/concrete_railing_yellow", () -> new BlockRailing(CONCRETE_RAILING_PROPERTIES, "info.yellow", 0.5F));
public static final RegistryObject<Block> RAILING_BLOCK = registerBlockWithModel("structural/railing", () -> new RailingBlock(getP(Material.IRON, 0.5f,0.25f,ToolType.PICKAXE, 1, SoundType.METAL, true, true), "info.railing", 0.5F));

//beams
public static final RegistryObject<Block> IRON_BEAM_CONCRETE = registerBlockWithModel("structural/iron_beam_concrete", () -> new BlockRotatedAxisCustomModel(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid(), 0.5F));
public static final RegistryObject<Block> IRON_BEAM = registerBlockWithModel("structural/iron_beam", () -> new BlockRotatedAxisCustomModel(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid(), 0.5F));
public static final RegistryObject<Block> IRON_BEAM_THIN = registerBlockWithModel("structural/iron_beam_thin", () -> new BlockRotatedAxisCustomModel(AbstractBlock.Properties.create(Material.IRON).requiresCorrectToolForDrops().hardnessAndResistance(3f,8f).notSolid(), 0.5F));

//slabs
public static final RegistryObject<Block> CONCRETE_SLAB_GRAY = registerBlockWithModelColored("slabs/concrete_slab_gray", () -> new BaseSlab( "info.gray"));
public static final RegistryObject<Block> CONCRETE_SLAB_GREEN = registerBlockWithModelColored("slabs/concrete_slab_green", () -> new BaseSlab( "info.green"));
public static final RegistryObject<Block> CONCRETE_SLAB_BLUE = registerBlockWithModelColored("slabs/concrete_slab_blue", () -> new BaseSlab("info.blue"));
public static final RegistryObject<Block> CONCRETE_SLAB_BEIGE = registerBlockWithModelColored("slabs/concrete_slab_beige", () -> new BaseSlab("info.beige"));
public static final RegistryObject<Block> CONCRETE_SLAB_BEIGE2 = registerBlockWithModelColored("slabs/concrete_slab_beige2", () -> new BaseSlab("info.beige2"));
public static final RegistryObject<Block> CONCRETE_SLAB_RED = registerBlockWithModelColored("slabs/concrete_slab_red", () -> new BaseSlab("info.red"));
public static final RegistryObject<Block> CONCRETE_SLAB_ORANGE = registerBlockWithModelColored("slabs/concrete_slab_orange", () -> new BaseSlab("info.orange"));
public static final RegistryObject<Block> CONCRETE_SLAB_YELLOW = registerBlockWithModelColored("slabs/concrete_slab_yellow", () -> new BaseSlab("info.yellow"));
public static final RegistryObject<Block> CONCRETE_SLAB_WHITE = registerBlockWithModelColored("slabs/concrete_slab_white", () -> new BaseSlab("info.white"));

//panels
public static final RegistryObject<Block> PANEL_CONCRETE_CORNER = registerNDBlock("structural/panel_concrete_corner", () -> new PanelBlockCorner());
public static final RegistryObject<Block> PANEL_CONCRETE_SIDE = registerNDBlock("structural/panel_concrete_side", () -> new PanelBlockSide());
public static final RegistryObject<Block> PANEL_TILE_CORNER = registerNDBlock("structural/panel_tile_corner", () -> new PanelBlockCorner());
public static final RegistryObject<Block> PANEL_TILE_SIDE = registerNDBlock("structural/panel_tile_side", () -> new PanelBlockSide());
public static final RegistryObject<Block> PANEL_CONCRETE_YELLOW_CORNER = registerNDBlock("structural/panel_concrete_yellow_corner", () -> new PanelBlockCorner());
public static final RegistryObject<Block> PANEL_CONCRETE_YELLOW_SIDE = registerNDBlock("structural/panel_concrete_yellow_side", () -> new PanelBlockSide());




    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
 */