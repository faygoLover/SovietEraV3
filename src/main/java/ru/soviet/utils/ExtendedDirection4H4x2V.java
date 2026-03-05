package ru.soviet.utils;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum ExtendedDirection4H4x2V implements StringRepresentable {
    NORTH("north"),
    SOUTH("south"),
    WEST("west"),
    EAST("east"),
    UP_NORTH("up_north"),
    UP_SOUTH("up_south"),
    UP_WEST("up_west"),
    UP_EAST("up_east"),
    DOWN_NORTH("down_north"),
    DOWN_SOUTH("down_south"),
    DOWN_WEST("down_west"),
    DOWN_EAST("down_east");

    private final String name;

    ExtendedDirection4H4x2V(String name) {
        this.name = name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }
}