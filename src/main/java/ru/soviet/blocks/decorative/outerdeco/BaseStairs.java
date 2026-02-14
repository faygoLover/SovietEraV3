package ru.soviet.blocks.decorative.outerdeco;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseStairs extends StairBlock {
    public static final BooleanProperty DAMAGED = BooleanProperty.create("damaged");
    //public static final BooleanProperty FULL = BooleanProperty.create("full");

    @Nullable
    private final String hoverTextKey;

    public BaseStairs(BlockState state, BlockBehaviour.Properties properties, @Nullable String hoverTextKey) {
        super(state, properties);
        this.hoverTextKey = hoverTextKey;
        this.registerDefaultState(this.defaultBlockState().setValue(DAMAGED, false));
        //this.registerDefaultState(this.defaultBlockState().setValue(FULL, true));
    }

    public BaseStairs(BlockState state, BlockBehaviour.Properties properties) {
        this(state, properties, null);
    }

    public BaseStairs(BlockState state, @Nullable String hoverTextKey) {
        this(state,
                BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)
                        .requiresCorrectToolForDrops()
                        .strength(1.0f, 4.0f),
                hoverTextKey);
    }

    public BaseStairs(BlockState state) {
        this(state, ((String) null));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(DAMAGED);
        //builder.add(FULL);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter worldIn, @NotNull List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        if (hoverTextKey != null) {
            tooltip.add(Component.translatable(hoverTextKey));
        }
    }
}