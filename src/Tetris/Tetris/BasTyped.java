package Tetris;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class BasTyped extends AbstractAction {

	//Attributs
	private static final long serialVersionUID = -4826549053903373470L;
	private Panneau panel;
	private Piece pieceActu;
	private Position tampon;
	private int score;

	//Constructeur
	public BasTyped (Panneau panneau, Position position){
		setPanel(panneau);
		setPieceActu(getPanel().getPieceActuelle());
		setScore(getPanel().getScore());
	}

	//Accesseurs
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

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
		boolean deplacementValide = true;
		if(getPieceActu().getForme()!=Forme.FormeO){
			getPieceActu().delPieceDansLePanneau(getPieceActu());
			try {
				Piece pieceTest = getPieceActu().clone();
				pieceTest .tournerPieceBas(pieceTest,false);
				int tmpx, tmpy;
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						tmpx = i+pieceTest.getPos().getX()-2;
						tmpy = j+pieceTest.getPos().getY()-1;
						if((tmpx<0||tmpy<0|| tmpx>=10||tmpy>=22)&&(pieceTest.getFormeEnXY(i,j)!=Forme.PasForme)){
							deplacementValide = false;   
						}
						if(((tmpx>=0&&tmpy>=0&&tmpx<10&&tmpy<22))){
							if((getPanel().getFormeXY(tmpx,tmpy)!=Forme.PasForme)&&(pieceTest.getFormeEnXY(i,j)!=Forme.PasForme)){
								deplacementValide = false;
							}
						}
					}
				}
			} catch (CloneNotSupportedException e1) {
				System.err.println("Erreur de clonage de la piece");
			}
			if(deplacementValide==true){
				getPieceActu().tournerPieceBas(getPieceActu(),true);
			}else{
				getPieceActu().putPieceDansLePanneau(getPieceActu()); 
			}
			getPanel().repaint();

		}
	}
}
