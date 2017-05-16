import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Wendy.TitleLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class IntroScreen extends FullFunctionScreen{

	private String bName;

	public IntroScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
		TitleLabel title = new TitleLabel(100,50,500,100);
		
		viewObjects.add(title);
		
		
		TextField input = new TextField(getHeight()/2,getWidth()/2,200,200,"Enter text");
		
		viewObjects.add(input);
		
		Button enter = new Button(110, 100, 25, 30, "Enter", new Action(){

			@Override
			public void act() {
				// TODO Auto-generated method stub
				bName = input.getText();
			}
			
		});
		
		viewObjects.add(enter);
		
		
		
	}

}
