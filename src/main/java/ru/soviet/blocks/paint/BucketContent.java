package ru.soviet.blocks.paint;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// Содержимое ведра для краски. Имена совпадают с вариантами в blockstates/placeable/dye_bucket.json
public enum BucketContent implements StringRepresentable {
    EMPTY("empty", null),
    WATER("water", null),
    BEIGE("beige", "beige"),
    GREEN("green", "green"),
    RED("red", "red"),
    ORANGE("orange", "orange"),
    BLUE("blue", "blue"),
    YELLOW("yellow", "yellow"),
    WHITE("white", "white"),
    FILLER("filler", null),
    BEIGE2("beige2", "beige2");

    private final String name;
    // Цвет бетона, в который красит эта краска (null — не краска)
    @Nullable
    private final String concreteColor;

    BucketContent(String name, @Nullable String concreteColor) {
        this.name = name;
        this.concreteColor = concreteColor;
    }

    public boolean isPaint() {
        return concreteColor != null;
    }

    @Nullable
    public String getConcreteColor() {
        return concreteColor;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }
}
