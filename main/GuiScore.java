package main;

import gui.Gui;
import gui.GuiLabel;
import gui.GuiManager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.plaf.FontUIResource;

public class GuiScore extends Gui {
	
	private int score;
	private GuiLabel gameOverLbl;
	private GuiLabel scoreLbl;

	public GuiScore(int posX, int posY, int width, int heigth, GuiManager guiManager) {
		super(posX, posY, width, heigth, guiManager);
		
		gameOverLbl = new GuiLabel(400, 220, 200, 50, 0, "GameOver", this);
		gameOverLbl.setColor(Color.RED);
		gameOverLbl.setFont(new FontUIResource("", Font.PLAIN, 22));
		
		scoreLbl = new GuiLabel(450, 270, 200, 50, 0, "", this);
		scoreLbl.setColor(Color.RED);
		scoreLbl.setFont(new FontUIResource("", Font.PLAIN, 24));
		this.addComponent(scoreLbl);
		this.addComponent(gameOverLbl);
		
	}
	
	public void setScore(int score){
		this.score = score;
		scoreLbl.setText(String.valueOf(this.score));
	}

	@Override
	public void actionPerformed(int ID) {
		// TODO Auto-generated method stub

	}
	
	public void update(long delta) {}

	@Override
	public int getPriority() {
		return 1;
	}

}
