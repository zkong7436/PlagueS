package JosephIvan;
import java.awt.Color;
import java.util.List;

import Jimmy.Sleeper;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
 import guiTeacher.userInterfaces.FullFunctionScreen;
import main.PlagueS;
 

public class DemoScreen extends FullFunctionScreen implements Runnable {
 
	private WorldPage p = new WorldPage(20,20,600,600);
	private int days = 0;
	private String months = "";
	private int years = 0;
	Sleeper date = new Sleeper();
 
public DemoScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

//s

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		
		//Sleeper date = new Sleeper();
		//date.run();
		
		
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
			//main.PlagueS.game.setScreen(PlagueS.Mscreen);
				
			}
			
		});
		
		TextLabel dd = new TextLabel(200, 400, 1000, 40, "Day " + days + " Month " + months + " Year " + years);
		
		//PieChart p = new PieChart(600,600);
		Graphic background = new Graphic(0,0,1000,1000,"");
		//Images/plague.jpg
		viewObjects.add(background);
		viewObjects.add(Display);
		viewObjects.add(Cure);
		viewObjects.add(World);
		viewObjects.add(dd);
		
		
	}
	public void getDays(){
		days= date.days;
		update();
	}
	public void getMonths(){
		months = date.months[date.month];
	}
	public void getYears(){
		years = date.year;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

 }
