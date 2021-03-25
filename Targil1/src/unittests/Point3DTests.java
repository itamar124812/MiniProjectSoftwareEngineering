/**
 * 
 */
package unittests;

import static java.lang.System.out;
import static org.junit.Assert.*;
import primitives.*;
import org.junit.Test;


/**
 * @author User
 *
 */
public class Point3DTests {
	/**
	 * Test method for {@link primitives.Point3D#subtract(primitives.Point3D)}.
	 */
	@Test
	public void testSubtract() {
		 // ============ Equivalence Partitions Tests ==============
		Point3D p1 = new Point3D(1, 2, 3); 
	     // TC01: Checking a subtraction operation between 2 normal points
		assertEquals(new Vector(1, 1, 1),(new Point3D(2, 3, 4).subtract(p1)));
	}

	/**
	 * Test method for {@link primitives.Point3D#add(primitives.Vector)}.
	 */
	@Test
	public void testAdd() {
		 // ============ Equivalence Partitions Tests ==============
		Point3D p1 = new Point3D(1, 2, 3); 
	       // TC01: Checking an insert operation between 2 standard points
		assertEquals(Point3D.ZERO,(p1.add(new Vector(-1, -2, -3))));
	}

	/**
	 * Test method for {@link primitives.Point3D#distanceSquared(primitives.Point3D)}.
	 */
	@Test
	public void testDistanceSquared() {
		 // ============ Equivalence Partitions Tests ==============
		Point3D p1=new Point3D(5,4,2);
		Point3D p2=new Point3D(3,3,3);
        // TC01: Distance squared between 2 regular points
		assertEquals("Bad distance",6, p1.distanceSquared(p2), 0.001);
        // =============== Boundary Values Tests ==================
        // TC02: Checking the distance squared between the point itself
		assertEquals("Bad distance",0,p1.distance(p1), 0.001);
	}

	/**
	 * Test method for {@link primitives.Point3D#distance(primitives.Point3D)}.
	 */
	@Test
	public void testDistance() {
		 // ============ Equivalence Partitions Tests ==============
		Point3D p1=new Point3D(5,4,2);
		Point3D p2=new Point3D(3,3,0);
        // TC01: Distance between 2 regular points
		assertEquals("Bad distance",3,p1.distance(p2), 0.001);	
		assertEquals("Bad distance",5,new Point3D(3,0,0).distance(new Point3D(0,4,0)), 0.001);

        // =============== Boundary Values Tests ==================
        // TC02: Checking the distance between the point itself
		assertEquals("Bad distance",0,p1.distance(p1), 0.001);
		//assertThrows("failure text", IllegalArgumentException.class, () -> p1.distance(p2));
	}
	
}
