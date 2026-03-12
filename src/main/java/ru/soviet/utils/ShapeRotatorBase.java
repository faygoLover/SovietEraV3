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

        // Собираем все ограничивающие прямоугольники (AABB) исходной формы
        List<AabbKey> boxes = new ArrayList<>();
        shape.forAllBoxes((x1, y1, z1, x2, y2, z2) ->
                boxes.add(new AabbKey(x1, y1, z1, x2, y2, z2))
        );
        // Сортируем для стабильного порядка – гарантирует одинаковый ключ для одинаковых наборов
        boxes.sort(null);

        // Получаем кэш для данного направления
        ConcurrentHashMap<List<AabbKey>, VoxelShape> dirCache =
                cache.computeIfAbsent(direction, d -> new ConcurrentHashMap<>());

        // Возвращаем уже повёрнутую форму из кэша или создаём новую
        return dirCache.computeIfAbsent(boxes, key -> rotateBoxes(key, direction));
    }

    /**
     * Поворачивает список боксов в заданное направление.
     */
    private VoxelShape rotateBoxes(List<AabbKey> boxes, D direction) {
        VoxelShape[] shapes = new VoxelShape[boxes.size()];
        int i = 0;
        for (AabbKey box : boxes) {
            double[] rotated = rotate(box.minX, box.minY, box.minZ,
                                      box.maxX, box.maxY, box.maxZ,
                                      direction);
            shapes[i++] = Shapes.box(rotated[0], rotated[1], rotated[2],
                    rotated[3], rotated[4], rotated[5]);
        }
        return Shapes.or(Shapes.empty(), shapes).optimize();
    }

    /**
     * Преобразует координаты одного бокса для заданного направления.
     * @return массив из 6 double: {minX, minY, minZ, maxX, maxY, maxZ}
     */
    protected abstract double[] rotate(double minX, double minY, double minZ,
                                       double maxX, double maxY, double maxZ,
                                       D direction);

    /**
     * Очищает внутренний кэш повёрнутых форм. Может быть вызван при перезагрузке ресурсов,
     * чтобы освободить память, если формы динамически меняются.
     */
    public void clearCache() {
        cache.clear();
    }

    /**
     * Ключ для кэширования – неизменяемое представление одного AABB,
     * поддерживающее естественный порядок для стабильной сортировки.
     */
    private record AabbKey(double minX, double minY, double minZ,
                           double maxX, double maxY, double maxZ)
            implements Comparable<AabbKey> {

        @Override
        public int compareTo(AabbKey o) {
            int cmp;
            if ((cmp = Double.compare(minX, o.minX)) != 0) return cmp;
            if ((cmp = Double.compare(minY, o.minY)) != 0) return cmp;
            if ((cmp = Double.compare(minZ, o.minZ)) != 0) return cmp;
            if ((cmp = Double.compare(maxX, o.maxX)) != 0) return cmp;
            if ((cmp = Double.compare(maxY, o.maxY)) != 0) return cmp;
            return Double.compare(maxZ, o.maxZ);
        }
    }
}