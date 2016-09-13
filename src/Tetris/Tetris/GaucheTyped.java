package Tetris;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class GaucheTyped extends AbstractAction {

	//Attributs
	private static final long serialVersionUID = -1035184221507956448L;
	private Panneau panel;
	private Piece pieceActu;

	//Constructeur
	public GaucheTyped (Panneau panneau,Position position){
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

	//Methode
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			getPieceActu().deplacerPieceDeXY(pieceActu, new Position(-1,0));
		}
		catch (ArrayIndexOutOfBoundsException e1){
			getPieceActu().deplacerPieceDeXY(pieceActu, new Position(0,0));
		}
		getPanel().repaint();
	}
}