package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase {

    public RayTracerBasic(Scene aScene) {
        super(aScene);
        //TODO Auto-generated constructor stub
    }

    private Color calcColor(Point3D closestPoint) {
        return scene.ambientLight.getIntensity();
    }
    @Override
    public Color traceRay(Ray ray) {
        List<Point3D> intersections = scene.geometries.findIntersections(ray);
        if (intersections == null)
            return scene.background;
        Point3D closestPoint = ray.findClosestPoint(intersections);
        return calcColor(closestPoint);
    }
    
}
