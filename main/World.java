package main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class World 
{
	public BufferedImage back;
	public BufferedImage fress;
	public BufferedImage schnake;
	public World()
	{
		try
		{
			back = ImageIO.read(new File("hintergrund.png"));
			fress = ImageIO.read(new File("fresschen.png"));
			schnake = ImageIO.read(new File("schlange.png"));
		}
		catch(Exception e)
		{
			System.out.println("Fehler");
		}
	}
	public void draw(Graphics g)
	{
		
	}
}
