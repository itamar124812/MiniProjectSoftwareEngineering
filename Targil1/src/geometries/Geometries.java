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
	public void add(List<Intersectable> gIntersectables)
	{
		if(intersectable!=null)
		intersectable.addAll(gIntersectables);
		else intersectable=gIntersectables;
	}
	/**
	 * 
	 * @param intersectable
	 */
	
	public Geometries(ArrayList<Intersectable> intersectable) {
		this.intersectable = intersectable;
	}
/*	@Override
	/**
	 * calculate the intersection between all the geometries in the list and ray  
	 * @param ray
	 * @return list of the intersection Geo Points between ray and the geometries in the list
	 **/
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) {
		List<GeoPoint> result=new ArrayList<GeoPoint>(),temp=new ArrayList<GeoPoint>();
		if(this.intersectable.isEmpty())
		return null;
		for(int i=0;i<this.intersectable.size();i++) {
			 temp=this.intersectable.get(i).findGeoIntersections(ray);
			 if(temp!=null)
				 result.addAll(temp);
		}
		if(result.isEmpty())
			return null;
		return result;
	}
	
	
}
