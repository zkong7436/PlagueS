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
 
 
 
public DemoScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

//s

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		TextLabel Display = new TextLabel(20, 40, 1000, 40, "hjkhk");
		Button Cure = new Button(100,100, 100, 100, "Cure", Color.blue, new Action(){

			@Override
			public void act() {
			Display.setText("Cure Clicked");
			Display.setCustomTextColor(Color.blue);
				
			}		
		}						
				);
		Button World = new Button(300,300, 100, 100, "World", Color.blue, new Action(){

			@Override
			public void act() {
			Display.setText("World Clicked");
			Display.setCustomTextColor(Color.green);
				
			}
			
		});
		
		PieChart p = new PieChart(600,600);
		String pics[] = {"Images/plague.jpg" };
		Graphic background = new Graphic(0,0,1000,1000,pics[0]);
		viewObjects.add(background);
		viewObjects.add(Display);
		viewObjects.add(p);
		viewObjects.add(Cure);
		viewObjects.add(World);
		
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

 }
