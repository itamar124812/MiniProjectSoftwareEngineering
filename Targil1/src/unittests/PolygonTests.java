/**
 * 
 */
package unittests;

import static org.junit.Assert.*;
import org.junit.Test;

import geometries.*;
import primitives.*;

/**
 * Testing Polygons
 * 
 * @author Dan
 *
 */
public class PolygonTests {

    /* bn* 
     * Test method for
     * {@link geometries.Polygon#Polygon(primitives.Point3D, primitives.Point3D, primitives.Point3D, primitives.Point3D)}.
     */
    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct concave quadrangular with vertices in correct order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(-1, 1, 1));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        }

        // TC02: Wrong vertices order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(0, 1, 0),
                    new Point3D(1, 0, 0), new Point3D(-1, 1, 1));
            fail("Constructed a polygon with wrong order of vertices");
        } catch (IllegalArgumentException e) {}

        // TC03: Not in the same plane
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 2, 2));
            fail("Constructed a polygon with vertices that are not in the same plane");
        } catch (IllegalArgumentException e) {}

        // TC04: Concave quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0.5, 0.25, 0.5));
            fail("Constructed a concave polygon");
        } catch (IllegalArgumentException e) {}

        // =============== Boundary Values Tests ==================

        // TC10: Vertex on a side of a quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0.5, 0.5));
            fail("Constructed a polygon with vertix on a side");
        } catch (IllegalArgumentException e) {}

        // TC11: Last point = first point
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0, 1));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

        // TC12: Colocated points
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 1, 0));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

    }
    /**
     * Test method for {@link geometries.Polygon#findIntersections(Ray ray)}.
     */
    @Test
    public void testFindIntsersections() 
    {
    	Polygon p=new Polygon(new Point3D(-1,0,0),new Point3D(0,0,5),new Point3D(0,4,5),new Point3D(-1,4,0) );
    	Ray ray;
    	 // ============ Equivalence Partitions Tests ==============
         // TC01: The ray is outside the polygon
   	     ray =new Ray(new Point3D(0,6,0),new Vector(0,-1,0));  	 
    	 assertNull(p.findIntersections(ray));
         // TC02: The ray intersect the polygon(one point)
    	 ray =new Ray(new Point3D(1,1,-1),new Vector(-8,1,10));
    	 assertTrue(p.findIntersections(ray).size()==1&& new Point3D(-0.76,1.22,1.2).equals( p.findIntersections(ray).get(0)));
    	 // =============== Boundary Values Tests ==================
    	 //TC03: The ray is edge of the Polygon(null requirement)
    	 ray =new Ray(new Point3D(0,-1,5),new Vector(0,1,0));
    	 assertNull(p.findIntersections(ray));
    	//TC04: The ray intersect one of the vertices(null requirement)
    	 ray =new Ray(new Point3D(-1,0,5),new Vector(1,0,0));
    	 assertNull(p.findIntersections(ray));
    	 //TC05: p0 is one of the vertices(null)
    	 ray =new Ray(new Point3D(0,0,5),new Vector(1,0,0));
    	 assertNull(p.findIntersections(ray)); 
    	 //TC06:The ray is normal for the Polygon p0 before the polygon(one point)
    	 ray =new Ray(new Point3D(1,2,3),new Vector(-5,0,1));
    	 assertTrue(p.findIntersections(ray).size()==1&& new Point3D(-0.3461538461538,2,3.269230769231).equals( p.findIntersections(ray).get(0)));
    	 //TC07:The polygon is include the ray p0 before the polygon(null requirement)
    	 ray =new Ray(new Point3D(-0.5,-1,2.5),new Vector(0,1,0));
    	 assertNull(p.findIntersections(ray));
    	 //TC08:The polygon is include the ray p0 on the polygon(null requirement)
    	 ray =new Ray(new Point3D(-0.5,2,2.5),new Vector(0,1,0));
    	 assertNull(p.findIntersections(ray));
    	 //TC09:p0 on the polygon(null requirement)
    	 ray =new Ray(new Point3D(-0.5,2,2.5),new Vector(1,1,1));
    	 assertNull(p.findIntersections(ray));
    	 //TC10: The ray intersect one of the edges(null requirement)
    	 ray =new Ray(new Point3D(-1.5,4,2.5),new Vector(1,0,0));
    	 assertNull(p.findIntersections(ray));  	 
    	 }

    /**
     * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0),
                new Point3D(-1, 1, 1));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to trinagle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }
    

}



