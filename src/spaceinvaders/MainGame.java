package spaceinvaders;

import javax.swing.JFrame;

public class MainGame {
	
	public static void main(String[] args) {

		JFrame window = new JFrame("Space Invaders");
		
		window.setSize(1366, 768);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		
		SpaceInvaders spaceinvaders = new SpaceInvaders();
		spaceinvaders.setBounds(0, 0, 1366, 768);
		
		window.add(spaceinvaders);
		
		window.addKeyListener(spaceinvaders);
		
		window.setVisible(true);
		
	}

}