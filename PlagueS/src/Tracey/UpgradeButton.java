/**
 * 
 */
package Tracey;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

/**
 * @author Student8
 *
 */
public class UpgradeButton extends Button {

	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param text
	 * @param color 
	 * @param action
	 */
	private boolean isClicked;
	
	public UpgradeButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		isClicked = false;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param text
	 * @param action
	 */
	public UpgradeButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	
	protected void colorBackground(Graphics2D g, boolean hover){
		
	}
	
	public void resetClick(){
		isClicked = !isClicked;
	}

}
