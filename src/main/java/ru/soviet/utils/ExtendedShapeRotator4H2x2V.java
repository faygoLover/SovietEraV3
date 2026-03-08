package ru.soviet.utils;

import net.minecraft.world.phys.shapes.VoxelShape;


public final class ExtendedShapeRotator4H2x2V {
    private static final ShapeRotatorBase<ExtendedDirection4H2x2V> INSTANCE = new ShapeRotatorBase<>(ExtendedDirection4H2x2V.NORTH) {
        @Override
        protected double[] rotate(double minX, double minY, double minZ,
                                  double maxX, double maxY, double maxZ,
                                  ExtendedDirection4H2x2V direction) {
            return switch (direction) {
                case NORTH  -> new double[]{minX, minY, minZ, maxX, maxY, maxZ};
                case SOUTH  -> new double[]{1 - maxX, minY, 1 - maxZ, 1 - minX, maxY, 1 - minZ};
                case WEST   -> new double[]{minZ, minY, 1 - maxX, maxZ, maxY, 1 - minX};
                case EAST   -> new double[]{1 - maxZ, minY, minX, 1 - minZ, maxY, maxX};
                case UP_X   -> new double[]{minX, 1 - maxZ, minY, maxX, 1 - minZ, maxY};
                case UP_Z   -> new double[]{1 - maxY, 1 - maxZ, minX, 1 - minY, 1 - minZ, maxX};
                case DOWN_X -> new double[]{minX, minZ, 1 - maxY, maxX, maxZ, 1 - minY};
                case DOWN_Z -> new double[]{minY, minZ, minX, maxY, maxZ, maxX};
            };
        }
    };

    public static VoxelShape rotateShape(VoxelShape shape, ExtendedDirection4H2x2V direction) {
        return INSTANCE.rotateShape(shape, direction);
    }
}