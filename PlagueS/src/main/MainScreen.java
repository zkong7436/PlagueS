package main;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import JosephIvan.CureDemo;
import Wendy.State;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
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
	private TextLabel dnapoints;
	private String[] names;
	private static ArrayList<State> butts;
	private static int DNA;
	private Thread check;
	private static int worldPop = 1;
	private static int worldInfected;
	private TextLabel dd;
	private boolean cureStarted;
	private boolean infectionStarted;
	private boolean adding = true;

	public MainScreen(int width, int height) {
		super(width, height);
		Thread update = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					update();
					if (state != null) addStatsBar(state);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
				}
			}
		});
		update.start();
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
		getWorld();
		
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
						
						welcome.setText("Click a state to begin");
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
		
		Button infection = new Button(50,650, 100, 100, "Infection", new Action(){
			@Override
			public void act(){
				PlagueS.game.setScreen(PlagueS.game.Dscreen);
			}
		});
		
		Button cure = new Button(1000,750, 100, 100, "Cure", new Action(){
			@Override
			public void act(){
				
			}
		});
		
		Graphic DNApoint = new Graphic(500, 750, 0.5, "Images/dna.png");
		dnapoints = new TextLabel(600, 750, 200, 50, DNA + " points");
		
		
		
		viewObjects.add(welcome);
		viewObjects.add(name);
		viewObjects.add(population);
		viewObjects.add(infected);
		viewObjects.add(dead);
		viewObjects.add(infection);
		viewObjects.add(cure);
		viewObjects.add(DNApoint);
		viewObjects.add(dnapoints);	
		
		 check = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("running");
				if(infectionStarted)
				{
					//System.out.println("infection started");
					dd = new TextLabel(800, 50, 1000, 40, "Day " + PlagueS.date.days + " Month " + PlagueS.date.months[PlagueS.date.month] + " Year " + PlagueS.date.year);
					PlagueS.date.setDisplay(dd);
					viewObjects.add(dd);
					startingDNA(viewObjects);
					curing(viewObjects);
					endGame(viewObjects);
				}
			}
		});	
	}
	
	private void curing(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		Thread cure = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					if(PlagueS.date.cure.isActivate() && !cureStarted)
					{
						System.out.println("CRY MYSELF A RIVER");
						Button cureS = new Button(getWidth()/6, getHeight()/3,900,100,"Research for cure to " + PlagueS.Iscreen.getbName() + " has started",Color.black,null);
						cureS.setAction(new Action(){
							
							@Override
							public void act() {
								// TODO Auto-generated method stub
								try {
									Thread.sleep(3000);
									remove(cureS);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						});
						addObject(cureS);
						cureStarted = true;
					}
					if(cureStarted){
						if(PlagueS.date.cure.getCurePercentage() % 10 == 0 )
						{
							System.out.println(PlagueS.date.cure.getCurePercentage() + "%");
							Button cureB = new Button(getWidth()/6, getHeight()/3,900,100,"Research for cure to " + PlagueS.Iscreen.getbName() + " is at "+ PlagueS.date.cure.getCurePercentage() + " percent",Color.black,null);
							cureB.setAction(new Action(){
								
								@Override
								public void act() {
									// TODO Auto-generated method stub
									try {
										Thread.sleep(3000);
										remove(cureB);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								
							});
							addObject(cureB);
						}
							
					}
				}
				
			}
			
		});
		cure.start();
	}
	
	private void endGame(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		Thread checkEnd = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					boolean endGame = true;
					int count = 0;
					for(int i = 0; i< butts.size(); i++)
					{
						if(!butts.get(i).isDestroyed())
						{
							endGame = false;
						}
						else{
							count++;
						}
					}

					if(endGame || count > 47)

					{
						PlagueS.date.setGameOn(false);
						adding = false;
						Button end =  new Button(getWidth()/6, getHeight()/3,900,100,"COngratz, " + PlagueS.Iscreen.getbName() + " has exterminated humanity",Color.black,null);
						end.setForeground(Color.white);
						end.setAction(new Action(){

							@Override
							public void act() {
								// TODO Auto-generated method stub
								end.setText(PlagueS.Iscreen.getbName() + " has ended humanity in " + PlagueS.date.getCount() + " days");
								try {
									for(int i = 0; i< butts.size(); i++)
									{
										butts.get(i).setEnabled(false);
									}
									Thread.sleep(1000);
									remove(end);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}							
							}
							
						});
						addObject(end);
					}
					
				}
			}
			
		});
		checkEnd.start();
	}
	
	private void getWorld() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i< butts.size(); i++)
		{
			worldPop += butts.get(i).getPopulation();
			worldInfected += butts.get(i).getInfectedPop();
		}
	}


	public static int getWorldPop() {
		return worldPop;
	}


	public static int getWorldInfected() {
		return worldInfected;
	}


	private void startingDNA(List<Visible> viewObjects){
			Thread addPoints = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true && adding)
					{
						try {
							//System.out.println("Thread running");
							int randTime = 1000 * (int) (Math.random() * 8 + 4);
							if(findInfected() != null)
							{
								State randomInfectedState = findInfected();
								ClickableGraphic clickMe = new ClickableGraphic(randomInfectedState.getX()+10, randomInfectedState.getY()+10, 1.0, "Images/dnapoints.png");
								randomInfectedState.setEnabled(false);
								//System.out.println("Balloon being created");
								clickMe.setAction(new Action(){
									
									@Override
									public void act() {
										// TODO Auto-generated method stub
										DNA = DNA + 5;
										dnapoints.setText(DNA + " points");
										//System.out.println(""+DNA);
										randomInfectedState.setEnabled(true);
										remove(clickMe);
									}
									
								});
								addObject(clickMe);
								Thread.sleep(3500);
								if(viewObjects.contains(clickMe))
								{
									randomInfectedState.setEnabled(true);
									remove(clickMe);
								}
							}
							Thread.sleep(randTime);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
					}
				}
			});
			addPoints.start();
			
	}
	
	private State findInfected() {
		// TODO Auto-generated method stub
		ArrayList<State> infected = new ArrayList<State>();
		for(int i = 0; i<butts.size();i++)
		{
			if(butts.get(i).isInfected() && !butts.get(i).isDestroyed())
			{
				infected.add(butts.get(i));
			}
		}
		if(infected.size() > 0)
		{
			int rand = (int) (Math.random() * infected.size());
			return infected.get(rand);						
		}
		else
			return null;
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
			dead = new TextLabel(40,270,1000,50,"Dead: ");
			dead.setSize(25);
		}
		else
		{
			name.setText("State: " + s.getName());
			population.setText("Population: " + s.getPopulation());
			infected.setText("Infected: " + s.getInfectedPop());
			dead.setText("Dead: " + s.getDeadPop());
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
				State but = new State(startX,startY,55,110,"T",null,names[i], 6360, null);//636000
				but.setAction(new Action(){

					@Override
					public void act() {
						// TODO Auto-generated method stub
						state = but;
						
						if(!infectionStarted)
						{
							infectionStarted = true;
							state.infect();
							check.start();
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
  