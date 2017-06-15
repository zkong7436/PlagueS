/**
 * 
 */
package Tracey;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.TextColoredLabel;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;

/**
 * @author zkong7436
 *
 */
public class DiseaseScreen extends Upgrades {

	/**
	 * @param width
	 * @param height
	 */
	
	public DiseaseScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Tracey.Upgrades#initItems(java.util.List)
	 */
	@Override
	public void initItems(List<Visible> viewObjects) {
		//name entered in the beginning
		TextLabel name = new TextLabel(70, 200, 700, 200, "This is your bacteria");
		name.setCustomTextColor(Color.white);
		name.setSize(40);
		
		viewObjects.add(name);
	}
	

}
