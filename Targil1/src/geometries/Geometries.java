/**
 * 
 */
package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author USER
 *
 */
public class Geometries implements Intersectable {

	private List<Intersectable> intersectable;
	public void add(Intersectable geometrie)
	{
		intersectable.add(geometrie);
	}
	public Geometries(ArrayList<Intersectable> intersectable) {
		this.intersectable = intersectable;
	}
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		return null;
	}
	
	
}
