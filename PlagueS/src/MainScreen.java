import java.util.ArrayList;

import GUIpractice.ClickableScreen;
import GUIpractice.components.Visible;
import Wendy.Stats;


public class MainScreen extends ClickableScreen implements MainScreenInterface{

	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public abstract void initRemainingItems(ArrayList<Visible> viewObjects); 

}
  