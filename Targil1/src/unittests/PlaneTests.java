/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import static primitives.Util.isZero;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
/**
 * @author Raz Shely && Itamar Cohen 
 *
 */
public class PlaneTests {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	/**
	 * Test method for {@link geometries.Plane#Plane(primitives.Point3D,primitives.Point3D,primitives.Point3D)}.
	 */
	@Test(expected =IllegalArgumentException.class)
	public void testPlanePoint3DPoint3DPoint3D() {
		Point3D p1=new Point3D(1,2,3);
		Point3D p2=new Point3D(2,4,6);
		Point3D p3=new Point3D(3,6,9);
		Plane testPlane =new Plane(p1,p2,p3);		
		exceptionRule.expect(IllegalArgumentException.class);
		Plane TestPlane =new Plane(p1,p1,p3);
		exceptionRule.expect(IllegalArgumentException.class);
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormalPoint3D() {
		Point3D p1=new Point3D(1,2,3);
		Point3D p2=new Point3D(2,4,6);
		Point3D p3=new Point3D(-1,-1,1);	
		Plane p=new Plane(p1,p2,p3);
        // ============ Equivalence Partitions Tests ==============
		//Check that the Length of the normal equals to 1
		assertEquals(isZero(p.getNormal().length()-1),true);
		//Check the the normal of some plane
		assertEquals(p.getNormal(),new Vector(5,-4,1).normalize());
	}
	/**
     * Test method for {@link geometries.Plane#findIntersections(Ray ray)}.
     */
    @Test
    public void testFindIntsersections() 
    {
    	// ============ Equivalence Partitions Tests ==============
    	// TC01: Ray's line is inside the Plane (1 point)
    	Point3D p0=new Point3D(1,1,1);
    	Point3D exeptedPoint=new Point3D(6,0,0);
    	List<Point3D> result=new ArrayList<Point3D>();
		result.add(exeptedPoint);
    	Vector v0=new Vector(1,2,3);
    	Vector dir=new Vector(1,0,0);
    	Plane p=new Plane(p0,v0);
    	Ray ray=new Ray(Point3D.ZERO,dir);
    	assertArrayEquals(result.toArray(),p.findIntersections(ray).toArray());
    	result.clear();
    	// TC02: Ray's line is outside the Plane (0 point)
    	ray=new Ray(Point3D.ZERO,v0.scale(-1));
    	assertNull(p.findIntersections(ray));
        // =============== Boundary Values Tests ==================
    	// TC01: Ray's line is include && parallel  the Plane (null)
    	ray=new Ray(p0,new Vector(5,-1,-1));
    	assertNull(p.findIntersections(ray));
    	//TC02: Ray's line is parallel the Plane but not include (null)
    	ray=new Ray(new Point3D(2,2,2),new Vector(5,-1,-1));
    	assertNull(p.findIntersections(ray));
    	//TC03:Ray is orthogonal to the plane p0 before the plane(one point)
        ray=new Ray(new Point3D(0,0,0),v0);
        exeptedPoint=new Point3D(0.428571428571429, 0.857142857142857, 1.285714285714286);
        assertTrue(p.findIntersections(ray).size()==1 &&exeptedPoint.equals(p.findIntersections(ray).get(0)));
        //TC04:Ray is orthogonal to the plane p0 in the plane(null requirement)
        ray=new Ray(new Point3D(1,1,1),v0);
        assertNull(p.findIntersections(ray));
        //TC05:Ray is orthogonal to the plane p0 after the plane(null)
        ray=new Ray(new Point3D(2,2,2),v0);
        assertNull(p.findIntersections(ray));
        //TC06: only p0 in the plane(null requirement)
        ray=new Ray(new Point3D(6,0,0),dir);
        assertNull(p.findIntersections(ray));
        //TC07: p0=q0(null requirement)
        ray=new Ray(new Point3D(1,1,1),dir);
        assertNull(p.findIntersections(ray));
    }
}
