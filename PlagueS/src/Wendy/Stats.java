package Wendy;

import java.awt.Graphics2D;

import guiPractice.components.Component;
import guiPractice.components.TextLabel;

public class Stats extends Component{
	
	private State state;
	private TextLabel name;
	private TextLabel population;
	private TextLabel infected;
	private TextLabel dead;

	public Stats(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub
		
		name = new TextLabel(getWidth()-100, getHeight() - 100, 100, 50, "HI");
		
	}
	
	public void setState(State s)
	{
		state = s;
	}

	

	

}
