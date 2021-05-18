package elements;

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
		return super.getIntensity().scale(Math.max(0, direction.dotProduct(super.getL(p))));
	}
	@Override
	public Vector getL(Point3D p) {
		// TODO Auto-generated method stub
		return  super.getL(p);
	}

}
