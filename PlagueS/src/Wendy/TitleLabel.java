package Wendy;

import java.awt.Graphics2D;

import guiTeacher.components.Component;
import guiTeacher.components.TextLabel;

public class TitleLabel extends Component{


	public TitleLabel(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
		g.drawRoundRect(getX(), getY(), getWidth(), getHeight(), 15, 15);
		
		TextLabel title = new TextLabel(getX(), getY(), getWidth(), getHeight(), "PLAGUE S-implified");
		
	}

}
