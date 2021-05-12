package unittests;

import primitives.*;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
	private int CalculateNumIntersection(Camera camera,Intersectable intersectable,int Nx, int Ny) {
		int count=0;
		List<Point3D> temp;
      for(int i=0;	i<Nx;	i++)
    	  for(int j=0;	j<Ny; j++) {
    		  temp= intersectable.findIntersections(camera.constructRayThroughPixel(Nx, Ny, i, j));
    		  if(temp!=null)
    			  count+=temp.size();    
    		  }
      		return count;
	}
	/**
	 * Test method for
	 * {@link elements.Camera#constructRayThroughPixel(int, int, int, int)}.
	 */
	@Test
	public void testConstructRayThroughPixelWithSphere() {
		// TC01: The sphere cut only by the center point of the view plane
		Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, -1),
				new Vector(1, 0, 0)).setDistance(1).setViewPlaneSize(3, 3);
		 Sphere sphere = new Sphere(new Point3D(0, 0, -3),1d);
		 assertEquals("Wrong number of points", 2, CalculateNumIntersection(camera,sphere,3, 3));
			// TC02: The sphere cut by all the center points of the view plane
		  camera = new Camera(new Point3D(0,0,0.5), new Vector(0, 0, -1), 
				  new Vector(1, 0, 0)).setDistance(1).setViewPlaneSize(3, 3);
		  sphere = new Sphere(new Point3D(0,0,-2.5),2.5d);
		 assertEquals("Wrong number of points", 18, CalculateNumIntersection(camera,sphere,3, 3));
			// TC03: The sphere cut by all the center points of the view plane except the corners
		 camera = new Camera(new Point3D(0,0,0.5), new Vector(0, 0, -1), 
				 new Vector(0, 1, 0)).setDistance(1).setViewPlaneSize(3, 3);
		  sphere = new Sphere(new Point3D(0,0,-2),2d);
		 assertEquals("Wrong number of points", 10, CalculateNumIntersection(camera,sphere,3, 3));
			// TC04: The view plane is inside The sphere
		 camera = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0))
				 .setDistance(1).setViewPlaneSize(3, 3);
		  sphere = new Sphere(new Point3D(0, 0, -0.5),4d);
		 assertEquals("Wrong number of points", 9, CalculateNumIntersection(camera,sphere,3, 3));
			// TC05: The sphere behind the view plane
		 camera = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0))
				 .setDistance(1).setViewPlaneSize(3, 3);
		  sphere = new Sphere(new Point3D(0,0,1),0.5d);
		 assertEquals("Wrong number of points", 0, CalculateNumIntersection(camera,sphere,3, 3));
	}
	
	/**
	 * Test method for
	 * {@link elements.Camera#constructRayThroughPixel(int, int, int, int)}.
	 */
	@Test
	public void testConstructRayThroughPixelWithPlane() {
		// TC01: The plane standing in front of the ray
		Camera camera = new Camera(new Point3D(0,0,-0.5), new Vector(0, 0, -1),
				new Vector(0, 1, 0)).setDistance(1).setViewPlaneSize(3, 3);
		Plane plane = new Plane(new Point3D(0,0,-2),new Vector(0,0,-1));
		assertEquals("Wrong number of points", 9, CalculateNumIntersection(camera,plane,3, 3));
		// TC02: The plane standing diagonally to the ray and hitting all the view plane
		camera = new Camera(new Point3D(0,0,0.5), 
				new Vector(0, 0, -1), 
			 new Vector(0, 1, 0)).setDistance(1).setViewPlaneSize(3, 3);
		plane = new Plane(new Point3D(3.5,2,2),new Vector(-1.5,0,0));
		assertEquals("Wrong number of points", 9, CalculateNumIntersection(camera,plane,3, 3));
			// TC03: The plane standing diagonally to the ray and hitting 6 rays from the view plane
		camera = new Camera(new Point3D(0,0,0.5), new Vector(0, 0, -1), 
			 new Vector(0, 1, 0)).setDistance(1).setViewPlaneSize(3, 3);
		plane = new Plane(new Point3D(3.5,2,2),new Vector(-1.5,0,0));
		assertEquals("Wrong number of points", 6, CalculateNumIntersection(camera,plane,3, 3));
	}
	
	/**
	 * Test method for
	 * {@link elements.Camera#constructRayThroughPixel(int, int, int, int)}.
	 */
	@Test
	public void testConstructRayThroughPixelWithTriangle() {
		// TC01: The triangle cut only by the center point of the view plane
		Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, -1), 
				new Vector(0,1, 0)).setDistance(1).setViewPlaneSize(3, 3);
		Triangle triangle=new Triangle(new Point3D(0, 1, -2),new Point3D(-1, -1, -2),new Point3D(1, -1, -2));	
		assertEquals("Wrong number of points", 1, CalculateNumIntersection(camera,triangle,3, 3));
			// TC02: The triangle cut by two points of the view plane
		camera = new Camera(Point3D.ZERO, new Vector(0, 0, -1), 
				new Vector(0, 1, 0)).setDistance(1).setViewPlaneSize(3, 3);
		   triangle=new Triangle(new Point3D(0, 20, -2),new Point3D(-1, -1, -2),new Point3D(1, -1, -2));
		 assertEquals("Wrong number of points", 2, CalculateNumIntersection(camera,triangle,3, 3));

	}
	
}
