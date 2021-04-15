package primitives;

public class Vector {
	private Point3D head;
	private  Vector()
	{
		head=new Point3D(0,0,0);
	}
    static	public Vector Vector0=new Vector();
	public Vector(double x,double y,double z) {
		if(x==0&& y==0&& z==0)throw new IllegalArgumentException("Do not enter a vector whose values ​​are 0.");
		head=new Point3D(x,y,z);
	}
    public Vector(Coordinate a,Coordinate b,Coordinate c)
    {
    	if(a.coord==0&& b.coord==0&& c.coord==0)throw new IllegalArgumentException("Do not enter a vector whose values ​​are 0.");
	head=new Point3D(a,b,c);
    }
	public Vector(Point3D Head) {
		super();
		if(Head.equals(new Point3D(0,0,0)))throw new IllegalArgumentException("Do not enter a vector whose values ​​are 0.");
		this.head = Head;
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vector))
			return false;
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}
	public Vector normalize() {
		 this.head=new Point3D(this.scale(1/this.length()).head.x,this.scale(1/this.length()).head.y,
				 this.scale(1/this.length()).head.z);
		 return this;
	}
	public Vector normalized() {
		Vector temp=this.normalize();
		return new Vector(temp.getHead());
	}
}
;