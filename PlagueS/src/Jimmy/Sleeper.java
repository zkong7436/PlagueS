package Jimmy;

import Wendy.State;

public class Sleeper implements Runnable {
//xd////////
		private int number;
		private int second;
		private int days;
		private boolean gameOn = true;
		private boolean cureStarted = false;
		private String[] months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		private int[] daysPerMonth = {31,28,31,31,31,31,31,31,31,31,3,31};
		private int year = 2017;
		private int dayYear;
		private Cure cure;
		private State state;
		

		public static void main(String[] args) {
			Thread one = new Thread(new Sleeper(1));
			one.start();
		}

		public Sleeper(int number) {
			this.number = number;
			this.second = (int) (2000);
			this.cure = new Cure();
			
		}

		public void run() {
			try {
				while(gameOn){
					Thread.sleep(second);
					days++;
					dayYear++;
					for(int i = 0; i > months.length; i++){
						for(int j = 0; j > 31; j++){
						if(daysPerMonth[j] > days){
							days = 1;
							i--;
						}
						if(dayYear > 365){
							dayYear = 1;
							year++;
						}
						System.out.println("Day " +days + "Month" + months[i] + "Year" + year);
						cure.isDetected();
					}
				}
			}
				
	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
}
