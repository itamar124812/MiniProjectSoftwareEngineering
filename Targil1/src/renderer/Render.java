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
    public Render setRayTracerBasic(RayTracerBasic rayTracerBasic) {
        this.rayTracer = rayTracerBasic;
        return this;
    }
    public void renderImage()
     {
         if(camera.equals(null)) throw new MissingResourceException("The camera is missed","elements.camera",null);
         else if(imageWriter.equals(null)) throw new MissingResourceException("The image writer is missed","renderer.ImageWriter",null);
         Ray ray;
      for(int i=0;i<imageWriter.getNy();i++)
      {
        for(int j=0;j<imageWriter.getNx();j++)
        {
            ray=camera.constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i);
            imageWriter.writePixel(j, i, rayTracer.traceRay(ray));
        }
      }
    }
    public void printGrid(int interval, Color color)
    {
        if(camera.equals(null)) throw new MissingResourceException("The camera is missed","elements.camera",null);
        else if(imageWriter.equals(null)) throw new MissingResourceException("The image writer is missed","renderer.ImageWriter",null);
        	for(int i=0;i<this.imageWriter.getNx();i++)
    			for(int j=0;j<this.imageWriter.getNy();j++) 
    				if(i%interval==0||j%interval==0)
    			    imageWriter.writePixel(i, j,color);	 	 									
    }
    public void writeToImage()
    {
        if(imageWriter.equals(null)) throw new MissingResourceException("The image writer is missed","renderer.ImageWriter",null);
        imageWriter.writeToImage();
    }
}
