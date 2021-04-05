package geometries;

import primitives.Point3D;

/**
 * Triangle class is geometries class which represents a Triangle by Polygon
 * 
 * @author Itamar and Raz
 *
 */
public class Triangle extends Polygon {

	/**
	 * Calculate the normal on point on Triangle by use his super class Polygon in order to find normal
	 * 
	 * @param point
	 * @return the normal on point on the The wall of the Triangle
	 */
	public Triangle(Point3D... vertices) {
		super(vertices);
	}
}
