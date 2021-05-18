package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight {
    private Vector direction;
	public SpotLight(Color intensity,Point3D position,Vector adirection) {
		super(intensity, position);		
		direction=adirection;
	}

}
