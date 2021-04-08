package geometries;

import primitives.*;
/**
 * Geometry class is interface class that all geometries class implements it for must create getNormal func
 * 
 * @author Itamar and Raz
 *
 */
public interface Geometry extends Intersectable {
public Vector getNormal(Point3D point); 
}