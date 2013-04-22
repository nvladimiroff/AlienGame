import java.awt.*;


public abstract class Animatable
{
	protected Graphics g;		// Graphics to draw to
	protected Animator main;	// The animator that will draw this
	protected boolean finished; // If true should stop drawing
	protected Shape area;		// The area this occupies
	

	public Animatable()
	{
		finished=false;
	}
	
	public abstract void draw();
	public abstract void nextFrame();
	public abstract void setBounds();
	public abstract void collision(Animatable other);
	
	public void setG(Graphics gr){g=gr;}
	
	public void setAnimator(Animator a)
	{
		main=a;
		g=main.getG();
	}
	
	public void finish()
	{
		finished=true;
		main=null;
		g=null;
	}
	
	public Graphics getG(){return g;}
	public Animator getAnimation(){return main;}
	public boolean isFinished(){return finished;}
	public Shape getBounds(){return area;}

}
