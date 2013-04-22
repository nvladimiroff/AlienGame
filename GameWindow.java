import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

public class GameWindow extends JFrame implements KeyListener
{
	Animator world;
	Player s;

	public GameWindow()
	{
		this.setSize(640, 480);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage i = GameImage.readImage("E:/Java/AlienGame/bin/test.gif");
		BufferedImage bkg = GameImage.readImage("E:/Java/AlienGame/bin/bk.jpg");
		
		world = new Animator(this,20,bkg);
		s = new Player(i,0,0);
		world.add(s);
		world.add(new Sprite(i,0,400));
		addKeyListener(this);

	}
	
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keyState[0] = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keyState[1] = true;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keyState[2] = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keyState[3] = true;

	}
	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keyState[0] = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keyState[1] = false;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keyState[2] = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keyState[3] = false;

	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void paint(Graphics g)
	{
		if(world != null)  world.main(g);
		
	}
}
