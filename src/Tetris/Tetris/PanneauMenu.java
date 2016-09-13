package Tetris;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanneauMenu extends JDialog {

	//Attributs
	private static final long serialVersionUID = 7588089613960442814L;
	private JButton nouvellePartieBoutton;
	private static Fenetre laFenetre;

	//Méthode de classe 
	public static void setLaFenetre(Fenetre laFenetre) {
		PanneauMenu.laFenetre = laFenetre;
	}

	//Accesseurs
	public JButton getNouvellePartieBoutton() {
		return nouvellePartieBoutton;
	}

	public void setNouvellePartieBoutton(JButton nouvellePartieBoutton) {
		this.nouvellePartieBoutton = nouvellePartieBoutton;
	}

	public static Fenetre getLaFenetre() {
		return laFenetre;
	}

	//Méthodes 
	public static void main(String[] args,Fenetre fenetre) {
		try {
			laFenetre=fenetre;
			PanneauMenu dialog = new PanneauMenu();
			dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent evt) {
					Tetris.pourQuitter();
				}
			});
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void redimenssioner(){
		Object[] possibilities = {"480*320","720*480", "1280*720", "Resolution maximale"};
		String s = (String)JOptionPane.showInputDialog(
				new JFrame(),
				"Choisir votre résolution:\n",
				"Changement de la résolution d'affichage du jeu",
				JOptionPane.PLAIN_MESSAGE,
				(Icon) new JFrame().getIconImage(),
				possibilities,
				"Choix");
		if ((s != null) && (s.length() > 0)) {
			GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
			if(s.equals("480*320")){
				if((maximumWindowBounds.getHeight()>=320)&&(maximumWindowBounds.getWidth()>=480)){
					getLaFenetre().setSize(new Dimension(480,320));
				}else{
					getLaFenetre().setSize(new Dimension(maximumWindowBounds.width,maximumWindowBounds.height));
				}
			}
			if(s.equals("720*480")){
				if((maximumWindowBounds.getHeight()>=480)&&(maximumWindowBounds.getWidth()>=720)){
					getLaFenetre().setSize(new Dimension(720,480));
				}else{
					getLaFenetre().setSize(new Dimension(maximumWindowBounds.width,maximumWindowBounds.height));
				}
			}
			if(s.equals("1280*720")){
				if((maximumWindowBounds.getHeight()>=720)&&(maximumWindowBounds.getWidth()>=1280)){
					getLaFenetre().setSize(new Dimension(1280,720));
				}else{
					getLaFenetre().setSize(new Dimension(maximumWindowBounds.width,maximumWindowBounds.height));
				}
			}
			if(s.equals("Resolution maximale")){
					getLaFenetre().setSize(new Dimension(maximumWindowBounds.width,maximumWindowBounds.height));
			}
			return;
		}else{
			//Ne rien faire
		}

	}

	public void changerDifficultee(){
		Object[] possibilities = {"Facile", "Normal", "Difficile"};
		String s = (String)JOptionPane.showInputDialog(
				new JFrame(),
				"Choisir votre difficultee:\n",
				"Changement de la difficultee",
				JOptionPane.PLAIN_MESSAGE,
				(Icon) new JFrame().getIconImage(),
				possibilities,
				"Choix");
		if ((s != null) && (s.length() > 0)) {
			if(s.equals("Facile")){
				getLaFenetre().getMonPanneau().setDifficultee(1);
			}
			if(s.equals("Normal")){
				getLaFenetre().getMonPanneau().setDifficultee(2);
			}
			if(s.equals("Difficile")){
				getLaFenetre().getMonPanneau().setDifficultee(3);
			}
			return;
		}else{
			//Ne rien faire
		}

	}

	public void reprendre(){
		getLaFenetre().setPauseThread(false);
		getLaFenetre().setVisible(true);
		getLaFenetre().repaint();
		this.dispose();
	}

	public void nouveauJeu(){
		getLaFenetre().getMonPanneau().nettoyerJeu();
		reprendre();
	}

	public PanneauMenu() {
		setTitle("Menu du jeu de Tetris");
		setResizable(false);
		setAlwaysOnTop(false);
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
		setBounds(maximumWindowBounds.width/4, maximumWindowBounds.height/4, maximumWindowBounds.width/2, maximumWindowBounds.height/2);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane);
			{
				nouvellePartieBoutton = new JButton("Nouvelle partie\n\n");
				nouvellePartieBoutton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						nouveauJeu();
					}
				});

			}
			buttonPane.setLayout(new GridLayout(0, 1, 0, 0));
			buttonPane.add(nouvellePartieBoutton);
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				buttonPane.add(verticalStrut);
			}
			{
				JButton changerResolutionBoutton = new JButton("Changer la résolution du jeu");
				changerResolutionBoutton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						redimenssioner();
					}
				});
				buttonPane.add(changerResolutionBoutton);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				buttonPane.add(verticalStrut);
			}
			{
				JButton changerDifficulteeBoutton = new JButton("Changer la difficultée du jeu");
				changerDifficulteeBoutton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						changerDifficultee();
					}
				});
				buttonPane.add(changerDifficulteeBoutton);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				buttonPane.add(verticalStrut);
			}
			{
				JButton reprendreJeuBoutton = new JButton("Reprendre le jeu");
				reprendreJeuBoutton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						reprendre();
					}
				});
				buttonPane.add(reprendreJeuBoutton);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				buttonPane.add(verticalStrut);
			}
			{
				JButton quitterJeuBoutton = new JButton("Quitter le jeu");
				quitterJeuBoutton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						getLaFenetre().détruire();
					}
				});
				buttonPane.add(quitterJeuBoutton);
			}
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			getContentPane().add(horizontalStrut, BorderLayout.EAST);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			getContentPane().add(verticalStrut, BorderLayout.SOUTH);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			getContentPane().add(verticalStrut, BorderLayout.NORTH);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			getContentPane().add(horizontalStrut, BorderLayout.WEST);
		}


	}

}
