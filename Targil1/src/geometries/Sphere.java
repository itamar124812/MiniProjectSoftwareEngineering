package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * Sphere class is geometries class which represents a Sphere by radius and center point
 * 
 * @author Itamar and Raz
 *
 */
public class Sphere implements Geometry {
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
}
