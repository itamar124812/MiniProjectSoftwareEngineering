package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

public abstract class RayTracerBase {
    protected Scene scene;
    public RayTracerBase(Scene aScene)
    {
        scene=aScene;
    }
    public Color traceRay(Ray ray)
    {
        return null;
    }
}
