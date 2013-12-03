package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

public class DrawManager {
	
	private ArrayList<IDrawable> drawList = new ArrayList<IDrawable>();
	
	public void draw(Graphics g){
		for(IDrawable d: drawList){
			d.draw(g);
		}
	}
	
	public void addToDrawList(IDrawable d){
		drawList.add(d);
		Collections.sort(drawList, new DrawComparator());
	}
	
	public void removeFromDrawList(IDrawable d){
		drawList.remove(d);
	}

}
