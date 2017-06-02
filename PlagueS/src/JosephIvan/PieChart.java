package JosephIvan;

import java.awt.Color;
import java.awt.Graphics2D;

import Jimmy.Cure;

public class PieChart extends guiTeacher.components.Component {

	public PieChart(int x, int y) {
		super(x,y,300,300);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.cyan);
		g.fillOval(0, 0, getWidth(), getHeight());
		g.setColor(Color.blue);
		g.fillArc(0, 0, getWidth(), getHeight(), 0, (int) (Cure.curePercentage*3.6)); 
		
		
	}
	public void again(){
		if(Cure.curePercentage!=0){
			update();
		}
	}

}
