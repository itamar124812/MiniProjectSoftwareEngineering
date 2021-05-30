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
		double factor=Util.alignZero( Math.max(0, direction.normalize().dotProduct(getL(p).normalize())));
		return super.getIntensity(p).scale(factor);
	}


}
