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
import elements.SuperSpotLight;
import geometries.Cylinder;
import geometries.Intersectable;
import geometries.Plane;
import geometries.Polygon;
import geometries.Sphere;
import geometries.Triangle;
public class MiniP {
	private Scene scene = new Scene("Bear scene");

    @Test
    public void Bear()
    {
    	
    	Camera camera = new Camera(new Point3D(-78, -105, -1000), new Vector(0, 0, 1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(750);
    	Material mat=new Material().setkD(0).setks(0).setnShininess(300).setKr(0).setKt(0);
    	scene.background=new Color(0,0,102);
		scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Sphere(new Point3D(-78, -88, -50),16) //
						.setEmmission(new Color(218,165,32)) //
						,
						new Sphere(new Point3D(-78, -62, -50),10) //
						.setEmmission(new Color(218,165,32)) //
						,
				new Sphere(new Point3D(-78, -68, -63),5) //
						.setEmmission(new Color(139,69,19)) //
						,
						new Sphere(new Point3D(-78.2, -94.78, -35.51),5) //
						.setEmmission(new Color(139,69,19)) //
						,
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
						.setMaterial(mat)
					/*	new Plane(new Point3D(-78, 50, 2000),new Vector(0,0,-1)).setEmmission(new Color(0,0,102))
						.setMaterial(mat.setKr(0.97).setKt(0))
						/*new Plane(new Point3D(-78, -88, -50),new Vector(0,0,-1)).setEmmission(new Color(1,1,1)
								).setMaterial(mat.setKt(1).setKr(0))*/
						)));
		scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Polygon(new Point3D(-40,-108,-130),new Point3D(-40,-108,0),new Point3D(-120,-108,0),new Point3D(-120,-108,-130)
						).setEmmission(new Color(51,153,255)),
				new Polygon(new Point3D(-120,-136,-130),new Point3D(-120,-108,-130),new Point3D(-120,-108,0),new Point3D(-120,-136,0)
						).setEmmission(new Color(51,153,255)),
				new Polygon(new Point3D(-120,-136,0),new Point3D(-120,-108,0),new Point3D(-40,-108,0),new Point3D(-40,-136,0)
								).setEmmission(new Color(51,153,255)),
				new Polygon(new Point3D(-40,-136,0),new Point3D(-40,-108,0),new Point3D(-120,-108,-130),new Point3D(-120,-136,-130)
						).setEmmission(new Color(51,153,255)),
				new Polygon(new Point3D(-40,-136,-130),new Point3D(-40,-108,-130),new Point3D(-40,-108,0),new Point3D(-40,-136,0)
						).setEmmission(new Color(51,153,255)),
				new Polygon(new Point3D(-40,-136,-130),new Point3D(-40,-136,0),new Point3D(-120,-136,0),new Point3D(-120,-136,-130)
						).setEmmission(new Color(51,153,255)),
				new Cylinder(new Ray(new Point3D(-145,-94,40),new Vector(0, -1,0)), 5, 50).setEmmission(new Color(128,128,128)).setMaterial(mat.setKt(0.3)) //
               ,new Cylinder(new Ray(new Point3D(-40,-94,-440),new Vector(0, -1,0)), 5, 50).setEmmission(new Color(128,128,128)).setMaterial(mat.setKt(0.3)) //
               ,new Cylinder(new Ray(new Point3D(-120,-94,-440),new Vector(0, -1,0)), 5, 50).setEmmission(new Color(128,128,128)).setMaterial(mat.setKt(0.3)) //
               ,new Cylinder(new Ray(new Point3D(-25,-94,40),new Vector(0, -1,0)), 5, 50).setEmmission(new Color(128,128,128)).setMaterial(mat.setKt(0.3)) //
              
               , new Polygon(new Point3D(-55,-60,0),new Point3D(-55,-108,0),new Point3D(-105,-108,0),new Point3D(-105,-60,0)
						).setEmmission(new Color(51,153,255)).setMaterial(mat),
				new Polygon(new Point3D(-55,-60,0),new Point3D(-105,-60,0),new Point3D(-105,-60,-10),new Point3D(-55,-60,-10)
								).setEmmission(new Color(51,153,255)).setMaterial(mat),
				new Polygon(new Point3D(-105,-108,-10),new Point3D(-105,-60,-10),new Point3D(-55,-60,-10),new Point3D(-55,-108,-10)
						).setEmmission(new Color(51,153,255)).setMaterial(mat),
				new Polygon(new Point3D(-55,-108,0),new Point3D(-55,-60,0),new Point3D(-55,-60,-10),new Point3D(-55,-108,-10)
						).setEmmission(new Color(51,153,255)).setMaterial(mat),
				new Polygon(new Point3D(-105,-108,0),new Point3D(-105,-60,0),new Point3D(-105,-60,-10),new Point3D(-105,-108,-10)
						).setEmmission(new Color(51,153,255)).setMaterial(mat),
				
				new Sphere(new Point3D(-145,-87,40),7) //
				.setEmmission(new Color(255,255,204)) //
				.setMaterial(mat.setKt(0.2).setkD(0.5).setKr(0.6).setks(0.4)),
				new Sphere(new Point3D(-40,-87,-440),7) //
				.setEmmission(new Color(255,255,204)) //
				.setMaterial(mat.setKt(0.2).setkD(0.5).setKr(0.6).setks(0.4)),
				new Sphere(new Point3D(-120,-87,-440),7) //
				.setEmmission(new Color(255,255,204)) //
				.setMaterial(mat.setKt(0.2).setkD(0.5).setKr(0.6).setks(0.4)),
				new Sphere(new Point3D(-25,-87,40),7) //
				.setEmmission(new Color(255,255,204)) //
				.setMaterial(mat.setKt(0.2).setKr(0.6).setks(0.4).setkD(0.5)),
				new Sphere(new Point3D(-78, 50, 1000),20) //
				.setEmmission(new Color(255,255,255)) //
				.setMaterial(mat.setKt(0.2).setkD(0.5)),
				
				new Cylinder(new Ray(new Point3D(-150,-64,100),new Vector(0, -1,0)), 10, 80).setEmmission(new Color(153,76,0)), //
				new Cylinder(new Ray(new Point3D(0,-64,70),new Vector(0, -1,0)), 10, 80).setEmmission(new Color(153,76,0)) //
				
				,new Triangle(new Point3D(-187,-64,100),new Point3D(-150,-64,127),new Point3D(-150,10,100)).setEmmission(new Color(0,102,51))
				,new Triangle(new Point3D(-150,-64,127),new Point3D(-113,-64,100),new Point3D(-150,10,100)).setEmmission(new Color(0,102,51))
				,new Triangle(new Point3D(-113,-64,100),new Point3D(-150,-64,63),new Point3D(-150,10,100)).setEmmission(new Color(0,102,51))
				,new Triangle(new Point3D(-187,-64,100),new Point3D(-150,-64,63),new Point3D(-150,10,100)).setEmmission(new Color(0,102,51))
				
				,new Triangle(new Point3D(27,-64,70),new Point3D(0,-64,97),new Point3D(0,10,70)).setEmmission(new Color(0,102,51))		
				,new Triangle(new Point3D(0,-64,97),new Point3D(-27,-64,70),new Point3D(0,10,70)).setEmmission(new Color(0,102,51))
				,new Triangle(new Point3D(-27,-64,70),new Point3D(0,-64,43),new Point3D(0,10,70)).setEmmission(new Color(0,102,51))
				,new Triangle(new Point3D(27,-64,70),new Point3D(0,-64,43),new Point3D(0,10,70)).setEmmission(new Color(0,102,51))
				,new Polygon(new Point3D(-300,-145,-600),new Point3D(300,-145,-600),new Point3D(300,-145,300),new Point3D(-300,-145,300)
						).setEmmission(new Color(51,255,51)).setMaterial(mat.setkD(0.4).setks(0.1))
				)));

		/*scene.geometries.add(new ArrayList<Intersectable>(List.of( //
				new Sphere(new Point3D(-78, -117.44, -85.33),14) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat.setKr(0)),
						new Sphere(new Point3D(-78,-103.44,-85.33),10) //
						.setEmmission(new Color(218,165,32)) //
						.setMaterial(mat.setKr(0)),
						/*new Sphere(new Point3D(-78,-103.44,-82.33),12) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat.setKr(0)),
						new Sphere(new Point3D(-78,-103.44,-92.33),5) //
						.setEmmission(new Color(139,69,19)) //
						.setMaterial(mat.setKr(0)),
						new Sphere(new Point3D(-74.91, -96.16, -91.45),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat.setKr(0)),
						new Sphere(new Point3D(-81.61, -96.7, -91.78),2) //
						.setEmmission(new Color(1,1,1)) //
						.setMaterial(mat.setKr(0)),
		
						new Cylinder(new Ray(new Point3D(-78, -117.44, -85.33),new Vector(0, 0, 35.33)), 12, 40.08).setEmmission(new Color(218,165,32)) //
						.setMaterial(mat.setKr(0)))));*/

		scene.lights.add(new SpotLight(new Color(255,255,255), new Point3D(-78, 50, 1000),new Vector(78, -40, -930)).setkC(0.012).setkL(0.975).setkQ(0.88));
		scene.lights.add(new SuperSpotLight(new Color(255,255,51), new Point3D(-145,-87,40),new Vector(40, 63, 510), 230));
		scene.lights.add(new SuperSpotLight(new Color(255,255,51), new Point3D(-40,-87,-440),new Vector(40, 63, 510), 250));
		scene.lights.add(new SuperSpotLight(new Color(255,255,51), new Point3D(-25,-87,40),new Vector(40, 63, 510), 250));
		scene.lights.add(new SuperSpotLight(new Color(255,255,51), new Point3D(-120,-87,-440),new Vector(40, 63, 510), 250));


		Render render = new Render() //
				.setImageWriter(new ImageWriter("Bearpo", 500, 500)) //
				.setCamera(camera) //
				.setRayTracerBasic(new RayTracerBasic(scene)).setMultithreading(3).setDebugPrint();
		render.aSuperSamplingOn=true;
		render.superSamplingOn=true;
		render.renderImage();
		render.writeToImage();
	}
    
}
