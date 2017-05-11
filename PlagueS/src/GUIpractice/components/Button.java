package GUIpractice.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Button extends TextLabel implements Clickable{
	
	private Color color;
	private Action action;
	

	public Button(int x, int y, int w, int h, String tex, Color c, Action act) {
		super(x, y, w, h, tex);
		this.color = c;
		this.action = act;
		
		update();
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color c)
	{
		color = c;
		update();
	}
	
	@Override
	public void update(Graphics2D g)
	{
		FontMetrics fm = g.getFontMetrics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 35);//
		g.setColor(Color.cyan);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 35);
		if(getText() != null)
		{
			g.setColor(Color.white);
			g.setFont(new Font(getFont(),Font.PLAIN,getSize()));
//			String t = getText();
//			int cutOff = t.length();
//			while(cutOff > 0 && fm.stringWidth(t) > getWidth())
//			{
//				cutOff--;
//				t = t.substring(0, cutOff);
//			}
//			g.drawString(t, ((getWidth()-fm.stringWidth(t))/2), (getHeight()+fm.getHeight()-fm.getDescent())/2);
			g.drawString(getText(), 4, getHeight()-5);
			
		}

	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return x >= getX() && x <= getX() + getWidth() && y >= getY() && y <= getY() + getHeight();
		
		
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		action.act();
	}
	
	

}
