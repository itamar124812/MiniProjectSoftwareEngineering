package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import geometries.*;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class GeometriesTests {

	@Test
	public void testGeometries() {
		try {
            new Geometries(new ArrayList<Intersectable>(List.of(
    				new Triangle(new Point3D(2,3,-1),new Point3D(1,1,0),new Point3D(0,1.6,2.5)),
    				new Tube(new Ray(new Point3D(2,2,0),new Vector(0,0,4)),1d))));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        }
	}

	@Test
	public void testFindIntsersections() {
    	// ============ Equivalence Partitions Tests ==============
		Geometries geometries=new Geometries(new ArrayList<Intersectable>(List.of(
				new Triangle(new Point3D(2,3,-1),new Point3D(1,1,0),new Point3D(0,1.6,2.5)),
				//new Polygon(new Point3D(2,3,-1),new Point3D(1,1,0),new Point3D(0,1.6,2.5),new Point3D(0,0,0)),
				//new Cylinder(new Ray(new Point3D(2,2,0),new Vector(0,0,4)),1,4),
				new Sphere(new Point3D(0,2,0),1d),
				new Tube(new Ray(new Point3D(2,2,0),new Vector(0,0,4)),1d))));
        // TC01: The ray pass all the geometries
        Ray ray=new Ray(new Point3D(-3,3,0),new Vector(3.869374604797966,-1.149054810376399,0.772276922141073));
        Point3D p1 = new Point3D(0.869374604797966, 1.850945189623601, 0.772276922141073);
       // Point3D p2 = new Point3D(1.018890926158435, 1.806544616963616, 0.802118438216291);
      //  Point3D p3 = new Point3D(2.716505573899753, 1.302418633727509, 1.140940276120951);
        Point3D p4 = new Point3D(-0.828275208253421, 2.355081615598605, 0.433448065697191);
        Point3D p5 = new Point3D(0.673842397953834, 1.909010702996012, 0.733251232900803);

   	 	List<Point3D> result = geometries.findIntersections(ray);
   	 	assertEquals("Wrong number of points", 3, result.size());
   	 	assertEquals("Ray crosses Geometries", List.of(p1, p5, p4), result);;
        // TC02: The ray not pass all the geometries

        // =============== Boundary Values Tests ==================

	}
	
}
