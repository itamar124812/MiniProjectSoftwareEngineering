/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import static primitives.Util.isZero;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import geometries.Triangle;
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
	/**
	 * Test method for {@link geometries.Triangle#testFindIntersections(primitives.Point3D,primitives.Point3D,primitives.Point3D)}.
	 */
	 @Test
	 public void testFindIntersections() {
		 Triangle triangle=new Triangle(new Point3D(-1,0,0),new Point3D(0,0,5),new Point3D(0,4,5));
	    	List<Point3D> result=new ArrayList<Point3D>();
	    	// ============ Equivalence Partitions Tests ==============
	    	// TC01: Ray-Triangle intersection inside triangle (1 point)
	    	Point3D p = new Point3D(-0.14,2.46,4.3);
	   	    result = triangle.findIntersections(new Ray(new Point3D(-2.5, 4, 5),
	   	    		 new Vector(2.36,-1.54,-0.7)));
	   			 assertEquals("Wrong number of points", 1, result.size());
	   			 assertEquals("Ray crosses tringle", List.of(p), result);;
	    	// TC02: Ray-Triangle intersection outside against edge (0 point)
	   			assertNull("Intersection outside against edge",
	   					triangle.findIntersections(new Ray(new Point3D(-4,5,4.3), 
	   						new Vector(4.11,0.04,1.17))));//(4.14,-5.79,1.3)(4.11,0.04,1.17)
	    	 //TC03: Ray-Triangle intersection outside against vertex (0 point)
	   			assertNull("Intersection outside against vertex",
	   					triangle.findIntersections(new Ray(new Point3D(-4,5,4.3), 
	   							new Vector(4.17,-3.27,1.43))));
	        // =============== Boundary Values Tests ==================
	    	// TC01: Ray-Triangle intersection on edge (0 point)
	   			assertNull("Intersection on edge",
	   					triangle.findIntersections(new Ray(new Point3D(4,5.2,-3), 
	   							new Vector(-4,-5.2,8))));
	    	//TC02: Ray-Triangle intersection in vertex (0 point)
	   			assertNull("Intersection on edge",
	   					triangle.findIntersections(new Ray(new Point3D(4,5.2,-3), 
	   					new Vector(-4,-3.83,8))));
	    	//TC03: Ray-Triangle intersection on edge's continuation (0 point)
	   			assertNull("Intersection on edge continuation",
	   					triangle.findIntersections(new Ray(new Point3D(4,5.2,-3), 
	   							new Vector(-3.8,-0.38,9.02))));
	 }
}
