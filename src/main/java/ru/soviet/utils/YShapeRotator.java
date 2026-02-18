package ru.soviet.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class YShapeRotator {
    private static final ConcurrentHashMap<Direction, ConcurrentHashMap<List<AabbKey>, VoxelShape>> CACHE = new ConcurrentHashMap<>();

    static {
        for (Direction dir : Direction.values()) {
            CACHE.put(dir, new ConcurrentHashMap<>());
        }
    }

    public static VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        if (direction == Direction.NORTH) return shape;

        List<AabbKey> boxes = new CopyOnWriteArrayList<>();
        shape.forAllBoxes((x1, y1, z1, x2, y2, z2) ->
                boxes.add(new AabbKey(x1, y1, z1, x2, y2, z2))
        );

        return CACHE.get(direction).computeIfAbsent(boxes, key -> rotateBoxes(key, direction));
    }

    private static VoxelShape rotateBoxes(List<AabbKey> boxes, Direction direction) {
        VoxelShape result = Shapes.empty();
        for (AabbKey box : boxes) {
            double[] rotated = rotate(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, direction);
            result = Shapes.or(result,
                    Shapes.box(rotated[0], rotated[1], rotated[2],
                            rotated[3], rotated[4], rotated[5]));
        }
        return result.optimize();
    }

    private static double[] rotate(double minX, double minY, double minZ,
                                   double maxX, double maxY, double maxZ,
                                   Direction direction) {
        return switch (direction) {
            case EAST  -> new double[]{1 - maxZ, minY, minX, 1 - minZ, maxY, maxX};
            case SOUTH -> new double[]{1 - maxX, minY, 1 - maxZ, 1 - minX, maxY, 1 - minZ};
            case WEST  -> new double[]{minZ, minY, 1 - maxX, maxZ, maxY, 1 - minX};
            default    -> new double[]{minX, minY, minZ, maxX, maxY, maxZ}; // NORTH
        };
    }

    private record AabbKey(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {}
}