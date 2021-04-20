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
	/**
	 * 
	 * @param geometrie
	 */
	public void add(Intersectable geometrie)
	{
		intersectable.add(geometrie);
	}
	/**
	 * 
	 * @param intersectable
	 */
	
	public Geometries(ArrayList<Intersectable> intersectable) {
		this.intersectable = intersectable;
	}
	@Override
	/**
	 * calculate the intersection between all the geometries and ray  
	 * @param ray
	 * @return list of the intersection points between ray and geometries
	 */
	public List<Point3D> findIntersections(Ray ray) {
    	List<Point3D> result=new ArrayList<Point3D>(),temp=new ArrayList<Point3D>();
		if(this.intersectable.isEmpty())
		return null;
		for(int i=0;i<this.intersectable.size();i++) {
			 temp=this.intersectable.get(i).findIntersections(ray);
			 if(temp!=null)
				 result.addAll(temp);
		}
		if(result.isEmpty())
			return null;
		return result;
	}
	
	
}
