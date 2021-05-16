package geometries;

import java.util.ArrayList;
import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.*;

/**
 * Sphere class is geometries class which represents a Sphere by radius and center point
 * 
 * @author Itamar and Raz
 *
 */
public class Sphere extends Geometry {
private Point3D center;
private double radius;

public Sphere(Point3D center, double radius) {
	super();
	this.center = center;
	this.radius = radius;
}
public Point3D getCenter() {
	return center;
}
public double getRadius() {
	return radius;
}
	@Override
public String toString() {
	return "Sphere [center=" + center + ", radius=" + radius + "]";
}
	/**
	 * 	Calculate the normal at a certain point on the circle
	 * 
	 * @param point
	 * @return the normal on point on the The wall of the Sphere
	 */
	@Override
	public Vector getNormal(Point3D point) {
		return (center.subtract(point)).normalize();
	}	
	/**
	 * @param ray
	 * calculate intersection pGeoPoint between sphere and ray
	 * 
	 * @return List<GeoPoint> include the specific points
	 */
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray){
		List<GeoPoint> res=new ArrayList<GeoPoint>();
		if(isZero(ray.getP0().getX()-center.getX()) && isZero(ray.getP0().getY()-center.getY()) &&
				isZero(ray.getP0().getZ()-center.getZ())) {
			res.add(new GeoPoint(this,ray.getPoint(this.radius)));
			return res;
		}
		Vector u=this.center.subtract(ray.getP0());
		double tm=alignZero(ray.getDir().dotProduct(u));
		double d=alignZero(Math.sqrt(alignZero(u.lengthSquared() - tm*tm)));
		if(d>=this.radius)
		return null;
		double th=alignZero(Math.sqrt(this.radius*this.radius-d*d));
		double t1=alignZero(th+tm),t2=alignZero(tm-th);

		 if(t1>0)
			res.add(new GeoPoint(this,ray.getPoint(t1)));
		 if(t2>0)
			res.add(new GeoPoint(this,ray.getPoint(t2)));
		 if(isZero(res.size()))
			return null;
		return res;
	}
	}

