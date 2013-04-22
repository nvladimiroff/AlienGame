import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.*;

public class Animator implements ActionListener
{
	private JFrame frame;
	private ArrayList<Sprite> objs;
	private Background bkg;
	private BufferedImage virtual;
	private Graphics buffer;
	private javax.swing.Timer timer;
	private int delay;


	public Animator(JFrame j, int d, BufferedImage bk)
	{
		frame = j;
		delay = d;
		objs = new ArrayList<Sprite>();
		timer = new javax.swing.Timer(delay,this);

		virtual = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
		buffer = virtual.getGraphics();
		
		bkg = new Background(bk);
		bkg.setPosition(100, 100, 200, 200);
		bkg.draw(buffer);
		
		timer.setInitialDelay(500);
		timer.start();
	}

	public void actionPerformed(ActionEvent evt)
	{
		frame.repaint();
	}

	public void main(Graphics g)
	{
		nextAll();
		checkCollisionAll();
		drawAll();
		g.drawImage(virtual,0,0,null);
		eraseAll();
		bkg.scroll(1, 1);
	}

	public void nextAll()
	{
		for(Sprite a: objs)
			a.next();
	}

	public void drawAll()
	{
		for(Sprite a: objs)
			a.draw(buffer);
	}
	
	public void eraseAll()
	{
		bkg.draw(buffer);
	}
	
	public void checkCollisionAll()
	{
		for(int x=0;x<objs.size();x++)
			for(int y=x+1;y<objs.size();y++)
			{
				Sprite a = objs.get(x);
				Sprite b = objs.get(y);

				if(checkCollision(a.getBounds(),b.getBounds()))
				{
					a.collision(b);
					b.collision(a);
				}
			}
	}
	
	public boolean checkCollision(Rectangle s1, Rectangle s2)
	{
		if(s1.intersects(s2))
			return true;
		else 
			return false;
	}
	
	public void add(Sprite a)
	{
		objs.add(a);
	}
	
	public void remove(Sprite a)
	{
		if(objs.contains(a))
			objs.remove(a);
	}

	public int getDelay(){return timer.getDelay();}
	public void setDelay(int d){delay=d;timer.setDelay(delay);}

	public Graphics getBuffer(){return buffer;}

}
