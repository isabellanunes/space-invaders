package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics2D;

public class Shoot {
	
	private int x;
	private int y;
	
	//Constructor
	public Shoot(int beginX, int beginY) {
		this.x = beginX;
		this.y = beginY;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 3, 15);
	}

}
