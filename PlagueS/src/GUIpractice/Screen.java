package GUIpractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GUIpractice.components.Visible;

public abstract class Screen {
	
	private int width;
	private int height;
	private ArrayList <Visible> viewObjects;
	protected BufferedImage image;//buffer image data thats tells you how pixels are displayed
	//protected similar to private but accessible to subclasses
	
	public Screen(int width, int height)
	{
		viewObjects = new ArrayList<Visible>();
		this.width = width;
		this.height = height;
		initObjects(viewObjects);
		initImage();
		
	}

	public abstract void initObjects(ArrayList<Visible> viewObjects);

	private void initImage() {
		image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);//red green blue and transparency (alpha)
		update();
		
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

	public void update() {
		//this is where you draw stuff
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		
		//draw all visible components
		
		for(int i = 0; i<viewObjects.size(); i++)
		{
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
//		for(Visible v: viewObjects)
//		{
//			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
//		} DOESNT WORK WHILE THREADING
		
		
//		g.setFont(new Font("Comic Sans MS",Font.PLAIN,50));
//		g.drawString("^    ^", 200, 220);
//		g.drawOval(150, 100, 200, 200);
//		g.drawRect(175, 300, 150, 300);
//		g.drawLine(325, 310, 420, 420);
//		g.drawLine(175, 300, 250, 450);
//		
//		g.setColor(Color.green);
//		for(int i = 0; i< image.getWidth();i+=2)
//		{
//			g.drawLine(i,600,i,614);	
//		}
		
	}
	
	public BufferedImage getImage()
	{
		return image;
	}

	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return null;
	}

	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void remove(Visible v)
	{
		//Removes a visible from the screen
		/* ArrayList Notes 
		 * While this method is very simple do not underestimate 
		 * the trickiness of removing items in an arrayList
		 * it causes indexes to change
		 * Example:
		 * Suppose you have an ArrayList<Integer> and you want to remove all values greater than 5
		 * THIS IS BAD:
		 * 
		 * for(int i = 0; i < arraylist.size(); i++)
		 * {
		 * 		if(arraylist.get(i) > 5) list.remove(i);
		 * }
		 * 
		 * {4,5,6,7} 1st integer to remove is 6, since removed 7 moves from index 3 to 2
		 * Your list is now {4,5,7} after you increment i, i = 3 which is outOfBounds and 7 never gets removed
		 * Instead when an object is removed decrease i to compensate for change in size
		 * 
		 * THIS IS GOOD:
		 * for(int i = 0; i < arraylist.size(); i++)
		 * {
		 * 		if(arraylist.get(i) > 5) 
		 *	 	{
		 * 			list.remove(i);
		 * 			i--;
		 * 		}
		 * }
		 * 
		 * Another way 
		 * for(int i = 0; i < arraylist.size(); i++)
		 * {
		 * 		while(i < arraylist.size() && arraylist.get(i) > 5)
		 *	 	{
		 * 			list.remove(i);
		 * 		}
		 * }
		 * 
		 * for this reason, the following doesn't even work at all:
		 * BECAUSE remove changes the size - for each loops
		 * for(Integer i: list)
		 * {
		 * 		if(i > 5) list.remove();
		 * }
		 * 
		 * if you remove using an index it returns the removed object, so you can do this
		 * System.out.println(list.remove(0).toString() + " was removed.")
		 * 
		 * */
		viewObjects.remove(v);//this removes the object that has the same identity as v
		//not an object equal to v
	}
	
	public void addObject(Visible v)
	{
		viewObjects.add(v);
	}
	
	public void moveToFront(Visible v)
	{
		if(viewObjects.contains(v))
		{
			viewObjects.remove(v);
			viewObjects.add(v);//very last object in the list
		}
	}
	
	public void moveToBack(Visible v)
	{
		if(viewObjects.contains(v))
		{
			viewObjects.remove(v);
			viewObjects.add(0,v);
			//viewObjects.add(n,v);
			//moves whatever object with index >= n to index n+1, increases size by 1, adds object to index n 
		}
	}
	
	public void moveToN(int n,Visible v)
	{
		if(viewObjects.contains(v))
		{
			viewObjects.remove(v);
			viewObjects.add(n,v);
			//moves whatever object with index >= n to index n+1, increases size by 1, adds object to index n 
		}
	}
	
	

}
