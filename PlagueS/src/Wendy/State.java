package Wendy;

public class State {
	
	private String name;
	private Climate climate;
	private int population;
	private boolean infected;
	private boolean destroyed;
	private int infectedPop;
	private int deadPop;
	private int alivePop = population - deadPop;
	private int notInfectedPop = population - infectedPop;
	private double percentInfected = (double)(infectedPop/population);
	
	private final int POPULATION_US = getPopulation();
	
	private String[] names = {"California","Texas","Florida","New York","Pennsylvania","Illinois","Ohio","Georgia","North Carolina","Michigan","New Jersey","Virginia","Washington","Arizona","Massachusetts","Tennessee","Indiana","Missouri","Maryland","Wisconsin","Colorado","Minnesota","South Carolina","Alabama","Louisiana","Kentucky","Oregon","Oklahoma","Connecticut","Puerto Rico","Iowa","Utah","Mississippi","Arkansas","Nevada","Kansas","New Mexico","Nebraska","West Virginia","Idaho","Hawaii","New Hampshire","Maine","Rhode Island","Montana","Delaware","South Dakota","North Dakota","Alaska","Wyoming","Vermont"};
	//location of the state name of images
	

	public State(String name, int population, Climate climate) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.climate = climate;
		this.population = population;
	}
	
	public int getInfectedPop() {
		return infectedPop;
	}

	public void setInfectedPop(int infectedPop) {
		this.infectedPop = infectedPop;
	}

	public int getDeadPop() {
		return deadPop;
	}

	public void setDeadPop(int deadPop) {
		this.deadPop = deadPop;
	}

	public int getAlivePop() {
		return alivePop;
	}

	public void setAlivePop(int alivePop) {
		this.alivePop = alivePop;
	}

	public int getNotInfectedPop() {
		return notInfectedPop;
	}

	public void setNotInfectedPop(int notInfectedPop) {
		this.notInfectedPop = notInfectedPop;
	}

	public double getPercentInfected() {
		return percentInfected;
	}

	public void setPercentInfected(double percentInfected) {
		this.percentInfected = percentInfected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Climate getClimate() {
		return climate;
	}

	public void setClimate(Climate climate) {
		this.climate = climate;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean isInfected() {
		return infected;
	}

	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}


}
