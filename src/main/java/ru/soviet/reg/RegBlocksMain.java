package ru.soviet.reg;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.baseblock.BaseBlock;
import ru.soviet.blocks.decorative.outerdeco.BaseSlab;
import ru.soviet.blocks.decorative.outerdeco.BaseStairs;
import ru.soviet.blocks.subtypes.*;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;

public class RegBlocksMain {
    public static final DeferredRegister<Block> BLOCKS_MAIN = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);

    //concrete
    public static final RegistryObject<Block> CONCRETE_RED = registerBlock("concrete/concrete_red", () -> new FerroconcreteBlock( "info.red"));
    public static final RegistryObject<Block> CONCRETE_ORANGE = registerBlock("concrete/concrete_orange", () -> new FerroconcreteBlock("info.orange"));
    public static final RegistryObject<Block> CONCRETE_YELLOW = registerBlock("concrete/concrete_yellow", () -> new FerroconcreteBlock( "info.yellow"));
    public static final RegistryObject<Block> CONCRETE_GREEN = registerBlock("concrete/concrete_green", () -> new FerroconcreteBlock( "info.green"));
    public static final RegistryObject<Block> CONCRETE_BLUE = registerBlock("concrete/concrete_blue", () -> new FerroconcreteBlock("info.blue"));
    public static final RegistryObject<Block> CONCRETE_GRAY = registerBlock("concrete/concrete_gray", () -> new FerroconcreteBlock( "info.gray"));
    public static final RegistryObject<Block> CONCRETE_BEIGE = registerBlock("concrete/concrete_beige", () -> new FerroconcreteBlock( "info.beige"));
    public static final RegistryObject<Block> CONCRETE_BEIGE2 = registerBlock("concrete/concrete_beige2", () -> new FerroconcreteBlock( "info.beige2"));
    public static final RegistryObject<Block> CONCRETE_WHITE = registerBlock("concrete/concrete_white", () -> new FerroconcreteBlock( "info.white"));

    public static final RegistryObject<Block> CONCRETE_RED_BR = registerBlock("concrete/concrete_red_br", () -> new FerroconcreteBlockDmg("info.red"));
    public static final RegistryObject<Block> CONCRETE_ORANGE_BR = registerBlock("concrete/concrete_orange_br", () -> new FerroconcreteBlockDmg("info.orange"));
    public static final RegistryObject<Block> CONCRETE_YELLOW_BR = registerBlock("concrete/concrete_yellow_br", () -> new FerroconcreteBlockDmg( "info.yellow"));
    public static final RegistryObject<Block> CONCRETE_GREEN_BR = registerBlock("concrete/concrete_green_br", () -> new FerroconcreteBlockDmg( "info.green"));
    public static final RegistryObject<Block> CONCRETE_BLUE_BR = registerBlock("concrete/concrete_blue_br", () -> new FerroconcreteBlockDmg("info.blue"));
    public static final RegistryObject<Block> CONCRETE_GRAY_BR = registerBlock("concrete/concrete_gray_br", () -> new FerroconcreteBlockDmg( "info.gray"));
    public static final RegistryObject<Block> CONCRETE_BEIGE_BR = registerBlock("concrete/concrete_beige_br", () -> new FerroconcreteBlockDmg("info.beige"));
    public static final RegistryObject<Block> CONCRETE_BEIGE2_BR = registerBlock("concrete/concrete_beige2_br", () -> new FerroconcreteBlockDmg( "info.beige2"));
    public static final RegistryObject<Block> CONCRETE_WHITE_BR = registerBlock("concrete/concrete_white_br", () -> new FerroconcreteBlockDmg( "info.white"));

    //stairs
    public static final RegistryObject<Block> CONCRETE_STAIRS_RED = registerBlock("stairs/concrete_red_stairs", () -> new BaseStairs(CONCRETE_RED.get().defaultBlockState(),  "info.red_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_ORANGE = registerBlock("stairs/concrete_orange_stairs", () -> new BaseStairs(CONCRETE_ORANGE.get().defaultBlockState(),  "info.orange_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_YELLOW = registerBlock("stairs/concrete_yellow_stairs", () -> new BaseStairs(CONCRETE_YELLOW.get().defaultBlockState(),  "info.yellow_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_GREEN = registerBlock("stairs/concrete_green_stairs", () -> new BaseStairs(CONCRETE_GRAY.get().defaultBlockState(),  "info.green_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_BLUE = registerBlock("stairs/concrete_blue_stairs", () -> new BaseStairs(CONCRETE_BLUE.get().defaultBlockState(), "info.blue_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_GRAY = registerBlock("stairs/concrete_gray_stairs", () -> new BaseStairs(CONCRETE_GREEN.get().defaultBlockState(), "info.gray_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_BEIGE = registerBlock("stairs/concrete_beige_stairs", () -> new BaseStairs(CONCRETE_BEIGE.get().defaultBlockState(),  "info.beige_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_BEIGE2 = registerBlock("stairs/concrete_beige2_stairs", () -> new BaseStairs(CONCRETE_BEIGE2.get().defaultBlockState(),  "info.beige2_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_WHITE = registerBlock("stairs/concrete_white_stairs", () -> new BaseStairs(CONCRETE_WHITE.get().defaultBlockState(), "info.white_var"));

    public static final RegistryObject<Block> CONCRETE_STAIRS_RED_FULL = registerBlock("stairs/concrete_red_stairs_full", () -> new BaseStairs(CONCRETE_RED.get().defaultBlockState(),  "info.red_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_ORANGE_FULL = registerBlock("stairs/concrete_orange_stairs_full", () -> new BaseStairs(CONCRETE_ORANGE.get().defaultBlockState(),  "info.orange_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_YELLOW_FULL = registerBlock("stairs/concrete_yellow_stairs_full", () -> new BaseStairs(CONCRETE_YELLOW.get().defaultBlockState(),  "info.yellow_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_GREEN_FULL = registerBlock("stairs/concrete_green_stairs_full", () -> new BaseStairs(CONCRETE_GREEN.get().defaultBlockState(),  "info.green_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_BLUE_FULL = registerBlock("stairs/concrete_blue_stairs_full", () -> new BaseStairs(CONCRETE_BLUE.get().defaultBlockState(), "info.blue_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_GRAY_FULL = registerBlock("stairs/concrete_gray_stairs_full", () -> new BaseStairs(CONCRETE_GREEN.get().defaultBlockState(), "info.gray_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_BEIGE_FULL = registerBlock("stairs/concrete_beige_stairs_full", () -> new BaseStairs(CONCRETE_BEIGE.get().defaultBlockState(),  "info.beige_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_BEIGE2_FULL = registerBlock("stairs/concrete_beige2_stairs_full", () -> new BaseStairs(CONCRETE_BEIGE2.get().defaultBlockState(),  "info.beige2_var"));
    public static final RegistryObject<Block> CONCRETE_STAIRS_WHITE_FULL = registerBlock("stairs/concrete_white_stairs_full", () -> new BaseStairs(CONCRETE_WHITE.get().defaultBlockState(), "info.white_var"));

    //slabs
    public static final RegistryObject<Block> CONCRETE_SLAB_RED = registerBlock("slabs/concrete_slab_red", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_RED.get()), "info.red_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_ORANGE = registerBlock("slabs/concrete_slab_orange", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_ORANGE.get()), "info.orange_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_YELLOW = registerBlock("slabs/concrete_slab_yellow", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_YELLOW.get()), "info.yellow_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_GREEN = registerBlock("slabs/concrete_slab_green", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_GREEN.get()), "info.green_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_BLUE = registerBlock("slabs/concrete_slab_blue", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_BLUE.get()), "info.blue_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_GRAY = registerBlock("slabs/concrete_slab_gray", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_GRAY.get()), "info.gray_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_BEIGE = registerBlock("slabs/concrete_slab_beige", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_BEIGE.get()), "info.beige_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_BEIGE2 = registerBlock("slabs/concrete_slab_beige2", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_BEIGE2.get()), "info.beige2_var"));
    public static final RegistryObject<Block> CONCRETE_SLAB_WHITE = registerBlock("slabs/concrete_slab_white", () -> new BaseSlab(BlockBehaviour.Properties.copy(CONCRETE_WHITE.get()), "info.white_var"));

    //tiles
    public static final RegistryObject<Block> TILE_QUAD_1 = registerBlock("quadtile/tile_quad_1", () -> new TilledBlock( "info.quadtile_1"));
    public static final RegistryObject<Block> TILE_QUAD_2 = registerBlock("quadtile/tile_quad_2", () -> new TilledBlock( "info.quadtile_2"));
    public static final RegistryObject<Block> SMALL_TILE_RED = registerBlock("smalltile/small_tile_red", () -> new TilledBlock( "info.small_tile_red"));
    public static final RegistryObject<Block> SMALL_TILE_YELLOW = registerBlock("smalltile/small_tile_yellow", () -> new TilledBlock( "info.small_tile_yellow"));
    public static final RegistryObject<Block> SMALL_TILE_WHITE = registerBlock("smalltile/small_tile_white", () -> new TilledBlock( "info.small_tile_white"));
    public static final RegistryObject<Block> SMALL_TILE_BLUE = registerBlock("smalltile/small_tile_blue", () -> new TilledBlock( "info.small_tile_blue"));
    public static final RegistryObject<Block> HORIZ_TILE_BLUE = registerBlock("horiztile/horiz_tile_blue", () -> new TilledBlock( "info.horiz_tile_blue"));
    public static final RegistryObject<Block> HORIZ_TILE_DARK_BLUE = registerBlock("horiztile/horiz_tile_dark_blue", () -> new TilledBlock( "info.horiz_tile_dark_blue"));
    public static final RegistryObject<Block> HORIZ_TILE_WHITE = registerBlock("horiztile/horiz_tile_white", () -> new TilledBlock( "info.horiz_tile_white"));

    public static final RegistryObject<Block> TILE_QUAD_1_BR = registerBlock("quadtile/tile_quad_1_br", () -> new TilledBlock( "info.quadtile_1_br"));
    public static final RegistryObject<Block> TILE_QUAD_2_BR = registerBlock("quadtile/tile_quad_2_br", () -> new TilledBlock( "info.quadtile_2_br"));
    public static final RegistryObject<Block> SMALL_TILE_RED_BR = registerBlock("smalltile/small_tile_red_br", () -> new TilledBlock( "info.small_tile_red_br"));
    public static final RegistryObject<Block> SMALL_TILE_YELLOW_BR = registerBlock("smalltile/small_tile_yellow_br", () -> new TilledBlock( "info.small_tile_yellow_br"));
    public static final RegistryObject<Block> SMALL_TILE_WHITE_BR = registerBlock("smalltile/small_tile_white_br", () -> new TilledBlock( "info.small_tile_white_br"));
    public static final RegistryObject<Block> SMALL_TILE_BLUE_BR = registerBlock("smalltile/small_tile_blue_br", () -> new TilledBlock( "info.small_tile_blue_br"));
    public static final RegistryObject<Block> HORIZ_TILE_BLUE_BR = registerBlock("horiztile/horiz_tile_blue_br", () -> new TilledBlock( "info.horiz_tile_blue_br"));
    public static final RegistryObject<Block> HORIZ_TILE_DARK_BLUE_BR = registerBlock("horiztile/horiz_tile_dark_blue_br", () -> new TilledBlock( "info.horiz_tile_dark_blue_br"));
    public static final RegistryObject<Block> HORIZ_TILE_WHITE_BR = registerBlock("horiztile/horiz_tile_white_br", () -> new TilledBlock( "info.horiz_tile_white_br"));

    //tiles
    public static final RegistryObject<Block> TILE_QUAD_3 = registerBlock("quadtile/tile_quad_3", () -> new TilledBlock( "info.quadtile_3"));
    public static final RegistryObject<Block> TILE_QUAD_WHITE = registerBlock("quadtile/tile_quad_white", () -> new TilledBlock( "info.quadtile_white"));
    public static final RegistryObject<Block> TILE_QUAD_BLUE = registerBlock("quadtile/tile_quad_blue", () -> new TilledBlock( "info.quadtile_blue"));
    public static final RegistryObject<Block> TILE_QUAD_4 = registerBlock("quadtile/tile_quad_4", () -> new TilledBlock( "info.quadtile_4"));
    public static final RegistryObject<Block> TILE_QUAD_5 = registerBlock("quadtile/tile_quad_5", () -> new TilledBlock( "info.quadtile_5"));
    public static final RegistryObject<Block> TILE_REST_BLACK = registerBlock("resttile/tile_rest_black", () -> new TilledBlock( "info.tile_rest_black"));
    public static final RegistryObject<Block> REGULAR_BROWN_TILE = registerBlock("regtile/tile_reg_brown", () -> new TilledBlock( "info.tile_reg_brown"));
    public static final RegistryObject<Block> REGULAR_LIL_TILE = registerBlock("regtile/tile_reg_lil", () -> new TilledBlock( "info.tile_reg_lil"));
    public static final RegistryObject<Block> REGULAR_AM_TILE = registerBlock("regtile/tile_reg_am", () -> new TilledBlock( "info.tile_reg_am"));

    public static final RegistryObject<Block> TILE_QUAD_3_BR = registerBlock("quadtile/tile_quad_3_br", () -> new TilledBlock( "info.quadtile_3_br"));
    public static final RegistryObject<Block> TILE_QUAD_WHITE_BR = registerBlock("quadtile/tile_quad_white_br", () -> new TilledBlock( "info.quadtile_white_br"));
    public static final RegistryObject<Block> TILE_QUAD_BLUE_BR = registerBlock("quadtile/tile_quad_blue_br", () -> new TilledBlock( "info.quadtile_blue_br"));
    public static final RegistryObject<Block> TILE_QUAD_5_BRf = registerBlock("quadtile/tile_quad_5_brf", () -> new TilledBlock( "info.quadtile_5_br"));
    public static final RegistryObject<Block> TILE_QUAD_5_BR = registerBlock("quadtile/tile_quad_5_br", () -> new TilledBlock( "info.quadtile_5_brf"));
    public static final RegistryObject<Block> TILE_REST_BLACK_BR = registerBlock("resttile/tile_rest_black_br", () -> new TilledBlock( "info.tile_rest_black_br"));
    public static final RegistryObject<Block> REGULAR_BROWN_TILE_BR = registerBlock("regtile/tile_reg_brown_br", () -> new TilledBlock( "info.tile_reg_brown_br"));
    public static final RegistryObject<Block> REGULAR_LIL_TILE_BR = registerBlock("regtile/tile_reg_lil_br", () -> new TilledBlock( "info.tile_reg_lil_br"));
    public static final RegistryObject<Block> REGULAR_AM_TILE_BR = registerBlock("regtile/tile_reg_am_br", () -> new TilledBlock( "info.tile_reg_am_br"));

    public static final RegistryObject<Block> TILE_REST_BROWN = registerBlock("resttile/tile_rest_brown", () -> new TilledBlock( "info.tile_rest_brown"));
    public static final RegistryObject<Block> TILE_REST_DARK_BLUE = registerBlock("resttile/tile_rest_dark_blue", () -> new TilledBlock( "info.tile_rest_dark_blue"));
    public static final RegistryObject<Block> TILE_REST_BLUE = registerBlock("resttile/tile_rest_blue", () -> new TilledBlock( "info.tile_rest_blue"));
    public static final RegistryObject<Block> TILE_REST_WHITE = registerBlock("resttile/tile_rest_white", () -> new TilledBlock( "info.tile_rest_white"));
    public static final RegistryObject<Block> TILE_QUAD_CONCRETE = registerBlock("quadtile/tile_quad_concrete", () -> new TilledBlock( "info.quadtile_concrete"));
    public static final RegistryObject<Block> TILE_QUAD_GRAY = registerBlock("quadtile/tile_quad_gray", () -> new TilledBlock( "info.quadtile_gray"));
    public static final RegistryObject<Block> CERAMIC_GLASS_BROWN = registerBlock("structural/ceramic_glass_brown", GlassBlock::new);
    public static final RegistryObject<Block> CERAMIC_GLASS_BLUE = registerBlock("structural/ceramic_glass_blue", GlassBlock::new);
    public static final RegistryObject<Block> CERAMIC_GLASS_GREEN = registerBlock("structural/ceramic_glass_green", GlassBlock::new);

    public static final RegistryObject<Block> TILE_REST_BROWN_BR = registerBlock("resttile/tile_rest_brown_br", () -> new TilledBlock( "info.tile_rest_brown_br"));
    public static final RegistryObject<Block> TILE_REST_DARK_BLUE_BR = registerBlock("resttile/tile_rest_dark_blue_br", () -> new TilledBlock( "info.tile_rest_dark_blue_br"));
    public static final RegistryObject<Block> TILE_REST_BLUE_BR = registerBlock("resttile/tile_rest_blue_br", () -> new TilledBlock( "info.tile_rest_blue_br"));
    public static final RegistryObject<Block> TILE_REST_WHITE_BR = registerBlock("resttile/tile_rest_white_br", () -> new TilledBlock( "info.tile_rest_white_br"));
    public static final RegistryObject<Block> TILE_MOSAIC_1 = registerBlock("mosaictile/tile_mosaic_1", () -> new TilledBlock("info.mosaic_tile1"));
    public static final RegistryObject<Block> TILE_MOSAIC_2 = registerBlock("mosaictile/tile_mosaic_2", () -> new TilledBlock("info.mosaic_tile2"));
    public static final RegistryObject<Block> PANEL_CONCRETE_YELLOW = registerBlock("structural/panel_concrete_yellow", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANEL_CONCRETE_YELLOW_SIDE = registerBlock("structural/panel_concrete_yellow_side", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANEL_CONCRETE_YELLOW_CORNER = registerBlock("structural/panel_concrete_yellow_corner", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHORT_BRICKS = registerBlock("brick/short_bricks", BrickBlock::new);
    public static final RegistryObject<Block> BRICKS_WITH_WHITE = registerBlock("brick/soviet_bricks_with_white", BrickBlock::new);
    public static final RegistryObject<Block> SMALL_BRICKS = registerBlock("brick/small_bricks", BrickBlock::new);
    public static final RegistryObject<Block> PANEL_TILE = registerBlock("structural/panel_tile", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANEL_TILE_SIDE = registerBlock("structural/panel_tile_side", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANEL_TILE_CORNER = registerBlock("structural/panel_tile_corner", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANEL_CONCRETE = registerBlock("structural/panel_concrete", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANEL_CONCRETE_SIDE = registerBlock("structural/panel_concrete_side", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PANEL_CONCRETE_CORNER = registerBlock("structural/panel_concrete_corner", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 8f).requiresCorrectToolForDrops()));


    //bricks
    public static final RegistryObject<Block> RED_BRICKS = registerBlock("brick/red_bricks", BrickBlock::new);
    public static final RegistryObject<Block> BRICKS = registerBlock("brick/soviet_bricks", BrickBlock::new);
    public static final RegistryObject<Block> WALL_BRICKS = registerBlock("brick/light_bricks2", BrickBlock::new);
    public static final RegistryObject<Block> LIGHT_BRICKS = registerBlock("brick/light_bricks", BrickBlock::new);
    public static final RegistryObject<Block> YELLOW_BRICKS_1 = registerBlock("brick/yellow_bricks_1", BrickBlock::new);
    public static final RegistryObject<Block> YELLOW_BRICKS_2 = registerBlock("brick/yellow_bricks_2", BrickBlock::new);
    public static final RegistryObject<Block> YELLOW_BRICKS_3 = registerBlock("brick/yellow_bricks_3", BrickBlock::new);
    public static final RegistryObject<Block> WHITE_BRICKS = registerBlock("brick/white_bricks", BrickBlock::new);
    public static final RegistryObject<Block> CLEAN_RUSTYMETAL_BLOCK = registerBlock("cleaned/cleaned_rusty_block", MetalBlock::new);


    public static final RegistryObject<Block> RED_BRICKS_BR = registerBlock("brick/red_bricks_br", BrickBlock::new);
    public static final RegistryObject<Block> BRICKS_BR = registerBlock("brick/soviet_bricks_br", BrickBlock::new);
    public static final RegistryObject<Block> WALL_BRICKS_BR = registerBlock("brick/light_bricks2_br", BrickBlock::new);
    public static final RegistryObject<Block> LIGHT_BRICKS_BR = registerBlock("brick/light_bricks_br", BrickBlock::new);
    public static final RegistryObject<Block> YELLOW_BRICKS_1_BR = registerBlock("brick/yellow_bricks_1_br", BrickBlock::new);
    public static final RegistryObject<Block> YELLOW_BRICKS_2_BR = registerBlock("brick/yellow_bricks_2_br", BrickBlock::new);
    public static final RegistryObject<Block> YELLOW_BRICKS_3_BR = registerBlock("brick/yellow_bricks_3_br", BrickBlock::new);
    public static final RegistryObject<Block> WHITE_BRICKS_BR = registerBlock("brick/white_bricks_br", BrickBlock::new);
    public static final RegistryObject<Block> RUSTYMETAL_BLOCK = registerBlock("structural/rusty_block", MetalBlock::new);

    //wallpapers
    public static final RegistryObject<Block> WALLPAPER_1 = registerBlock("wallpapers/wp1", () -> new WallpaperBlock("wp1.info"));
    public static final RegistryObject<Block> WALLPAPER_2 = registerBlock("wallpapers/wp2", () -> new WallpaperBlock("wp2.info"));
    public static final RegistryObject<Block> WALLPAPER_3 = registerBlock("wallpapers/wp3", () -> new WallpaperBlock("wp3.info"));
    public static final RegistryObject<Block> WALLPAPER_4 = registerBlock("wallpapers/wp4", () -> new WallpaperBlock("wp4.info"));
    public static final RegistryObject<Block> WALLPAPER_5 = registerBlock("wallpapers/wp5", () -> new WallpaperBlock("wp5.info"));
    public static final RegistryObject<Block> WALLPAPER_6 = registerBlock("wallpapers/wp6", () -> new WallpaperBlock("wp6.info"));
    public static final RegistryObject<Block> WALLPAPER_7 = registerBlock("wallpapers/wp7", () -> new WallpaperBlock("wp7.info"));
    public static final RegistryObject<Block> WALLPAPER_8 = registerBlock("wallpapers/wp8", () -> new WallpaperBlock("wp8.info"));
    public static final RegistryObject<Block> CLEAN_CONTAINMENT_BLOCK = registerBlock("cleaned/cleaned_containment_block", MetalBlock::new);

    public static final RegistryObject<Block> WALLPAPER_9 = registerBlock("wallpapers/wp9", () -> new WallpaperBlock("wp9.info"));
    public static final RegistryObject<Block> WALLPAPER_10 = registerBlock("wallpapers/wp10", () -> new WallpaperBlock("wp10.info"));
    public static final RegistryObject<Block> WALLPAPER_11 = registerBlock("wallpapers/wp11", () -> new WallpaperBlock("wp11.info"));
    public static final RegistryObject<Block> WALLPAPER_12 = registerBlock("wallpapers/wp12", () -> new WallpaperBlock("wp12.info"));
    public static final RegistryObject<Block> WALLPAPER_13 = registerBlock("wallpapers/wp13", () -> new WallpaperBlock("wp13.info"));
    public static final RegistryObject<Block> WALLPAPER_14 = registerBlock("wallpapers/wp14", () -> new WallpaperBlock("wp14.info"));
    public static final RegistryObject<Block> WALLPAPER_15 = registerBlock("wallpapers/wp15", () -> new WallpaperBlock("wp15.info"));
    public static final RegistryObject<Block> LEADCERAMIC_TILE = registerBlock("structural/leadceramic_tile", TilledBlock::new);
    public static final RegistryObject<Block> CONTAINMENT_BLOCK = registerBlock("structural/containment_block", MetalBlock::new);

    //trim_stone
    public static final RegistryObject<Block> TRIM_TILE_1 = registerBlock("structural/trim_tile_1", TilledBlock::new);
    public static final RegistryObject<Block> TRIM_STONE_1 = registerBlock("structural/trim_stone_1", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5.5f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TRIM_STONE_2 = registerBlock("structural/trim_stone_2", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5.5f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TRIM_STONE_3 = registerBlock("structural/trim_stone_3", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5.5f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TRIM_STONE_4 = registerBlock("structural/trim_stone_4", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5.5f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PARQUET_BLOCK = registerBlock("structural/parquet_block", () -> new WoodBlock(props -> props.strength(5.5f, 15f)));
    public static final RegistryObject<Block> PARQUET_BLOCK_DIAG = registerBlock("structural/parquet_block_diagonal", () -> new WoodBlock(props -> props.strength(5.5f, 15f)));
    public static final RegistryObject<Block> TRIM_TILE_RED = registerBlock("structural/trim_tile_red", TilledBlock::new);
    public static final RegistryObject<Block> TRIM_TILE_BLUE = registerBlock("structural/trim_tile_blue", TilledBlock::new);

    public static final RegistryObject<Block> TRIM_TILE_1_BR = registerBlock("structural/trim_tile_1_br", TilledBlock::new);
    public static final RegistryObject<Block> CONCRETE_PLATE = registerBlock("structural/concrete_plate", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5.5f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TRIM_METAL_1 = registerBlock("structural/trim_metal_1", MetalBlock::new);
    public static final RegistryObject<Block> TRIM_METAL_2 = registerBlock("structural/trim_metal_2", MetalBlock::new);

    //linos
    public static final RegistryObject<Block> LINO_1 = registerBlock("lino/lino1", LinoBlock::new);
    public static final RegistryObject<Block> LINO_2 = registerBlock("lino/lino2", LinoBlock::new);
    public static final RegistryObject<Block> LINO_3 = registerBlock("lino/lino3", LinoBlock::new);
    public static final RegistryObject<Block> LINO_4 = registerBlock("lino/lino4", LinoBlock::new);
    public static final RegistryObject<Block> LINO_5 = registerBlock("lino/lino5", LinoBlock::new);
    public static final RegistryObject<Block> LINO_6 = registerBlock("lino/lino6", LinoBlock::new);
    public static final RegistryObject<Block> LINO_7 = registerBlock("lino/lino7", LinoBlock::new);
    public static final RegistryObject<Block> LINO_8 = registerBlock("lino/lino8", LinoBlock::new);

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS_MAIN.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
