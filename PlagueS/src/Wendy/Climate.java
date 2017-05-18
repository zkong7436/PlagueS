package Wendy;



public class Climate {

	private double averageTemp;
	
	public static final Climate WARM_CLIMATE = new Climate(80);
	public static final Climate COLD_CLIMATE = new Climate(40);
	
	public Climate(double avgT) {
		averageTemp = avgT;
		// TODO Auto-generated constructor stub
	}

	public double getAverageTemp() {
		return averageTemp;
	}

	public void setAverageTemp(double averageTemp) {
		this.averageTemp = averageTemp;
	}

}
