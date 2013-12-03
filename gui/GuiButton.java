package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GuiButton extends GuiComponent{
	
	private BufferedImage img;
	private String text;
	private boolean mouseOver;
	private Color color;
	private Font font;

	public GuiButton(int posX, int posY, int width, int height, int ID, String text, BufferedImage img, Gui parent) {
		super(posX, posY, width, height, ID, parent);
		this.text = text;
		this.img = img;
		color = Color.BLACK;
		mouseOver = false;
		font = new Font("", Font.PLAIN, 12);
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setFont(Font font){
		this.font = font;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, rect.x, rect.y, null);
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, rect.x, rect.y + rect.height/2);
		if(mouseOver){
			g.setColor(new Color(200, 200, 200, 60));
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}

	@Override
	public void mouseClicked(Point p) {
		Rectangle r = new Rectangle(rect.x, rect.y, rect.width, rect.height);
		if(r.contains(p)) parent.actionPerformed(ID);
	}

	@Override
	public void mouseMoved(Point p) {
		if(rect.contains(p)) mouseOver = true;
		else mouseOver = false;
	}

}