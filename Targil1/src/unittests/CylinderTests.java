	/**
	 * 
	 */
	package unittests;

	import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import geometries.Cylinder;
	import org.junit.Test;
	import primitives.*;


	/**
	 *@author Raz Shely && Itamar Cohen
	 *
	 */
	public class CylinderTests {

		/**
		 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
		 */
		@Test
		public void testGetNormal() {
			Point3D pP0=new Point3D(0,0,2);
			Vector vDir=new Vector(0,0,1); 
			Ray rVal=new Ray(pP0,vDir);
			Cylinder cTest=new Cylinder(rVal,3,4);
	        // ============ Equivalence Partitions Tests ==============
			//Checks the normal to some points on the cylinder bases.
			assertEquals(new Vector(0,0,1),cTest.getNormal(new Point3D(0,2,2)));
			assertEquals(new Vector(0,0,1),cTest.getNormal(new Point3D(0,2,6)));
			//Checks the normal to some point on the cylinder side.
			assertEquals(new Vector(0,1,0),cTest.getNormal(new Point3D(0,3,5)));
			// =============== Boundary Values Tests ================== 
			//Checks the normal to central points on the cylinder bases.
			assertEquals(new Vector(0,0,1),cTest.getNormal(new Point3D(0,0,2)));
			assertEquals(new Vector(0,0,1),cTest.getNormal(new Point3D(0,0,6)));
		}
		/**
		 * Test method for{@link geometries.Cylinder#findIntersections(Ray)}.
		 */
		@Test
public void testFindIntersections() 
{
	Cylinder c=new Cylinder(new Ray(new Point3D(0,0,-1),new Vector(0,0,1)),1,2);
	//assertNull(new Cylinder(new Ray(new Point3D(-75d/2, 25,-150), new Vector(0, 1, 0)), 10, 0.1).findGeoIntersections(new Ray(new Point3D())));
	// ============ Equivalence Partitions Tests ==============
	//TC1::the ray does not intersect the cylinder(null) 
	Ray ray=new Ray(new Point3D(2,0,-1),new Vector(0,0,3)) ;
	assertNull(c.findIntersections(ray));
	//TC2::the ray intersect the cylinder in one Point
	ray=new Ray(new Point3D(2,0,-1),new Vector(-1,0,2));
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(1,0,1))).toArray(),c.findIntersections(ray).toArray());
	//TC3::the ray intersect the cylinder in two Points
	ray=new Ray(new Point3D(2,0,-1),new Vector(-1,0,0.5));
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(1,0,-0.5),new Point3D(-1,0,0.5))).toArray(),c.findIntersections(ray).toArray());
	// =============== Boundary Values Tests ==================
	//TC4::The ray starts before the bottom base and parallels the axis of the cylinder so that it crosses the two bases.(two points)
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(0,0.5,-1),new Point3D(0,0.5,1))).toArray(),c.findIntersections(new Ray(new Point3D(0, 0.5, -2), new Vector(0, 0, 1))).toArray());
    //TC5::The ray starts on the bottom base and parallels the axis of the cylinder so that it crosses the two bases.(one point requirement)
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(0,0.5,1))).toArray(),c.findIntersections(new Ray(new Point3D(0, 0.5, -1), new Vector(0, 0, 1))).toArray());
	//TC6::The ray starts in the cylinder and across the top base(one point)
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(0,0.5,1))).toArray(),c.findIntersections(new Ray(new Point3D(0, 0.5, 0), new Vector(0, 0, 1))).toArray());
	//TC7::The ray starts on the top base (null requirement)
    assertNull(c.findIntersections(new Ray(new Point3D(0, 0.5, 1), new Vector(0, 0, 1))));
    //TC8::The ray starts above the top base. (null)
	assertNull(c.findIntersections(new Ray(new Point3D(0, 0.5, 2), new Vector(0, 1, 0))));
	//TC9::The ray starts before the base and continues on the base leading to an infinity of intersections between it and the cylinder.(null requirement)
	assertNull(c.findIntersections(new Ray(new Point3D(-5, 0, -1), new Vector(1, 0, 0))));
	//TC10::The ray starts on the base and continues on the base leading to an infinity of intersections between it and the cylinder.(null requirement)
	assertNull(c.findIntersections(new Ray(new Point3D(0, 0, -1), new Vector(1, 0, 0))));
	//TC11::The ray dirction vector is on the lower base but it cuts the bottom base exactly at its end point so that from the cut only one point is formed(null requirement)
	assertNull(c.findIntersections(new Ray(new Point3D(1,1,-1),new Vector(0,-1,0))));
    //TC12::The ray intersect side and base(two points)
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(1,0,0),new Point3D(0, 0, 1))).toArray(),c.findIntersections(new Ray(new Point3D(2, 0,-1), new Vector(-2, 0, 2))).toArray());
	//TC13::The ray intersect lower and upper bases cap in there rim(two points)
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(1,0,-1),new Point3D(-1, 0, 1))).toArray(),c.findIntersections(new Ray(new Point3D(2, 0,-2), new Vector(-2, 0, 2))).toArray());
	//TC14::The ray is parallel to the cylinder bases(two points)
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(-1,0,0),new Point3D(1, 0, 0))).toArray(),c.findIntersections(new Ray(new Point3D(-2, 0,0), new Vector(1, 0, 0))).toArray());
  }
}
