package unittests;
import static org.junit.Assert.*;
import static java.lang.System.out;
import static org.junit.Assert.*;
import primitives.*;
import scene.Scene;

import org.junit.Test;

import elements.Camera;
public class MiniP {
    @Test
    public void Bear()
    {
        Scene scene = new Scene("Bear scene");
        Camera camera=new Camera(new Point3D(1,3,7), new Vector(-1,-1,-1), new Vector(0,-1,1))
        .setDistance(1)
        .setViewPlaneSize(100, 100);
        scene.setAmbientLight(new Color());
        scene.geometries.add(new Sphere);

    }
}
