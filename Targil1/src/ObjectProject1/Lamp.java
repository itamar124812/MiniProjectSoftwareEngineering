package ObjectProject1;


import java.util.ArrayList;
import java.util.List;

import elements.PointLight;
import geometries.Geometries;
import geometries.Intersectable;
import geometries.Polygon;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

/**
 * Lamp class: Creates lampshade
 *lightLamp,list of geometries lampParts
 */
public class Lamp

{
    private Geometries lampParts;
    PointLight lightLamp;

    /**
     * constructor. transparency ball that contain a point light/ spot light. and a long wire.
     * @param color- the color of the light ball
     * @param lampShadeColor-the color of lamp Shade
     * @param radius-the radius the light ball
     * @param radius1- the radius of little ball between the lamp and the wire.
     * @param lightLamp- the light of the lamp.
     * @param v1 - the direction of the lamp.
     * @param v2 - a vector that vertical to v1.
     * @throws IllegalArgumentException in case the vectors v1 and v2 are not vertical.
     */
    public Lamp(Color color, Color lampShadeColor, double radius,double radius1 ,PointLight lightLamp,Vector v1, Vector v2) {
        this.lightLamp=lightLamp;

        if(Util.alignZero(v1.dotProduct(v2))!=0) //for the lamp will not be warp.
        {
            throw  new IllegalArgumentException("the vectors of the lamp must be vertix");
        }
        Material materialLamp=new Material().setnShininess(100).setkD(0.2).setks(0.2).setKt(0.8);// the sphere that surrounding a point light/ spot light have to be transparency for the light to be seen.
        Material lampShadeMaterial=new Material().setnShininess(100).setkD(0.2).setks(0.2);

        //the lamp ball
        Point3D center=lightLamp.getPosition();
        Sphere s=new Sphere(center,radius);
        s.setEmmission(color).setMaterial(materialLamp);
        //The lampshade
        Vector v3=v1.crossProduct(v2);
        Point3D p1=center.add(v1.scale(2*radius));
        Point3D p2=center.add(v2.scale(2*radius));
        Point3D p3=center.add(v3.scale(2*radius));
        Point3D p4=center.add(v2.scale(-2*radius));
        Point3D p5=center.add(v3.scale(-2*radius));
        Sphere s1=new Sphere(p1,radius1);
        s1.setEmmission(new Color(140,140,140)).setMaterial(lampShadeMaterial);
        //the cord of the lamp
        Point3D pCord1=p1.add(v2.scale(0.5));
        Point3D pCord2=p1.add(v2.scale(-0.5));
        Point3D pCord3=p1.add(v3.scale(0.5));
        Point3D pCord4=p1.add(v3.scale(-0.5));



        //The shapes that make up the lamp 134 ,125, 135

        lampParts=new Geometries( new ArrayList<Intersectable>(List.of( s,s1, new Triangle(p1,p2,p3).setEmmission(lampShadeColor).setMaterial(lampShadeMaterial),
                new Triangle(p1,p3,p4).setEmmission(lampShadeColor).setMaterial(lampShadeMaterial),
                new Triangle(p1,p2,p5).setEmmission(lampShadeColor).setMaterial(lampShadeMaterial),
                new Triangle(p1,p3,p5).setEmmission(lampShadeColor).setMaterial(lampShadeMaterial),
                new Polygon(pCord1,pCord2,pCord2.add(v1.scale(100)),pCord1.add(v1.scale(100))).setEmmission(new Color(140,140,140)).setMaterial(lampShadeMaterial),
                new Polygon(pCord3,pCord4,pCord4.add(v1.scale(100)),pCord3.add(v1.scale(100))).setEmmission(new Color(140,140,140)).setMaterial(lampShadeMaterial))));




    }

    public Geometries getLampParts() {
        return lampParts;
    }

    public PointLight getLightLamp() {
        return lightLamp;
    }
}