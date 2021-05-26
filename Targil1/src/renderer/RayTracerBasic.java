package renderer;

import java.util.List;
import geometries.Intersectable.GeoPoint;
//import jdk.javadoc.internal.doclets.toolkit.resources.doclets_zh_CN;
import primitives.*;
import scene.Scene;
import elements.*;

public class RayTracerBasic extends RayTracerBase {
    private static final int MAX_CALC_COLOR_LEVEL = 10;
    private static final double MIN_CALC_COLOR_K = 0.001;
	private static final double INITIAL_K = 1.0;

	private double transparency (Vector l, Vector n, GeoPoint geopoint,LightSource light){
		Vector lightDirection = l.scale(-1).normalized(); // from point to light source		
		Ray lightRay = new Ray(geopoint.point, lightDirection,n);
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);
		if (intersections == null) return 1.0;
		double ktr=1.0;
		double lightDistance = light.getDistance(geopoint.point);
		for (GeoPoint gp : intersections) {
		if (Util.alignZero(gp.point.distance(geopoint.point)-lightDistance) <= 0)
		{
			ktr *= gp.geometry.getMaterial().kT;
            if (ktr < MIN_CALC_COLOR_K) return 0.0;
		}		
		}
		return ktr;         
	}

    public RayTracerBasic(Scene aScene) {
        super(aScene);
    }
    
	private GeoPoint findClosestIntersection(Ray ray) {
		List<GeoPoint> lPoints=scene.geometries.findGeoIntersections(ray);
		return ray.findClosestGeoPoint(lPoints);
	}
    private Color calcColor(GeoPoint geopoint, Ray ray) {
    	return calcColor(findClosestIntersection(ray), ray, MAX_CALC_COLOR_LEVEL, INITIAL_K)
    	.add(scene.ambientLight.getIntensity());
    	}
    
    private Color calcColor(GeoPoint intersection, Ray ray, int level, double k) {
        Color color = intersection.geometry.getEmmission();
    	color = color.add(calcLocalEffects(intersection, ray,k));
    	return 1 == level ? color : color.add(calcGlobalEffects(intersection, ray.getDir(), level, k));
    	}

    private Color calcGlobalEffects(GeoPoint gp, Vector v, int level, double k) {
    	Color color = Color.BLACK; Vector n = gp.geometry.getNormal(gp.point);
    	Material material = gp.geometry.getMaterial();
    	double kkr = k * material.kR;
    	if (kkr > MIN_CALC_COLOR_K)
    	color = calcGlobalEffect(constructReflectedRay(gp.point, v, n), level, material.kR, kkr);
    	double kkt = k * material.kT;
    	if (kkt > MIN_CALC_COLOR_K)
    	color = color.add(
    	calcGlobalEffect(constructRefractedRay(gp.point, v, n), level, material.kT, kkt));
    	return color;
    	}
    
    	private Ray constructRefractedRay(Point3D point, Vector v, Vector n) {
    		
            return new Ray(point ,v,n);
	    }

		private Ray constructReflectedRay(Point3D point, Vector v, Vector n) {
		//   𝒓 = 𝒗 − 𝟐 ∙ (𝒗 ∙ 𝒏) ∙ 𝒏
        return new Ray(point ,v.subtract((v.crossProduct(n).crossProduct(n).scale(2)),n));
	}

		private Color calcGlobalEffect(Ray ray, int level, double kx, double kkx) {
    	GeoPoint gp = findClosestIntersection (ray);
    	return (gp == null ? scene.background : calcColor(gp, ray, (level- 1), kkx)
    	).scale(kx);
    	}
    
    private Color calcLocalEffects(GeoPoint intersection, Ray ray,double k) {
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
		double ktr = transparency( l, n, intersection,lightSource);
        if (ktr * k > MIN_CALC_COLOR_K) {
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
	GeoPoint closestPoint = findClosestIntersection(ray);
	return closestPoint == null ? scene.background : calcColor(closestPoint, ray);
	}
    	/*public Color traceRay(Ray ray) {
    		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
    		if (intersections == null) return scene.background;
    		GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
    		return calcColor(closestPoint, ray);
    	}*/
}