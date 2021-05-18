package renderer;

import java.util.List;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;
import elements.*;

public class RayTracerBasic extends RayTracerBase {

    public RayTracerBasic(Scene aScene) {
        super(aScene);
        //TODO Auto-generated constructor stub
    }
    
    private Color calcColor(GeoPoint intersection, Ray ray) {
    	return scene.ambientLight.getIntensity()
    	.add(intersection.geometry.getEmmission())
    	// add calculated light contribution from all light sources)
    	.add(calcLocalEffects(intersection, ray));
    	}

    private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
    	Vector v = ray.getDir ();
    	Vector n = intersection.geometry.getNormal(intersection.point);
    	double nv = Util.alignZero(n.dotProduct(v));
    	if (nv == 0) return Color.BLACK;
    	Material material = intersection.geometry.getMaterial();
    	int nShininess = material.getnShininess();
    	double kd = material.getkD(), ks = material.getkS();
    	Color color = Color.BLACK;
    	for (LightSource lightSource : scene.lights) {
    	Vector l = lightSource.getL(intersection.point);
    	double nl = Util.alignZero(n.dotProduct(l));
    	if (nl * nv > 0) { // sign(nl) == sing(nv)
    	Color lightIntensity = lightSource.getIntensity(intersection.point);
    	color = color.add(calcDiffusive(kd, l, n, lightIntensity),
    	calcSpecular(ks, l, n, v, nShininess, lightIntensity));
    	}
    	}
    	return color;
    	}


    @Override
    	public Color traceRay(Ray ray) {
    		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
    		if (intersections == null) return scene.background;
    		GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
    		return calcColor(closestPoint, ray);
    	}

}
