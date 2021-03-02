package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener {

	private Ship ship;
	private int direction = 0;
	private Shoot shoot;

	//Constructor
	public SpaceInvaders() {
		
		ship = new Ship();
		
		Thread loopGame = new Thread(this);
		loopGame.start();
	}

	@Override
	public void run() {
		while (true) {
			update();
			repaint();
			sleep();
		}
	}
	
	private void update() {
		ship.movement(direction);
	}
	
	int x = 0;
	
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		
		Graphics2D g = (Graphics2D) g2.create();
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		ship.paint(g);
		if(shoot!=null) {
			shoot.paint(g);
		}
	}
	
	private void sleep() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			direction = 1;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A) {
			direction = -1;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			shoot = ship.shoot();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			direction = 0;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A) {
			direction = 0;
		}
		
	}
	
}
