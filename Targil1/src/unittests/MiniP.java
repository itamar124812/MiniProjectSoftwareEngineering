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
import elements.SpotLight;
import geometries.Intersectable;
import geometries.Sphere;
public class MiniP {
	private Scene scene = new Scene("Bear scene");

    @Test
    public void Bear()
    {
    	Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);
    	Material mat=new Material().setkD(0.5).setks(0.5).setnShininess(100).setKr(0.2);
		scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Sphere(new Point3D(-78, -88, -50),16) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat),
						new Sphere(new Point3D(0, 0, -50),10) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat),
				new Sphere(new Point3D(0, 0, -50),25) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat))));
		
		scene.lights.add( //
				new SpotLight(new Color(1000, 600, 0), new Point3D(-100, -100, 500), new Vector(-1, -1, -2)) //
						.setkL(0.0004).setkQ(0.0000006));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("Bearpo", 500, 500)) //
				.setCamera(camera) //
				.setRayTracerBasic(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}

    }
}
