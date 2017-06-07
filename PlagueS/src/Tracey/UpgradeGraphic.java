/**
 * 
 */
package Tracey;

import guiTeacher.components.ClickableGraphic;

/**
 * @author Nai
 *
 */
public class UpgradeGraphic extends ClickableGraphic {

	
	private boolean clicked;
	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param imageLocation
	 */
	public UpgradeGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param scale
	 * @param imageLocation
	 */
	public UpgradeGraphic(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	} 

	/**
	 * @param x
	 * @param y
	 * @param imageLocation
	 */
	public UpgradeGraphic(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		clicked = false;
		// TODO Auto-generated constructor stub
	}

	public void setClicked() {
		clicked = !clicked;
		// TODO Auto-generated method stub
		
	}

	public boolean getClicked() {
		// TODO Auto-generated method stub
		return clicked;
	}

}
