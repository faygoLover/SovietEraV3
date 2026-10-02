package ru.soviet.utils;

import com.google.gson.*;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Vector3d;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ModelShapeBuilder {
    private static final Gson GSON = new Gson();
    private static final ConcurrentMap<String, List<AABB>> MODEL_CACHE = new ConcurrentHashMap<>();
    private static final ConcurrentMap<String, Map<RotationKey, List<AABB>>> ROTATED_CACHE = new ConcurrentHashMap<>();

    private final double volumeThreshold;
    private final List<AABB> boxes = new ArrayList<>();

    public ModelShapeBuilder(double volumeThreshold) {
        this.volumeThreshold = volumeThreshold;
    }

    public void addModel(String modelPath, double rotY, double rotX, double rotZ) {
        List<AABB> modelBoxes = loadModel(modelPath);
        RotationKey key = new RotationKey(rotY, rotX, rotZ);

        List<AABB> rotatedBoxes = ROTATED_CACHE
                .computeIfAbsent(modelPath, p -> new ConcurrentHashMap<>())
                .computeIfAbsent(key, k -> {
                    List<AABB> result = new ArrayList<>();
                    for (AABB box : modelBoxes) {
                        AABB rotated = rotateAABB(box, rotY, rotX, rotZ);
                        if (getVolume(rotated) >= volumeThreshold) {
                            result.add(rotated);
                        }
                    }
                    return result;
                });

        boxes.addAll(rotatedBoxes);
    }

    public VoxelShape build() {
        if (boxes.isEmpty()) return Shapes.empty();
        VoxelShape shape = Shapes.empty();
        for (AABB box : boxes) {
            shape = Shapes.or(shape, Shapes.create(box));
        }
        return shape.optimize();
    }

    private List<AABB> loadModel(String path) {
        return MODEL_CACHE.computeIfAbsent(path, p -> {
            try {
                String resourcePath = "/assets/" + p.replace(":", "/models/") + ".json";
                InputStream is = getClass().getResourceAsStream(resourcePath);
                if (is == null) {
                    throw new RuntimeException("Model not found: " + resourcePath);
                }
                JsonObject root = GSON.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), JsonObject.class);
                JsonArray elements = root.getAsJsonArray("elements");
                List<AABB> boxes = new ArrayList<>();
                for (JsonElement elem : elements) {
                    JsonObject obj = elem.getAsJsonObject();
                    JsonArray from = obj.getAsJsonArray("from");
                    JsonArray to = obj.getAsJsonArray("to");
                    double x1 = from.get(0).getAsDouble() / 16.0;
                    double y1 = from.get(1).getAsDouble() / 16.0;
                    double z1 = from.get(2).getAsDouble() / 16.0;
                    double x2 = to.get(0).getAsDouble() / 16.0;
                    double y2 = to.get(1).getAsDouble() / 16.0;
                    double z2 = to.get(2).getAsDouble() / 16.0;
                    double minX = Math.min(x1, x2);
                    double minY = Math.min(y1, y2);
                    double minZ = Math.min(z1, z2);
                    double maxX = Math.max(x1, x2);
                    double maxY = Math.max(y1, y2);
                    double maxZ = Math.max(z1, z2);
                    boxes.add(new AABB(minX, minY, minZ, maxX, maxY, maxZ));
                }
                return boxes;
            } catch (Exception e) {
                throw new RuntimeException("Failed to load model: " + path, e);
            }
        });
    }

    private AABB rotateAABB(AABB box, double rotY, double rotX, double rotZ) {
        Vector3d center = new Vector3d(0.5, 0.5, 0.5);
        Vector3d[] corners = {
                new Vector3d(box.minX, box.minY, box.minZ),
                new Vector3d(box.maxX, box.minY, box.minZ),
                new Vector3d(box.minX, box.maxY, box.minZ),
                new Vector3d(box.maxX, box.maxY, box.minZ),
                new Vector3d(box.minX, box.minY, box.maxZ),
                new Vector3d(box.maxX, box.minY, box.maxZ),
                new Vector3d(box.minX, box.maxY, box.maxZ),
                new Vector3d(box.maxX, box.maxY, box.maxZ)
        };
        for (Vector3d v : corners) {
            v.sub(center);
            if (rotY != 0) {
                double rad = Math.toRadians(rotY);
                double cos = Math.cos(rad);
                double sin = Math.sin(rad);
                double x = v.x;
                double z = v.z;
                v.x = x * cos - z * sin;
                v.z = x * sin + z * cos;
            }
            if (rotX != 0) {
                double rad = Math.toRadians(rotX);
                double cos = Math.cos(rad);
                double sin = Math.sin(rad);
                double y = v.y;
                double z = v.z;
                v.y = y * cos - z * sin;
                v.z = y * sin + z * cos;
            }
            if (rotZ != 0) {
                double rad = Math.toRadians(rotZ);
                double cos = Math.cos(rad);
                double sin = Math.sin(rad);
                double x = v.x;
                double y = v.y;
                v.x = x * cos - y * sin;
                v.y = x * sin + y * cos;
            }
            v.add(center);
        }
        double minX = Double.POSITIVE_INFINITY, minY = Double.POSITIVE_INFINITY, minZ = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY, maxY = Double.NEGATIVE_INFINITY, maxZ = Double.NEGATIVE_INFINITY;
        for (Vector3d v : corners) {
            minX = Math.min(minX, v.x);
            minY = Math.min(minY, v.y);
            minZ = Math.min(minZ, v.z);
            maxX = Math.max(maxX, v.x);
            maxY = Math.max(maxY, v.y);
            maxZ = Math.max(maxZ, v.z);
        }
        return new AABB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    private double getVolume(AABB box) {
        double dx = box.maxX - box.minX;
        double dy = box.maxY - box.minY;
        double dz = box.maxZ - box.minZ;
        return dx * dy * dz;
    }

    private record RotationKey(double rotY, double rotX, double rotZ) {}
}