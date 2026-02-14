package ru.soviet.blocks.baseblock;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseBlock extends Block {

    @Nullable
    private final String hoverTextKey;

    public BaseBlock(Properties properties, @Nullable String hoverTextKey) {
        super(properties);
        this.hoverTextKey = hoverTextKey;
    }

    public BaseBlock(Properties properties) {
        this(properties, null);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (hoverTextKey != null) {
            tooltip.add(Component.translatable(hoverTextKey));
        }
    }
}