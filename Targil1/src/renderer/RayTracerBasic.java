package renderer;

import java.util.List;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import scene.Scene;
import elements.*;

public class RayTracerBasic extends RayTracerBase {
    private static final double DELTA = 0.1;
	private boolean unshaded(Vector l, Vector n, GeoPoint geopoint,LightSource light){
		Vector lightDirection = l.scale(-1); // from point to light source
		Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
		Point3D point = geopoint.point.add(delta);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);
		if (intersections == null) return true;
		double lightDistance = light.getDistance(geopoint.point);
		for (GeoPoint gp : intersections) {
		if (Util.alignZero(gp.point.distance(geopoint.point)-lightDistance) <= 0)
		return false;
		}
		return true;
         
	}

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
			if (unshaded(l,n, intersection,lightSource)) {
    	Color lightIntensity = lightSource.getIntensity(intersection.point);
    	color = color.add(calcDiffusive(kd, l, n, lightIntensity),
    	calcSpecular(ks, l, n, v, nShininess, lightIntensity));
			}
    	}
    	}
    	return color;
    	}

    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
    return lightIntensity.scale(kd* Math.abs(l.dotProduct(n)));
    }

    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		return lightIntensity.scale(ks*Math.pow((v.scale(-1).dotProduct(l.subtract(n.scale(2*l.dotProduct(n))))),nShininess));
	}

	@Override
    	public Color traceRay(Ray ray) {
    		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
    		if (intersections == null) return scene.background;
    		GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
    		return calcColor(closestPoint, ray);
    	}

}
