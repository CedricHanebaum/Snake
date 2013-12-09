package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class DrawManager extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<IDrawable> drawList = new ArrayList<IDrawable>();
	private ArrayList<IDrawable> tmpAddList = new ArrayList<IDrawable>();
	private ArrayList<IDrawable> tmpRemoveList = new ArrayList<IDrawable>();
	
	public void draw() {
		this.repaint();
	}
	
	private void refreshList() {
		for (IDrawable d: tmpAddList) {
			drawList.add(d);
		}
		for (IDrawable d: tmpRemoveList) {
			drawList.remove(d);
		}

		tmpAddList = new ArrayList<IDrawable>();
		tmpRemoveList = new ArrayList<IDrawable>();
		Collections.sort(drawList, new DrawComparator());
	}

	public void addToDrawList(IDrawable d){
		tmpAddList.add(d);
	}
	
	public void removeFromDrawList(IDrawable d){
		tmpRemoveList.add(d);
	}

	@Override
	public void paintComponent(Graphics g) {
		for (IDrawable d: drawList) {
			d.draw(g);
		}
		this.refreshList();
	}
}