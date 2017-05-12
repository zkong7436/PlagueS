/*******************************************************************************
 * Copyright (c) 2016-2017 Benjamin Nockles
 *
 * This file is part of OrcMath.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License 
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package guiTeacher.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.interfaces.Clickable;


public class Checkbox extends StyledComponent implements Clickable {

	public static final Color CHECK_COLOR = new Color(50,200,150);
	public static final int CHECKBOX_LENGTH = 20;

	private static final int _SPACE = 5;

	private String text;
	private boolean checked;
	private Action action;

	public Checkbox(String text, int x, int y, int width, boolean checked, Action action){
		super(x, y, width,CHECKBOX_LENGTH);
		this.text = text;
		this.checked= checked;
		this.action = action;
		update();
	}

	private void drawCheck(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, CHECKBOX_LENGTH+2, CHECKBOX_LENGTH);
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(3));
		g.drawRect(2, 2, CHECKBOX_LENGTH-4, CHECKBOX_LENGTH-4);
		g.setStroke(new BasicStroke(5));
		if(checked){
			g.setColor(CHECK_COLOR);
			g.drawLine(0, CHECKBOX_LENGTH/2, CHECKBOX_LENGTH/3, CHECKBOX_LENGTH);
			g.drawLine(CHECKBOX_LENGTH/3, CHECKBOX_LENGTH, CHECKBOX_LENGTH-2, 0);
		}
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		drawCheck(g);
		g.setColor(getForeground());
		g.setFont(getBaseFont());
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(1));
		g.drawString(text, CHECKBOX_LENGTH+_SPACE, CHECKBOX_LENGTH-3);
	}

	@Override
	public void act() {
		//handles adding/removing check
		checked = !checked;
		update();
		//acts
		if(action != null) action.act();
	}

	public boolean isChecked(){
		return checked;
	}
	

	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x < getX()+CHECKBOX_LENGTH && y>getY() && y < getY()+CHECKBOX_LENGTH;
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
	}


}
