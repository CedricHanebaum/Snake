package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class GuiLabel extends GuiComponent{
	
	private String text;
	private Color color;
	private Font font;

	public GuiLabel(int posX, int posY, int width, int height, int ID, String text, Gui parent) {
		super(posX, posY, width, height, ID, parent);
		this.text = text;
		color = Color.BLACK;
		font = new Font("", Font.PLAIN, 12);
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setFont(Font font){
		this.font = font;
	}

	@Override
	public void mouseClicked(Point p) {}

	@Override
	public void draw(Graphics g) {
		g.setFont(font);
		g.setColor(color);
		g.drawString(text, rect.x, rect.y);
	}

	@Override
	public void mouseMoved(Point p) {}

}