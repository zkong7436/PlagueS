package Jimmy;

import Wendy.State;

public class Cure {
	
	private int curePercentage= 0;
	private double infectedPercentage = 0;
	private double popDeadPercentage;
	
	public boolean activate = false;
	private int counter = 0;	
	private int counter2 = 0;
	private int counter3 = 0;
	private boolean win = true;
	public Cure() {
		
	}
	
	public boolean getWin() {
		return win;
		
	}
	
	public void isDetected(){
		//while every second passes
		//infected = State.getInfectedpop
		
		if(infectedPercentage == 0) {
			System.out.println("The diseased has been erased from this world. You have lost");
			win = false;
		}
		if (curePercentage < 100 && counter < 1) {
			if(infectedPercentage >= 20) {
				System.out.println("cure has started");
				if(infectedPercentage == 100) {
					cureBase(5);
				}else if (infectedPercentage >= 60){
					cureBase(10);
				}else{
					cureBase(20);
				}
				
					
			}
			if(infectedPercentage >= 10 && counter2 < 1){
				System.out.println("A new disease is discovered in the us");
				counter2++;
				
			}
			else if(infectedPercentage >= 0 && infectedPercentage < 10){
				System.out.println("Currently the percentage of the infected population is " + infectedPercentage);
				infectedPercentage++;
			}
			
		}else{
			
			if(counter3 < 1) {
				System.out.println("Cure has been completed and is being delivered around the world");
				counter3++;
				counter++;
			}
			spreadCure(1);
			System.out.println("Infected percentage is now " + infectedPercentage);
			
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

//		else{
//			System.out.println("Cure will be completed in " + b/365 + " year(s)");
//		}

		else{
			System.out.println("Cure will be completed in " + b/365 + " year(s)");
		}

		
	}
	
	public void cureBase(int base) {
		if(Sleeper.ten % base == 0 ){
	
		curePercentage++;

		System.out.println("cure is " + curePercentage + "% completed");
		System.out.println("Infected percentage is " + infectedPercentage + "%");
		
		if(infectedPercentage < 100) {
			infectedPercentage++;
		}
		

		makingCure(base);
	 
		}
	}	
	
	public void spreadCure(int base){
		if(Sleeper.ten % base == 0 ){
			infectedPercentage--;
			System.out.println(infectedPercentage + "% infected :(");		 
		}		
	}
}
