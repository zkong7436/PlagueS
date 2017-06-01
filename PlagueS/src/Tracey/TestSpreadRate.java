/**
 * 
 */
package Tracey;

/**
 * @author Student 6
 *
 */
public class TestSpreadRate implements Runnable{

	private static int POP = 636000;
	private static int infectedPop;
	private static int spreadRate;
	private static boolean infected;
	private static int second;
	/**
	 * 
	 */
	public TestSpreadRate() {
		infected = true;
		second = (int)(1000);
		infectedPop = 1;
		spreadRate = 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread one = new Thread(new TestSpreadRate());
		one.start();		
	}
	
	public void run(){
		while(isInfected()){
			try {
				Thread.sleep(second);
				System.out.println("Infected population: "+infectedPop);
				infectedPop+=(int)((Math.random()*4)+spreadRate);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static boolean isInfected() {
		return true;
	}
	private static void setInfected(boolean i){
		infected  = i;
	}

}
