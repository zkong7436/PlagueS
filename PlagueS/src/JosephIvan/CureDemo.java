package JosephIvan;

import Jimmy.Sleeper;

public class CureDemo extends guiTeacher.GUIApplication{

	static Sleeper date = new Sleeper();

	public CureDemo(int width, int height) {
		super(1000,1000);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		
		DemoScreen cure = new DemoScreen(1000,1000);
		setScreen(cure);		
	}
	public static void main (String[] args){
		CureDemo D = new CureDemo(1000,1000);
		
		Thread app = new Thread(D);
		app.start();
		date.run();
		
	
	}

}



