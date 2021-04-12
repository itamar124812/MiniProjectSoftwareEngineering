/**
 * 
 */
package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * @author USER
 *
 */
public interface Intersectable  {
	List<Point3D> findIntersections(Ray ray);
}
