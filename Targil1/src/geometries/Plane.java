package geometries;
import primitives.Vector;
import primitives.Point3D;
public class Plane  implements Geometry {
private Vector normal;
private Point3D q0;
public Plane(Point3D a,Point3D b,Point3D c)
{
	q0=a;
	
}
@Override
public Vector getNormal(Point3D point) {
	// TODO Auto-generated method stub
	return null;
}

}
