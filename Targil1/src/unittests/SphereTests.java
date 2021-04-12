/**
 * 
 */
package unittests;
import static org.junit.Assert.*;
import java.util.List;

import geometries.Sphere;
import org.junit.Test;
import primitives.*;

/**
 * Testing Spheres
 * 
 * @author Itamar and Raz
 *
 */
public class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
	    // ============ Equivalence Partitions Tests ==============
		Sphere sTest=new Sphere(new Point3D(3,0,0),5);
        // TC01: test a dot on the circle
		assertEquals(new Vector(0.6,-Math.sqrt(8)/5,-Math.sqrt(8)/5),sTest.getNormal(new Point3D(0,Math.sqrt(8),Math.sqrt(8))));
	}
	/**
	 * Test method for {@link geometries.Sphere#findIntsersections(primitives.Ray)}.
	 */
	 @Test
	 public void testFindIntsersections() {
	 Sphere sphere = new Sphere(new Point3D(1, 0, 0),1d);
	 // ============ Equivalence Partitions Tests ==============
	 // TC01: Ray's line is outside the sphere (0 points)
	 assertNull("Ray's line out of sphere",
	 sphere.findIntsersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))));
	 // TC02: Ray starts before and crosses the sphere (2 points)
	 Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
	 Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
	 List<Point3D> result = sphere.findIntsersections(new Ray(new Point3D(-1, 0, 0),
	 new Vector(3, 1, 0)));
	 assertEquals("Wrong number of points", 2, result.size());
	 if (result.get(0).getX() > result.get(1).getX())
	 result = List.of(result.get(1), result.get(0));
	 assertEquals("Ray crosses sphere", List.of(p1, p2), result);;
	 // TC03: Ray starts inside the sphere (1 point)
	 p1 = new Point3D(1.3559964222368532, 0.3559964222368531,  0.864021466578881);
	 result = sphere.findIntsersections(new Ray(new Point3D(1.5, 0.5, 0),
	 new Vector(-0.5, -0.5, 3)));
	 assertEquals("Wrong number of points", 1, result.size());
	 assertEquals("Ray crosses sphere", List.of(p1), result);;
	 // TC04: Ray starts after the sphere (0 points)
	 assertNull("Ray's line after the sphere",
	 sphere.findIntsersections(new Ray(new Point3D(1.5, 0, 2), new Vector(0.25, 0, 1))));
	 
	 // =============== Boundary Values Tests ==================
	 // **** Group: Ray's line crosses the sphere (but not the center)
	 // TC11: Ray starts at sphere and goes inside (1 points)
	 p1 = new Point3D(0.9930295817749066, 0.7070724243454608,Math.sqrt(0.5));
	 result = sphere.findIntsersections(new Ray(new Point3D(0.5, 0.5, Math.sqrt(0.5)),
	 new Vector(0.5,0.21,0)));
	 assertEquals("Wrong number of points", 1, result.size());
	 assertEquals("Ray crosses sphere", List.of(p1), result);;
	 // TC12: Ray starts at sphere and goes outside (0 points)
	 assertNull("Ray's line goes outside the sphere",
	 sphere.findIntsersections(new Ray(new Point3D(0.5, 0.5, Math.sqrt(0.5)),
			 new Vector(-3.68,0.74,-0.71))));
	 // **** Group: Ray's line goes through the center
	 // TC13: Ray starts before the sphere (2 points)
	 p2 = new Point3D(1.6666666666666667,0.6666666666666667,0.33333333333333337);
	 p1 = new Point3D(0.3333333333333335, -0.6666666666666665,-0.33333333333333326);
	 result = sphere.findIntsersections(new Ray(new Point3D(3,2,1),
	 new Vector(-2,-2,-1)));
	 assertEquals("Wrong number of points", 2, result.size());
	 if (result.get(0).getX() > result.get(1).getX())
	 result = List.of(result.get(1), result.get(0));
	 assertEquals("Ray crosses sphere", List.of(p1, p2), result);;
	 // TC14: Ray starts at sphere and goes inside (1 points)
	 p1 = new Point3D(1.2672612419124243,0.2672612419124244,-0.9258200997725514);
	 result = sphere.findIntsersections(new Ray(new Point3D(0.75, -0.25, Math.sqrt(0.75)),
	 new Vector(0.25,0.25,-Math.sqrt(0.75))));
	 assertEquals("Wrong number of points", 1, result.size());
	 assertEquals("Ray crosses sphere", List.of(p1), result);;
	 // TC15: Ray starts inside (1 points)
	 p1 = new Point3D(0.6518446880886042,-0.34815531191139576,-0.8703882797784892);
	 result = sphere.findIntsersections(new Ray(new Point3D(1.2,0.2,0.5),
	 new Vector(-0.2,-0.2,-0.5)));
	 assertEquals("Wrong number of points", 1, result.size());
	 assertEquals("Ray crosses sphere", List.of(p1), result);;
	 // TC16: Ray starts at the center (1 points)
	 p1 = new Point3D(1.4082482904638631,0.8164965809277261,0.4082482904638631);
	 result = sphere.findIntsersections(new Ray(new Point3D(1,0,0),
	 new Vector(1,2,1)));
	 assertEquals("Wrong number of points", 1, result.size());
	 assertEquals("Ray crosses sphere", List.of(p1), result);;
	 // TC17: Ray starts at sphere and goes outside (0 points)
	 assertNull("Ray's line starts at sphere and goes outside",
	 sphere.findIntsersections(new Ray(new Point3D(1,Math.sqrt(0.5),-Math.sqrt(0.5)),
			 new Vector(0,0.68,-0.68))));
	 // TC18: Ray starts after sphere (0 points)
	 assertNull("Ray's line starts after the sphere",
	 sphere.findIntsersections(new Ray(new Point3D(2,3,0),
			 new Vector(0.45,1.34,0))));
	 // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
	 // TC19: Ray starts before the tangent point
	 assertNull("Ray's line starts before the tangent point",
	 sphere.findIntsersections(new Ray(new Point3D(1,1,3.6),
			 new Vector(0,0,-3.6))));
	 // TC20: Ray starts at the tangent point
	 assertNull("Ray's line starts at the tangent point",
	 sphere.findIntsersections(new Ray(new Point3D(1,1,0),
			 new Vector(0,0,2.5))));
	 // TC21: Ray starts after the tangent point
	 assertNull("Ray's line starts after the tangent point",
	 sphere.findIntsersections(new Ray(new Point3D(1,1,2.2),
			 new Vector(0,0,1.4))));
	 // **** Group: Special cases
	 // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
	 assertNull("Ray's line starts after the sphere",
	 sphere.findIntsersections(new Ray(new Point3D(1.3,2,1.5),
			 new Vector(-1.5,0,0.3))));
	 }
}
