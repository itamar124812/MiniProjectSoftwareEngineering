package primitives;

/**
 * Ray class is class that represents a beam by the zero point direction vector
 * 
 * @author Itamar and Raz
 *
 */
public class Ray {
private Point3D p0;
private Vector dir;
 
public Ray(Point3D p0, Vector dir) {
	super();
	this.p0 = p0;
	if(dir.length()==1)
	this.dir = dir;
	else
		this.dir=dir.normalize();
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
if (this == obj) return true;
if (obj == null) return false;
if (!(obj instanceof Ray)) return false;
Ray other = (Ray)obj;
return this.p0.equals(other.p0) && this.dir.equals(other.dir);
}
public Point3D getPoint(double t) {
	return this.p0.add(this.dir.scale(t));
}
}
