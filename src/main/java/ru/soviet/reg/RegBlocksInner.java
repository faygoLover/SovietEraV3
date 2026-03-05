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
import ru.soviet.blocks.container.drawers.DrawerStorage;
import ru.soviet.blocks.decorative.innerdeco.Ladder;
import ru.soviet.blocks.baseblock.Enableable4MBlock;
import ru.soviet.blocks.decorative.innerdeco.devices.BigTumbler;
import ru.soviet.blocks.decorative.innerdeco.devices.ModelDevice;
import ru.soviet.blocks.decorative.innerdeco.devices.Toggleable4MBlock;
import ru.soviet.blocks.container.dsp.DspStorage;
import ru.soviet.blocks.container.dsp.DspStorageTable;
import ru.soviet.blocks.container.safe.SafeStorage;
import ru.soviet.blocks.decorative.innerdeco.HomePipes;
import ru.soviet.blocks.decorative.innerdeco.WallWire;
import ru.soviet.blocks.decorative.innerdeco.devices.PowerSocket;
import ru.soviet.blocks.decorative.innerdeco.devices.SmallTumbler;
import ru.soviet.blocks.holder.HolderTable;
import ru.soviet.core.SovietEra;

import java.util.function.Supplier;

public class RegBlocksInner {
    public static final DeferredRegister<Block> BLOCKS_INNER = DeferredRegister.create(ForgeRegistries.BLOCKS, SovietEra.MODID);

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
    public static final RegistryObject<Block> LAB_SINK = registerBlock("innerdeco/lab_sink", () -> new Directional4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
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
    public static final RegistryObject<Block> GAS_STOVE = registerBlock("innerdeco/furniture/gas_stove", () -> new Variants4MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
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
            )
    );
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
    public static final RegistryObject<Block> VENT_GRID_OPEN = registerBlock("innerdeco/pipes/vent_grid_open", () -> new Directional6MBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
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
            ))
    );

    public static final RegistryObject<Block> VENT_GRID = registerBlock("innerdeco/pipes/vent_grid", () -> new Directional4H2x2VMBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
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
    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS_INNER.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return RegItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
