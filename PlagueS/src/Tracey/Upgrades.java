package Tracey;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

/**
 * @author zkong7436
 */
public abstract class Upgrades extends FullFunctionScreen implements UpgradesInterface{

	public static Graphic background;
	public static ArrayList<UpgradeButton> buttons;
	public static UpgradeButton tran;
	public static UpgradeButton symp;
	public static UpgradeButton abil;
	
	public Upgrades(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	} 
 
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0,80, 0.65,"Images/back.jpg");
		buttons = new ArrayList<UpgradeButton>();
		
		tran = new UpgradeButton(0, 80, 200, 60, "Transmission", Color.white, new Action(){

			@Override
			public void act() {
				main.PlagueS.game.setScreen(new TransmissionsScreen(getWidth(), getHeight()));
				
			}
			
		});
		symp = new UpgradeButton(200, 80, 200, 60, "Symptoms", Color.white, new Action(){

			@Override
			public void act() {
				main.PlagueS.game.setScreen(new TransmissionsScreen(getWidth(), getHeight()));
			}
			
		});
		abil = new UpgradeButton(400, 80, 200, 60, "Abilities", Color.white, new Action(){

			@Override
			public void act() {
				main.PlagueS.game.setScreen(new TransmissionsScreen(getWidth(), getHeight()));
			}
			
		}); 
		
		tran.setSize(20);
		symp.setSize(20);
		abil.setSize(20);
		
		buttons.add(tran);
		buttons.add(symp);
		buttons.add(abil);
		viewObjects.add(background);
		viewObjects.addAll(buttons);
		initItems(viewObjects);
	}
	
	public abstract void initItems(List<Visible> viewObjects);

}
