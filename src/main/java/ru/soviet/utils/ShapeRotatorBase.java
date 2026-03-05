package ru.soviet.utils;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Базовый класс для поворота VoxelShape в различные стороны.
 * @param <D> тип перечисления направлений
 */
public abstract class ShapeRotatorBase<D extends Enum<D>> {
    private final ConcurrentHashMap<D, ConcurrentHashMap<List<AabbKey>, VoxelShape>> cache = new ConcurrentHashMap<>();
    private final D baseDirection;

    protected ShapeRotatorBase(D baseDirection) {
        this.baseDirection = baseDirection;
    }

    /**
     * Поворачивает форму в заданном направлении.
     * @param shape исходная форма (для базового направления)
     * @param direction целевое направление
     * @return повёрнутая форма (кэшируется)
     */
    public VoxelShape rotateShape(VoxelShape shape, D direction) {
        if (direction == baseDirection) return shape;

        List<AabbKey> boxes = new ArrayList<>();
        shape.forAllBoxes((x1, y1, z1, x2, y2, z2) ->
                boxes.add(new AabbKey(x1, y1, z1, x2, y2, z2))
        );

        ConcurrentHashMap<List<AabbKey>, VoxelShape> dirCache =
                cache.computeIfAbsent(direction, d -> new ConcurrentHashMap<>());

        return dirCache.computeIfAbsent(boxes, key -> rotateBoxes(key, direction));
    }

    /**
     * Поворачивает список боксов в заданное направление.
     */
    private VoxelShape rotateBoxes(List<AabbKey> boxes, D direction) {
        List<VoxelShape> shapes = new ArrayList<>(boxes.size());
        for (AabbKey box : boxes) {
            double[] rotated = rotate(box.minX, box.minY, box.minZ,
                                      box.maxX, box.maxY, box.maxZ,direction);
            shapes.add(Shapes.box(rotated[0], rotated[1], rotated[2],
                                  rotated[3], rotated[4], rotated[5]));
        }
        return Shapes.or(Shapes.empty(), shapes.toArray(new VoxelShape[0])).optimize();
    }

    /**
     * Преобразует координаты одного бокса для заданного направления.
     * @return массив из 6 double: {minX, minY, minZ, maxX, maxY, maxZ}
     */
    protected abstract double[] rotate(double minX, double minY, double minZ,
                                       double maxX, double maxY, double maxZ,
                                       D direction);

    /**
     * Ключ для кэширования – неизменяемое представление одного AABB.
     */
    private record AabbKey(double minX, double minY, double minZ,
                           double maxX, double maxY, double maxZ) {}
}