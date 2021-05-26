package elements;


import primitives.Color;
import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

public class SpotLight extends PointLight {
    private Vector direction;
	public SpotLight(Color intensity,Point3D position,Vector adirection) {
		super(intensity, position);		
		direction=adirection;}
	@Override
	public Color getIntensity(Point3D p) {
		double factor=Util.alignZero( Math.max(0, direction.normalize().dotProduct(super.getL(p).normalize())));
		return super.getIntensity().scale(factor);
	}
	@Override
	public Vector getL(Point3D p) {
		// TODO Auto-generated method stub
		return  super.getL(p).normalize();
	}
	@Override
	public double getDistance(Point3D p)
	{
           return super.getDistance(p);
	}

}
