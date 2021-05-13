package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

public abstract class RayTracerBase {
    protected Scene scene;

    public RayTracerBase(Scene aScene) {
        scene = aScene;
    }

    public Color traceRay(Ray ray) {
        List<Point3D> intersections = scene.geometries.findIntersections(ray);
        if (intersections == null)
            return scene.background;
        Point3D closestPoint = ray.findClosestPoint(intersections);
        return calcColor(closestPoint);
    }

    private Color calcColor(Point3D closestPoint) {
        return scene.ambientLight.getIntensity();
    }
}
