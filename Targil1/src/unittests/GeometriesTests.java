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
		fail("Not yet implemented");
	}

	@Test
	public void testFindIntsersections() {
    	// ============ Equivalence Partitions Tests ==============
		Geometries geometries=new Geometries(new ArrayList<Intersectable>(List.of(new Triangle(new Point3D(-1,0,0),new Point3D(0,0,5),new Point3D(0,4,5)),
				new Polygon(new Point3D(-1,0,0),new Point3D(0,0,5),new Point3D(0,4,5),new Point3D(-1,4,0)),
				new Cylinder(new Ray(new Point3D(0,0,-1),new Vector(0,0,1)),1,2),
				new Sphere(new Point3D(1, 0, 0),1d),
				new Tube(new Ray(new Point3D(0,0,1),new Vector(0,0,1)),1d))));
        // TC01: The ray pass all the geometries

        // =============== Boundary Values Tests ==================

	}
	
}
