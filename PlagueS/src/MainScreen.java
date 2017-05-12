import java.util.ArrayList;
import java.util.List;

import Wendy.State;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;


public class MainScreen extends FullFunctionScreen{
	
	private State state;
	private TextLabel name;
	private TextLabel infected;
	private TextLabel dead;

	public MainScreen(int width, int height) {
		super(width, height);

	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		state = new State("NY", 500, null);
		state.setInfectedPop(10);
		name = new TextLabel(50,100,1000,50,"State: " + state.getName());
		infected = new TextLabel(50,200,1000,50,"Infected: " + state.getInfectedPop());
		dead = new TextLabel(50,250,100,50,"Dead: " + state.getDeadPop());
		viewObjects.add(name);
		viewObjects.add(infected);
		viewObjects.add(dead);
		
		TextField ex = new TextField(50, 300, 200, 100, "This is a ex");
		viewObjects.add(ex);
	}



}
  