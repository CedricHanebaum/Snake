package main;

import java.awt.Graphics;

public class Snake extends World implements IDrawable, ITickable {
	private int posx, posy, width, height;
	private World welt;
	private Snake vorherige;
	private int lastpos[] = new int[2];
	private int speedf = 5;
	private boolean visible;
	
	private SnakeGame snakeGame;

	public Snake(int posx, int posy, int width, int height, World welt, SnakeGame snakeGame) {
		this.visible = false;
		this.posx = posx;
		this.posy = posy;
		this.width = width;
		this.height = height;
		this.welt = welt;
		this.lastpos[0] = posx;
		this.lastpos[1] = posy;
		this.snakeGame = snakeGame;
	}

	public void setVorherige(Snake vorherige) {
		this.vorherige = vorherige;
	}

	public void draw(Graphics g) {
		if (visible) {
			g.drawImage(this.welt.schnake, posx, posy, width, height, null);
			move();
		}
	}

	public int getPosx() {
		return this.posx;
	}

	public int getPosy() {
		return this.posy;
	}

	public void move() {
		if (!snakeGame.isStart())
			return;
		lastpos[0] = this.posx;
		lastpos[1] = this.posy;
		int direction = snakeGame.getSnake_direction();
		if (vorherige == null) {
			snakeGame.checkCollision();
			switch (direction) {
			case 0:
				if (posx < 780)
					this.posx += speedf;
				else
					this.posx = 5;
				break;
			case 1:
				if (posx > 5)
					this.posx -= speedf;
				else
					this.posx = 790;
				break;
			case 2:
				if (posy < 550)
					this.posy += speedf;
				else
					this.posy = 10;
				break;
			case 3:
				if (posy > 10)
					this.posy -= speedf;
				else
					this.posy = 580;
				break;
			}
			return;
		}
		posx = vorherige.lastpos[0];
		posy = vorherige.lastpos[1];
	}

	@Override
	public int getPriority() {
		return 4;
	}

	@Override
	public void update(long delta) {
	}
}
