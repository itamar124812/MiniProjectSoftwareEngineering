package elements;

import primitives.Color;

public class AmbientLight {
 private Color intensity;

public AmbientLight(Color Ia,double Ka ) {
    intensity=Ia.scale(Ka);
}
 public AmbientLight()
{
    intensity=Color.BLACK;
}
public Color getIntensity() {
    return intensity;
}
    
}
