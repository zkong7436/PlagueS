package main;
import Tracey.TransmissionsScreen;
import guiTeacher.GUIApplication;

/**
 * @author zkong7436
 *
 */
public class PlagueS extends GUIApplication {

	/**
	 * 
	 */
	public PlagueS() {
		super(1200,900);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static PlagueS game;
	public static IntroScreen Iscreen;
	public static MainScreen Mscreen;
	
	public static TransmissionsScreen test;
	
	public static void main(String[] args){
		game = new PlagueS();
		Thread app = new Thread(game);
		app.start();
	}
	/* (non-Javadoc)
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		Iscreen = new IntroScreen(getWidth(),getHeight());
		Mscreen = new MainScreen(getWidth(), getHeight());
		test = new TransmissionsScreen(getWidth(), getHeight());
		setScreen(test);
	}

}
