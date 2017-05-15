import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Wendy.State;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;


public class MainScreen extends FullFunctionScreen{
	
	private State state;
	private TextLabel name;
	private TextLabel infected;
	private TextLabel dead;
	private String[] n = {"California","Texas","Florida","New York","Pennsylvania","Illinois","Ohio","Georgia","North Carolina","Michigan","New Jersey","Virginia","Washington","Arizona","Massachusetts","Tennessee","Indiana","Missouri","Maryland","Wisconsin","Colorado","Minnesota","South Carolina","Alabama","Louisiana","Kentucky","Oregon","Oklahoma","Connecticut","Puerto Rico","Iowa","Utah","Mississippi","Arkansas","Nevada","Kansas","New Mexico","Nebraska","West Virginia","Idaho","Hawaii","New Hampshire","Maine","Rhode Island","Montana","Delaware","South Dakota","North Dakota","Alaska","Wyoming","Vermont"};
	private ArrayList<State> butts;

	public MainScreen(int width, int height) {
		super(width, height);

	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
		Graphic backGround = new Graphic(10, 10, 1.1, "Images/map0.1.jpg");
		
		viewObjects.add(backGround);
		
		fillInButtons();
		viewObjects.addAll(butts);
		//width = 55 height = 110
		
		//state.setInfectedPop(10);
		//name = new TextLabel(50,100,1000,50,"State: " + state.getName());
		//infected = new TextLabel(50,200,1000,50,"Infected: " + state.getInfectedPop());
		//dead = new TextLabel(50,250,100,50,"Dead: " + state.getDeadPop());
		viewObjects.add(name);
		viewObjects.add(infected);
		viewObjects.add(dead);
		
	}
	
	public void fillInButtons(){
		butts = new ArrayList<State>();
		int startY = 10;
		int i = 0;
		for(int row = 0; row < 5; row++){
			int startX = 175;
			startY+=110;
			for(int col = 0; col < 10; col++){
				startX+=55;
				State but = new State(startX,startY,55,110,"T",new Action(){

					@Override
					public void act() {
						// TODO Auto-generated method stub
						name = new TextLabel(50,100,1000,50,"State: " + but.getName());
						infected = new TextLabel(50,200,1000,50,"Infected: " + but.getInfectedPop());
						dead = new TextLabel(50,250,100,50,"Dead: " + but.getDeadPop());
						
					}
					
				},n[i], col, null);
				but.setForeground(Color.red);
				butts.add(but);
				i++;
			}
		}
	}



}
  