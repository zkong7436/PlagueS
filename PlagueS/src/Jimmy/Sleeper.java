package Jimmy;

import State;

public class Sleeper implements Runnable {
//xd////////
		private int number;
		private int second;
		private int days;
		private int month;
		private boolean gameOn = true;
		private boolean cureStarted = false;
		private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		private int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		private int year = 2017;
		private int dayYear;
		private Cure cure;
		private State state;
		public static int ten;
		

		public static void main(String[] args) {
			Thread one = new Thread(new Sleeper());
			one.start();
		}

		public Sleeper() {
			this.second = (int) (1000);
			this.cure = new Cure();
			
		}

		public void run() {
			try {
				while(gameOn){
					Thread.sleep(second);
					days++;
					dayYear++;
					ten++;
						if(daysPerMonth[month] < days){
							days = 1;
							month++;
						}
						if(dayYear > 365){
							dayYear = 1;
							month = 0;
							year++;
						}
					System.out.println("Day " + days + " Month " + months[month] + " Year " + year);
						cure.isDetected();
					}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
}
