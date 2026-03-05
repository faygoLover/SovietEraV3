package ru.soviet.utils;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum ExtendedDirection4H2x2V implements StringRepresentable {
    NORTH("north"),
    SOUTH("south"),
    WEST("west"),
    EAST("east"),
    UP_X("up_x"),
    UP_Z("up_z"),
    DOWN_X("down_x"),
    DOWN_Z("down_z");

    private final String name;

    ExtendedDirection4H2x2V(String name) {
        this.name = name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }
}