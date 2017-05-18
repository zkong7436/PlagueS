package Jimmy;

import State;

public class Cure {
	
	private int cure= 0;
	private double infectedPercentage = 40;
	private double popDeadPercentage;
	
	public boolean activate = false;
	private int counter = 0;	

	public Cure() {
		
	}
	
	
	public boolean isDetected(){
		//while every second passes
		//infected = State.getInfectedpop
		
		if(infectedPercentage >= 20 || popDeadPercentage >= 3) {
			System.out.println("cure has started");
			
			//say cure starts
			//run cure method counterr
			if (infectedPercentage >= 60) {
				cureBase(10);
			}else if(infectedPercentage >= 40) {
				cureBase(15);
			}else
			cureBase(20);
		}
		if(infectedPercentage >= 10 && counter < 1){
				//say disease found in u.s
			System.out.println("cure has ENDED");
			counter++;
			
		}
		return false;
	}
	
	public void makingCure(){
		int rate;
		
	}
	
	public void cureBase(int base) {
		if(Sleeper.ten % base == 0 ){
		System.out.println(cure);
		cure++;
		}
	}
	
	
	public boolean finishedCure(){
		return false;
		
	}
}
