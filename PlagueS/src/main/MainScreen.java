package main;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	private TextLabel population;
	private TextLabel infected;
	private TextLabel dead;
	private String[] names;
	private static ArrayList<State> butts;


	private boolean infectionStarted;

	public MainScreen(int width, int height) {
		super(width, height);

	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		String[] names = {"California","Texas","Florida","New York","Pennsylvania","Illinois","Ohio","Georgia","North Carolina","Michigan","New Jersey","Virginia","Washington","Arizona","Massachusetts","Tennessee","Indiana","Missouri","Maryland","Wisconsin","Colorado","Minnesota","South Carolina","Alabama","Louisiana","Kentucky","Oregon","Oklahoma","Connecticut","Puerto Rico","Iowa","Utah","Mississippi","Arkansas","Nevada","Kansas","New Mexico","Nebraska","West Virginia","Idaho","Hawaii","New Hampshire","Maine","Rhode Island","Montana","Delaware","South Dakota","North Dakota","Alaska","Wyoming","Vermont"};
		this.names = names;
		butts = new ArrayList<State>();
		fillInButtons();
		viewObjects.addAll(butts);
		//width = 55 height = 110
		
		Button welcome = new Button(getWidth()/6, getHeight()/3,900,100,"Welcome to PlagueS! \n You are a new Bacteria. To win, you must evolve and spread across the country - wiping out all humans in the Plague",Color.red,null);
		welcome.setAction(new Action(){

			@Override
			public void act() {
				// TODO Auto-generated method stub
//				
				Thread change = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						welcome.setText("Click a state to begin");//dont know why text dont change before sleeping
						try {
							Thread.sleep(1000);
							remove(welcome);
							for(int i = 0; i< butts.size(); i++)
							{
								butts.get(i).setEnabled(true);
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				change.start();
				
			}
		
		});
		
		addStatsBar(state);
		
		Button infection = new Button(50,750, 100, 100, "Infection", new Action(){
			@Override
			public void act(){
				
			}
		});
		
		Button cure = new Button(1000,750, 100, 100, "Cure", new Action(){
			@Override
			public void act(){
				
			}
		});
		
		viewObjects.add(welcome);
		viewObjects.add(name);
		viewObjects.add(population);
		viewObjects.add(infected);
		viewObjects.add(dead);
		viewObjects.add(infection);
		viewObjects.add(cure);
	}
	
	private void addStatsBar(State s) {
		// TODO Auto-generated method stub
		if(s==null)
		{
			name = new TextLabel(40,100,1000,50,"State: ");
			name.setSize(25);
			population = new TextLabel(40,170,1000,50,"Population: ");
			population.setSize(25);
			infected = new TextLabel(40,220,1000,50,"Infected: ");
			infected.setSize(25);
			dead = new TextLabel(40,270,100,50,"Dead: ");
			dead.setSize(25);
		}
		else
		{
			name.setText("State: " + s.getName());
			population.setText("Population: " + s.getPopulation());
			infected.setText("Infected " + s.getInfectedPop());
			dead.setText("Dead " + s.getDeadPop());
		}
	}


	public void fillInButtons(){
		
		int startY = 10;
		int i = 0;
		for(int row = 0; row < 5; row++){
			int startX = 250;
			startY+=110;
			for(int col = 0; col < 10; col++){
				startX+=60;
				State but = new State(startX,startY,55,110,"T",null,names[i], 100, null);
				but.setAction(new Action(){

					@Override
					public void act() {
						// TODO Auto-generated method stub
						state = but;
						addStatsBar(state);
						if(!infectionStarted)
						{
							state.infect();
							infectionStarted = true;
						}
					}
					
				});
				but.setForeground(Color.red);
				but.setEnabled(false);
				butts.add(but);
				i++;
			}
		}
	}

	public static ArrayList<State> getButts() {
		return butts;
	}





}
  