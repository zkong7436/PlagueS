package main;
import Jimmy.Sleeper;
import JosephIvan.DemoScreen;
import Tracey.DiseaseScreen;
import Tracey.SymptomsScreen;
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
	static Sleeper date = new Sleeper();
	
	public PlagueS() {
		super(1200,900);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static PlagueS game;
	public static IntroScreen Iscreen;
	public static MainScreen Mscreen;
	public static DiseaseScreen Dscreen;
	public static SymptomsScreen Sscreen;
	public static TransmissionsScreen Tscreen;
	public static DemoScreen Cscreen;
	
	public static void main(String[] args){
		game = new PlagueS();
		Thread app = new Thread(game);
		app.start();
		
		date.run();
	}
	/* (non-Javadoc)
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		Iscreen = new IntroScreen(getWidth(),getHeight());
		Mscreen = new MainScreen(getWidth(), getHeight());
		
		Dscreen = new DiseaseScreen(getWidth(),getHeight());
		Tscreen = new TransmissionsScreen(getWidth(), getHeight());
		Sscreen = new SymptomsScreen(getWidth(), getHeight());
		
		Cscreen = new DemoScreen(getWidth(),getHeight());
				
		setScreen(Iscreen);
	}

}
