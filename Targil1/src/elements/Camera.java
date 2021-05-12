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
/**
 * 
 * @param location
 * @param vto
 * @param vup
 */
public Camera(Point3D location, Vector vto, Vector vup) {
    this.location = location;
    Vto = vto.normalized();
    Vup = vup.normalized();
    if(Util.isZero(vto.dotProduct(vup)))
   {
      Vright=vto.crossProduct(vup).normalize();
   }
    else throw new IllegalArgumentException("Vto must be orthogonal to Vup");
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
/**
 * 
 * @param nX
 * @param nY
 * @param j
 * @param i
 * @return Ray
 */
public Ray constructRayThroughPixel(int nX, int nY, int j, int i)
{
    Point3D Pc= location.add(Vto.scale(Distance));
    double Rx=Width/nX;
    double Ry=Height/nY;
    if(Util.isZero(Rx*(j-(double)(nX-1)/2))&&Util.isZero(-Ry*(i-(double)(nY-1)/2))) return new Ray(location,Pc.subtract(location));
    else if(Util.isZero(Rx*(j-(double)(nX-1)/2))) return new Ray(location,Pc.add(Vup.scale(-Ry*(i-(double)(nY-1)/2))).subtract(location));
    else if(Util.isZero(-Ry*(i-(double)(nY-1)/2))) return new Ray(location,Pc.add(Vright.scale(Rx*(j-(double)(nX-1)/2))).subtract(location));
    else return new Ray(location,Pc.add(Vright.scale(Rx*(j-(double)(nX-1)/2))).add(Vup.scale(-Ry*(i-(double)(nY-1)/2))).subtract(location));
}
/**
 * 
 * @param width
 * @param height
 * @return Camera(this).
 */
public Camera setViewPlaneSize(double width, double height) {
this.Width=width;
this.Height=height;
return this;
}
/**
 * 
 * @param distance
 * @return Camera(this)
 */
public Camera setDistance(double distance) {
this.Distance=distance;
return this;
} 
  
}
