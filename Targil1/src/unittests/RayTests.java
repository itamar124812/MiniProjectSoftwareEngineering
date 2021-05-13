package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import geometries.Intersectable;
import geometries.Triangle;
import geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class RayTests {
	
	@Test
	public void testfindClosestPoint() {
		Ray ray=new Ray(new Point3D(0,0,0),new Vector(1,0,0));
		
		 // ============ Equivalence Partitions Tests ==============
		 // TC01: The center point in the list is closest
		List<Point3D> list=new ArrayList<Point3D>(List.of(new Point3D(20,0,0),
				new Point3D(12,0,0),new Point3D(0,6,0),new Point3D(50,20,0),new Point3D(30,0,2)));
   	 	assertEquals("the center point is closest", new Point3D(0,6,0), ray.findClosestPoint(list));
   	 	
		 // =============== Boundary Values Tests ==================
		 // TC11: The list not contain points
   	 assertNull("the list not contain points",ray.findClosestPoint(null));
   	 
   	 	// TC12: The first point in the list is closest
   	    list=new ArrayList<Point3D>(List.of(new Point3D(0,6,0),new Point3D(20,0,0),
			new Point3D(12,0,0),new Point3D(50,20,0),new Point3D(30,0,2)));
	 	assertEquals("the first point is closest", new Point3D(0,6,0), ray.findClosestPoint(list));   	 
   	 	// TC13: The last point in the list is closest
		list=new ArrayList<Point3D>(List.of(new Point3D(20,0,0),
				new Point3D(12,0,0),new Point3D(50,20,0),new Point3D(30,0,2),new Point3D(0,6,0)));
   	 	assertEquals("the last point is closest", new Point3D(0,6,0), ray.findClosestPoint(list));	}
}