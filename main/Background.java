package main;

import java.awt.Graphics;

public class Background extends World implements IDrawable, ITickable {

	World world;
	int posx, posy, width, height;
	boolean visible;

	public Background(World world, int posx, int posy, int width, int height) {
		this.world = world;
		this.posx = posx;
		this.posy = posy;
		this.width = width;
		this.height = height;
		this.visible = true;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void update(long delta) {

	}

	public void draw(Graphics g) {
		if (visible) {
			g.drawImage(this.world.back, posx, posy, width, height, null);
		}
	}

	@Override
	public int getPriority() {
		return 5;
	}
}
