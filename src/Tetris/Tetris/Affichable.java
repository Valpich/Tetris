package Tetris;

import java.awt.Color;
import java.awt.Graphics;

public interface Affichable {

	//Methodes à implementer
	public void afficherChaines(Graphics g);

	public void afficheRect(Graphics g,boolean plein,int x, int y);

	public void afficheString(Graphics g,int x, int y,final String string, Color c);

	public void afficherPlateau(Graphics g);

	public void afficherCube(Graphics g,double x,double y,Cube piece);

	public void nettoyerJeu();

	public void afficherPieceSuivante(Graphics g, Piece aAfficher);

}
