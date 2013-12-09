package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class DrawManager extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<IDrawable> drawList = new ArrayList<IDrawable>();
	
	public void draw() {
		this.repaint();
	}
	
	public void addToDrawList(IDrawable d){
		drawList.add(d);
		Collections.sort(drawList, new DrawComparator());
	}
	
	public void removeFromDrawList(IDrawable d){
		drawList.remove(d);
	}

	@Override
	public void paintComponent(Graphics g) {
		for (IDrawable d: drawList) {
			d.draw(g);
		}
	}

}