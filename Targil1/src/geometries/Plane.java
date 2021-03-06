package geometries;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
/**
 * Represents a plane in space with the help of a normal vector and a reference point
*/
public class Plane extends Geometry {
private Vector normal;
private Point3D q0;
/*
 * Constructor that accepts a three-point checks are on the right if you do not produce them represented with a plane normal vector and a reference point
 * the math module: All three points that are not on the same line maintain a plane in space.
 * So we need to check that the three points are not on the same line and move the plane they create to representation using normal and reference point
 * The test works like this:
 * create two vectors from the points A form point a  to point b and B from point a to point c
 * if A,B on the same line there is k belongs to R that Uphold k*A=B the problem there is infinity values for k and we don't have access to their coordinates
 *the number of combinations of k to two by normalizing the two vectors
 *After normalization there will be two options k = 1 or k = -1 we will check them if they exist we will throw another deviation we have a plane and we will use a vector product to find the normal to our plane.
 **/
public Plane(Point3D a,Point3D b,Point3D c)
{
	q0=a;
	Vector A =a.subtract(b);
	Vector B=a.subtract(c);
	if(A.normalized().equals(B.normalized())||A.normalized().equals(B.normalized().scale(-1)))	throw new  IllegalArgumentException("Three points must not be on the same straight line.");
	else  
	{
		normal =(A.crossProduct(B)).normalize();
	}
}
//Constructor that accepts parameters and sets them
public Plane(Point3D Q0,Vector Normal) 
{
	q0=Q0;
	normal=Normal.normalize();
}
@Override
public String toString() {
	return "Plane [normal=" + normal + ", q0=" + q0 + "]";
} 
@Override
public Vector getNormal(Point3D point) {
	// TODO Auto-generated method stub
	return normal;
}
//Getters
public Vector getNormal() {
	return normal;
}

public Point3D getQ0() {
	return q0;
}
/**
 * calculate intersection GeoPoint between plane and ray
 * @param ray
 * @return List<GeoPoint> include the specific point
 **/
@Override
public List<GeoPoint> findGeoIntersections(Ray ray) {
	if(ray.getP0().equals(this.q0) || Util.isZero(ray.getP0().subtract(q0).dotProduct(normal))) return null;
	else {
		double t=normal.dotProduct((this.q0).subtract(ray.getP0()));
		if(t==0) return null;
		if(normal.dotProduct(ray.getDir())!=0)
			{
			t/=normal.dotProduct(ray.getDir());
			if(t>0)
			{
			List<GeoPoint> result=new ArrayList<GeoPoint>();
			result.add(new GeoPoint(this,ray.getPoint(t)));
			return result;
			}
			else return null;
			}
		else return null;
		
	}
}

}
