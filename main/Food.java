package main;
import java.awt.Graphics;

public class Food extends World implements IDrawable
{
	World world;
	int posx, posy, width, height;
	public Food(World world, int posx, int posy, int width, int height)
	{
		this.world = world;
		this.posx = posx; 
		this.posy = posy;
		this.width = width;
		this.height = height;
	}
	public void draw(Graphics g)
	{
		g.drawImage(this.world.fress, posx, posy, width, height, null);
	}
	public void setPosx(int posx)
	{
		this.posx = posx;
	}
	public int getPosx()
	{
		return this.posx;
	}
	public int getPosy()
	{
		return this.posy;
	}
	@Override
	public int getPriority() {
		return 4;
	}
}
