package primitives;

import java.util.List;

import geometries.Intersectable.GeoPoint;

/** 
 * Ray class is class that represents a beam by the zero point direction vector
 * 
 * @author Itamar and Raz
 *
 */
public class Ray {
	private Point3D p0;
	private Vector dir;
    private static final double Delta=0.1;
	public Ray(Point3D head,Vector direction, Vector normal)
	{
		dir=direction.normalize();
		if(normal.length()!=1)normal.normalize();
		if(!Util.isZero(direction.dotProduct(normal))) p0=head.add(normal.scale(Delta*(direction.dotProduct(normal))));
		else p0=head;
	}
	public Ray(Point3D p0, Vector dir) {
		super();
		this.p0 = p0;
		if (dir.length() == 1)
			this.dir = dir;
		else
			this.dir = dir.normalize();
	}

	public Point3D getP0() {
		return p0;
	}

	public Vector getDir() {
		return dir;
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0.toString() + ", dir=" + dir.toString() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		return this.p0.equals(other.p0) && this.dir.equals(other.dir);
	}

	public Point3D getPoint(double t) {
		if(!Util.isZero(t))
		return this.p0.add(this.dir.scale(t));
		else return p0;
	}

	/**
	 * findClosestPoint
	 * 
	 * @param List<Point3D>
	 * @return the closest point to p0 ray
	 */
	public Point3D findClosestPoint(List<Point3D> list) {
		if (list == null)
			return null;
		Point3D close = list.get(0);
		for (int i = 1; i < list.size(); i++)
			if (this.p0.distance(close) > this.p0.distance(list.get(i)))
				close = list.get(i);
		return close;
	}

	public GeoPoint findClosestGeoPoint(List<GeoPoint> list) {
		if (list == null)
			return null;
		GeoPoint close = list.get(0);
		for (int i = 1; i < list.size(); i++)
			if (this.p0.distance(close.point) > this.p0.distance(list.get(i).point))
				close = list.get(i);
		return close;
	}
}
