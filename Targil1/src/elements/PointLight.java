package elements;
 
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource {
private double kC,kL,kQ;
public PointLight setkC(double kC) {
	this.kC = kC;
	return this;
}
public PointLight setkL(double kL) {
	this.kL = kL;return this;
}


public PointLight setkQ(double kQ) {
	this.kQ = kQ;return this;
}

private Point3D position;
	public PointLight(Color intensity,Point3D Position) {
		super(intensity);
		position=Position;
		kC=1;
		kL=0;
		kQ=0;
	}

	@Override
	public Color getIntensity(Point3D p) {
		double d=getDistance(p);
		return intensity.scale(1d/(kC+kL*d+kQ*d*d));
	}

	@Override
	public Vector getL(Point3D p) {
		// TODO Auto-generated method stub
		return  p.subtract(position).normalize();
	}
	@Override
	public double getDistance(Point3D point) {
		// TODO Auto-generated method stub
		return position.distance(point);
	}
    public Point3D getPosition()
	{
		return position;
	}
}
