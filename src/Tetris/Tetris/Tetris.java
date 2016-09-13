package Tetris;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class Tetris {

	//Méthode main du programme

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
				Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
				@SuppressWarnings("unused")
				Fenetre fenetre = new Fenetre(maximumWindowBounds.width,maximumWindowBounds.height);
			}
		});
	}

	//Methode de sortie du programme
	public static void pourQuitter() {
		System.exit(0);
	}

}
