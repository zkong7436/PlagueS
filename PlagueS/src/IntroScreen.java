
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class IntroScreen extends FullFunctionScreen{

	private String bName;


	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public IntroScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
		TextLabel title = new TextLabel(getHeight()/2 - 100, getWidth()/10, 1000, 100, "PLAGUE S-implified");
		title.setSize(50);
		
		
		TextField input = new TextField(getHeight()/3,getWidth()/3,500,100,"Enter a name");
		input.setSize(50);
		
		Button enter = new Button(getHeight()/3 + 550, getWidth()/3 + 50, 100, 50, "Enter", null);
		
		enter.setAction(new Action(){

			@Override
			public void act() {
				// TODO Auto-generated method stub
				System.out.println(input.getText());
				bName = input.getText();
				remove(input);
				remove(enter);
				PlagueS.game.setScreen(PlagueS.Mscreen);
			}
			
		});
		

		
		viewObjects.add(title);
		viewObjects.add(input); 
		viewObjects.add(enter);
		
		
	
		
	}

}
