import java.awt.image.BufferedImage;


public class Player extends Sprite
{
	boolean keyState[];
	
	public Player(BufferedImage i, int x, int y)
	{
		super(i,x,y);
		keyState = new boolean[5];
	}
	
	public void next()
	{
		if(keyState[0])
			moveRelative(0,-5);
		if(keyState[1])
			moveRelative(0,5);
		if(keyState[2])
			moveRelative(-5,0);
		if(keyState[3])
			moveRelative(5,0);
	}
	
	public void switchKey(int index)
	{
		keyState[index] = !keyState[index];
	}

}
