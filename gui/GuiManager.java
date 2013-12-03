package gui;

import java.awt.event.KeyEvent;

import main.DrawManager;
import main.Game;
import main.GuiMain;
import main.GuiOptions;
import main.GuiScore;

public class GuiManager {
	
	private Game game;
	private DrawManager drawManager;
	
	private Gui mainMenu = new GuiMain(0, 0, 800, 600, KeyEvent.VK_ESCAPE, KeyEvent.VK_Q, this);
	private Gui optionsMenu = new GuiOptions(0, 0, 800, 600, 0, 0, this);
	private Gui scoreGui = new GuiScore(300, 200, 200, 400, 0, 0, this);
	
	private Gui activeGui;
	
	
	public GuiManager(Game game, DrawManager drawManager){
		this.game = game;
		this.drawManager = drawManager;
		activeGui = null;
		
		this.game.addToUpdateList(mainMenu);
		this.game.addToUpdateList(optionsMenu);
		this.game.addToUpdateList(scoreGui);
		
		this.drawManager.addToDrawList(mainMenu);
		this.drawManager.addToDrawList(optionsMenu);
		this.drawManager.addToDrawList(scoreGui);
	}


	public void startGame() {
		game.startGame();
	}
	
	public void showScoreGui(int score){
		if(activeGui != null) activeGui.setVisible(false);
		scoreGui.setVisible(true);
		activeGui = scoreGui;
		((GuiScore) scoreGui).setScore(score);
	}


	public void showMainMenu() {
		if(activeGui != null) activeGui.setVisible(false);
		mainMenu.setVisible(true);
		activeGui = mainMenu;
	}


	public void showOptionsMenu() {
		if(activeGui != null) activeGui.setVisible(false);
		optionsMenu.setVisible(true);
		activeGui = optionsMenu;
	}
	
	public void closeActiveGui(){
		if(activeGui != null) activeGui.setVisible(false);
		activeGui = null;
	}
	
	public void closeGame() {
		game.closeGame();
	}

}
