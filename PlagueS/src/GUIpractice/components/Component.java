package GUIpractice.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Component implements Visible {
	
	//FIELDS
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;
	
	//CONSTRUCTOR
	public Component(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		update(image.createGraphics());
	}
	
	public Graphics2D clear()
	{
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		return image.createGraphics();
	}

	//draw the component
	public abstract void update(Graphics2D g);

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return w;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return h;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		update(image.createGraphics());
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}

}
