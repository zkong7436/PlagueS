/**
 * 
 */
package Tracey;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
	private ArrayList<TextColoredLabel> descriptions;
	
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
		descriptions = new ArrayList<TextColoredLabel>();
		
		for(int i=0; i<resources.length; i++){
			TextColoredLabel des = new TextColoredLabel(900,180,200,40,getTransmission(resources[i].getName()), Color.black, Color.white);
			des.setCustomTextColor(Color.white);
			des.setSize(20);
			descriptions.add(des);
		}
		
		ph = 0;
		for(j=0; j<resources.length; j++){
			UpgradeGraphic pic = new UpgradeGraphic(10, 180+(j*80), "Images/trans/" + resources[j].getName());
			pic.setAction(new Action(){
				public void act(){
					pic.setClicked();
					if(pic.getClicked()) viewObjects.add(descriptions.get(ph));
					else viewObjects.remove(descriptions.get(ph));
					ph++;
				}
			});
			tools.add(pic);
		}
//		TextColoredLabel description = new TextColoredLabel(900,180,200,40,getTransmission(resources[0].getName()), Color.black, Color.white);
//		description.setCustomTextColor(Color.white);
//		description.setSize(20);
//		
//		UpgradeGraphic sample = new UpgradeGraphic(10, 180, "Images/trans/Bird1_transmission.png");
//		sample.setAction(new Action(){
//			public void act(){
//				sample.setClicked();
//				if(sample.getClicked()) viewObjects.add(description);
//				else viewObjects.remove(description);
//			}
//		});
//		
//		viewObjects.add(sample);
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
