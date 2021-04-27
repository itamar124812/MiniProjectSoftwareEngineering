package unittests;

import primitives.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.Camera;
import geometries.*;

/**
 * Testing View Plane intresection
 * 
 * @author Itamar and Raz
 *
 */
public class ViewPlaneTests {
	/**
	 * Test method for
	 * {@link }.
	 */
	@Test
	public void testConstructRayThroughPixel() {
		Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0))
				.setDistance(10);


	}
	
}
