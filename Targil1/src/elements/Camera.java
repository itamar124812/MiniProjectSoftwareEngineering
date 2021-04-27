package elements;
import primitives.*;
public class Camera {
private Point3D location;
private Vector Vto;
private Vector Vright;
private Vector Vup;
public Camera(Point3D location, Vector vto, Vector vup) {
    this.location = location;
    Vto = vto;
    Vup = vup;
    if(Util.isZero(vto.dotProduct(vup)))
   {
      Vright=vup.crossProduct(vto);
   }
    else throw new IllegalArgumentException("Vto must be ");
}

}
