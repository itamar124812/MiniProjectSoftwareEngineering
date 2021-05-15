package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;
import unittests.Point3DTests;

/**
 * Cylinder class is geometries class which represents a cylinder by radius and tube
 * 
 * @author Itamar and Raz
 *
 */
public class Cylinder extends Tube{
	private double height;
/**
 * 
 * @param axisRay
 * @param radius
 * @param height
 */
	public Cylinder(Ray axisRay, double radius, double height) {
		super(axisRay, radius);
		this.height = height;
	}
/**
 * 
 * @return
 */
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
	@Override
	/**
	 * calculate intersection points between Cylinder and ray
	 * @param ray
	 * @return List<Point3D> include the specific points
	 */
	public List<Point3D> findIntersections(Ray ray) {
		if (super.findIntersections(ray) == null)			
		{
             if(Util.isZero(ray.getDir().dotProduct(super.getAxisRay().getDir()))) return null;
			 else
			 {
				List<Point3D> result=new ArrayList<Point3D>();
				double t3=0;
                double t4=0;
				try {
					t3=getAxisRay().getP0().subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());                    
				} 
				catch (IllegalArgumentException e) {}
				try{	
				t4=getAxisRay().getP0().add(getAxisRay().getDir().scale(height)).subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());	
				}
				catch(IllegalArgumentException e){
                  return null;
				}					  
                if(t3>0&&!Util.isZero(t3)&&ray.getPoint(t3).distance(getAxisRay().getP0())<super.getRadius())
				      result.add(ray.getPoint(t3));
			    if(t4>0&&ray.getPoint(t4).distance(getAxisRay().getP0().add(getAxisRay().getDir().scale(height)))<super.getRadius())
				      result.add(ray.getPoint(t4));
				 if(result.size()!=0)return result;
				 else return null;
				
			 }
		}
		else {
			List<Point3D> result = super.findIntersections(ray);
			for (int i = 0; i < result.size(); i++) {
              try{
				if(Util.isZero(ray.getDir().dotProduct(getAxisRay().getDir()))&&(Util.isZero(result.get(i).subtract(super.getAxisRay().getP0()).dotProduct(super.getAxisRay().getDir()))||Util.isZero(result.get(i).subtract(super.getAxisRay().getP0().add(super.getAxisRay().getDir().scale(height))).dotProduct(super.getAxisRay().getDir()))))
				{
					return null;
				}
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
			double t3=0;
                double t4=0;
				try {
					t3=getAxisRay().getP0().subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());                    
				} 
				catch (IllegalArgumentException e) {}
				try{	
				t4=getAxisRay().getP0().add(getAxisRay().getDir().scale(height)).subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());	
				}
				catch(IllegalArgumentException e){
                  return null;
				}					  
                if(t3>0&&!Util.isZero(t3)&&ray.getPoint(t3).distance(getAxisRay().getP0())<super.getRadius())
				      result.add(ray.getPoint(t3));
			    if(t4>0&&ray.getPoint(t4).distance(getAxisRay().getP0().add(getAxisRay().getDir().scale(height)))<super.getRadius())
				      result.add(ray.getPoint(t4));
			return result.size() !=0? result:null;
		}

	}
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray)
	{
		if (super.findGeoIntersections(ray) == null)			
		{
             if(Util.isZero(ray.getDir().dotProduct(super.getAxisRay().getDir()))) return null;
			 else
			 {
				List<GeoPoint> result=new ArrayList<GeoPoint>();
				double t3=0;
                double t4=0;
				try {
					t3=getAxisRay().getP0().subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());                    
				} 
				catch (IllegalArgumentException e) {}
				try{	
				t4=getAxisRay().getP0().add(getAxisRay().getDir().scale(height)).subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());	
				}
				catch(IllegalArgumentException e){
                  return null;
				}					  
                if(t3>0&&!Util.isZero(t3)&&ray.getPoint(t3).distance(getAxisRay().getP0())<super.getRadius())
				      result.add(new GeoPoint(this,ray.getPoint(t3)));
			    if(t4>0&&ray.getPoint(t4).distance(getAxisRay().getP0().add(getAxisRay().getDir().scale(height)))<super.getRadius())
				      result.add(new GeoPoint(this,ray.getPoint(t4)));
				 if(result.size()!=0)return result;
				 else return null;
				
			 }
		}
		else {
			List<GeoPoint> result = super.findGeoIntersections(ray);
			for (int i = 0; i < result.size(); i++) {
              try{
				if(Util.isZero(ray.getDir().dotProduct(getAxisRay().getDir()))&&(Util.isZero(result.get(i).point.subtract(super.getAxisRay().getP0()).dotProduct(super.getAxisRay().getDir()))||Util.isZero(result.get(i).point.subtract(super.getAxisRay().getP0().add(super.getAxisRay().getDir().scale(height))).dotProduct(super.getAxisRay().getDir()))))
				{
					return null;
				}
                     if(result.get(i).point.subtract(super.getAxisRay().getP0()).dotProduct(super.getAxisRay().getDir())<0&& !Util.isZero(result.get(i).point.subtract(super.getAxisRay().getP0()).dotProduct(super.getAxisRay().getDir())))
					    result.remove(i);
					else if(result.get(i).point.subtract(super.getAxisRay().getP0().add(super.getAxisRay().getDir().scale(height))).dotProduct(super.getAxisRay().getDir())>0&& !Util.isZero(result.get(i).point.subtract(super.getAxisRay().getP0().add(super.getAxisRay().getDir().scale(height))).dotProduct(super.getAxisRay().getDir())))	
					{
						result.remove(i);
					}
			  }
			  catch(IllegalArgumentException e)
			  {
                 
			  }
			}
			double t3=0;
                double t4=0;
				try {
					t3=getAxisRay().getP0().subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());                    
				} 
				catch (IllegalArgumentException e) {}
				try{	
				t4=getAxisRay().getP0().add(getAxisRay().getDir().scale(height)).subtract(ray.getP0()).dotProduct(super.getAxisRay().getDir())/ray.getDir().dotProduct(super.getAxisRay().getDir());	
				}
				catch(IllegalArgumentException e){
                  return null;
				}					  
                if(t3>0&&!Util.isZero(t3)&&ray.getPoint(t3).distance(getAxisRay().getP0())<super.getRadius())
				      result.add(new GeoPoint(this,ray.getPoint(t3)));
			    if(t4>0&&ray.getPoint(t4).distance(getAxisRay().getP0().add(getAxisRay().getDir().scale(height)))<super.getRadius())
				      result.add(new GeoPoint(this,ray.getPoint(t4)));
			return result.size() !=0? result:null;
		}

	}


}
