package Jimmy;

import Wendy.State;

public class Cure {
	
	private double cure= 0;
	private double infectedPercentage;
	private double popDeadPercentage;
	private int infected = 100;
	public boolean activate = false;
	private int counter = 0;
	public static void main (String[] args){
		
	}
	
	public Cure() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isDetected(){
		//while every second passes
		//infected = State.getInfectedpop
		
		if(infected >= 20 || popDeadPercentage >= 3) {
			System.out.println("cure has started");
			infected = 10;
			//say cure starts
			//run cure method counterr
		}
		if(infected >= 10 && counter < 1){
				//say disease found in u.s
			System.out.println("cure has ENDED");
			counter++;
		}
		return false;
	}
	
	public void makingCure(){
		
	}
	
	public boolean finishedCure(){
		return false;
		
	}
}
