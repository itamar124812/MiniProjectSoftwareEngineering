	/**
	 * 
	 */
	package unittests;

	import static org.junit.Assert.*;
	import geometries.Cylinder;
	import org.junit.Test;
	import primitives.*;


	/**
	 * @author User
	 *
	 */
	public class CylinderTests {

		/**
		 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
		 */
		@Test
		public void testGetNormal() {
			Point3D pP0=new Point3D(0,0,2);
			Vector vDir=new Vector(0,0,4);
			Ray rVal=new Ray(pP0,vDir);
			Cylinder cTest=new Cylinder(rVal,3,4);
			assertEquals(new Vector(0,1,0),cTest.getNormal(new Point3D(0,2,2)));	
		}

	}
