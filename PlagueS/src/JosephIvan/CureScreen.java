package JosephIvan;

public class CureScreen extends guiTeacher.GUIApplication{



	public CureScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		DemoScreen cure = new DemoScreen(1000,1000);
		setScreen(cure);		
	}

}
