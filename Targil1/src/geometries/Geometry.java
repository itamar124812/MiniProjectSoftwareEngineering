package geometries;

import primitives.*;
/**
 * Geometry class is interface class that all geometries class implements it for must create getNormal func
 * 
 * @author Itamar and Raz
 *
 */
public abstract class Geometry implements Intersectable {
	public abstract Vector getNormal(Point3D point); 
	protected Color emmission = Color.BLACK;

/**
	 * @return the emmission
	 */
	public Color getEmmission() {
		return emmission;
	}

	/**
	 * @param emmission the emmission to set
	 * 
	 * @return the emmission
	 */
	public Geometry setEmmission(Color emmission) {
		this.emmission = emmission;
		return this;
	}
}