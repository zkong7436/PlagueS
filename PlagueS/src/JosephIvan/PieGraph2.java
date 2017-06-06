package JosephIvan;

import java.awt.Color;
import java.awt.Graphics2D;

import Jimmy.Cure;
import guiTeacher.components.Component;

public class PieChart2 extends Component {

	public PieChart2(int x, int y) {
		super(x,y,300,300);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.cyan);
		g.fillOval(0, 0, getWidth(), getHeight());
		g.setColor(Color.blue);
		g.fillArc(0, 0, getWidth(), getHeight(), 0, (int)100*main.MainScreen.get); 
		
		
	}
}
