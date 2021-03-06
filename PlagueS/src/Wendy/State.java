package Wendy;




import java.awt.Color;
import java.util.ArrayList;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class State extends Button implements Runnable{
	
	private ArrayList<State> adStates;
	private  String name;
	private  Climate climate;
	private  int population;
	private  boolean infected;
	private  boolean destroyed;
	private  int infectedPop;
	private  int deadPop;
	private  int alivePop = population - deadPop;
	private  int notInfectedPop = population - infectedPop;
	private double rateOfInfection;
	private double transmission = 2.5;
	//private double percentInfected = (double)(infectedPop/population);
	private boolean twentyfive;
	private boolean forty;
	private boolean fifty;
	private boolean eighty;
	private boolean ninty;
	private boolean infecting = true;
	private boolean startDying;
	private boolean dying;
	private boolean moreDying;
	private boolean dead;

	private int deathRate = 1;
	
	public double getTransmission() {
		return transmission;
	}


	public void setTransmission(double up) {
		System.out.println("+++++++++initial transmission"+transmission);
		transmission+=up;
		System.out.println("+++++++++new transmission:"+transmission);
	}


	public int getDeathRate() {
		return deathRate;
	}


	public void setDeathRate(int dRate) {
		System.out.println("+++++++++initial death rate"+deathRate);
		deathRate += dRate;
		System.out.println("+++++++++new death rate:"+deathRate);
	}

	private final int POPULATION_US = getPopulation();
	
	
	public State(int x, int y, int w, int h, String text, Action action, String name, int population, Climate climate) {
		super(x, y, w, h, text,Color.white, action);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.climate = climate;
		this.population = population;
		update();
	}
	
	public int getInfectedPop() {
		return infectedPop;
	}

	public void setInfectedPop(int infectedPop) {
		this.infectedPop = infectedPop;
	}

	public int getDeadPop() {
		return deadPop;
	}

	public void setDeadPop(int deadPop) {
		this.deadPop = deadPop;
	}

	public int getAlivePop() {
		return alivePop;
	}

	public void setAlivePop(int alivePop) {
		this.alivePop = alivePop;
	}

	public int getNotInfectedPop() {
		return notInfectedPop;
	}

	public void setNotInfectedPop(int notInfectedPop) {
		this.notInfectedPop = notInfectedPop;
	}

//	public double getPercentInfected() {
//		return percentInfected;
//	}
//
//	public void setPercentInfected(double percentInfected) {
//		this.percentInfected = percentInfected;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Climate getClimate() {
		return climate;
	}

	public void setClimate(Climate climate) {
		this.climate = climate;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean isInfected() {
		return infected;
	}

	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public void infect(){
		setInfected(true);
		infectedPop = 1;
		Thread stateStart = new Thread(this);
		stateStart.start();
		adStates = new ArrayList<State>();
		findAdStates();
		//System.out.println("Finding ad states");
		//run();
	}
	
	public void run() {
		while(isInfected())
		{
			try {
				int randomTime = 1000*(int)(Math.random() * 4);
				//System.out.println("THE INFECTION IS NOW SPREADING");
				rateOfInfection = rateOfInfection + transmission;
				if(infectedPop + rateOfInfection < population && infecting)
				{
					infectedPop = (int) (rateOfInfection + infectedPop);
					System.out.println(""+transmission);
				}
				else{					
					if(population - deadPop >= 0)
					{
						infectedPop = population;
						infecting = false;						
					}
				}
				Thread.sleep(randomTime);
				//System.out.println("" + infectedPop);
				if(infectedPop >= population * 0.25 && !twentyfive && infectedPop < population * 0.4)
				{
					setBackground(new Color(255,204,204));
					twentyfive = true;
					update();
				}
				else if(infectedPop >= population * 0.4 && infectedPop <= population * 0.5)
				{
					if(!forty)
					{
						setBackground(Color.pink);
						forty = true;		
						update();
					}
					int spread = (int)(Math.random() * 2 +1);
					while(adStates.size() > 0 && spread > 0 )
					{
						//System.out.println("INFECTION IS NOW SPREADING TO OTHER STATE");
						int ran = (int) (Math.random() * adStates.size());
						adStates.get(ran).infect();	
						spread--;
						adStates.remove(ran);
					}
				}
				else if(infectedPop >= population * 0.5)
				{
					if(!fifty)
					{
						//setBackground(new Color(255, 204, 204));
						setBackground(new Color(240,128,128));
						fifty = true;		
						update();
					}
					else if(infectedPop >= population * 0.8)
					{
						if(!eighty)
						{
							setBackground(Color.red);
							eighty =true;	
							update();
						}else if(infectedPop >= population * 0.95)
						{
							if(!ninty)
							{
								setBackground(new Color(139,0,0));
								ninty = true;
								update();
							}
							//System.out.println("People are now dying" + deadPop);
							Thread.sleep(8000);

							if(deadPop < population && deadPop + deathRate + 20 < population)
							deadPop+= deathRate + 20;
							if(deadPop > 1 && !startDying)
							{
								setBackground(new Color(168,168,168));
								startDying = true;
								update();
							}
							if(deadPop > population * 0.3 && deadPop < population * 0.65)
							{
								if(!dying)
								{
									setBackground(Color.gray);
									dying = true;
									update();
								}
								Thread.sleep(4000);

								if(deadPop < population && deadPop + deathRate + 20 < population)
								deadPop+= deathRate + 30;
								else{
									deadPop = population;
									infectedPop = 0;
									destroyed = true;
									setInfected(false);
								}
							}
							else{
								if(deadPop > population * 0.65)
								{
									if(!moreDying)
									{
										setBackground(new Color(88,88,88));
										moreDying = true;
										update();
									}
									if(deadPop >population * 0.9 && !dead)
									{
										setBackground(Color.BLACK);
										dead = true;
										update();
									}
//									if(deadPop >= population)
//									{
//										deadPop = population;
//										infectedPop = 0;
//										destroyed = true;
//										setInfected(false);
//									}						
									Thread.sleep(2000);

									if(deadPop < population && deadPop + deathRate + 70 < population)
									deadPop += deathRate + 40; 
									else
									{
										deadPop = population;
										infectedPop = 0;
										destroyed = true;
										setInfected(false);
									}
								}
							}
						}

					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void findAdStates(){
		for(int i = 0; i< main.MainScreen.getButts().size();i++)
		{
			if(Math.sqrt(Math.pow(getX() - main.MainScreen.getButts().get(i).getX(),2) + Math.pow(getY() - main.MainScreen.getButts().get(i).getY(),2)) <= getWidth()*2 && !main.MainScreen.getButts().get(i).getName().equals(getName()))
			{
				adStates.add(main.MainScreen.getButts().get(i));
				//System.out.println(main.MainScreen.getButts().get(i).getName());
			}
		
		}
	}


}
