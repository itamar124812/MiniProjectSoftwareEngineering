package primitives;

public final class Point3D {
	private final Coordinate x;
	private final Coordinate y;
	private final Coordinate z;
	
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
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

}
