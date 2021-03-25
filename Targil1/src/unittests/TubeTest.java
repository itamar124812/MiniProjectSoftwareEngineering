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
 * @author USER
 *
 */
public class TubeTest {

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
	 */ 
	@Test
	public void testGetNormal() {
		Point3D p=new Point3D(0,0,0);
		Vector v=new Vector(0,0,1);
		Ray r=new Ray(p,v);
		Tube t= new Tube(r,1);
		assertEquals(t, 0);
	}

}
