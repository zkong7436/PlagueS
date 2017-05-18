/**
 * 
 */
package Tracey;

import java.util.ArrayList;

import guiTeacher.interfaces.Visible;

/**
 * @author zkong7436
 *
 */
public class TransmissionsScreen extends Upgrades {

	/**
	 * @param width
	 * @param height
	 */
	private boolean opened;
	
	public TransmissionsScreen(int width, int height) {
		super(width, height);
		opened = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initItems(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isOpened(){
		return opened;
	}
}
