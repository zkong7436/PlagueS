/**
 * 
 */
package Tracey;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.TextLabel;
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
	private ArrayList<ClickableGraphic> tools;
	
	
	public TransmissionsScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initItems(List<Visible> viewObjects) {
		tools = new ArrayList<ClickableGraphic>();
		
		TextLabel description = new TextLabel(400,180,100,500,"Bird1");
		
		ClickableGraphic sample = new ClickableGraphic(10, 180, "Images/trans/Bird1_transmission.png");
		
		viewObjects.add(sample);
		viewObjects.add(description);
	}

	
}
