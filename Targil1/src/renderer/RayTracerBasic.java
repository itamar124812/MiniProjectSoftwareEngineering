package renderer;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase {

    public RayTracerBasic(Scene aScene) {
        super(aScene);
        //TODO Auto-generated constructor stub
    }
    
    private Color calcColor(GeoPoint intersection) {
    	return scene.ambientLight.getIntensity()
    	.add(intersection.geometry.getEmmission());
    	}

    @Override
    public Color traceRay(Ray ray) {
    	var intersections = scene.geometries.findGeoIntersections(ray);
    	if (intersections == null) return scene.background;
    	GeoPoint closestPoint = ray.getGeoClosestPoint(intersections);
    	return calcColor(closestPoint);
    	}

}
