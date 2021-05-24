package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
    private Vector direction;
	public DirectionalLight(Color intensity,Vector dir) {
		super(intensity); 
		direction=dir;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getIntensity(Point3D p) {
		// TODO Auto-generated method stub
		return intensity;
	}

	@Override
	public Vector getL(Point3D p) {
		// TODO Auto-generated method stub
		return direction.normalize();
	}

	@Override
	public double getDistance(Point3D point) {
		return Double.POSITIVE_INFINITY;
	}

}
