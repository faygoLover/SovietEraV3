package ru.soviet.utils;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.core.Direction;
import java.util.HashMap;
import java.util.Map;

public class YShapeRotator {
    private static final Map<Direction, Map<VoxelShape, VoxelShape>> SHAPE_CACHE = new HashMap<>();

    static {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            SHAPE_CACHE.put(direction, new HashMap<>());
        }
    }

    public static VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        return SHAPE_CACHE.get(direction)
                .computeIfAbsent(shape, s -> rotateShapeInternal(s, direction));
    }

    private static VoxelShape rotateShapeInternal(VoxelShape shape, Direction direction) {
        VoxelShape[] result = {Shapes.empty()};

        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
            double[] newCoords = switch (direction) {
                case EAST -> new double[]{1 - maxZ, minY, minX, 1 - minZ, maxY, maxX};
                case SOUTH -> new double[]{1 - maxX, minY, 1 - maxZ, 1 - minX, maxY, 1 - minZ};
                case WEST -> new double[]{minZ, minY, 1 - maxX, maxZ, maxY, 1 - minX};
                default -> new double[]{minX, minY, minZ, maxX, maxY, maxZ}; // NORTH
            };

            result[0] = Shapes.or(result[0],
                    Shapes.box(
                            clamp(newCoords[0]), newCoords[1], clamp(newCoords[2]),
                            clamp(newCoords[3]), newCoords[4], clamp(newCoords[5])
                    )
            );
        });

        return result[0];
    }

    private static double clamp(double value) {
        return Math.max(0.0, Math.min(1.0, value));
    }
}