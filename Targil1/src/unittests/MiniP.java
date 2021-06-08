package unittests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.junit.Assert.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.RayTracerBasic;
import renderer.Render;
import scene.Scene;

import org.junit.Test;

import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.Intersectable;
import geometries.Sphere;
public class MiniP {
	private Scene scene = new Scene("Bear scene");

    @Test
    public void Bear()
    {
    	
    	Camera camera = new Camera(new Point3D(-78, -88, -1000), new Vector(0, 0, 1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1500);
    	Material mat=new Material().setkD(0.4).setks(0.4).setnShininess(300).setKr(0.2);
		scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Sphere(new Point3D(-78, -88, -50),16) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-78, -62, -50),10) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat),
				new Sphere(new Point3D(-78, -68, -63),5) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-84.87, -55.82, -46.17),4.5) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-72.2, -55.01, -45.81),4.5) //
						.setEmmission(new Color(218,165,32)),
						new Sphere(new Point3D(-84.87, -55.82, -50),2.5) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-72.2, -55.01, -50),2.5) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),/////////////////////////////////////////////////////////
						new Sphere(new Point3D(-81, -62, -65),2) //
						.setEmmission(new Color(0,0,0)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-75, -62, -65),2) //
						.setEmmission(new Color(0,0,0)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-78, -68, -72),2) //
						.setEmmission(new Color(0,0,0)) //
						.setMaterial(mat),/////////////////////////////////////////////////
						new Sphere(new Point3D(-67.57, -79.27, -58.43),6) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-89.08, -78.26, -56.2),6) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-87.46, -98.73, -57.17),6) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-71.77, -100.69, -57.49),6) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat)
						)));
		
		scene.lights.add(new PointLight(new Color(255,0,0), new Point3D(-78,-150,-50)));
		scene.lights.add(new PointLight(new Color(255,0,0), new Point3D(-100, -88, -50)));
		scene.lights.add(new PointLight(new Color(255,0,0), new Point3D(-78, -120, -50)));
		scene.lights.add(new PointLight(new Color(255,0,0), new Point3D(-78, -88, -85)));


		Render render = new Render() //
				.setImageWriter(new ImageWriter("Bearpo", 500, 500)) //
				.setCamera(camera) //
				.setRayTracerBasic(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}
    
}
