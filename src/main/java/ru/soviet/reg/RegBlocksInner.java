package ru.soviet.reg;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.soviet.blocks.baseblock.*;
import ru.soviet.blocks.entities.chair.ChairBlock;
import ru.soviet.blocks.entities.clock.ClockBroken;
import ru.soviet.blocks.entities.clock.ClockDisplay;
import ru.soviet.blocks.entities.container.drawers.DrawerStorage;
import ru.soviet.blocks.entities.container.kitchen.KitchenStorage;
import ru.soviet.blocks.decorative.innerdeco.*;
import ru.soviet.blocks.baseblock.Enableable4MBlock;
import ru.soviet.blocks.decorative.innerdeco.devices.*;
import ru.soviet.blocks.entities.container.dsp.DspStorage;
import ru.soviet.blocks.entities.container.dsp.DspStorageTable;
import ru.soviet.blocks.entities.container.safe.SafeStorage;
import ru.soviet.blocks.entities.holder.HolderTable;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;

public class RegBlocksInner {
    public static final DeferredRegister<Block> BLOCKS_INNER = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);

    //мебель
    public static final RegistryObject<Block> SAFE = registerBlock("innerdeco/furniture/safe", () -> new SafeStorage(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), "info.safe",
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.75)
            )
    );
    public static final RegistryObject<Block> BIOLAB_TABLE = registerBlock("innerdeco/biolab_table", () -> new DrawerStorage(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
            Shapes.box(
                    0, 0.0625, 0.0625,
                    1, 1, 0.9375)
    ));
    public static final RegistryObject<Block> BIOLAB_TABLE2 = registerBlock("innerdeco/biolab_table2", () -> new Linear4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
            Shapes.or(
                    Shapes.box(
                            0.03125, 0, 0.03125,
                            0.09375, 0.9375, 0.96875), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.90625, 0, 0.03125,
                            0.96875, 0.9375, 0.96875), //правая
                    Shapes.box(
                            0.03125, 0.75, 0.03125,
                            0.96875, 0.875, 0.96875) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.90625, 0, 0.03125,
                            0.96875, 0.9375, 0.96875), //правая
                    Shapes.box(
                            0, 0.75, 0.03125,
                            0.96875, 0.875, 0.96875) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0.03125, 0, 0.03125,
                            0.09375, 0.9375, 0.96875), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.03125, 0.75, 0.03125,
                            1, 0.875, 0.96875) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0, 0.75, 0.03125,
                            1, 0.875, 0.96875) //средняя
            ))
    );
    public static final RegistryObject<Block> BIOLAB_TABLE3 = registerBlock("innerdeco/biolab_table3", () -> new Linear4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
            Shapes.or(
                    Shapes.box(
                            0.03125, 0, 0.03125,
                            0.09375, 0.9375, 0.96875), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.90625, 0, 0.03125,
                            0.96875, 0.9375, 0.96875), //правая
                    Shapes.box(
                            0.03125, 0.75, 0.03125,
                            0.96875, 0.875, 0.96875) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.90625, 0, 0.03125,
                            0.96875, 0.9375, 0.96875), //правая
                    Shapes.box(
                            0, 0.75, 0.03125,
                            0.96875, 0.875, 0.96875) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0.03125, 0, 0.03125,
                            0.09375, 0.9375, 0.96875), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.03125, 0.75, 0.03125,
                            1, 0.875, 0.96875) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0, 0.75, 0.03125,
                            1, 0.875, 0.96875) //средняя
            ))
    );
    public static final RegistryObject<Block> BIOLAB_TABLE4 = registerBlock("innerdeco/biolab_table4", () -> new DrawerStorage(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1),
                    Shapes.box(
                            0.0625, 0.1875, 0.0625,
                            0.9375, 0.9375, 0.9375)
            )
    ));
    public static final RegistryObject<Block> BIOLAB_TABLE_UP = registerBlock("innerdeco/biolab_table_up", () -> new HolderTable(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().strength(2.0F, 2.0F),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0.0625,
                            0.09375, 0.875, 0.9375), //левая
                    Shapes.box(
                            0, 0.875, 0.0625,
                            1, 1, 0.90625), //верхняя
                    Shapes.box(
                            0.90625, 0, 0.0625,
                            1, 0.875, 0.9375), //правая
                    Shapes.box(
                            0.0625, 0, 0,
                            0.9375, 0.9375, 0.0625) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.875, 0.0625,
                            1, 1, 0.90625), //верхняя
                    Shapes.box(
                            0.90625, 0, 0.0625,
                            1, 0.875, 0.9375), //правая
                    Shapes.box(
                            0, 0, 0,
                            0.9375, 0.9375, 0.0625) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0.0625,
                            0.09375, 0.875, 0.9375), //левая
                    Shapes.box(
                            0, 0.875, 0.0625,
                            1, 1, 0.90625), //верхняя
                    Shapes.box(
                            0.0625, 0, 0,
                            1, 0.9375, 0.0625) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.875, 0.0625,
                            1, 1, 0.90625), //верхняя
                    Shapes.box(
                            0, 0, 0,
                            1, 0.9375, 0.0625) //задняя
            ))
    );
    public static final RegistryObject<Block> CHEMLAB_TABLE = registerBlock("innerdeco/chemlab_table", () -> new DrawerStorage(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion(),
            Shapes.or(
                    Shapes.box(
                            0, 0.935, 0,
                            1, 1, 1),
                    Shapes.box(
                            0, 0.125, 0,
                            1, 0.935, 0.96875)
            )
    ));
    public static final RegistryObject<Block> CHEMLAB_TABLE_UP = registerBlock("innerdeco/chemlab_table_up", () -> new HolderTable(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().strength(2.0F, 2.0F),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.9375), //левая
                    Shapes.box(
                            0, 0.875, 0.125,
                            1, 1, 0.9375), //верхняя
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.9375), //правая
                    Shapes.box(
                            0, 0, 0.125,
                            1, 0.9375, 0.1875) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.875, 0.125,
                            1, 1, 0.9375), //верхняя
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 1, 0.9375), //правая
                    Shapes.box(
                            0, 0, 0.125,
                            1, 0.9375, 0.1875) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 1, 0.9375), //левая
                    Shapes.box(
                            0, 0.875, 0.125,
                            1, 1, 0.9375), //верхняя
                    Shapes.box(
                            0, 0, 0.125,
                            1, 0.9375, 0.1875) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.875, 0.125,
                            1, 1, 0.9375), //верхняя
                    Shapes.box(
                            0, 0, 0.125,
                            1, 0.9375, 0.1875) //задняя
            ))
    );
    public static final RegistryObject<Block> LAB_SINK = registerBlock("innerdeco/lab_sink", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(0, 0.953125, 0,
                               1, 1, 1), //верхняя
                    Shapes.box(0.0625, 0.765625, 0.203125,
                               0.9375, 0.953125, 0.890625), //нижняя
                    Shapes.box(0.015625,0,0.015625,
                               0.078125,0.953125,0.078125), //bl
                    Shapes.box(0.015625,0,0.921875,
                               0.078125,0.953125,0.984375), //fl
                    Shapes.box(0.921875,0,0.015625,
                               0.984375,0.953125,0.078125), //br
                    Shapes.box(0.921875,0,0.921875,
                               0.984375,0.953125,0.984375), //fr
                    Shapes.box(0.015625,0.125,0.078125,
                               0.078125,0.1875,0.921875),  //l
                    Shapes.box(0.921875,0.125,0.078125,
                               0.984375,0.1875,0.921875), //r
                    Shapes.box(0.078125,0.125,0.015625,
                               0.921875,0.1875,0.078125), //b
                    Shapes.box(0.078125,0.125,0.921875,
                               0.921875,0.1875,0.984375)  //f
            )
    ));
    public static final RegistryObject<Block> DSP_TUMB = registerBlock("innerdeco/furniture/dsp_tumb", () -> new DspStorage(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD).noOcclusion(),
            Shapes.box(
                    0, 0.375, 0.21875,
                    1, 1, 0.78125)
    ));
    public static final RegistryObject<Block> DSP_TABLE = registerBlock("innerdeco/furniture/dsp_table", () -> new DspStorageTable(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD).noOcclusion(),
            Shapes.or(
                    Shapes.box(
                            0.03125, 0.125, 0.0625,
                            0.125, 0.9375, 0.9375), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.875, 0.125, 0.0625,
                            0.96875, 0.9375, 0.9375), //правая
                    Shapes.box(
                            0.125, 0.75, 0.09375,
                            0.875, 0.9375, 0.90625) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.625, 0.125, 0.0625,
                            1, 0.9375, 0.9375), //правая
                    Shapes.box(
                            0, 0.75, 0.09375,
                            0.625, 0.9375, 0.90625) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.125, 0.0625,
                            0.6875, 0.9375, 0.9375), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.6875, 0.75, 0.09375,
                            1, 0.9375, 0.90625) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0, 0.75, 0.09375,
                            1, 0.9375, 0.90625) //средняя
            ))
    );
    public static final RegistryObject<Block> DSP_TABLE_NON_CLOTH = registerBlock("innerdeco/furniture/dsp_table_non_cloth", () -> new Linear4MBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.or(
                    Shapes.box(
                            0.03125, 0.125, 0.0625,
                            0.125, 0.9375, 0.9375), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.875, 0.125, 0.0625,
                            0.96875, 0.9375, 0.9375), //правая
                    Shapes.box(
                            0.125, 0.25, 0.09375,
                            0.875, 0.75, 0.15625), //задняя
                    Shapes.box(
                            0.125, 0.75, 0.09375,
                            0.875, 0.9375, 0.90625) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.875, 0.125, 0.0625,
                            0.96875, 0.9375, 0.9375), //правая
                    Shapes.box(
                            0, 0.25, 0.09375,
                            0.875, 0.75, 0.15625), //задняя
                    Shapes.box(
                            0, 0.75, 0.09375,
                            0.875, 0.9375, 0.90625) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0.03125, 0.125, 0.0625,
                            0.125, 0.9375, 0.9375), //левая
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0.125, 0.25, 0.09375,
                            1, 0.75, 0.15625), //задняя
                    Shapes.box(
                            0.125, 0.75, 0.09375,
                            1, 0.9375, 0.90625) //средняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 1), //верхняя
                    Shapes.box(
                            0, 0.25, 0.09375,
                            1, 0.75, 0.15625), //задняя
                    Shapes.box(
                            0, 0.75, 0.09375,
                            1, 0.9375, 0.90625) //средняя
            ))
    );
    public static final RegistryObject<Block> PURPLE_TABLE = registerBlock("innerdeco/furniture/purple_table", () -> new Linear4MBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.or(
                    Shapes.box(
                            0.0625, 0.125, 0.0625,
                            0.1875, 0.875, 0.9375), //левая
                    Shapes.box(
                            0, 0.875, 0,
                            1, 0.984375, 1), //верхняя
                    Shapes.box(
                            0.8125, 0.125, 0.0625,
                            0.9375, 0.875, 0.9375), //правая
                    Shapes.box(
                            0.1875, 0.125, 0.125,
                            0.8125, 0.875, 0.1875) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.875, 0,
                            1, 0.984375, 1), //верхняя
                    Shapes.box(
                            0.8125, 0.125, 0.0625,
                            0.9375, 0.875, 0.9375), //правая
                    Shapes.box(
                            0, 0.125, 0.125,
                            0.8125, 0.875, 0.1875) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0.0625, 0.125, 0.0625,
                            0.1875, 0.875, 0.9375), //левая
                    Shapes.box(
                            0, 0.875, 0,
                            1, 0.984375, 1), //верхняя
                    Shapes.box(
                            0.1875, 0.125, 0.125,
                            1, 0.875, 0.1875) //задняя
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.875, 0,
                            1, 0.984375, 1), //верхняя
                    Shapes.box(
                            0, 0.125, 0.125,
                            1, 0.875, 0.1875) //задняя
            )
    ));
    public static final RegistryObject<Block> KITCHEN_TABLE = registerBlock("innerdeco/furniture/kitchen_table", () -> new KitchenStorage(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.8125), //верхняя
                    Shapes.box(
                            0, 0.125, 0,
                            1, 0.9375, 0.75), //средняя
                    Shapes.box(
                            0, 0, 0,
                            1, 0.125, 0.6875) //нижняя
            )
    ));
    public static final RegistryObject<Block> KITCHEN_SINK = registerBlock("innerdeco/furniture/kitchen_sink", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0.9375, 0,
                            1, 1, 0.8125), //t
                    Shapes.box(
                            0.125, 0.8125, 0.125,
                            0.875, 0.9375, 0.6875), //d
                    Shapes.box(
                            0, 0, 0,
                            0.0625, 0.9375, 0.0625), //bl
                    Shapes.box(
                            0.9375, 0, 0,
                            1, 0.9375, 0.0625), //br
                    Shapes.box(
                            0, 0, 0.75,
                            0.0625, 0.9375, 0.8125), //fl
                    Shapes.box(
                            0.9375, 0, 0.75,
                            1, 0.9375, 0.8125), // fr
                    Shapes.box(
                            0.0625, 0, 0,
                            0.9375, 0.0625, 0.0625), //db
                    Shapes.box(
                            0, 0, 0.0625,
                            0.0625, 0.0625, 0.75), //dl
                    Shapes.box(
                            0.9375, 0, 0.0625,
                            1, 0.0625, 0.75), //dr
                    Shapes.box(
                            0.0625, 0.5625, 0,
                            0.9375, 0.625, 0.0625), //tb
                    Shapes.box(
                            0, 0.5625, 0.0625,
                            0.0625, 0.625, 0.75), //tl
                    Shapes.box(
                            0.9375, 0.5625, 0.0625,
                            1, 0.625, 0.75) //tr
            )
    ));

    public static final RegistryObject<Block> DSP_CHAIR = registerBlock("innerdeco/furniture/dsp_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),0.3,0.19));
    public static final RegistryObject<Block> PURPLE_CHAIR = registerBlock("innerdeco/furniture/purple_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),0.3,0.19));
    public static final RegistryObject<Block> PINK_CHAIR = registerBlock("innerdeco/furniture/pink_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),0.19,0.06));
    public static final RegistryObject<Block> BIOLAB_CHAIR = registerBlock("innerdeco/biolab_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),0.25,0.19));

    //Девайсы
    public static final RegistryObject<Block> SMALL_COMPUTER = registerBlock("innerdeco/devices/small_computer", () -> new Enableable4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0.25, 0, 0.1875,
                            1, 0.25, 0.625),
                    Shapes.box(
                            0.275, 0.015625, 0.625,
                            0.9921875, 0.0625, 0.9375),
                    Shapes.box(
                            0.4375, 0.3125, 0.4375,
                            0.8125, 0.65625, 0.5625),
                    Shapes.box(
                            0.453125, 0.34375, 0.15625,
                            0.796875, 0.640625, 0.5625),
                    Shapes.box(
                            0.0625, 0, 0, 0.1875,
                            0.0625, 0.453125)
            ))
    );
    public static final RegistryObject<Block> COMPUTER = registerBlock("innerdeco/devices/computer", () -> new Enableable4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.875)
            )
    );
    public static final RegistryObject<Block> SPEC_MONITOR = registerBlock("innerdeco/devices/spec_monitor", () -> new Enableable4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0.375,
                            1, 1, 0.8125),
                    Shapes.box(
                            0.0625, 0.25, 0,
                            0.9375, 0.8125, 0.375)
            ))
    );
    public static final RegistryObject<Block> INFOTABLE = registerBlock("innerdeco/devices/infotable", () -> new Infotable(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.box(
                    0, 0.3125, 0,
                    1, 0.6875, 0.125)
            )
    );
    public static final RegistryObject<Block> CLOCK_ELECTRINIKA_DISP = registerBlock("innerdeco/devices/clock_electronika_disp", () -> new ClockDisplay(BlockBehaviour.Properties.copy(Blocks.GLASS),
                    Shapes.box(
                            0, 0.3125, 0,
                            1, 0.6875, 0.125)
            )
    );    public static final RegistryObject<Block> CLOCK_ELECTRINIKA = registerBlock("innerdeco/devices/clock_electronika", () -> new ClockBroken(BlockBehaviour.Properties.copy(Blocks.GLASS),
                    Shapes.box(
                            0, 0.3125, 0,
                            1, 0.6875, 0.125)
            )
    );
    public static final RegistryObject<Block> SYS_BLOCK = registerBlock("innerdeco/devices/sys_block", () -> new ModelDevice(
            Shapes.box(
                    0.25, 0, 0,
                    0.75, 0.9, 1)
            )
    );
    public static final RegistryObject<Block> TV = registerBlock("innerdeco/devices/tv", () -> new ModelDevice(
            Shapes.box(
                    0, 0.03125, 0.1875,
                    1, 0.84375, 0.8125)
            )
    );
    public static final RegistryObject<Block> AUTOCLAVE = registerBlock("innerdeco/autoclave", () -> new ModelDevice(
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.0625, 1),
                    Shapes.box(
                            0.0625, 0.1875, 0.1875,
                            0.9375, 0.8125, 0.8125),
                    Shapes.box(
                            0.1875, 0.1875, 0.0625,
                            0.8125, 0.8125, 0.9375),
                    Shapes.box(
                            0.25, 0.8125, 0.25,
                            0.75, 1, 0.75)
            ))
    );
    public static final RegistryObject<Block> CRYOCAPSULE = registerBlock("innerdeco/cryocapsule", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0.125, 0.03125,
                            1, 0.875, 0.78125),
                    Shapes.box(
                            0.0625, 0, 0.09375,
                            0.9375, 1, 0.8125)
            ))
    );
    public static final RegistryObject<Block> DRY_CAB = registerBlock("innerdeco/devices/dry_cab", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RADIATOR = registerBlock("innerdeco/radiator", () -> new Linear4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.3125)
            )
    );
    public static final RegistryObject<Block> LAB_STOVE = registerBlock("innerdeco/devices/lab_stove", () -> new ModelDevice(
            Shapes.box(
                    0.15625, 0, 0.15625,
                    0.84375, 0.1875, 0.84375)
            )
    );
    public static final RegistryObject<Block> MIXER = registerBlock("innerdeco/devices/mixer", () -> new ModelDevice(
            Shapes.box(
                    0.0625, 0, 0.25,
                    0.9375, 0.4375, 0.75)
            )
    );
    public static final RegistryObject<Block> MAGNET_MIXER = registerBlock("innerdeco/devices/magnet_mixer", () -> new ModelDevice(
            Shapes.box(
                    0.15625, 0, 0.21875,
                    0.84375, 0.1875, 0.78128)
            )
    );
    public static final RegistryObject<Block> ELECTRICAL_PANEL = registerBlock("innerdeco/devices/electrical_panel", () -> new Toggleable4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.1875)
            )
    );

    //Физика
    public static final RegistryObject<Block> EM_METER = registerBlock("innerdeco/devices/phys/em_meter", ModelDevice::new);
    public static final RegistryObject<Block> A_METER = registerBlock("innerdeco/devices/phys/a_meter", ModelDevice::new);
    public static final RegistryObject<Block> P_METER = registerBlock("innerdeco/devices/phys/p_meter", ModelDevice::new);
    public static final RegistryObject<Block> OM_METER = registerBlock("innerdeco/devices/phys/om_meter", ModelDevice::new);
    public static final RegistryObject<Block> V_METER = registerBlock("innerdeco/devices/phys/v_meter", ModelDevice::new);
    public static final RegistryObject<Block> W_METER = registerBlock("innerdeco/devices/phys/w_meter", ModelDevice::new);
    public static final RegistryObject<Block> K_METER = registerBlock("innerdeco/devices/phys/k_meter", ModelDevice::new);
    public static final RegistryObject<Block> M_METER = registerBlock("innerdeco/devices/phys/m_meter", ModelDevice::new);
    public static final RegistryObject<Block> FREQUE_METER = registerBlock("innerdeco/devices/phys/freque_meter", ModelDevice::new);
    public static final RegistryObject<Block> ASSIGNER_BLOCK = registerBlock("innerdeco/devices/phys/assigner_block", ModelDevice::new);
    public static final RegistryObject<Block> OSCILLOSCOPE = registerBlock("innerdeco/devices/phys/oscilloscope", ModelDevice::new);
    public static final RegistryObject<Block> CONTROLLER = registerBlock("innerdeco/devices/phys/controller", ModelDevice::new);
    public static final RegistryObject<Block> GEIGER_STATIC = registerBlock("innerdeco/devices/phys/geiger_static", ModelDevice::new);
    public static final RegistryObject<Block> FREQUE_ANALISATOR = registerBlock("innerdeco/devices/phys/freque_analisator", ModelDevice::new);
    public static final RegistryObject<Block> AUTOWRITER = registerBlock("innerdeco/devices/phys/autowriter", ModelDevice::new);
    public static final RegistryObject<Block> STANDART_SIGNAL_GEN = registerBlock("innerdeco/devices/phys/standart_signal_gen", ModelDevice::new);
    public static final RegistryObject<Block> E_CONVERTER = registerBlock("innerdeco/devices/phys/e_converter", ModelDevice::new);
    public static final RegistryObject<Block> E_TESTER = registerBlock("innerdeco/devices/phys/e_tester", ModelDevice::new);
    public static final RegistryObject<Block> SOUND_POWER_AMPLIFIER = registerBlock("innerdeco/devices/phys/sound_power_amplifier", ModelDevice::new);
    public static final RegistryObject<Block> COULOMETRIC_INTEGRATOR = registerBlock("innerdeco/devices/phys/coulometric_integrator", ModelDevice::new);
    public static final RegistryObject<Block> COULOMETRIC_INTEGRATOR2 = registerBlock("innerdeco/devices/phys/coulometric_integrator2", ModelDevice::new);
    public static final RegistryObject<Block> WAVEMETER = registerBlock("innerdeco/devices/phys/wavemeter", ModelDevice::new);
    public static final RegistryObject<Block> DIGITAL_MS_CONTROL = registerBlock("innerdeco/devices/phys/digital_ms_control", ModelDevice::new);
    public static final RegistryObject<Block> DIGITAL_MS_BASE = registerBlock("innerdeco/devices/phys/digital_ms_base", ModelDevice::new);
    public static final RegistryObject<Block> DIGITAL_MS_CALCBLOCK = registerBlock("innerdeco/devices/phys/digital_ms_calcblock", ModelDevice::new);
    public static final RegistryObject<Block> SOLDERING_STATION = registerBlock("innerdeco/devices/phys/soldering_station", ModelDevice::new);
    public static final RegistryObject<Block> AUDIORECORDER = registerBlock("innerdeco/devices/phys/audiorecorder", ModelDevice::new);
    public static final RegistryObject<Block> AUDIORECORDER2 = registerBlock("innerdeco/devices/phys/audiorecorder2", ModelDevice::new);
    public static final RegistryObject<Block> RADIOSTATION = registerBlock("innerdeco/devices/phys/radiostation", ModelDevice::new);
    public static final RegistryObject<Block> COIL = registerBlock("innerdeco/devices/phys/coil", () -> new VerticalMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TRANSFORMATOR_ISOLATORS = registerBlock("innerdeco/devices/phys/transformator_isolators", ModelDevice::new);
    public static final RegistryObject<Block> TRANSFORMATOR_BASE = registerBlock("innerdeco/devices/phys/transformator_base", ModelDevice::new);
    public static final RegistryObject<Block> WELDING_MACHINE = registerBlock("innerdeco/devices/welding_machine", ModelDevice::new);
    public static final RegistryObject<Block> TELEGRAPH = registerBlock("innerdeco/devices/telegraph", ModelDevice::new);

    public static final RegistryObject<Block> GAS_STOVE = registerBlock("innerdeco/furniture/gas_stove", () -> new GasStove(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 0.9375, 0.875)
    ));
    public static final RegistryObject<Block> SMALL_SINK = registerBlock("innerdeco/furniture/small_sink", () -> new ModelDevice(
            Shapes.box(
                    0.1875, 0.625, 0,
                    0.8125, 0.9375, 0.625)
            )
    );
    public static final RegistryObject<Block> SINK = registerBlock("innerdeco/furniture/sink", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0.09375, 0.75, 0,
                            0.90625, 0.9376, 0.6875),
                    Shapes.box(
                            0.15625, 0.6875, 0,
                            0.84375, 0.9376, 0.75),
                    Shapes.box(
                            0.21875, 0.75, 0.75,
                            0.78125, 0.9376, 0.8125)
            )
    ));

    public static final RegistryObject<Block> BIO_STILLAGE = registerBlock("innerdeco/bio_stillage", () -> new Vertical2MBlock(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.or(
                    Shapes.box(0.09375, 0.6625, 0.125, 0.90625, 0.69375, 0.875), //1
                    Shapes.box(0.09375, 0.33125, 0.125, 0.90625, 0.3625, 0.875), //2
                    Shapes.box(0.890625, 0, 0, 0.984375, 0.046875, 1), //right leg
                    Shapes.box(0.90625, 0.046875, 0.4375, 0.96875, 1, 0.5625), //right
                    Shapes.box(0.015625, 0, 0, 0.109375, 0.046875, 1), //left leg
                    Shapes.box(0.03125, 0.046875, 0.4375, 0.09375, 1, 0.5625), //left
                    Shapes.box(0.09375, 0.984375, 0.40625, 0.90625, 1, 0.59375) //top
            ),
            Shapes.or(
                    Shapes.box(0.09375, 0.6625, 0.125, 0.90625, 0.69375, 0.875), //1
                    Shapes.box(0.09375, 0.33125, 0.125, 0.90625, 0.3625, 0.875), //2
                    Shapes.box(0.09375, 0, 0.125, 0.90625, 0.03125, 0.875), //3
                    Shapes.box(0.90625, 0.046875, 0.4375, 0.96875, 1, 0.5625), //right
                    Shapes.box(0.03125, 0.046875, 0.4375, 0.09375, 1, 0.5625), //left
                    Shapes.box(0.09375, 0.984375, 0.40625, 0.90625, 1, 0.59375) //top
            ),
            Shapes.or(
                    Shapes.box(0.09375, 0.6625, 0.125, 0.90625, 0.69375, 0.875), //1
                    Shapes.box(0.09375, 0.33125, 0.125, 0.90625, 0.3625, 0.875), //2
                    Shapes.box(0.890625, 0, 0, 0.984375, 0.046875, 1), //right leg
                    Shapes.box(0.90625, 0.046875, 0.4375, 0.96875, 1, 0.5625), //right
                    Shapes.box(0.015625, 0, 0, 0.109375, 0.046875, 1), //left leg
                    Shapes.box(0.03125, 0.046875, 0.4375, 0.09375, 1, 0.5625) //left
            ),
            Shapes.or(
                    Shapes.box(0.09375, 0.6625, 0.125, 0.90625, 0.69375, 0.875), //1
                    Shapes.box(0.09375, 0.33125, 0.125, 0.90625, 0.3625, 0.875), //2
                    Shapes.box(0.09375, 0, 0.125, 0.90625, 0.03125, 0.875), //3
                    Shapes.box(0.90625, 0.046875, 0.4375, 0.96875, 1, 0.5625), //right
                    Shapes.box(0.03125, 0.046875, 0.4375, 0.09375, 1, 0.5625) //left
            ))
    );

    public static final RegistryObject<Block> ALUM_FRAME_EMPTY = registerBlock("innerdeco/windows/alum_frame_empty", () -> new Vertical4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.03125, 0.15625),
                    Shapes.box(
                            0, 0, 0,
                            0.03125, 1, 0.15625),
                    Shapes.box(
                            0.96875, 0, 0,
                            1, 1, 0.15625),
                    Shapes.box(
                            0, 0.96875, 0,
                            1, 1, 0.15625)
            ))
    );
    public static final RegistryObject<Block> ALUM_FRAME = registerBlock("innerdeco/windows/alum_frame", () -> new Vertical4MBlock(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.15625)
            )
    );
    public static final RegistryObject<Block> CHAIN = registerBlock("innerdeco/chain", () -> new VerticalMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0.421875, 0, 0.421875,
                    0.578125, 1, 0.578125)
            )
    );

    //Кабели
    public static final RegistryObject<Block> REDSTONE_WIRE = registerBlock("innerdeco/devices/redstone_wire", () -> new WallWire(BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.1876)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.1876),
                    Shapes.box(
                            0, 0, 0.1876,
                            0.1876, 1, 1)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.1876),
                    Shapes.box(
                            0.8125, 0, 0.1876,
                            1, 1, 1)
            ))
    );
    public static final RegistryObject<Block> SWITCH_REDSTONE_WIRE = registerBlock("innerdeco/devices/switch_redstone_wire", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.1876)
            )
    );

    //Трубы
    public static final RegistryObject<Block> HOME_PIPES = registerBlock("innerdeco/pipes/home_pipes", () -> new HomePipes(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0.071875, 0,
                            1, 0.15, 0.164),
                    Shapes.box(
                            0, 0.8375, 0,
                            1, 0.915625, 0.164)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.071875, 0,
                            1, 0.15, 0.164),
                    Shapes.box(
                            0, 0.8375, 0,
                            1, 0.915625, 0.164),
                    Shapes.box(
                            0, 0.071875, 0.164,
                            0.164, 0.15, 1),
                    Shapes.box(
                            0, 0.8375, 0.164,
                            0.164, 0.915625, 1)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0.071875, 0,
                            1, 0.15, 0.164),
                    Shapes.box(
                            0, 0.8375, 0,
                            1, 0.915625, 0.164),
                    Shapes.box(
                            0.836, 0.071875, 0.164,
                            1, 0.15, 1),
                    Shapes.box(
                            0.836, 0.8375, 0.164,
                            1, 0.915625, 1)
            ))
    );
    public static final RegistryObject<Block> HOME_PIPES_BATTERY = registerBlock("innerdeco/pipes/home_pipes_battery", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0, 0,
                    1, 1, 0.25)
    ));
    public static final RegistryObject<Block> VENTPIPE = registerBlock("innerdeco/pipes/ventpipe", () -> new Ventpipe(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> VENTPIPE_BASE = registerBlock("innerdeco/pipes/ventpipe_base", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> VENTPIPE_FILTER = registerBlock("innerdeco/pipes/ventpipe_filter", () -> new Directional2MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 0.125, 1),
                    Shapes.box(
                            0, 0.875, 0,
                            1, 1, 1),
                    Shapes.box(
                            0.125, 0.125, 0.0625,
                            0.875, 0.875, 0.9375),
                    Shapes.box(
                            0.0625, 0.125, 0.125,
                            0.9375, 0.875, 0.875)
            )
    ));
    public static final RegistryObject<Block> VENT_GRID = registerBlock("innerdeco/pipes/vent_grid", () -> new VentGrid(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.125, 0.125, 0.875),
                    Shapes.box(
                            0.875, 0, 0,
                            1, 0.125, 0.875),
                    Shapes.box(
                            0, 0.875, 0,
                            0.125, 1, 0.875),
                    Shapes.box(
                            0.875, 0.875, 0,
                            1, 1, 0.875),
                    Shapes.box(
                            0.046875, 0, 0,
                            0.953125, 1, 0.0625),
                    Shapes.box(
                            0, 0.0625, 0.875,
                            0.0625, 0.9375, 1),
                    Shapes.box(
                            0.9375, 0.0625, 0.875,
                            1, 0.9375, 1),
                    Shapes.box(
                            0, 0, 0.75,
                            1, 0.0625, 1),
                    Shapes.box(
                            0, 0.9375, 0.75,
                            1, 1, 1)
            ),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            0.125, 0.125, 0.875),
                    Shapes.box(
                            0.875, 0, 0,
                            1, 0.125, 0.875),
                    Shapes.box(
                            0, 0.875, 0,
                            0.125, 1, 0.875),
                    Shapes.box(
                            0.875, 0.875, 0,
                            1, 1, 0.875),
                    Shapes.box(
                            0.046875, 0, 0,
                            0.953125, 1, 0.0625),
                    Shapes.box(
                            0, 0, 0.875,
                            1, 1, 1),
                    Shapes.box(
                            0, 0, 0.75,
                            1, 0.125, 0.875),
                    Shapes.box(
                            0, 0.875, 0.75,
                            1, 1, 0.875)
            ))
    );
    public static final RegistryObject<Block> CIRCLE_FILTER = registerBlock("innerdeco/circle_filter", () -> new Directional6MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0.1875, 0.1875, 0,
                    0.8125, 0.8125, 0.109375)
    ));
    public static final RegistryObject<Block> REST_FILTER = registerBlock("innerdeco/rest_filter", () -> new Directional4H2x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.box(
                    0, 0.125, 0,
                    1, 0.875, 0.265625)
    ));
    public static final RegistryObject<Block> METRO_RAIL = registerBlock("innerdeco/metro_rail", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
            Shapes.or( //WIP
                    Shapes.box(
                            0, 0, 0,
                            1, 0.15625, 1)
            )
    ));

    public static final RegistryObject<Block> DSP_PANEL = registerBlock("innerdeco/furniture/dsp_panel", () -> new Directional6MBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD),
            Shapes.or(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.03125),
                    Shapes.box(
                            0.0625, 0.0625, 0.03125,
                            0.9375, 0.9375, 0.0625)
            )
    ));

    //Ускоритель
    public static final RegistryObject<Block> ACCL_STAND = registerBlock("innerdeco/accelerator/accl_stand", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ACCL_CALC = registerBlock("innerdeco/accelerator/accl_calc", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ACCL = registerBlock("innerdeco/accelerator/accl", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ACCL_RINGS = registerBlock("innerdeco/accelerator/accl_rings", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ACCL_RINGS_CORNER_LEFT = registerBlock("innerdeco/accelerator/accl_rings_corner_left", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ACCL_RINGS_CORNER_RIGHT = registerBlock("innerdeco/accelerator/accl_rings_corner_right", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ACCL_RINGS_END = registerBlock("innerdeco/accelerator/accl_rings_end", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    public static final RegistryObject<Block> BIO_POWER_SOCKET = registerBlock("innerdeco/furniture/bio_power_socket", () -> new PowerSocket(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
            Shapes.box(
                    0.375, 0.375, 0,
                    0.625, 0.625, 0.046875)
    ));


    //тумблеры
    public static final RegistryObject<Block> BIO_TUMBLER = registerBlock("innerdeco/furniture/bio_tumbler", () -> new SmallTumbler(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
            Shapes.box(
                    0.375, 0.375, 0,
                    0.625, 0.625, 0.046875)
    ));
    public static final RegistryObject<Block> TUMBLER = registerBlock("innerdeco/furniture/tumbler", () -> new SmallTumbler(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
            Shapes.box(
                    0.375, 0.375, 0,
                    0.625, 0.625, 0.046875)
    ));
    public static final RegistryObject<Block> SMALL_BUTTON = registerBlock("innerdeco/devices/small_button", () -> new SmallTumbler(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
            Shapes.box(
                    0.375, 0.375, 0,
                    0.625, 0.625, 0.03125)
    ));
    public static final RegistryObject<Block> RUSTY_TUMBLER = registerBlock("innerdeco/rusty_tumbler", () -> new BigTumbler(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RUSTY_TUMBLER2 = registerBlock("innerdeco/rusty_tumbler2", () -> new BigTumbler(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    //лампы
    public static final RegistryObject<Block> FLUO_LAMP = registerBlock("innerdeco/lamp/fluo_lamp", () -> new FluoLamp(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.box(
                    0, 0.3125, 0,
                    1, 0.6875, 0.125)
    ));
    public static final RegistryObject<Block> FLUO_LAMP2 = registerBlock("innerdeco/lamp/fluo_lamp2", () -> new FluoLamp2(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.box(
                    0, 0.3125, 0,
                    1, 0.6875, 0.125)
    ));
    public static final RegistryObject<Block> FLUO_LAMP3 = registerBlock("innerdeco/lamp/fluo_lamp3", () -> new FluoLamp3(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.box(
                    0, 0.3125, 0,
                    1, 0.6875, 0.2)
    ));
    public static final RegistryObject<Block> INC_LAMP = registerBlock("innerdeco/lamp/inc_lamp", () -> new SmallLamp(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.box(
                    0.3125, 0.3125, 0,
                    0.6875, 0.6875, 0.5)
    ));
    public static final RegistryObject<Block> RED_LAMP = registerBlock("innerdeco/lamp/red_lamp", () -> new SmallLamp(BlockBehaviour.Properties.copy(Blocks.GLASS),
            Shapes.box(
                    0.3125, 0.3125, 0,
                    0.6875, 0.6875, 0.5)
    ));


    //лестницы
    public static final RegistryObject<Block> LADDER_1 = registerBlock("innerdeco/ladder_1", () -> new Ladder(BlockBehaviour.Properties.copy(Blocks.LADDER),
            Shapes.box(
                    0.1876, 0, 0,
                    0.8125, 1, 0.1876)
            )
    );
    public static final RegistryObject<Block> LADDER_2 = registerBlock("innerdeco/ladder_2", () -> new Ladder(BlockBehaviour.Properties.copy(Blocks.LADDER),
            Shapes.box(
                    0.21875, 0, 0,
                    0.78125, 1, 0.1876)
            )
    );

    //Всякое
    public static final RegistryObject<Block> THIN_LEAD_WALL = registerBlock("innerdeco/thin_lead_wall", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.3125)
            )
    );
    public static final RegistryObject<Block> LEAD_WALL = registerBlock("innerdeco/lead_wall", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.875)
            )
    );
    public static final RegistryObject<Block> TUBING_HORIZONTAL = registerBlock("innerdeco/tubing_horizontal", () -> new Directional4H2x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TUBING_VERTICAL = registerBlock("innerdeco/tubing_vertical", () -> new Directional4H2x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));






    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS_INNER.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
