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
	public static ArrayList<UpgradeButton> buttons;
	
	public Upgrades(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	} 
 
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0,80, 0.65,"Images/back.png");
		buttons = new ArrayList<UpgradeButton>();
		
		UpgradeButton dise = new UpgradeButton(0, 80, 200, 60, "Disease", Color.gray, new Action(){

			@Override
			public void act() {
				main.PlagueS.game.setScreen(main.PlagueS.game.Dscreen);
				
			}
			
		});
		UpgradeButton tran = new UpgradeButton(200, 80, 200, 60, "Transmission", Color.gray, new Action(){

			@Override
			public void act() {
				main.PlagueS.game.setScreen(main.PlagueS.game.Tscreen);
				
			}
			
		});
		UpgradeButton symp = new UpgradeButton(400, 80, 200, 60, "Symptoms", Color.gray, new Action(){

			@Override
			public void act() {
				main.PlagueS.game.setScreen(main.PlagueS.game.Tscreen);
			}
			
		});
		UpgradeButton abil = new UpgradeButton(600, 80, 200, 60, "Abilities", Color.gray, new Action(){

			@Override
			public void act() {
				main.PlagueS.game.setScreen(main.PlagueS.game.Tscreen);
			}
			
		});
		Button exit = new Button(1100, 80, 70, 70, "X", Color.gray, new Action(){
			
			@Override
			public void act() {
				main.PlagueS.game.setScreen(main.PlagueS.game.Mscreen);
			}
		});
		
		exit.setCurve(50,50);
		
		dise.setSize(20);
		tran.setSize(20);
		symp.setSize(20);
		abil.setSize(20);
		
		exit.setSize(25);
		
		buttons.add(dise);
		buttons.add(tran);
		buttons.add(symp);
		buttons.add(abil);
		viewObjects.add(background);
		viewObjects.addAll(buttons);
		viewObjects.add(exit);
		initItems(viewObjects);
	}
	
	public abstract void initItems(List<Visible> viewObjects);

}
