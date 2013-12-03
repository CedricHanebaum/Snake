package main;

import gui.GuiManager;

import java.util.ArrayList;

public class SnakeGame implements ITickable{
	
	private Food fressen;
	private ArrayList<Snake> schlange;
	private short snake_direction = 1;
	private boolean start = true;
	private int points = 0;
	private World world;
	private Background bg;
	private boolean gameover = false;

	private Game game;
	private GuiManager guiManager;
	private DrawManager drawManager;

	public SnakeGame(Game game, DrawManager drawManager) {
		this.game = game;
		this.game.addToUpdateList(this);
		guiManager = this.game.getGuiManager();
		this.drawManager = drawManager;
		
		world = new World();
		bg = new Background(world, 0, 0, 800, 600);
		this.game.addToUpdateList(bg);
		this.drawManager.addToDrawList(bg);
	}

	public void checkCollision() {
		int posx = schlange.get(0).getPosx();
		int posy = schlange.get(0).getPosy();
		int diff = 0;
		for (int i = 2; i < schlange.size(); i++) {
			diff += Math.abs(posx - schlange.get(i).getPosx());
			diff += Math.abs(posy - schlange.get(i).getPosy());
			if (diff < 9) {
				setStart(false);
				this.guiManager.showScoreGui(points);
				System.out.println("Punkte: " + points);
				gameover = true;
			}
			diff = 0;
		}
		diff += Math.abs(posx - fressen.getPosx());
		diff += Math.abs(posy - fressen.getPosy());
		//System.out.println(diff);
		if (diff < 11)
			eat();
	}

	public void eat() {
		fressen.setPosx((int) (Math.random() * 750) + 10);
		fressen.setPosy((int) (Math.random() * 550) + 10);
		Snake temp = schlange.get(schlange.size() - 1);
		Snake neu = new Snake(temp.getPosx(), temp.getPosy(), 25, 25, world, this, game);
		schlange.add(neu);
		neu.setVorherige(temp);
		points += 10;
	}

	public void snakeMove() {
		if (Game.inputManager.isDown(38)) {
			if (getSnake_direction() != 2)
				setSnake_direction((short) 3);
			return;
		}

		if (Game.inputManager.isDown(37)) {
			if (getSnake_direction() != 0)
				setSnake_direction((short) 1);
			return;
		}

		if (Game.inputManager.isDown(39)) {
			if (getSnake_direction() != 1)
				setSnake_direction((short) 0);
			return;
		}

		if (Game.inputManager.isDown(40)) {
			if (getSnake_direction() != 3)
				setSnake_direction((short) 2);
			return;
		}

		if (Game.inputManager.isDown(80)) {
			if (isStart())
				setStart(false);
		}
		if (Game.inputManager.isDown(82)) {
			if (!isStart() && !gameover)
				setStart(true);
		}
	}

	public void reset() {
		world = new World();
		bg = new Background(world, 0, 0, 800, 600);
		bg.setVisible(true);
		fressen = new Food(world, (int) (Math.random() * 750) + 10, (int) (Math.random() * 550) + 10, 18, 18);
		this.drawManager.addToDrawList(fressen);
		schlange = new ArrayList<Snake>();
		schlange.add(new Snake(400, 284, 25, 25, world, this, game));
		Snake temp;
		for (int i = 0; i < 16; i++) {
			temp = new Snake(400 + (i + 1) * 15, 284, 25, 25, world, this, game);
			schlange.add(temp);
			temp.setVorherige(schlange.get(i));
		}
		setSnake_direction((short) 1);
		setStart(true);
		points = 0;
		gameover = false;
		this.guiManager.closeActiveGui();
	}

	@Override
	public void update(long delta) {
		this.snakeMove();
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public short getSnake_direction() {
		return snake_direction;
	}

	public void setSnake_direction(short snake_direction) {
		this.snake_direction = snake_direction;
	}

}
