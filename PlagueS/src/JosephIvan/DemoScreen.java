package JosephIvan;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
 import guiTeacher.userInterfaces.FullFunctionScreen;
 

public class DemoScreen extends FullFunctionScreen implements Runnable {
 
 
 
public DemoScreen(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

//s

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
//		DemoScreen d = new DemoScreen(1000,1000);
		TextLabel movementDisplay = new TextLabel(20, 40, 1000, 25, "hjkhk");
		PieChart p = new PieChart(300,300);
		viewObjects.add(movementDisplay);
		viewObjects.add(p);
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

 }