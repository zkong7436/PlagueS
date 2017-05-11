import java.util.ArrayList;

import Wendy.Stats;
import guiPractice.components.ClickableScreen;
import guiPractice.components.Visible;

public class MainScreen extends ClickableScreen{

	public MainScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		
		Stats s = new Stats(50,50,300,500);
		
		viewObjects.add(s);
	}

}
  