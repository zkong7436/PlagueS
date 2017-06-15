/**
 * 
 */
package Tracey;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Wendy.State;
import guiTeacher.components.Action;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.interfaces.Visible;

/**
 * @author zkong7436
 *
 */
public class SymptomsScreen extends Upgrades {

	/**
	 * @param width
	 * @param height
	 */
	private ArrayList<UpgradeGraphic> tools;
	private ArrayList views;
	private ArrayList<ClickableGraphic> evolves;
	
	
	private int points;
	private boolean[] used;
	private int[] pts ={2,4,2,9,8,2,5,2,2,5,4,7,3,5,7,4};
	
	public SymptomsScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initItems(List<Visible> viewObjects) {
		File[] resources = new File("Images/symps/").listFiles();
		tools = new ArrayList<UpgradeGraphic>();
		views = new ArrayList();
		int[] pts ={2,4,2,9,8,2,5,2,2,5,4,7,3,5,7,4};
		String[] desc = {"Pockets of infected flesh are painful and act as breeding grounds for the pathogen, increasing infection rates when burst.",
				"Chance of infection by spreading pathogen into surroundings, especially in high density, urban areas.",
				"Painful lumps containing pockets of the pathogen. Slight chance of bursting which can spread disease.",
				"Increase in temperature, contagiousness and severe dehydration, which can be fatal.",
				"Immune system produces inhibitors that destroy factor VIII, preventing blood clotting. Infectivity increased",
				"Increases likelihood of allergic reactions which can distract the immune system. Rich regions particularly vulnerable.",
				"Inflammation obstructs bodily processes. Swelling can obstruct breathing and be fatal.",
				"Inability to sleep makes people irritable and less productive.",
				"Irritated stomach lining leads to discomfort. Slight chance of infection when kissing.",
				"Irrational delusions and mental symptoms. Victims distrust of others makes them unlikely to seek treatment or cooperate with others.",
				"Serious fluid build and discharge from the lungs. People in cold climates especially vulnerable.",
				"Potentially fatal heart abnormality causes breakdown of respiratory system, releasing pathogen into the air.",
				"The skin becomes blistered and painful, slightly increasing infectivity.",
				"Fluid discharge through sneezing greatly increases infection rates.",
				"The loss of fluid through sweating also increases infection rates due to poor hygiene. More dangerous in cold countries.",
				"The expulsion of infected material through projectile vomiting increases the risk of infection."};
		used = new boolean[resources.length];
		
		
		for(int j=0; j<resources.length; j++){
			TextColoredLabel des = new TextColoredLabel(900,180,200,40,getSymptom(resources[j].getName()), Color.black, Color.white);
			TextColoredLabel det = new TextColoredLabel(900,220,200,170,desc[j], Color.black, Color.white);
			TextColoredLabel dnp = new TextColoredLabel(900,390,200,40,"-"+pts[j]+" DNA points", Color.black, Color.white);
			des.setSize(20);
			det.setSize(16);

			int temp = j;
			UpgradeGraphic pic = new UpgradeGraphic(50+(((j/4)*100)), 180+((j%4)*120), "Images/symps/" + resources[j].getName());
			pic.setAction(new Action(){
				public void act(){
					viewObjects.removeAll(views);
					views.clear();
					pic.setClicked();
					if(pic.getClicked()){
						views.add(des);
						views.add(det);
						views.add(dnp);
						points = temp;
						viewObjects.addAll(views);
					}
				}
			});
			tools.add(pic);
		}
		
		UpgradeButton evolve = new UpgradeButton(950, 430, 100, 40, "Evolve", Color.gray, null);
		evolve.setAction(new Action(){
			public void act(){
				if(pts[points] > 0){
					addSymptom(main.PlagueS.game.Mscreen.getButts(), points);
				}
			}
		});
		
		viewObjects.addAll(tools);
		viewObjects.add(evolve);
	}
	
	public String getSymptom(String location){
		for(int i=0; i<location.length(); i++){
			if(location.substring(i,i+1).equals(".")){
				return location.substring(0,i);
			}
		}
		return "";
	}
	
	public void addSymptom(ArrayList<State> states, int index){
		if(!used[index] && main.PlagueS.game.Mscreen.getDNA()>=pts[index]){
			for(State s: states){
				s.setDeathRate(pts[index]);
			}
			used[index]=true;
			main.PlagueS.game.Mscreen.setDNA((int)(pts[index]));
		}
	}

}
