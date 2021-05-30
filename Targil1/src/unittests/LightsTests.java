package unittests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

/**
 * Test rendering a basic image
 * 
 * @author Dan
 */
public class LightsTests {
	private Scene scene1 = new Scene("Test scene");
	private Scene scene2 = new Scene("Test scene") //
			.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));
	private Camera camera1 = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setViewPlaneSize(150, 150) //
			.setDistance(1000);
	private Camera camera2 = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
			.setViewPlaneSize(200, 200) //
			.setDistance(1000);

	private static Geometry triangle1 = new Triangle( //
			new Point3D(-150, -150, -150), new Point3D(150, -150, -150), new Point3D(75, 75, -150));
	private static Geometry triangle2 = new Triangle( //
			new Point3D(-150, -150, -150), new Point3D(-70, 70, -50), new Point3D(75, 75, -150));
	private static Geometry sphere = new Sphere(new Point3D(0, 0, -50), 50) //
			.setEmmission(new Color(java.awt.Color.BLUE)) //
			.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(100));

	/**
	 * Produce a picture of a sphere lighted by a directional light
	 */
	@Test
	public void sphereDirectional() {
		scene1.geometries.add(sphere);
		scene1.lights.add(new DirectionalLight(new Color(500, 300, 0), new Vector(1, 1, -1)));

		ImageWriter imageWriter = new ImageWriter("lightSphereDirectional", 500, 500);
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera1) //
				.setRayTracerBasic(new RayTracerBasic(scene1));
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a sphere lighted by a point light
	 */
	@Test
	public void spherePoint() {
		scene1.geometries.add(sphere);
		scene1.lights.add(new PointLight(new Color(500, 300, 0), new Point3D(-50, -50, 50))//
				.setkL(0.00001).setkQ(0.000001));

		ImageWriter imageWriter = new ImageWriter("lightSpherePoint", 500, 500);
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera1) //
				.setRayTracerBasic(new RayTracerBasic(scene1));
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a sphere lighted by a spot light
	 */
	@Test
	public void sphereSpot() {
		scene1.geometries.add(sphere);
		scene1.lights.add(new SpotLight(new Color(500, 300, 0), new Point3D(-50, -50, 50), new Vector(1, 1, -2)) //
				.setkL(0.00001).setkQ(0.00000001));

		ImageWriter imageWriter = new ImageWriter("lightSphereSpot", 500, 500);
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera1) //
				.setRayTracerBasic(new RayTracerBasic(scene1));
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a two triangles lighted by a directional light
	 */
	@Test
	public void trianglesDirectional() {
		scene2.geometries.add(new ArrayList<Intersectable>(List.of( triangle1.setMaterial(new Material().setkD(0.8).setks(0.2).setnShininess(300)), //
				triangle2.setMaterial(new Material().setkD(0.8).setks(0.2).setnShininess(300)))));
		scene2.lights.add(new DirectionalLight(new Color(300, 150, 150), new Vector(0, 0, -1)));
        
		ImageWriter imageWriter = new ImageWriter("lightTrianglesDirectional", 500, 500);
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera2) //
				.setRayTracerBasic(new RayTracerBasic(scene2));
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a two triangles lighted by a point light
	 */
	@Test
	public void trianglesPoint() {
		scene2.geometries.add(new ArrayList<Intersectable>(List.of( triangle1.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(300)), //
				triangle2.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(300)))));
		scene2.lights.add(new PointLight(new Color(500, 250, 250), new Point3D(10, -10, -130)) //
				.setkL(0.0005).setkQ(0.0005));

		ImageWriter imageWriter = new ImageWriter("lightTrianglesPoint", 500, 500);
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera2) //
				.setRayTracerBasic(new RayTracerBasic(scene2));
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a two triangles lighted by a spot light
	 */
	@Test
	public void trianglesSpot() {
		scene2.geometries.add(new ArrayList<Intersectable>(List.of( triangle1.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(300)),
				triangle2.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(300)))));
		scene2.lights.add(new SpotLight(new Color(500, 250, 250), new Point3D(10, -10, -130), new Vector(-2, -2, -1)) //
				.setkL(0.0001).setkQ(0.000005));
		
		ImageWriter imageWriter = new ImageWriter("lightTrianglesSpot", 500, 500);
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera2) //
				.setRayTracerBasic(new RayTracerBasic(scene2));
		render.renderImage();
		render.writeToImage();
	}
		/**
	 * Produce a picture of a two triangles lighted by a spot light
	 */
	@Test
	public void AllLightes() {
		scene2.geometries.add(new ArrayList<Intersectable>(List.of( triangle1.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(300)),
				triangle2.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(300)))));
		scene2.lights.add(new SpotLight(new Color(500, 250, 250), new Point3D(10, -10, -130), new Vector(-2, -2, -1)) //
				.setkL(0.0001).setkQ(0.000005));
				scene2.lights.add(new PointLight(new Color(255, 255, 0), new Point3D(10, -10, -130)) //
				.setkL(0.0005).setkQ(0.0005));
				scene2.lights.add(new DirectionalLight(new Color(184,134,11), new Vector(0, 0, -1)));
		ImageWriter imageWriter = new ImageWriter("lightTrianglesAllLights", 500, 500);
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera2) //
				.setRayTracerBasic(new RayTracerBasic(scene2));
		render.renderImage();
		render.writeToImage();
	}
	@Test 
	public void func()
	{//new Cylinder(new Ray(new Point3D(-75d/2, 25,-150), new Vector(0, 1, 0)), 10, 1).setEmmission(new Color(255,128,0))
		Scene scene3=new Scene("TestScene");
		scene3.geometries.add(new ArrayList<Intersectable> (List.of(new Polygon(new Point3D(75,-150,-150),new Point3D(45,-150,-150),new Point3D(45, 0, -150),new Point3D(75, 0, -150)).setEmmission(new Color(139,69,19)),new Polygon(new Point3D(45, -50, -150),new Point3D(15, -50, -150),new Point3D(15, 0, -150),new Point3D(45, 0, -150)).setEmmission(new Color(139,69,19)),new Polygon(new Point3D(15, -150, -150),new Point3D(15,0,-150),new Point3D(-75,0,-150),new Point3D(-75,-150,-150)).setEmmission(new Color(139,69,19)),new Triangle(new Point3D(75, 0, -150),new Point3D(-75, 0, -150),new Point3D(0, 50, -150)).setEmmission(new Color(java.awt.Color.red)).setMaterial(new Material().setkD(0.01).setks(0.01).setnShininess(800))
		,new Sphere(new Point3D(-90, 100, -300), 20).setEmmission(new Color(java.awt.Color.yellow)),new Polygon(new Point3D(45,-150,-150),new Point3D(15, -150, -150),new Point3D(15, -50, -150),new Point3D(45, -50, -150)).setEmmission(new Color(255,255,102)) 	)	));
		for(int i=100;i>76;i-=1)
		{
            scene3.geometries.add(new Triangle(new Point3D(i,-150 , -150),new Point3D(i-20, -150, -150),new Point3D(i-10, -130, -150)).setEmmission(new Color(0,204,0)).setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(100)));
		}
		scene3.lights.add(new DirectionalLight(new Color(255, 255, 255), new Vector(0, 0, -1)));
		//scene3.lights.add(new PointLight(new Color(500, 250, 250), new Point3D(75,60,-100)));

		scene3.setbackground(new Color(java.awt.Color.CYAN));
		ImageWriter imageWriter = new ImageWriter("HBS", 500, 500);//java.awt.Color.CYAN
		Render render = new Render()//
				.setImageWriter(imageWriter) //
				.setCamera(camera2) //
				.setRayTracerBasic(new RayTracerBasic(scene3));
		render.renderImage();
		render.writeToImage();
		camera2.rotateCamera(new Vector(1,0,0),Math.toRadians(45));//.moveCamara(new Point3D(0,0,-1000))
		scene3.setbackground(new Color(java.awt.Color.CYAN));
		ImageWriter imageWriter1 = new ImageWriter("HB", 500, 500);//java.awt.Color.CYAN
		Render render1 = new Render()//
				.setImageWriter(imageWriter1) //
				.setCamera(camera2) //
				.setRayTracerBasic(new RayTracerBasic(scene3));
		render1.renderImage();
		render1.writeToImage();
	}


}
