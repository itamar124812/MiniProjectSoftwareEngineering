package primitives;

public class Vector {
	private Point3D head;
	public Vector(double x,double y,double z) {
		head=new Point3D(x,y,z);
	}
    public Vector(Coordinate a,Coordinate b,Coordinate c)
    {
	head=new Point3D(a,b,c);
    }
	public Vector(Point3D head) {
		super();
		this.head = head;
	}

	public Point3D getHead() {
		return head;
	}
	public Vector add(Vector other) {
		return new Vector(head.x.coord+other.head.x.coord,head.y.coord+other.head.y.coord,head.z.coord+other.head.z.coord);
	}
	public Vector subtract(Vector other) {
		return new Vector(head.x.coord-other.head.x.coord,head.y.coord-other.head.y.coord,head.z.coord-other.head.z.coord);
	}
	public Vector scale(double scalar) {
		return new Vector(head.x.coord * scalar,head.y.coord* scalar,head.z.coord* scalar);
	}
	public double dotProduct(Vector other)
	{
		return head.x.coord*other.head.x.coord +head.y.coord*other.head.y.coord+head.z.coord*other.head.z.coord;
	}
	public Vector crossProduct(Vector other)
	{
		return new Vector(head.y.coord *other.head.z.coord-head.z.coord*other.head.y.coord , head.z.coord*other.head.x.coord-head.x.coord*other.head.z.coord ,head.x.coord*other.head.y.coord-head.y.coord*other.head.x.coord);
	}
	public double lengthSquared()
	{
		return head.x.coord*head.x.coord+head.y.coord*head.y.coord+head.z.coord*head.z.coord;
	}
	public double length()
	{
		return Math.sqrt(this.lengthSquared());
	}
	@Override
	public String toString() {
		return "Vector [head=" + head + "]";
	}

}
;