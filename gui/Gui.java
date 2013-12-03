package gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Game;
import main.IDrawable;
import main.IMouseNoticeable;

public abstract class Gui implements IDrawable, IMouseNoticeable {
	
	protected BufferedImage background;
	private Rectangle rect;
	private boolean visible;
	private ArrayList<GuiComponent> components = new ArrayList<GuiComponent>();
	protected GuiManager guiManager;

	public Gui(int posX, int posY, int width, int heigth, GuiManager guiManager) {
		rect = new Rectangle(posX, posY, width, heigth);
		this.guiManager = guiManager;
		visible = false;
		Game.inputManager.addListener(this);
	}
	
	public abstract void actionPerformed(int ID);
	
	public void mouseClicked(Point p){
		if(rect.contains(p) && visible){
			for(GuiComponent c: components){
				c.mouseClicked(p);
			}
		}
	}
	
	public void mouseMoved(Point p){
		if(rect.contains(p) && visible){
			for(GuiComponent c: components){
				c.mouseMoved(p);
			}
		}
	}
	
	public void addComponent(GuiComponent c){
		components.add(c);
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	@Override
	public void draw(Graphics g) {
		if(visible){
			g.drawImage(background, rect.x, rect.y, null);
			for(GuiComponent c: components){
				c.draw(g);
			}
		}
	}

}
