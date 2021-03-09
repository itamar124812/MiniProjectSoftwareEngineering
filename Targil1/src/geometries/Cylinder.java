package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube implements Geometry{
	private double height;
	
	public Cylinder(Ray axisRay, double radius, double height) {
		super(axisRay, radius);
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	@Override
	public String toString() {
		return "Cylinder [height=" + height + ", toString()=" + super.toString() + "]";
	}
	@Override
	public Vector getNormal(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

}
