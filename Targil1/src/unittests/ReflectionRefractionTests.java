package unittests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.*;
import geometries.Intersectable; 
import geometries.Polygon;
import geometries.Sphere;
import geometries.Triangle;
import primitives.*;
import renderer.*;
import scene.Scene;

/**
 * @author User
 Tests for reflection and transparency functionality, test for partial shadows
 * (with transparency)
 * 
 */
public class ReflectionRefractionTests {
	private Scene scene = new Scene("Test scene");

	/**
	 * Produce a picture of a sphere lighted by a spot light
	 */
	@Test
	public void twoSpheres() {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);

		scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Sphere(new Point3D(0, 0, -50),50) //
						.setEmmission(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.4).setks(0.3).setnShininess(100).setKt(0.3)),
				new Sphere(new Point3D(0, 0, -50),25) //
						.setEmmission(new Color(java.awt.Color.RED)) //
						.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(100)))));
		scene.lights.add( //
				new SpotLight(new Color(1000, 600, 0), new Point3D(-100, -100, 500), new Vector(-1, -1, -2)) //
						.setkL(0.0004).setkQ(0.0000006));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("refractionTwoSpheres", 500, 500)) //
				.setCamera(camera) //
				.setRayTracerBasic(new RayTracerBasic(scene)).setMultithreading(4).setDebugPrint();
		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a sphere lighted by a spot light
	 */
	@Test
	public void twoSpheresOnMirrors() {
		Camera camera = new Camera(new Point3D(0, 0, 10000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(10000); //

		scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

		scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Sphere(new Point3D(-950, -900, -1000),400) //
						.setEmmission(new Color(0, 0, 100)) //
						.setMaterial(new Material().setkD(0.25).setks(0.25).setnShininess(20).setKt(0.5)),
				new Sphere(new Point3D(-950, -900, -1000),200) //
						.setEmmission(new Color(100, 20, 20)) //
						.setMaterial(new Material().setkD(0.25).setks(0.25).setnShininess(20)),
				new Triangle(new Point3D(1500, -1500, -1500), new Point3D(-1500, 1500, -1500),
						new Point3D(670, 670, 3000)) //
								.setEmmission(new Color(20, 20, 20)) //
								.setMaterial(new Material().setKr(1)),
				new Triangle(new Point3D(1500, -1500, -1500), new Point3D(-1500, 1500, -1500),
						new Point3D(-1500, -1500, -2000)) //
								.setEmmission(new Color(20, 20, 20)) //
								.setMaterial(new Material().setKr(0.5)))));

		scene.lights.add(new SpotLight(new Color(1020, 400, 400), new Point3D(-750, -750, -150), new Vector(-1, -1, -4)) //
				.setkL(0.00001).setkQ(0.000005));

		ImageWriter imageWriter = new ImageWriter("reflectionTwoSpheresMirrored", 500, 500);
		Render render = new Render() //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracerBasic(new RayTracerBasic(scene));

		render.renderImage();
		render.writeToImage();
	}

	/**
	 * Produce a picture of a two triangles lighted by a spot light with a partially
	 * transparent Sphere producing partial shadow
	 */
	@Test
	public void trianglesTransparentSphere() {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(200, 200).setDistance(1000);

		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

		scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Triangle(new Point3D(-150, -150, -115), new Point3D(150, -150, -135), new Point3D(75, 75, -150)) //
						.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(60)), //
				new Triangle(new Point3D(-150, -150, -115), new Point3D(-70, 70, -140), new Point3D(75, 75, -150)) //
						.setMaterial(new Material().setkD(0.5).setks(0.5).setnShininess(60)), //
				new Sphere(new Point3D(60, 50, -50),30) //
						.setEmmission(new Color(java.awt.Color.BLUE)) //
						.setMaterial(new Material().setkD(0.2).setks(0.2).setnShininess(30).setKt(0.6)))));

		scene.lights.add(new SpotLight(new Color(700, 400, 400), new Point3D(60, 50, 0), new Vector(0, 0, -1)) //
				.setkL(4E-5).setkQ(2E-7));

		ImageWriter imageWriter = new ImageWriter("refractionShadow", 600, 600);
		Render render = new Render() //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracerBasic(new RayTracerBasic(scene));

		render.renderImage();
		render.writeToImage();
	}
	@Test
	public void test4u() {
		Camera camera = new Camera(new Point3D(550,500, 1000), new Vector(-450, -535,-1100).normalize(), new Vector(-1, (28250d/9)/535, -22d/9).normalize()) //
				.setViewPlaneSize(200, 200).setDistance(1000);
		scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.BLACK), 0.15));
        scene.background=new Color(java.awt.Color.CYAN);
		scene.geometries.add(new ArrayList<Intersectable>(List.of(
			    new Polygon(new Point3D(-200,-150,-100),new Point3D(-200,-50, -125),new Point3D(250, -50, -125),new Point3D(250,-150,-100)).setEmmission(new Color(0,0,0)) //
				.setMaterial(new Material().setkD(0.1).setks(0.1).setnShininess(300).setKt(0.1))
				,new Polygon(new Point3D(100,-75,-100),new Point3D(100,05,-100),new Point3D(-50,05,-100),new Point3D(-50, -75, -100)).setEmmission(new Color(240,0,0)).setMaterial(new Material().setkD(0.4).setks(0.4).setnShininess(40).setKt(0.4))
				,new Polygon(new Point3D(100,-75,-120),new Point3D(100,05,-120),new Point3D(-50,05,-120),new Point3D(-50, -75, -120)).setEmmission(new Color(240,0,0)).setMaterial(new Material().setkD(0.2).setks(0.2).setnShininess(20))
				,new Sphere(new Point3D(75, -75, -100),15) //
				.setEmmission(new Color(java.awt.Color.BLACK)),new Triangle(new Point3D(-200,-270,-120),new Point3D(-200,-145,-100),new Point3D(237.5,-163,-120)).setEmmission(new Color(51,255,51)),
				new Sphere(new Point3D(-25, -75, -100),15) //
				.setEmmission(new Color(java.awt.Color.BLACK))
				,new Sphere(new Point3D(200, 100, -50),12) //
						.setEmmission(new Color(java.awt.Color.YELLOW)) //
						.setMaterial(new Material().setkD(0.2).setks(0.2).setnShininess(30).setKt(0.6)))));
        for(int i=250;i>-250;i-=30)
		{
			scene.geometries.add(new Polygon(new Point3D(i,-100,-107.5),new Point3D(i,-70, -116.5),new Point3D(i-15, -70, -116.5),new Point3D(i-15,-100,-107.5)).setEmmission(new Color(255,255,255)).setMaterial(new Material().setkD(0.2).setks(0.2).setnShininess(30).setKt(0.05)));
		}
		scene.lights.add(new SpotLight(new Color(0,0,0), new Point3D(600, 500, 0), new Vector(0, -1, 0)) //
				.setkL(4E-5).setkQ(2E-7));
		scene.lights.add(new SuperSpotLight(new Color(255,255,0), new Point3D(200, 100, -50), new Vector(5,-18,-50), 1d/200).setkL(4E-5).setkQ(2E-7));

		ImageWriter imageWriter = new ImageWriter("r4u", 600, 600);
		Render render = new Render() //
				.setImageWriter(imageWriter) //
				.setCamera(camera) //
				.setRayTracerBasic(new RayTracerBasic(scene));

		render.renderImage();
		render.writeToImage();
	}

}
