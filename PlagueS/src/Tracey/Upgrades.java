package Tracey;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

/**
 * @author zkong7436
 */
public abstract class Upgrades extends FullFunctionScreen implements UpgradesInterface{

	public static Graphic background;
	public static Button tran;
	public static Button symp;
	
	public Upgrades(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
 
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0,80, 0.65,"Images/back.jpg");
		
		tran = new Button(0, 80, 200, 60, "Transmissions", Color.red, new Action(){

			@Override
			public void act() {
//				PlagueS.game.setScreen(new TransmissionsScreen(getWidth(), getHeight()));
			}
			
		});
		tran.setSize(20);
		viewObjects.add(background);
		viewObjects.add(tran);
	}
	
	public abstract void initItems(ArrayList<Visible> viewObjects);

}
