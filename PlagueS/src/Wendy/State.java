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
		Thread stateStart = new Thread(this);
		stateStart.start();
		adStates = new ArrayList<State>();
		findAdStates();
		System.out.println("Finding ad states");
	}
	
	public void run() {
		while(isInfected())
		{
			
		}
	}
	
	public void findAdStates(){
		for(int i = 0; i< main.MainScreen.getButts().size();i++)
		{
			if(Math.sqrt(Math.pow(getX() - main.MainScreen.getButts().get(i).getX(),2) + Math.pow(getY() - main.MainScreen.getButts().get(i).getY(),2)) <= getWidth()*2 && !main.MainScreen.getButts().get(i).getName().equals(getName()))
			{
				System.out.println(getWidth());
				adStates.add(main.MainScreen.getButts().get(i));
				System.out.println(main.MainScreen.getButts().get(i).getName());
			}
		
		}
	}


}
