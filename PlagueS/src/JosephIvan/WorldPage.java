package JosephIvan;

import java.awt.Graphics2D;

import guiTeacher.components.TextLabel;

public class WorldPage extends guiTeacher.components.Component {

private PieChart chart;
private TextLabel text;
private PieChart2 chart2;

	public WorldPage(int x, int y, int w, int h) {
		super(x, y, w, h);

		
		Thread update = new Thread(new Runnable(){

			@Override
			public void run() {
				
				while(true){
					update();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}

		}
				);
		update.start();
	}

	@Override
	public void update(Graphics2D g) {
		chart = new PieChart(20,80);
		chart2 = new PieChart2(300,300);
		text = new TextLabel(0,0,600,50,"The Plague is starting to take over the world!");
		text.setSize(30);
		if(chart!=null){
			g.drawImage(text.getImage(), text.getX(),text.getY(),null);
			g.drawImage(chart.getImage(), chart.getX(),chart.getY(),null);
			g.drawImage(chart2.getImage(), chart2.getX(),chart2.getY(),null);
			
		}
		
	}

}
