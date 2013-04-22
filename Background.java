import java.awt.*;
import java.awt.image.*;

public class Background
{
	protected BufferedImage back;
	protected int xStart;
	protected int yStart;
	protected int width;
	protected int height;
	
	public Background(BufferedImage i)
	{
		back = i;
		xStart = 0;
		yStart = 0;
		width = 0;
		height = 0;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(back.getSubimage(xStart, yStart, width, height), 0, 0, null);
	}
	
	public void setPosition(int x, int y, int w, int h)
	{
		xStart = x;
		yStart = y;
		width = w;
		height = h;
	}
	
	public void scroll(int x, int y)
	{
		xStart += x;
		yStart += y;
	}
	
	public int getXStart() { return xStart; }
	public int getYStart() { return yStart; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }

}
