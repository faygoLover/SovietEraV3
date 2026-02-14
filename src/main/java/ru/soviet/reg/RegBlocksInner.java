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
import ru.soviet.blocks.baseblock.HorizontalConnectingModelBlock;
import ru.soviet.blocks.container.drawers.DrawerStorage;
import ru.soviet.blocks.decorative.innerdeco.devices.ModelDeviceEnable;
import ru.soviet.blocks.decorative.innerdeco.devices.ModelDevice;
import ru.soviet.blocks.decorative.innerdeco.devices.ModelDeviceToggle;
import ru.soviet.blocks.container.dsp.DspStorage;
import ru.soviet.blocks.container.dsp.DspStorageTable;
import ru.soviet.blocks.container.safe.SafeStorage;
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
    public static final RegistryObject<Block> BIOLAB_TABLE_UP = registerBlock("innerdeco/biolab_table_up", () -> new HorizontalConnectingModelBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion(),
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
    public static final RegistryObject<Block> BIOLAB_TABLE2 = registerBlock("innerdeco/biolab_table2", () -> new HorizontalConnectingModelBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
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
    public static final RegistryObject<Block> BIOLAB_TABLE3 = registerBlock("innerdeco/biolab_table3", () -> new HorizontalConnectingModelBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
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
    public static final RegistryObject<Block> BIOLAB_TABLE = registerBlock("innerdeco/biolab_table", () -> new DrawerStorage(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(),
            Shapes.box(
                    0, 0.0625, 0.0625,
                    1, 1, 0.9375)
    ));
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
                            0.975, 0.9375, 0.90625) //средняя
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

    public static final RegistryObject<Block> CHEMLAB_TABLE_UP = registerBlock("innerdeco/chemlab_table_up", () -> new HorizontalConnectingModelBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion(),
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

    public static final RegistryObject<Block> SMALL_COMPUTER = registerBlock("innerdeco/devices/small_computer", () -> new ModelDeviceEnable(
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
    public static final RegistryObject<Block> COMPUTER = registerBlock("innerdeco/devices/computer", () -> new ModelDeviceEnable(
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
                    0, 0.3125, 0.1875,
                    1, 0.84375, 0.8125)
            )
    );
    public static final RegistryObject<Block> SPEC_MONITOR = registerBlock("innerdeco/devices/spec_monitor", () -> new ModelDeviceEnable(
            Shapes.or(
                    Shapes.box(
                            0, 0, 0.375,
                            1, 1, 0.8125),
                    Shapes.box(
                            0.0625, 0.25, 0,
                            0.9375, 0.8125, 0.375)
            ))
    );
    public static final RegistryObject<Block> ACCELERATOR_CALC_BLOCK = registerBlock("innerdeco/accelerator/accl_calc_block", ModelDevice::new);
    public static final RegistryObject<Block> LAB_SINK = registerBlock("innerdeco/lab_sink", ModelDevice::new);
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
    public static final RegistryObject<Block> CRYOCAPSULE = registerBlock("innerdeco/cryocapsule", () -> new ModelDeviceEnable(
            Shapes.or(
                    Shapes.box(
                            0, 0.125, 0.03125,
                            1, 0.875, 0.78125),
                    Shapes.box(
                            0.0625, 0, 0.09375,
                            0.9375, 1, 0.8125)
            ))
    );
    public static final RegistryObject<Block> RADIATOR = registerBlock("innerdeco/radiator", () -> new ModelDevice(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.3125)
            )
    );
    public static final RegistryObject<Block> ELECTRICAL_PANEL = registerBlock("innerdeco/devices/electrical_panel", () -> new ModelDeviceToggle(
                    Shapes.box(
                            0, 0, 0,
                            1, 1, 0.1875)
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
