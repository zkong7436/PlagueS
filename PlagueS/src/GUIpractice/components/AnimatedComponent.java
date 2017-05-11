package GUIpractice.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatedComponent extends MovingComponent {
	
	private ArrayList<BufferedImage> frame;
	private ArrayList<Integer> times;
	private long displayTime;
	private int currentFrame;
	private boolean repeat;
	

	public AnimatedComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		frame = new ArrayList<BufferedImage>();
		times = new ArrayList<Integer>();
		currentFrame = 0;
		repeat = true;
	}


	public boolean isRepeat() {
		return repeat;
	}


	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
	
	public void addFrame(BufferedImage img, Integer time)
	{
		frame.add(img);
		times.add(time);
	}


	@Override
	public void checkBehaviors() {
		// TODO Auto-generated method stub
		//restrictions on component's location? 
		if(getX() > 400 )
		{
			setX(400); 
		 	//setVx(getVx()*-1);
		} 
	}


	@Override
	public void drawImage(Graphics2D g) {
		// TODO Auto-generated method stub
		long currentTime = System.currentTimeMillis();
		/**
		 * check if its time to change the frame
		 * and there should be same number of frames as times
		 * and check that there are images to be drawn
		 */
		if(frame != null && frame.size() > 0 && frame.size() == times.size() 
				&& currentTime - displayTime > times.get(currentFrame))
		{
			//update is occurring so update the display time
			displayTime = currentTime;
			//increase currentFrame
			currentFrame = (currentFrame + 1)%frame.size();
			if(currentFrame == 0 && ! repeat)
			{
				setRunning(false);
				return;
			}
			//clear the previous img 
			g = clear();
			BufferedImage newFrame = frame.get(currentFrame);
			//use the scaled image method
			g.drawImage(newFrame, 0, 0, getWidth(),getHeight(), 0, 0,newFrame.getWidth(),newFrame.getHeight(), null);
		}
	}
	

}
