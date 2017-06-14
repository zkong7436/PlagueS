/**
 * 
 */
package Tracey;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.Utilities;
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
	
	public UpgradeButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
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
	
	public void drawBorder(Graphics2D g){
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
	}
	
	protected void colorBackground(Graphics2D g, boolean hover){
		if(getBackground() != null){
			if(!hover)g.setColor(getBackground());
			else{
				g.setColor(Utilities.lighten(Color.red, .4f));
//				g.setColor(getBackground());
			}
			g.fillRect(0, 0, getWidth(), getHeight());
		}else{
			clear();
		}
	}
	

}
