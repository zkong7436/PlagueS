package JosephIvan;

import java.awt.Graphics2D;

import guiTeacher.components.TextLabel;

public class WorldPage extends guiTeacher.components.Component {

private PieChart chart;
private BarGraph bar;
private TextLabel text;

	public WorldPage(int x, int y, int w, int h) {
		super(x, y, w, h);
		chart = new PieChart(20,20);
		text = new TextLabel(0,0,300,40,"The Plague is starting to take over the world!");
		text.setSize(35);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		if(chart!=null){
			g.drawImage(text.getImage(), text.getX(),text.getY(),null);
			g.drawImage(chart.getImage(), chart.getX(),chart.getY(),null);
		}
		
	}

}
