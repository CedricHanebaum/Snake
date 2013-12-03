package main;

import gui.Gui;
import gui.GuiButton;
import gui.GuiLabel;
import gui.GuiManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GuiOptions extends Gui {

	public GuiOptions(int posX, int posY, int width, int heigth, GuiManager guiManager) {
		super(posX, posY, width, heigth, guiManager);
		
		BufferedImage buttonImg = null;
		
		try {
			this.background = ImageIO.read(new File("MainMenuBG.png"));
			buttonImg = ImageIO.read(new File("Button.png"));
		} catch (IOException e) {}
		
		GuiLabel header = new GuiLabel(500, 80, 150, 30, -1, "Options", this);
		header.setColor(Color.RED);
		header.setFont(new Font("", Font.PLAIN, 18));
		GuiButton backBtn = new GuiButton(450, 100, 300, 60, 1, "Back", buttonImg, this);
		backBtn.setColor(Color.WHITE);
		
		this.addComponent(header);
		this.addComponent(backBtn);
	}

	@Override
	public void actionPerformed(int ID) {
		switch(ID){
		case 1:
			this.setVisible(false);
			guiManager.showMainMenu();
			break;
		}

	}

	@Override
	public int getPriority() {
		return 1;
	}

}
