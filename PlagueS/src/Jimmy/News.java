package Jimmy;

import java.util.ArrayList;

public class News {
	private String state;//get this from somewhere
	private String curePercent;//get this from my cure class
	private String currentNews; //what the news is currently displaying.
	private ArrayList<String> allNews = new ArrayList<String>(); //clicking on a button will
	//display all the news. This should be in the news button. 
	private String[] randomNews = {""};
	
	private String[] infectionNews = {"The plague begins in " + state, ""};
	
	private String[] cure = {"The plague is detected in " + state + " and scientists have started working on a cure", 
			"The cure has reached " + curePercent + "% completion",
			"The cure has reached 100% completion is is now being sent around the country"};
	
	private String[] currentEvents = { "The results are in, and the president of the United States is Donald J Trump!",
			"Festival of Love in <name of country>: <name of country> celebrates the Festival of Love. Fans praise the replacement of International Kissing Day. Critics question hygiene standards",
			"Billions of dollars of damage caused in <country>. WHO expects it will take years to repair the damage caused to thousands of businesses, homes and research facilities.",
			"The investment bank reported catastrophic losses today due to a technical error in their random number generator",
			"Tsunami hits <country>: Extreme tsunami hits <country>. WHO analysts expect significant property damage and electricity shortages",
			 
	};
			
	public News(String news) {
		currentNews = news;
	} 
	
	public String getCurrentNews() {
		return currentNews;
	}
	
	public void setCurrentNews(String currentNews) {
		this.currentNews = currentNews;
	}
	
	
}
