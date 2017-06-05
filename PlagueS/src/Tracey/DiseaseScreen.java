/**
 * 
 */
package Tracey;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;

/**
 * @author Wendigo
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
		TextLabel name = new TextLabel(100, 200, 100, 500, "Bacteria" );
		name.setCustomTextColor(Color.white);

		viewObjects.add(name);
	}

}
