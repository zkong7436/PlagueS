package Jimmy;

import Wendy.State;
import guiTeacher.components.TextLabel;

public class Sleeper implements Runnable {
//xd////////
		private int number;
		private int second;
		public int days ;
		public int month;
		private boolean gameOn = true;
		private boolean cureStarted = false;
		public String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		private int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		public int year = 2017;
		private int dayYear;
		public Cure cure;

		private State state;
		public static int ten;
		private TextLabel display;
		private int count;
		

		public void setDisplay(TextLabel display) {
			this.display = display;
		}

		public boolean isGameOn() {
			return gameOn;
		}

		public void setGameOn(boolean gameOn) {
			this.gameOn = gameOn;
		}

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
					count++;
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
					if(display!=null){
						display.setText("Day " + days + " Month " + months[month] + " Year " + year);
					}
						System.out.println("Day " + days + " Month " + months[month] + " Year " + year);
						cure.isDetected();
						
					}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public int getCount() {
			return count;
		}
		
}
