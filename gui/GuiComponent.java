package gui;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.IMouseNoticeable;

public abstract class GuiComponent implements IMouseNoticeable{
	
	protected int ID;
	protected Rectangle rect;
	protected Gui parent;
	
	public GuiComponent(int posX, int posY, int width, int height, int ID, Gui parent){
		rect = new Rectangle(posX, posY, width, height);
		this.ID = ID;
		this.parent = parent;
	}
	
	public abstract void draw(Graphics g);
	

}