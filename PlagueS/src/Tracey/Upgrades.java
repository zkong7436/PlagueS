package Tracey;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

/**
 * @author zkong7436
 */
public abstract class Upgrades extends FullFunctionScreen{

	public static Graphic background;
	
	public Upgrades(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
 
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0,0,"Images/back.jpg");
	}

}
