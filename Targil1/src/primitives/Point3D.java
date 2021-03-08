package primitives;

public final class Point3D {
	private final Coordinate x;
	private final Coordinate y;
	private final Coordinate z;
	
	final static Point3D ZERO =new Point3D(0,0,0);

	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point3D(double x, double y, double z) {
		super();
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}
	public Coordinate getX() {
		return x;
	}
	public Coordinate getY() {
		return y;
	}
	public Coordinate getZ() {
		return z;
	}
	 @Override
	 public boolean equals(Object obj) {
	 if (this == obj) return true;
	 if (obj == null) return false;
	 if (!(obj instanceof Point3D)) return false;
	 Point3D other = (Point3D)obj;
	 return this.x.equals(other.x) && this.y.equals(other.y)&& this.z.equals(other.z);
	 }
	@Override
	public String toString() {
		return "Point3D [ x= " + x.toString() + " , y= " + y.toString() + " , z= " + z.toString() + " ]";
	}
	public Vector subtract(Point3D point2) {
	 
	}
	public Point3D add(Vector vector) {
		 
	}
	public double distanceSquared(Point3D point2) {
		 return this.x
	}
	public double distance(Point3D point2) {
		 
	}
}
