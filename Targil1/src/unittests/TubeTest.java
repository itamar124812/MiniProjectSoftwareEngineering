/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;
import primitives.Ray;
import primitives.Vector;
import primitives.Point3D;
import geometries.Tube;

/**
 * Testing Tubes
 * 
 * @author Itamar and Raz
 *
 */
public class TubeTest {
	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
	 */ 
	@Test
	public void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Point3D p=new Point3D(0,0,0);
		Vector v=new Vector(0,0,1);
		Ray r=new Ray(p,v);
		Tube t= new Tube(r,3);
		Point3D check1=new Point3D(0,3,1);
		 // TC01:test equilibrium class at a particular point in the Infinite Tube
		assertEquals(new Vector(0,1,0),t.getNormal(check1));
		// =============== Boundary Values Tests ==================
		Point3D check2=new Point3D(3,0,0);
		 // TC11: test the point is in front of the head of the foundation
		assertEquals(new Vector(1,0,0),t.getNormal(check2));
	}
	/**
	 * Test method for {@link geometries.Tube#findIntersections(primitives.Point3D)}.
	 */ 
	@Test
	public void testFindIntersersections() {
		
	}
}
