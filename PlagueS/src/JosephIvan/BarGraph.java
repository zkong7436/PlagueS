package JosephIvan;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class BarGraph extends Component {

	public BarGraph(int x, int y, int w, int h) {
		super(x,y,300,300);
		update();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.cyan);
		g.drawRect(40, 400, 100, 100);
		g.fillRect(getX(), getY(), getWidth(), getHeight());

	}

}
