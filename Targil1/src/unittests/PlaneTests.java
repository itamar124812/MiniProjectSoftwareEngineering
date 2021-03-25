/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;
import geometries.Plane;
import primitives.Point3D;
import primitives.Vector;
/**
 * @author USER
 *
 */
public class PlaneTests {

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormalPoint3D() {
		Point3D p1=new Point3D(1,2,3);
		Point3D p2=new Point3D(2,4,6);
		Point3D p3=new Point3D(-1,-1,1);
		Plane p=new Plane(p1,p2,p3);
		assertEquals(p.getNormal().length()==1||p.getNormal().length()==-1,true);
		assertEquals(p.getNormal(),new Vector(5,-4,1));
	}

}
