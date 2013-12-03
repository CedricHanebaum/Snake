package main;

import gui.Gui;
import gui.GuiButton;
import gui.GuiManager;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GuiMain extends Gui {
	

	public GuiMain(int posX, int posY, int width, int heigth, GuiManager guiManager) {
		super(posX, posY, width, heigth, guiManager);
		
		BufferedImage buttonBg = null;
		try {
			buttonBg = ImageIO.read(new File("Button.png"));
			this.background = ImageIO.read(new File("MainMenuBG.png"));
		} catch (IOException e) {e.printStackTrace();}
		
		GuiButton startGameBtn = new GuiButton(posX + 30, posY + 160, 300, 60, 0, "Start Game!", buttonBg, this);
		GuiButton optionsBtn = new GuiButton(posX + 30, posY + 230, 300, 60, 1, "Options", buttonBg, this);
		GuiButton exitBtn = new GuiButton(posX + 30, posY + 300, 300, 60, 2, "Exit", buttonBg, this);
		exitBtn.setColor(Color.WHITE);
		optionsBtn.setColor(Color.WHITE);
		startGameBtn.setColor(Color.WHITE);
		
		this.addComponent(startGameBtn);
		this.addComponent(optionsBtn);
		this.addComponent(exitBtn);
	}

	@Override
	public void actionPerformed(int ID) {
		switch(ID){
		case 0:
			this.setVisible(false);
			guiManager.startGame();
			break;
		case 1:
			this.setVisible(false);
			guiManager.showOptionsMenu();
			break;
		case 2:
			guiManager.closeGame();
			break;
		}
	}

	@Override
	public int getPriority() {
		return 1;
	}

}
