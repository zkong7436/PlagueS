package GUIpractice.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextLabel extends Component {

	private String text;
	private String font;
	private int size;
	
	public TextLabel(int x, int y, int w, int h, String tex) {
		super(x, y, w, h);//updates super
		// TODO Auto-generated constructor stub
		this.text = tex;
		font = "Times New Roman";
		size = 30;
		update();//updates with new info
		
	}
	
	public void setText(String s)
	{
		this.text = s; 
		update();
	}
	
	public void setFont(String f)
	{
		this.font = f;
		update();
	}
	
	public void setSize(int n)
	{
		this.size = n;
		update();
	}
	public String getText() {
		return text;
	}

	public String getFont() {
		return font;
	}

	public int getSize() {
		return size;
	}
	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g = clear();//clears image and gets new graphic
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		if(text != null)
		{
			g.setFont(new Font(font,Font.PLAIN,size));
			g.drawString(text, 4, getHeight()-5);
			
		}
	}

}
