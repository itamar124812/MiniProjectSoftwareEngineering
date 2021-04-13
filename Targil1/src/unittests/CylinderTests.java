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
	// ============ Equivalence Partitions Tests ==============
	//the ray does not intersect the cylinder(null)
	Ray ray=new Ray(new Point3D(2,0,-1),new Vector(0,0,3)) ;
	assertNull(c.findIntersections(ray));
	//the ray intersect the cylinder in one Point
	ray=new Ray(new Point3D(2,0,-1),new Vector(-1,0,1));
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(1,0,0))).toArray(),c.findIntersections(ray).toArray());
	//the ray intersect the cylinder in two Points
	ray=new Ray(new Point3D(2,0,-1),new Vector(-1,0,0.5));
	assertArrayEquals(new ArrayList<Point3D>(Arrays.asList(new Point3D(1,0,-0.5),new Point3D(-1,0,0.5))).toArray(),c.findIntersections(ray).toArray());
	// =============== Boundary Values Tests ==================
	//
}
	}
