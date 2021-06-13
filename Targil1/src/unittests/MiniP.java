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
import geometries.Plane;
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
						new Sphere(new Point3D(-78.2, -94.78, -35.51),5) //
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
						new Sphere(new Point3D(-69.24, -78.34, -64.12),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-62.87, -79.64, -62.15),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-64.77, -77.12, -63.28),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-67.17, -75.32, -62.93),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						//////////////////////////////////////////////////////////////
						new Sphere(new Point3D(-89.08, -78.26, -56.2),6) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-93.93, -77.85, -59.71),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-91.89, -75.49, -60.72),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-89.31, -73.86, -60.27),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-87.4, -76.55, -61.7),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						/////////////////////////////////////////////////////////
						new Sphere(new Point3D(-87.46, -98.73, -57.17),6) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-85.84, -103.71, -60.09),3) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-89.66, -103.58, -59.94),3) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-92.39, -100.81, -59.89),3) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						//////////////////////////////////////////////////////////
						new Sphere(new Point3D(-71.77, -100.69, -57.49),6) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-67.87, -104.41, -60.13),3) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-71.54, -105.35, -61.26),3) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Sphere(new Point3D(-74.82, -105.09, -60.2),3) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat),
						new Plane(new Point3D(-78, -120, -50),new Vector(0,-1,0)))
						));
		
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
