import java.awt.image.*;
import java.awt.*;

public class Sprite
{
	protected BufferedImage img;
	protected int xPos;
	protected int yPos;
	protected boolean needToUpdate;
	protected boolean dead;

	public Sprite(BufferedImage i, int x, int y)
	{
		xPos = x;
		yPos = y;
		img  = i;
		needToUpdate = true;
		dead = false;
	}

	public void next()
	{
		moveRelative(5,0);
		
	}

	public void draw(Graphics g)
	{
		//if(needToUpdate)
		//{
			//g.clipRect(xPos, yPos, img.getWidth(), img.getHeight());
			g.drawImage(img, xPos, yPos, null);
			needToUpdate = false;
		//}
	}

	public void collision(Sprite other)
	{
		System.out.println("Collision");
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(xPos, yPos, img.getWidth(), img.getHeight());
	}
	
	public void moveTo(int x, int y)
	{
		xPos = x;
		yPos = y;
		forceUpdate();
	}
	
	public void moveRelative(int x, int y)
	{
		xPos += x;
		yPos += y;
		forceUpdate();
	}
	
	public void forceUpdate() { needToUpdate = true; }
	public boolean isDead() { return dead; }
	public int getX() { return xPos; }
	public int getY() { return yPos; }
}
