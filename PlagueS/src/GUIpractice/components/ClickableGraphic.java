package GUIpractice.components;

public class ClickableGraphic extends Graphic implements Clickable{
	
	private Action action;

	public ClickableGraphic(int x, int y, String imageLocation) {
		super(x, y, imageLocation);

	}

	public ClickableGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
	}

	public ClickableGraphic(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return x >= getX() && x <= getX() + getWidth() && y >= getY() && y <= getY() + getHeight();
	}
	
	public void setAction(Action a)
	{
		this.action = a;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		if(action != null)
		{
			action.act();
			
		}
		
	}

}
