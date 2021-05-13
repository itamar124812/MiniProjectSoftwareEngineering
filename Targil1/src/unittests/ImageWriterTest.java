package unittests;

import org.junit.Test;
import renderer.*;
import primitives.Color;

public class ImageWriterTest {
  
	
	@Test
	public void ImageWriter() {
		ImageWriter imageWriter=new ImageWriter("Test",800,500);
		imageWriter.writeToImage();
		for(int i=0;i<imageWriter.getNx();i++)
			for(int j=0;j<imageWriter.getNy();j++) {
				if(i%50==0||j%50==0)
			    imageWriter.writePixel(i, j,new Color(java.awt.Color.YELLOW));
			else
				imageWriter.writePixel(i, j,new Color(java.awt.Color.BLUE));
			}
		imageWriter.writeToImage();
	}
}
