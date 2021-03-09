package geometries;
import primitives.Vector;
import primitives.Point3D;
public class Plane  implements Geometry {
private Vector normal;
private Point3D q0;
public Plane(Point3D a,Point3D b,Point3D c)
{
	q0=a;
	Vector A =a.subtract(b);
	Vector B=a.subtract(c);
	if(A.normalize().equals(B.normalize())||A.normalize().equals(B.normalize().scale(-1)))	throw new  IllegalArgumentException("Three points must not be on the same straight line.");
	else 
	{
		normal =A.crossProduct(B);
	}
}
public Plane(Point3D Q0,Vector Normal) 
{
	q0=Q0;
	normal=Normal;
}
@Override
public String toString() {
	return "Plane [normal=" + normal + ", q0=" + q0 + "]";
}
@Override
public Vector getNormal(Point3D point) {
	// TODO Auto-generated method stub
	return null;
}

public Vector getNormal() {
	return normal;
}

public Point3D getQ0() {
	return q0;
}

}
