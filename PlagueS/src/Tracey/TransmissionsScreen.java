/**
 * 
 */
package Tracey;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import guiTeacher.components.Action;
import Tracey.UpgradeGraphic;
import guiTeacher.components.TextColoredLabel;
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
	private ArrayList<UpgradeGraphic> tools;
	private ArrayList views;
	
	
	private int startY = 180;
	private int j;
	private int ph;
	
	public TransmissionsScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initItems(List<Visible> viewObjects) {
		File[] resources = new File("Images/trans/").listFiles();
		tools = new ArrayList<UpgradeGraphic>();
		views = new ArrayList();
		
		String desc[] = {"Gives pathogen ability to travel on dust particles. Increase infectivity, especially in arid environments and plane transmission", 
				"Birds become susceptible to infection. Avian carriers increase infectivity, land transmission and mutation",
				"Gives organism ability to spread through blood to blood contact. Increases infectivity, especially in poor regions and mutation chance", 
				"Insects susceptible to infection. Carrier insects increase infectivity, especially in hot climates and chance of mutation",
				"Livestock susceptible to infection. Increase infectivity, especially in rural regions and mutation",
				"Common flea susceptible to infection. Increase infectivity, especially in urban regions and mutation",
				"Pathogen can survive outside the body in fresh, warm water. Increase infectivity, especially in humid environments and ship transmission"};
		
		
		for(int j=0; j<resources.length; j++){
			TextColoredLabel des = new TextColoredLabel(900,180,200,40,getTransmission(resources[j].getName()), Color.black, Color.white);
			TextColoredLabel det = new TextColoredLabel(900,220,200,170,desc[j], Color.black, Color.white);
			des.setSize(20);
			det.setSize(16);
			UpgradeGraphic pic = new UpgradeGraphic(50, 180+(j*80), "Images/trans/" + resources[j].getName());
			pic.setAction(new Action(){
				public void act(){
					viewObjects.removeAll(views);
					pic.setClicked();
					if(pic.getClicked()){
						views.add(des);
						views.add(det);
						viewObjects.addAll(views);
					}
				}
			});
			tools.add(pic);
		}

		viewObjects.addAll(tools);
	}
	
	public String getTransmission(String location){
		for(int i=0; i<location.length(); i++){
			if(location.substring(i,i+1).equals("_")){
				return location.substring(0,i);
			}
		}
		return "";
	}

	
}
