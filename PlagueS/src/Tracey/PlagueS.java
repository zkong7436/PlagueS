/**
 * 
 */
package Tracey;

import guiPractice.GuiApplication;
import main.LockScreen;
import main.Pokedex;
import main.PokedexScreen;

/**
 * @author zkong7436
 *
 */
public class PlagueS extends GuiApplication {

	/**
	 * 
	 */
	public PlagueS() {
		// TODO Auto-generated constructor stub
	}

	public static PlagueS game;
	public static MainScreen screen;
	
	public static void main(String[] args){
		game = new PlagueS();
		Thread app = new Thread(game);
		app.start();
	}
	/* (non-Javadoc)
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub

	}

}
