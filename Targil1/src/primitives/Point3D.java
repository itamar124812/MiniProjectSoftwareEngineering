package primitives;

/**
 * Point Displays a point in space by 3 coordinates
 * 
 * @author Itamar and Raz
 *
 */
public final class Point3D {
	 final Coordinate x;
	 final Coordinate y;
	 final Coordinate z;
	
	public final static Point3D ZERO =new Point3D(0,0,0);

	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		this(x.coord,y.coord,z.coord);
	}
	public Point3D(double x, double y, double z) {
		super();
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
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
	/**
     * Vector subtraction
     * 
     * @param point
     * @return Vector from the second point to the point on which it is performed the action
     */
	public Vector subtract(Point3D point2) {
		return new Vector((this.x.coord-point2.x.coord),(this.y.coord-point2.y.coord),(this.z.coord-point2.z.coord));
	}
	/**
     * Add a vector to a dot
     * 
     * @param vector
     * @return A new point
     */
	public Point3D add(Vector vector) {
	return new Point3D(this.x.coord+vector.getHead().x.coord,this.y.coord+vector.getHead().y.coord,
				 this.z.coord+vector.getHead().z.coord);
	}
	/**
     * Calculate the distance between two points or more squared
     * 
     * @param point
     * @return the distance between two points squared
     */
	public double distanceSquared(Point3D point2) {
		return ((this.x.coord-point2.x.coord)*(this.x.coord-point2.x.coord))+((this.y.coord-point2.y.coord)*(this.y.coord-point2.y.coord))
				+((this.z.coord-point2.z.coord)*(this.z.coord-point2.z.coord));
	}
	/**
     * Calculate distance between two points by the previous function
     * 
     * @param point
     * @return distance between two points
     */
	public double distance(Point3D point2) {
		 return  Math.sqrt(this.distanceSquared(point2));
	}
}
