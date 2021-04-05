/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import static primitives.Util.isZero;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Vector;

/**
 * Testing Triangles
 * 
 * @author Itamar and Raz
 *
 */
public class TriangleTest {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Point3D p1=new Point3D(1,2,3);
		Point3D p2=new Point3D(2,4,6);
		Point3D p3=new Point3D(-1,-1,1);
		Plane p=new Plane(p1,p2,p3);
		 // TC01:Check that the Length of the normal equals to 1
		assertEquals(isZero(p.getNormal().length()-1),true);
		// TC02:Check the the normal of Triangle
		assertEquals(p.getNormal(),new Vector(5,-4,1).normalize());
	}

}
