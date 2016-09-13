package Tetris;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class EspaceTyped extends AbstractAction {

	//Attributs
	private static final long serialVersionUID = -4826549053903373470L;
	private Panneau panel;
	private Piece pieceActu;
	private Position tampon;

	//Constructeur
	public EspaceTyped (Panneau panneau,Position position){
		setPanel(panneau);
		setPieceActu(getPanel().getPieceActuelle());
	}

	//Accesseurs
	public Panneau getPanel() {
		return panel;
	}

	public void setPanel(Panneau panel) {
		this.panel = panel;
	}

	public Piece getPieceActu() {
		return pieceActu;
	}

	public void setPieceActu(Piece pieceActu) {
		this.pieceActu = pieceActu;
	}

	public Position getTampon() {
		return tampon;
	}

	public void setTampon(Position tampon) {
		this.tampon = tampon;
	}

	//Méthode
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			setTampon(getPieceActu().getPos());
			getPieceActu().deplacerPieceDeXY(pieceActu, new Position(0,1));
			if(getTampon().equals(getPieceActu().getPos())){
				getPanel().setTombe(false);
			}
		}			
		catch (ArrayIndexOutOfBoundsException e1){
			getPieceActu().deplacerPieceDeXY(pieceActu, new Position(0,0));
		}
		getPanel().repaint();

	}

}
