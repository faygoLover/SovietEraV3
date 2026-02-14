package ru.soviet.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseItem extends Item {
    protected String hoverTextKey;

    public BaseItem(Properties properties, String hoverTextKey) {
        super(properties);
        this.hoverTextKey = hoverTextKey;
    }

    public BaseItem(Properties properties) {
        this(properties, null);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (hoverTextKey != null) {
            tooltip.add(Component.translatable(hoverTextKey));
        }
    }
}