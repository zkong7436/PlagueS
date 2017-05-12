import java.util.ArrayList;

import GUIpractice.ClickableScreen;
import GUIpractice.components.TextLabel;
import GUIpractice.components.Visible;
import Wendy.State;


public class MainScreen extends ClickableScreen{
	
	private State state;
	private TextLabel name;
	private TextLabel infected;
	private TextLabel dead;

	public MainScreen(int width, int height) {
		super(width, height);

	}


	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		state = new State("NY", 500, null);
		state.setInfectedPop(10);
		name = new TextLabel(50,50,1000,50,"State: " + state.getName());
		infected = new TextLabel(50,150,1000,50,"Infected: " + state.getInfectedPop());
		dead = new TextLabel(50,200,100,50,"Dead: " + state.getDeadPop());
		viewObjects.add(name);
		viewObjects.add(infected);
		viewObjects.add(dead);
	}



}
  