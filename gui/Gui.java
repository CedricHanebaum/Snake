package gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Game;
import main.IDrawable;
import main.IMouseNoticeable;
import main.ITickable;

public abstract class Gui implements ITickable, IDrawable, IMouseNoticeable{
	
	protected BufferedImage background;
	private Rectangle rect;
	private int activateKey, deactivateKey;
	private boolean visible;
	private ArrayList<GuiComponent> components = new ArrayList<GuiComponent>();
	protected GuiManager guiManager;

	public Gui(int posX, int posY, int width, int heigth, int activateKey, int deactivateKey, GuiManager guiManager) {
		rect = new Rectangle(posX, posY, width, heigth);
		this.guiManager = guiManager;
		this.activateKey = activateKey;
		this.deactivateKey = deactivateKey;
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

	@Override
	public void update(long delta) {
		if(Game.inputManager.isDown(activateKey)){
			visible = true;
		}
		if(Game.inputManager.isDown(deactivateKey)){
			visible = false;
		}
	}

}
