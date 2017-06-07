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
		TextLabel name = new TextLabel(70, 200, 200, 700, "Bacteria");
		name.setCustomTextColor(Color.white);
		name.setSize(40);
		
		//separate lines
		//add the starting country
		//daily infections
		//daily deaths
		TextColoredLabel data = new TextColoredLabel(70, 270, 200, 40, "Start Location:", Color.black, Color.white);
		data.setSize(20);
		TextColoredLabel loca = new TextColoredLabel(70, 300, 200, 40, "Korea", Color.black, Color.white);
		loca.setSize(18);
		TextColoredLabel data2 = new TextColoredLabel(70, 500, 300, 200, "Start Location" + System.lineSeparator() + "Korea", Color.black, Color.white);
		data.setSize(20);

		viewObjects.add(name);
		viewObjects.add(data);
		viewObjects.add(loca);
		viewObjects.add(data2);
	}

}
