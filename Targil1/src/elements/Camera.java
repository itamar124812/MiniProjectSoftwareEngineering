package elements;
import primitives.*;
public class Camera {
private Point3D location;
private Vector Vto;
private Vector Vright;
private Vector Vup;
private double Distance;
private double Width;
private double Height;
public Camera(Point3D location, Vector vto, Vector vup) {
    this.location = location;
    Vto = vto;
    Vup = vup;
    if(Util.isZero(vto.dotProduct(vup)))
   {
      Vright=vup.crossProduct(vto);
   }
    else throw new IllegalArgumentException("Vto must be orthogonal");
}
public Point3D getLocation() {
    return location;
}
public Vector getVto() {
    return Vto;
}
public Vector getVright() {
    return Vright;
}

public Vector getVup() {
    return Vup;
}


}
