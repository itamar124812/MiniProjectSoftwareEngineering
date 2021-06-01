package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

public class SuperSpotLight extends PointLight {
  private double nLight;
 private Vector direction;
	public SuperSpotLight(Color intensity, Point3D position, Vector adirection,double nlight) {
		super(intensity, position);
		direction=adirection;
		nLight=nlight;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Color getIntensity(Point3D p) {
		double factor=Util.alignZero( Math.max(0, direction.normalize().dotProduct(getL(p).normalize())));
		return super.getIntensity(p).scale(Math.pow(factor, nLight));
	}
	
	

}
