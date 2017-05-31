package JosephIvan;
import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
 import guiTeacher.userInterfaces.FullFunctionScreen;
 

public class DemoScreen extends FullFunctionScreen implements Runnable {
 
	private WorldPage p = new WorldPage(20,20,600,600);
 
public DemoScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

//s

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		//work on Sleeper here
		// created a new instance
		// doing this in Connell's room so I haven't tested it yet.
		//Might not be in nockles' class today bc i'm going to get medicine. My right hand is really swollen. I'll send a pic bro.
		Sleeper date = new Sleeper();
		date.run();
		TextLabel dd = new TextLabel(20, 40, 1000, 40, "Day " + date.days + " Month " + date.months[date.month] + " Year " + date.year);
		
		
		TextLabel Display = new TextLabel(20, 40, 1000, 40, "hjkhk");
		Button Cure = new Button(100,100, 100, 100, "Cure", Color.blue, new Action(){

			@Override
			public void act() {
			Display.setText("Cure Clicked");
			Display.setCustomTextColor(Color.blue);
			viewObjects.add(p);
				
			}		
		}						
				);
		Button World = new Button(300,300, 100, 100, "World", Color.blue, new Action(){

			@Override
			public void act() {
			Display.setText("World Clicked");
			Display.setCustomTextColor(Color.green);
			remove(p);
				
			}
			
		});
		
		//PieChart p = new PieChart(600,600);
		String pics[] = {"Images/plague.jpg" };
		Graphic background = new Graphic(0,0,1000,1000,pics[0]);
		viewObjects.add(background);
		viewObjects.add(Display);
		viewObjects.add(Cure);
		viewObjects.add(World);
		viewObjects.add(dd);
		
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

 }
