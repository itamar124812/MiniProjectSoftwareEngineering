package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SuperSpotLight extends SpotLight {
private double angle;
public SuperSpotLight setAngle(double Angle)
{	
	while(!(Angle>=0 && Angle<2*Math.PI))
	{
		if(Angle>0)Angle+=2*Math.PI;
		else Angle-=2*Math.PI;
	}
	if(Angle>=0&&Angle<2*Math.PI)
	{
		angle=Angle;
	}
	return this;
}
	public SuperSpotLight(Color intensity, Point3D position, Vector adirection) {
		super(intensity, position, adirection);
		// TODO Auto-generated constructor stub
	}
	

}
