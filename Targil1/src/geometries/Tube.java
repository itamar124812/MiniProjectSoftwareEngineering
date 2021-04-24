package geometries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
/**
 * Calculate the normal on point on the The wall of the Tube
 * 
 * @param point
 * @return the normal on point on the The wall of the Tube
 */
	@Override
	public Vector getNormal(Point3D point) {
		double temp=axisRay.getDir().dotProduct(point.subtract(axisRay.getP0()));
		if(temp==0)
		return (point.subtract(Point3D.ZERO)).normalize();
		Point3D O=axisRay.getP0().add(axisRay.getDir().scale(temp));
		return (point.subtract(O)).normalize();

	}
	/**
	 * @param ray
	 * calculate intersection points between Tube and ray
	 * 
	 * @return List<Point3D> include the specific points
	 */
@Override
public List<Point3D> findIntersections(Ray ray) {  
	double a=0;
    double b=0;
	double c=0;
	if(ray.getP0().equals(axisRay.getP0()))
	{
		if(ray.getDir().equals(axisRay.getDir()))return null;
		else
		{
            if(Util.isZero(ray.getDir().dotProduct(axisRay.getDir())))return new ArrayList<Point3D>(Arrays.asList(ray.getPoint(radius)));
			else return new ArrayList<Point3D>(Arrays.asList(ray.getPoint(radius/Math.sqrt((ray.getDir().subtract(axisRay.getDir().scale(ray.getDir().dotProduct(axisRay.getDir())/axisRay.getDir().lengthSquared()))).lengthSquared()))));
		}		
	}
	if(Util.isZero(ray.getDir().dotProduct(axisRay.getDir())))
	{
         a=ray.getDir().lengthSquared();
		 if(Util.isZero(ray.getP0().subtract(axisRay.getP0()).dotProduct(axisRay.getDir())))	
		 {
           b=2*ray.getP0().subtract(axisRay.getP0()).dotProduct(ray.getDir());
		   c=ray.getP0().subtract(axisRay.getP0()).lengthSquared()-radius*radius;
		 }	 
		 else
		 {
            b=2*ray.getDir().dotProduct(ray.getP0().subtract(axisRay.getP0()).subtract(this.axisRay.getDir().scale(ray.getP0().subtract(axisRay.getP0()).dotProduct(this.axisRay.getDir())/this.axisRay.getDir().lengthSquared())));
			c=ray.getP0().subtract(axisRay.getP0()).subtract(this.axisRay.getDir().scale(ray.getP0().subtract(axisRay.getP0()).dotProduct(this.axisRay.getDir())/this.axisRay.getDir().lengthSquared())).lengthSquared()-radius*radius;	
		 }
	}
    else if(Util.isZero(ray.getP0().subtract(axisRay.getP0()).dotProduct(axisRay.getDir())))
    {
		try {
			a=ray.getDir().subtract(this.axisRay.getDir().scale(ray.getDir().dotProduct(this.axisRay.getDir())/this.axisRay.getDir().lengthSquared())).lengthSquared();
            
		} catch (IllegalArgumentException e) {
			return null;
		}
		    b= 2*ray.getDir().subtract(this.axisRay.getDir().scale(ray.getDir().dotProduct(this.axisRay.getDir())/this.axisRay.getDir().lengthSquared())).dotProduct(ray.getP0().subtract(axisRay.getP0()));
			c=-radius*radius+ray.getP0().subtract(axisRay.getP0()).lengthSquared();
    }
	else{
	 Vector projectedRayVector=this.axisRay.getDir().scale(ray.getDir().dotProduct(this.axisRay.getDir())/this.axisRay.getDir().lengthSquared());;
	 Vector pRaySubP0=pRaySubP0=ray.getP0().subtract(axisRay.getP0());
	 Vector projectedDPVector=this.axisRay.getDir().scale(pRaySubP0.dotProduct(this.axisRay.getDir())/this.axisRay.getDir().lengthSquared());	
	try {
		a=ray.getDir().subtract(projectedRayVector).lengthSquared();
	} catch (IllegalArgumentException e) {
		a=0;
	}
	try {
		b=2*ray.getDir().subtract(projectedRayVector).dotProduct(pRaySubP0.subtract(projectedDPVector));
	} catch (IllegalArgumentException e) {
		b=0;
	}	
	try {
		c=pRaySubP0.subtract(projectedDPVector).lengthSquared()-this.radius*radius;
	} catch (IllegalArgumentException e) {
		c=-this.radius*radius;
	}
	
}
/*	double a=ray.getDir().getHead().getX()*ray.getDir().getHead().getX()+ray.getDir().getHead().getY()*ray.getDir().getHead().getY();
	double b=2*(ray.getDir().getHead().getX()*ray.getP0().getX()+ray.getDir().getHead().getY()*ray.getP0().getY());
	double c=ray.getP0().getY()*ray.getP0().getY()+ray.getP0().getX()*ray.getP0().getX()-this.radius;*/
	if(Util.isZero(a))return null;
	 if(Util.isZero(b*b-4*a*c)) {
		 if(-b/(2*a)<0)return null;
		ArrayList<Point3D> result=new ArrayList<Point3D> ();
		result.add(ray.getPoint(-b/(2*a)));
		return result;
	 }
	 else if((b*b-4*a*c)<0) return null;		
	 else
	 {
		double d=Math.sqrt(b*b-4*a*c);
		if((-b-d)/(2*a)>0&&(-b+d)/(2*a)>0  && ! Util.isZero((-b-d)/(2*a)))
		{
		ArrayList<Point3D> result=new ArrayList<Point3D> ();	
		result.add(ray.getPoint((-b-d)/(2*a)));
		result.add(ray.getPoint((-b+d)/(2*a)));
	    return result;
		}
		else if((-b+d)/(2*a)>0 && ! Util.isZero((-b+d)/(2*a)))
		{
			ArrayList<Point3D> result=new ArrayList<Point3D> ();
			result.add(ray.getPoint((-b+d)/(2*a)));
		    return result;
		}
		else return null;
	 }
}


}
