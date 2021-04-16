package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

/**
 * Cylinder class is geometries class which represents a cylinder by radius and tube
 * 
 * @author Itamar and Raz
 *
 */
public class Cylinder extends Tube implements Geometry {
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
	/**
	 * Calculate the normal for points on the bases and axis of a final cylinder.
	 * 
	 * @param point
	 * @return Calculate the normal for points on the bases and axis of a final
	 *         cylinder.
	 */
	public Vector getNormal(Point3D point) {
		if (point.equals(getAxisRay().getP0())
				|| point.equals(getAxisRay().getP0().add(getAxisRay().getDir().scale(height))))
			return this.getAxisRay().getDir();
		Vector a = (point.subtract(this.getAxisRay().getP0()));
		Vector b = point.subtract(this.getAxisRay().getP0()).subtract(this.getAxisRay().getDir().scale(height));
		if (a.dotProduct(this.getAxisRay().getDir()) == 0 || b.dotProduct(this.getAxisRay().getDir()) == 0) {
			return this.getAxisRay().getDir();
		} else if (super.getNormal(point) != null)
			return super.getNormal(point);
		else
			throw new IllegalArgumentException("The point is not on the cylinder.");

	}

	public List<Point3D> findIntersections(Ray ray) {
		if (super.findIntersections(ray) == null)
			return null;
		else {
			List<Point3D> result = super.findIntersections(ray);
			for (int i = 0; i < result.size(); i++) {
              try{
                     if(result.get(i).subtract(super.getAxisRay().getP0()).dotProduct(super.getAxisRay().getDir())<0&& !Util.isZero(result.get(i).subtract(super.getAxisRay().getP0()).dotProduct(super.getAxisRay().getDir())))
					    result.remove(i);
					else if(result.get(i).subtract(super.getAxisRay().getP0().add(super.getAxisRay().getDir().scale(height))).dotProduct(super.getAxisRay().getDir())>0&& !Util.isZero(result.get(i).subtract(super.getAxisRay().getP0().add(super.getAxisRay().getDir().scale(height))).dotProduct(super.getAxisRay().getDir())))	
					{
						result.remove(i);
					}
			  }
			  catch(IllegalArgumentException e)
			  {
                 
			  }
			}
			return result;
		}

	}

}
