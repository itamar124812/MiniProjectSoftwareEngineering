package geometries;

import primitives.*;
/**
 * Tube class is geometries class which represents a tube by radius and ray
 * 
 * @author Itamar and Raz
 *
 */
public class Tube implements Geometry {
private Ray axisRay;
private double radius;
public Tube(Ray axisRay, double radius) {
	super();
	this.axisRay = axisRay;
	this.radius = radius;
}
public Ray getAxisRay() {
	return axisRay;
}

@Override
public String toString() {
	return "Tube [axisRay=" + axisRay + ", radius=" + radius + "]";
}
public double getRadius() {
	return radius;
}
	@Override
	public Vector getNormal(Point3D point) {

		

		double temp=axisRay.getDir().dotProduct(point.subtract(axisRay.getP0()));
		if(temp==0)
		return (point.subtract(Point3D.ZERO)).normalize();
		Point3D O=axisRay.getP0().add(axisRay.getDir().scale(temp));
		return (point.subtract(O)).normalize();

	}


}
