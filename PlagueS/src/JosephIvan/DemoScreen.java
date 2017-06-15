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
	//Sleeper date = new Sleeper();
 
public DemoScreen(int width, int height) {
		super(width, height);
		setVisible(true);
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
			viewObjects.add(p);
				
			}		
		}						
				);
		Button World = new Button(500,500, 100, 100, "World", Color.blue, new Action(){

			@Override
			public void act() {
			Display.setText("World Clicked");
			Display.setCustomTextColor(Color.green);
			remove(p);
			//main.PlagueS.game.setScreen(PlagueS.Mscreen);
				
			}
			
		});
		
		Button exit = new Button(1100, 80, 70, 70, "X", Color.gray, new Action(){
			
			@Override
			public void act() {
				main.PlagueS.game.setScreen(main.PlagueS.game.Mscreen);
			}
		});
	
		//PieChart p = new PieChart(600,600);
		Graphic background = new Graphic(0,0,1000,1000,"");
		//Images/plague.jpg
		viewObjects.add(background);
		viewObjects.add(Display);
		viewObjects.add(Cure);
		viewObjects.add(World);
		viewObjects.add(exit);
		
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

 }
