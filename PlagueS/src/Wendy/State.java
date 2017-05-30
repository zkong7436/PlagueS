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
	private double resisitance = 1.18954723;
	//private double percentInfected = (double)(infectedPop/population);
	
	private final int POPULATION_US = getPopulation();
	
	
	public State(int x, int y, int w, int h, String text, Action action, String name, int population, Climate climate) {
		super(x, y, w, h, text,Color.blue, action);
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
		System.out.println("Finding ad states");
		//run();
	}
	
	public void run() {
		while(isInfected())
		{
			try {
				int randomTime = 1000*(int)(Math.random() * 10);
				System.out.println("THE INFECTION IS NOW SPREADING");
				//rateOfInfection = 1 + (0.1 * resisitance);
//				if((int) (rateOfInfection * infectedPop) > population)
//				{
//					infectedPop = population - deadPop;
//				}
//				else{					
//					infectedPop = (int) (rateOfInfection * infectedPop);
				infectedPop+= 5;
//				}
				Thread.sleep(randomTime);
				//resisitance = Math.pow(Math.E/3*2, resisitance);
				System.out.println("" + infectedPop);
				if(infectedPop >= population * 0.55)
				{
					int spread = (int)(Math.random() * 2 );
					while(spread > 0 && adStates.size() > 0)
					{
						System.out.println("INFECTION IS NOW SPREADING TO OTHER STATE");
						int ran = (int) (Math.random() * adStates.size());
						adStates.get(ran).infect();	
						adStates.remove(ran);
						if(infectedPop >= population * 0.7)
						{
							setForeground(Color.pink);
							if(infectedPop >= population * 0.8)
							{
								if(infectedPop >= population * 0.9)
								{
									System.out.println("People are now dying" + deadPop);
									Thread.sleep(3000);
									deadPop+= 5;
								}
								else{
									Thread.sleep(5000);
									deadPop+= 2;
								}
							}
							else{
								Thread.sleep(8000);
								deadPop+= 1;
							}
						}
						spread--;
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
