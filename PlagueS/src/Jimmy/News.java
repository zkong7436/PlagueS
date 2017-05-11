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
