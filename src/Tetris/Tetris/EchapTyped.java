package Tetris;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class EchapTyped extends AbstractAction {

	//Attributs
	private static final long serialVersionUID = -5914438169802006033L;
	private Fenetre maFenetre;
	private boolean attente = true;

	//Constructeur
	public EchapTyped(Fenetre fenetre){
		setMaFenetre(fenetre);
		setAttente(true);
	}

	//Accesseurs
	public Fenetre getMaFenetre() {
		return maFenetre;
	}

	public void setMaFenetre(Fenetre maFenetre) {
		this.maFenetre = maFenetre;
	}

	public boolean isAttente() {
		return attente;
	}

	public void setAttente(boolean attente) {
		this.attente = attente;
	}

	//Méthodes
	@Override
	public void actionPerformed(ActionEvent e) {
		pause();
		new MenuDuJeu(maFenetre);

	}

	public void pause(){
		getMaFenetre().setPauseThread(true);
		getMaFenetre().setVisible(false);
	}

	public void reprendre(){
		getMaFenetre().setPauseThread(false);
		getMaFenetre().setVisible(true);
		getMaFenetre().repaint();
	}
}
