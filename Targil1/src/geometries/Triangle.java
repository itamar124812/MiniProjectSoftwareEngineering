package geometries;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Triangle class is geometries class which represents a Triangle by Polygon
 * 
 * @author Itamar and Raz
 *
 */
public class Triangle extends Polygon {
	public Triangle(Point3D... vertices) {
		super(vertices);
	}

	/**
	 * Calculate the normal on point on Triangle by use his super class Polygon in order to find normal
	 * 
	 * @param point
	 * @return the normal on point on the The wall of the Triangle
	 */
	@Override
	public Vector getNormal(Point3D point) {
		return super.getNormal(point);
	}
	/**
	 * @param ray
	 * calculate intersection point between Tringale and ray
	 * 
	 * @return List<Point3D> include the specific point
	 */
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		return super.findIntersections(ray);
	}
	/**
	 * @param ray
	 * calculate intersection GeoPoint between Tringale and ray
	 * 
	 * @return List<GeoPoint> include the specific point
	 */
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray){
			return super.findGeoIntersections(ray);
	}
}
