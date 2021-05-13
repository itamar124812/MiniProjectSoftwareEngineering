package renderer;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import primitives.Ray;

public class Render {  
    private ImageWriter imageWriter;
    private Camera camera;
    private RayTracerBasic rayTracer;
    public Render setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
    }
    public Render setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }
    public Render setRayTracerBasic(RayTracerBasic RayTracer) {
        this.rayTracer = RayTracer;
        return this;
    }
    public void renderImage()
     {
         if(camera.equals(null)) throw new MissingResourceException("The camera is missed","elements.camera",null);
         else if(imageWriter.equals(null)) throw new MissingResourceException("The image writer is missed","renderer.ImageWriter",null);
         Ray ray;
      for(int i=0;i<imageWriter.getNx();i++)
      {
        for(int j=0;j<imageWriter.getNy();j++)
        {
            ray=camera.constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i);
            imageWriter.writePixel(i, j, rayTracer.traceRay(ray));
        }
      }
    }
    public void printGrid(int interval, Color color)
    {
         
    }
    public void writeToImage()
    {
        if(imageWriter.equals(null)) throw new MissingResourceException("The image writer is missed","renderer.ImageWriter",null);
        imageWriter.writeToImage();
    }
}
