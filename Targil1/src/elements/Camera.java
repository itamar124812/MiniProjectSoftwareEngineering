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
    Vto = vto.normalized();
    Vup = vup.normalized();
    if(Util.isZero(vto.dotProduct(vup)))
   {
      Vright=vup.crossProduct(vto).normalize();
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
public Ray constructRayThroughPixel(int nX, int nY, int j, int i)
{
    Vector Pc=new Vector(location.add(Vto.scale(Distance)));
    double Rx=Width/nX;
    double Ry=Height/nY;
    if(Util.isZero(-Rx*(j-(double)(nX-1)/2))&&Util.isZero(-Ry*(i-(double)(nY-1)/2))) return new Ray(location,Pc);
    else if(Util.isZero(-Rx*(j-(double)(nX-1)/2))) return new Ray(location,Pc.add(Vup.scale(-Ry*(i-(double)(nY-1)/2))));
    else if(Util.isZero(-Ry*(i-(double)(nY-1)/2))) return new Ray(location,Pc.add(Vright.scale(-Rx*(j-(double)(nX-1)/2))));
    else return new Ray(location,Pc.add(Vright.scale(-Rx*(j-(double)(nX-1)/2))).add(Vup.scale(-Ry*(i-(double)(nY-1)/2))));
}
public Camera setViewPlaneSize(double width, double height) {
this.Width=width;
this.Height=height;
return this;
}

public Camera setDistance(double distance) {
this.Distance=distance;
return this;
}

}
