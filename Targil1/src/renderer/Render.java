package renderer;

import elements.Camera;

public class Render {  
    private ImageWriter imageWriter;
    private Camera camera;
    private RayTracerBase rayTracerBase;
    public Render setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
    }
    public Render setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }
    public Render setRayTracerBase(RayTracerBase rayTracerBase) {
        this.rayTracerBase = rayTracerBase;
        return this;
    }
    public void renderImage()
     {

    }
    public void printGrid(int interval, Color color)
    {

    }
    public void writeToImage()
    {
        
    }
}
