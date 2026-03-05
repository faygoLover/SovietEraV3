package ru.soviet.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class ShapeRotator {
    private static final ShapeRotatorBase<Direction> INSTANCE = new ShapeRotatorBase<>(Direction.NORTH) {
        @Override
        protected double[] rotate(double minX, double minY, double minZ,
                                  double maxX, double maxY, double maxZ,
                                  Direction direction) {
            return switch (direction) {
                case NORTH -> new double[]{minX, minY, minZ, maxX, maxY, maxZ};
                case SOUTH -> new double[]{1 - maxX, minY, 1 - maxZ, 1 - minX, maxY, 1 - minZ};
                case WEST  -> new double[]{minZ, minY, 1 - maxX, maxZ, maxY, 1 - minX};
                case EAST  -> new double[]{1 - maxZ, minY, minX, 1 - minZ, maxY, maxX};
                case DOWN  -> new double[]{minX, minZ, 1 - maxY, maxX, maxZ, 1 - minY};
                case UP    -> new double[]{minX, 1 - maxZ, minY, maxX, 1 - minZ, maxY};
            };
        }
    };

    public static VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        return INSTANCE.rotateShape(shape, direction);
    }
}