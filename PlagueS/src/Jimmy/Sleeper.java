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
		private String[] daysPerMonth = {"32","28","31","31","31","31","31","31","31","31","31","31"};
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
					System.out.println("Day " +days);
					cure.isDetected();
				}
				
	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
}
