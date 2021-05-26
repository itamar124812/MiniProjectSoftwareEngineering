package elements;

import javax.swing.text.Position;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight {
    private Vector direction;
	public SpotLight(Color intensity,Point3D position,Vector adirection) {
		super(intensity, position);		
		direction=adirection;}
	@Override
	public Color getIntensity(Point3D p) {
		return super.getIntensity().scale(Math.max(0, direction.normalize().dotProduct(super.getL(p).normalize())));
	}
	@Override
	public Vector getL(Point3D p) {
		// TODO Auto-generated method stub
		return  super.getL(p);
	}
	@Override
	public double getDistance(Point3D p)
	{
           return super.getDistance(p);
	}

}
