/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import geometries.Sphere;
import org.junit.Test;
import primitives.*;

/**
 * @author User
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
        // TC01: 
		assertEquals(new Vector(0.6,-Math.sqrt(8)/5,-Math.sqrt(8)/5),sTest.getNormal(new Point3D(0,Math.sqrt(8),Math.sqrt(8))));
	}

}
