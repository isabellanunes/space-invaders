package spaceinvaders;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ship {
	
	private BufferedImage shipSprite;
	private int x;
	private int velocity;
	
	//Constructor
	public Ship() {
		try {
			shipSprite = ImageIO.read(new File("images/ship.png"));
		} catch (IOException e) {
			System.out.println("Can't load the ship image");
			e.printStackTrace();
		}
		
		x = 683;
		velocity = 3;
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(shipSprite, x, 600, x + 100, 600 + 100, 0, 0, shipSprite.getWidth(), shipSprite.getHeight(), null);
	}
	
	public void movement(int value) {
		if(value == 1) {
			x += velocity;
		} else if(value == -1) {
			x-=velocity;
		}
	}
	
	//The ship will return a shoot in the position that currently is
	public Shoot shoot() {
		Shoot shoot = new Shoot(x + 50, 600);
		return shoot;
	}

}
