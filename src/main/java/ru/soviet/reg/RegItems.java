package ru.soviet.reg;

import java.util.function.Supplier;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import ru.soviet.core.SovietEra;
import ru.soviet.items.ItemBurnable;
import ru.soviet.items.ItemInfo;
//import ru.soviet.items.protection_suit.Suit;

public class RegItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SovietEra.MODID);

    //custom
    //public static final RegistryObject<Item> SUIT_GAS_MASK       = ITEMS.register("adc_gas_mask",        () -> new Suit(ArmorMaterial.DIAMOND, EquipmentSlotType.HEAD, (new Item.Properties())));
    //public static final RegistryObject<Item> SUIT_JACKET         = ITEMS.register("adc_jacket",          () -> new Suit(ArmorMaterial.DIAMOND, EquipmentSlotType.CHEST, (new Item.Properties())));
    //public static final RegistryObject<Item> SUIT_LEGS           = ITEMS.register("adc_legs",            () -> new Suit(ArmorMaterial.DIAMOND, EquipmentSlotType.LEGS, (new Item.Properties())));
    //public static final RegistryObject<Item> SUIT_BOOTS          = ITEMS.register("adc_boots",           () -> new Suit(ArmorMaterial.DIAMOND, EquipmentSlotType.FEET, (new Item.Properties())));
    //public static final RegistryObject<Item> DYE_BRUSH           = ITEMS.register("dye_brush",           () -> new DyeBrush());
    //public static final RegistryObject<Item> DYE_SCRAPPER        = ITEMS.register("dye_scrapper",        () -> new DyeScrapper("info.dye_scrapper"));
    //public static final RegistryObject<Item> DYE_SCRAPPER_FILLER = ITEMS.register("dye_scrapper_filler", () -> new FillerScrapper());
    //public static final RegistryObject<Item> HAMMER              = ITEMS.register("hammer",              () -> new Hammer("info.hammer"));
    //public static final RegistryObject<Item> ARMATURES           = ITEMS.register("armatures",           () -> new ArmatureFrame(new Item.Properties()));
    //public static final RegistryObject<Item> SANDSPRAY           = ITEMS.register("sandspray",           () -> new SandsprayItem(new Item.Properties()));
    //public static final RegistryObject<Item> MORTAR              = ITEMS.register("mortar", Mortar::new);
    //public static final RegistryObject<Item> PESTLE              = ITEMS.register("pestle", Pestle::new);
    //public static final RegistryObject<Item> REDSTONE_GRINDER    = ITEMS.register("redstone_grinder", RedstoneGrinder::new);
    //public static final RegistryObject<Item> SIEVE               = ITEMS.register("sieve", DamageableItem::new);
    //public static final RegistryObject<Item> WIRE_CUTTERS        = ITEMS.register("wire_cutters", WireCutter::new);
    //public static final RegistryObject<Item> TOXIC_WATER_BUCKET  = ITEMS.register("toxic_water_bucket",  () -> new BucketItem(() -> RegFluids.TOXIC_WATER.get(), new Item.Properties().stacksTo(1)));


    //tiles
    public static final RegistryObject<Item> FRAME_BIG_TILE= ITEMS.register("frame_big_tile", () -> new ItemInfo(new Item.Properties(), "info.frame_big_tile"));
    public static final RegistryObject<Item> FRAME_QUAD_TILE = ITEMS.register("frame_quad_tile", () -> new ItemInfo(new Item.Properties(), "info.frame_quad_tile"));
    public static final RegistryObject<Item> FRAME_REST_TILE = ITEMS.register("frame_rest_tile", () -> new ItemInfo(new Item.Properties(), "info.frame_rest_tile"));
    public static final RegistryObject<Item> FRAME_SMALL_TILE = ITEMS.register("frame_small_tile", () -> new ItemInfo(new Item.Properties(), "info.frame_small_tile"));
    public static final RegistryObject<Item> QUAD_TILE = ITEMS.register("quad_tile", () -> new ItemInfo(new Item.Properties(), "info.quad_tile"));
    public static final RegistryObject<Item> BIG_TILE = ITEMS.register("big_tile", () -> new ItemInfo(new Item.Properties(), "info.big_tile"));
    public static final RegistryObject<Item> REST_TILE = ITEMS.register("rest_tile", () -> new ItemInfo(new Item.Properties(), "info.rest_tile"));
    public static final RegistryObject<Item> SMALL_TILE = ITEMS.register("small_tile", () -> new ItemInfo(new Item.Properties(), "info.small_tile"));
    public static final RegistryObject<Item> QUAD_TILE_NEW = ITEMS.register("quad_tile_new", () -> new ItemInfo(new Item.Properties(), "info.quad_tile"));
    public static final RegistryObject<Item> BIG_TILE_NEW = ITEMS.register("big_tile_new", () -> new ItemInfo(new Item.Properties(), "info.big_tile"));
    public static final RegistryObject<Item> REST_TILE_NEW = ITEMS.register("rest_tile_new", () -> new ItemInfo(new Item.Properties(), "info.rest_tile"));
    public static final RegistryObject<Item> SMALL_TILE_NEW = ITEMS.register("small_tile_new", () -> new ItemInfo(new Item.Properties(), "info.small_tile"));

    //scrap
    public static final RegistryObject<Item> LEAD_SCRAP = ITEMS.register("lead_scrap", () -> new ItemInfo(new Item.Properties(), "info.restore"));
    public static final RegistryObject<Item> CONCRETE_SCRAP = ITEMS.register("concrete_scrap", () -> new ItemInfo(new Item.Properties(), "info.restore"));
    public static final RegistryObject<Item> RUSTY_SCRAP = ITEMS.register("rusty_scrap", () -> new ItemInfo(new Item.Properties(), "info.restore"));
    public static final RegistryObject<Item> CERAMIC_SHARD = ITEMS.register("ceramic_shard", () -> new ItemInfo(new Item.Properties(), "info.restore"));
    public static final RegistryObject<Item> ARMATURE = ITEMS.register("armature", () -> new ItemInfo(new Item.Properties(), "info.restore"));
    public static final RegistryObject<Item> COPPER_SCRAP = ITEMS.register("copper_scrap", () -> new ItemInfo(new Item.Properties(), "info.restore"));
    public static final RegistryObject<Item> ALUMINUM_SCRAP = ITEMS.register("aluminum_scrap", () -> new ItemInfo(new Item.Properties(), "info.restore"));
    public static final RegistryObject<Item> WOOD_SCRAP = ITEMS.register("wood_scrap", () -> new ItemBurnable(new Item.Properties(), 250, "info.wood_scrap"));

    //brick
    public static final RegistryObject<Item> WHITE_BRICK = ITEMS.register("white_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROKEN_WHITE_BRICK = ITEMS.register("broken_white_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRACKED_YELLOW_BRICK = ITEMS.register("cracked_yellow_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROKEN_YELLOW_BRICK = ITEMS.register("broken_yellow_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRACKED_RED_BRICK = ITEMS.register("cracked_red_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROKEN_RED_BRICK = ITEMS.register("broken_red_brick", () -> new Item(new Item.Properties()));

    //tools
    public static final RegistryObject<Item> BEIGE2_DYE = ITEMS.register("beige2_dye", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BEIGE_DYE = ITEMS.register("beige_dye", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () -> new AxeItem(SovietItemTier.PLATINUM, 8, -3F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () -> new HoeItem(SovietItemTier.PLATINUM, 1, -2F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () -> new PickaxeItem(SovietItemTier.PLATINUM, 2, -2.8F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () -> new ShovelItem(SovietItemTier.PLATINUM, 2, -3F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () -> new SwordItem(SovietItemTier.PLATINUM, 5, -1F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATOL_AXE = ITEMS.register("platol_axe", () -> new AxeItem(SovietItemTier.PLATOL, 8, -3F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATOL_HOE = ITEMS.register("platol_hoe", () -> new HoeItem(SovietItemTier.PLATOL, 1, -2F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATOL_PICKAXE = ITEMS.register("platol_pickaxe", () -> new PickaxeItem(SovietItemTier.PLATOL, 2, -2.8F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATOL_SHOVEL = ITEMS.register("platol_shovel", () -> new ShovelItem(SovietItemTier.PLATOL, 2, -3F, (new Item.Properties())));
    public static final RegistryObject<Item> PLATOL_SWORD = ITEMS.register("platol_sword", () -> new SwordItem(SovietItemTier.PLATOL, 5, -1F, (new Item.Properties())));
    public static final RegistryObject<Item> PULLER = ITEMS.register("puller", () -> new ItemInfo(new Item.Properties().stacksTo(1).durability(180).setNoRepair(), "info.puller"));
    public static final RegistryObject<Item> SANDSPRAY_DUST = ITEMS.register("sandspray_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VARIANT_ITEM = ITEMS.register("variant_item", () -> new ItemInfo(new Item.Properties(), "info.variant_item"));
    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", () -> new ItemInfo(new Item.Properties(), "wrench.info"));

    //ingots
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATOL_INGOT = ITEMS.register("platol_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILICON_INGOT = ITEMS.register("silicon_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties()));

    //dust
    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_MICRO_DUST  = ITEMS.register("detail_scrap/black_micro_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_CONDENSER_DUST  = ITEMS.register("detail_scrap/blue_condenser_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_JACK_DUST  = ITEMS.register("detail_scrap/blue_jack_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CERAMIC_DUST = ITEMS.register("ceramic_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_BLUE_MICRO_DUST  = ITEMS.register("detail_scrap/dark_blue_micro_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_GRAY_TRANSISTOR_DUST  = ITEMS.register("detail_scrap/dark_gray_transistor_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_RED_MICRO_DUST  = ITEMS.register("detail_scrap/dark_red_micro_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_YELLOW_MICRO_DUST = ITEMS.register("detail_scrap/dark_yellow_micro_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_YELLOW_TRANSISTOR_DUST  = ITEMS.register("detail_scrap/dark_yellow_transistor_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIODE_BLACK_DUST  = ITEMS.register("detail_scrap/diode_black_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIODE_GRAY_DUST  = ITEMS.register("detail_scrap/diode_gray_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_CONDENSER_DUST  = ITEMS.register("detail_scrap/green_condenser_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_JACK_DUST  = ITEMS.register("detail_scrap/green_jack_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEADCERAMIC_DUST = ITEMS.register("leadceramic_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_DUST = ITEMS.register("netherite_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_CONDENSER_DUST  = ITEMS.register("detail_scrap/orange_condenser_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_DUST = ITEMS.register("palladium_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_DUST = ITEMS.register("platinum_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATOL_DUST = ITEMS.register("platol_dust", () -> new ItemInfo(new Item.Properties(), "platol.platol_dust"));
    public static final RegistryObject<Item> RED_CONDENSER_DUST  = ITEMS.register("detail_scrap/red_condenser_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_LEAD_DUST = ITEMS.register("small_lead_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_CONDENSER_DUST  = ITEMS.register("detail_scrap/yellow_condenser_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_JACK_DUST  = ITEMS.register("detail_scrap/yellow_jack_dust", () -> new Item(new Item.Properties()));

    //details
    public static final RegistryObject<Item> BLACK_MICRO = ITEMS.register("circuits/black_micro", () -> new ItemInfo(new Item.Properties(), "circ.black_micro"));
    public static final RegistryObject<Item> BLUE_CONDENSER = ITEMS.register("circuits/blue_condenser", () -> new ItemInfo(new Item.Properties(), "circ.blue_condenser"));
    public static final RegistryObject<Item> BLUE_JACK = ITEMS.register("circuits/blue_jack", () -> new ItemInfo(new Item.Properties(), "circ.blue_jack"));
    public static final RegistryObject<Item> DARK_BLUE_MICRO = ITEMS.register("circuits/dark_blue_micro", () -> new ItemInfo(new Item.Properties(), "circ.dark_blue_micro"));
    public static final RegistryObject<Item> DARK_GRAY_TRANSISTOR = ITEMS.register("circuits/dark_gray_transistor", () -> new ItemInfo(new Item.Properties(), "circ.dark_gray_transistor"));
    public static final RegistryObject<Item> DARK_RED_MICRO = ITEMS.register("circuits/dark_red_micro", () -> new ItemInfo(new Item.Properties(), "circ.dark_red_micro"));
    public static final RegistryObject<Item> DARK_YELLOW_MICRO = ITEMS.register("circuits/dark_yellow_micro", () -> new ItemInfo(new Item.Properties(), "circ.dark_yellow_micro"));
    public static final RegistryObject<Item> DARK_YELLOW_TRANSISTOR = ITEMS.register("circuits/dark_yellow_transistor", () -> new ItemInfo(new Item.Properties(), "circ.dark_yellow_transistor"));
    public static final RegistryObject<Item> DIODE_BLACK = ITEMS.register("circuits/diode_black", () -> new ItemInfo(new Item.Properties(), "circ.diode_black"));
    public static final RegistryObject<Item> DIODE_GRAY = ITEMS.register("circuits/diode_gray", () -> new ItemInfo(new Item.Properties(), "circ.diode_gray"));
    public static final RegistryObject<Item> GREEN_CONDENSER = ITEMS.register("circuits/green_condenser", () -> new ItemInfo(new Item.Properties(), "circ.green_condenser"));
    public static final RegistryObject<Item> GREEN_JACK = ITEMS.register("circuits/green_jack", () -> new ItemInfo(new Item.Properties(), "circ.green_jack"));
    public static final RegistryObject<Item> LEADCERAMIC_TILE = ITEMS.register("leadceramic_tile", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_CONDENSER = ITEMS.register("circuits/orange_condenser", () -> new ItemInfo(new Item.Properties(), "circ.orange_condenser"));
    public static final RegistryObject<Item> RED_CONDENSER = ITEMS.register("circuits/red_condenser", () -> new ItemInfo(new Item.Properties(), "circ.red_condenser"));
    public static final RegistryObject<Item> REOCHORD = ITEMS.register("circuits/reochord", () -> new ItemInfo(new Item.Properties(), "circ.reochord"));
    public static final RegistryObject<Item> YELLOW_CONDENSER = ITEMS.register("circuits/yellow_condenser", () -> new ItemInfo(new Item.Properties(), "circ.yellow_condenser"));
    public static final RegistryObject<Item> YELLOW_JACK = ITEMS.register("circuits/yellow_jack", () -> new ItemInfo(new Item.Properties(), "circ.yellow_jack"));

    //other items
    public static final RegistryObject<Item> KEY_DOOR = ITEMS.register("key_door", () -> new ItemInfo(new Item.Properties(), "key.key_door"));
    public static final RegistryObject<Item> LINO = ITEMS.register("lino", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLUOLAMP = ITEMS.register("fluolamp", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FUEL_CANISTER = ITEMS.register("fuel_canister", () -> new ItemInfo(new Item.Properties().stacksTo(1), "info.fuel_canister"));
    public static final RegistryObject<Item> SUGAR = ITEMS.register("sugar", () -> new ItemInfo(new Item.Properties().stacksTo(1), "info.sugar"));
    public static final RegistryObject<Item> CONDENSED_MILK = ITEMS.register("condensed_milk", () -> new ItemInfo(new Item.Properties().stacksTo(1), "info.condensed_milk"));


    public enum SovietItemTier implements Tier {

        PLATINUM(2, 370, 17.0F, 1.0F, 30, () ->
                Ingredient.of(RegItems.PLATINUM_INGOT.get())
        ),
        PLATOL(4, 3400, 24.0F, 6.0F, 45, () ->
                Ingredient.of(RegItems.PLATOL_INGOT.get())
        );

        private final int level;
        private final int uses;
        private final float speed;
        private final float damage;
        private final int enchantmentValue;
        private final Supplier<Ingredient> repairIngredient;

        SovietItemTier(int level, int uses, float speed, float damage,
                       int enchantmentValue, Supplier<Ingredient> repairIngredient) {
            this.level = level;
            this.uses = uses;
            this.speed = speed;
            this.damage = damage;
            this.enchantmentValue = enchantmentValue;
            this.repairIngredient = repairIngredient;
        }

        @Override public int getLevel() {return this.level;}
        @Override public int getUses() {return this.uses;}
        @Override public float getSpeed() {return this.speed;}
        @Override public float getAttackDamageBonus() {return this.damage;}
        @Override public int getEnchantmentValue() {return this.enchantmentValue;}
        @Override public @NotNull Ingredient getRepairIngredient() {return this.repairIngredient.get();}
    }

}
