package Jimmy;

import Wendy.State;

public class Cure {
	
	private int curePercentage= 0;
	private double infectedPercentage = 61;
	private double popDeadPercentage;
	
	public boolean activate = false;
	private int counter = 0;	

	public Cure() {
		
	}
	
	
	public void isDetected(){
		//while every second passes
		//infected = State.getInfectedpop
		if (curePercentage < 100) {
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
				System.out.println("A new disease is discovered in teh us");
				counter++;
				
			}
		}else{
			System.out.println("Cure has been completed and is being delivered around the world");
		}		
	}
	 
	public void makingCure(int rate){
		int a = (rate * 100);
		int b = (a - curePercentage*rate);
		if(curePercentage == 100){
			System.out.println("Cure is done!!");
		}	
		else if(a == 0){
			System.out.println("No Cure is currently being made");
		}
		else if(b < 365){
			System.out.println("Cure will be completed in " + b + " day(s)");
		}
		else{
			System.out.println("Cure will be completed in " + b/365 + " year(s)");
		}
		
	}
	
	public void cureBase(int base) {
		if(Sleeper.ten % base == 0 ){
		curePercentage++;
		System.out.println(curePercentage + "%");		 
//		infectedPercentage--;
		makingCure(base);
		 
		
		}
	}	
	
	public boolean finishedCure(){
		return false;
		
	}
}
