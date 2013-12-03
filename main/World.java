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
			back = ImageIO.read(new File("img" + File.separator + "hintergrund.png"));
			fress = ImageIO.read(new File("img" + File.separator + "fresschen.png"));
			schnake = ImageIO.read(new File("img" + File.separator + "schlange.png"));
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
