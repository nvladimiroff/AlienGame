import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameImage
{
	public static boolean[][] getTransparency(BufferedImage img)
	{
		if(img == null)
			return null;
		int width = img.getWidth();
		int height = img.getHeight();
		boolean[][] transparency = new boolean[width][height];
		
		for(int x=0;x<width;x++)
			for(int y=0;y<height;y++)
				if((img.getRGB(y, x) >>> 24) > 0)
					transparency[x][y] = false;
				else
					transparency[x][y] = true;
		
		return transparency;
	}
	
	public static BufferedImage readImage(String s)
	{
		BufferedImage pic = null;
		try
		{
			File f = new File(s);
			pic = ImageIO.read(f);
		}
		catch(IOException e)
		{
			System.err.println("File Not Found");
			System.exit(1);
		}
		
		return pic;
	}
	

}
