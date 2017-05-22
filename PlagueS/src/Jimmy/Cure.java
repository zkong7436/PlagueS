package Jimmy;

import Wendy.State;

public class Cure {
	
	private int cure= 0;
	private double infectedPercentage = 61;
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
			//run cure method counter
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
	
	public void makingCure(int rate){
		int a = (rate * 100)/365;
		if(a == 0){
			System.out.println("Cure has not been started");
		}
		else{
			System.out.println("Cure will be completed in " + a + " years");
		}
		
	}
	
	public void cureBase(int base) {
		if(Sleeper.ten % base == 0 ){
		System.out.println(cure);
		cure++; 
		infectedPercentage--;
		makingCure(base);
		}
	}	
	
	public boolean finishedCure(){
		return false;
		
	}
}
