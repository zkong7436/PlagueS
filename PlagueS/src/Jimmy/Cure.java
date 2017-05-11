package Jimmy;

import Wendy.State;

public class Cure {
	
	private double cure;
	private double infectedPercentage;
	private double popDeadPercentage = (double)(State.getDeadPop());
	private int infected;
	public boolean activate = false;
	
	
	
	public Cure() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isDetected(){
		//while every second passes
		//infected = State.getInfectedpop
		int counter = 0;
		if(infected >= 20 || popDeadPercentage >= 3) {
			//say cure starts
			//run cure method counterr
		}
		if(infected >= 10 && counter == 0){
				//say disease found in u.s
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
