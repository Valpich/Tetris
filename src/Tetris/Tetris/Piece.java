package Tetris;

import java.util.Arrays;
import java.util.Random;

enum Angle{CENTQUATREVINGT,DEUXCENTSOIXANTEDIX,QUATREVINGTDIX,ZERO};

public class Piece implements Cloneable{

	//Attributs
	private Angle angle;
	private Forme forme;
	private Panneau panneau;
	private Cube[][] piece = new Cube[4][4];
	private Position pos;

	//Constructeur
	public Piece(Forme forme, Panneau p){
		setAngle(Angle.ZERO);
		setPanneau(p);
		setPos(new Position(5,1));
		setForme(forme);
		switch(getForme()){
		case FormeI:
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			piece[0][1].setForme(forme);
			piece[1][1].setForme(forme);
			piece[2][1].setForme(forme);
			piece[3][1].setForme(forme);
			piece[0][1].setCouleur("Rouge");
			piece[1][1].setCouleur("Rouge");
			piece[2][1].setCouleur("Rouge");
			piece[3][1].setCouleur("Rouge");
			break;
		case FormeO :
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			piece[1][1].setForme(forme);
			piece[1][2].setForme(forme);
			piece[2][1].setForme(forme);
			piece[2][2].setForme(forme);
			piece[1][1].setCouleur("Bleu");
			piece[1][2].setCouleur("Bleu");
			piece[2][1].setCouleur("Bleu");
			piece[2][2].setCouleur("Bleu");
			break;
		case FormeT :
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			piece[1][1].setForme(forme);
			piece[2][1].setForme(forme);
			piece[3][1].setForme(forme);
			piece[2][2].setForme(forme);
			piece[1][1].setCouleur("Orange");
			piece[2][1].setCouleur("Orange");
			piece[3][1].setCouleur("Orange");
			piece[2][2].setCouleur("Orange");
			break;
		case FormeL :
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			piece[1][1].setForme(forme);
			piece[2][1].setForme(forme);
			piece[3][1].setForme(forme);
			piece[1][2].setForme(forme);
			piece[1][1].setCouleur("Magenta");
			piece[2][1].setCouleur("Magenta");
			piece[3][1].setCouleur("Magenta");
			piece[1][2].setCouleur("Magenta");
			break;
		case FormeJ :
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			piece[1][1].setForme(forme);
			piece[2][1].setForme(forme);
			piece[3][1].setForme(forme);
			piece[3][2].setForme(forme);
			piece[1][1].setCouleur("Blanc");
			piece[2][1].setCouleur("Blanc");
			piece[3][1].setCouleur("Blanc");
			piece[3][2].setCouleur("Blanc");
			break;
		case FormeZ :
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			piece[1][1].setForme(forme);
			piece[2][1].setForme(forme);
			piece[2][2].setForme(forme);
			piece[3][2].setForme(forme);
			piece[1][1].setCouleur("Jaune");
			piece[2][1].setCouleur("Jaune");
			piece[2][2].setCouleur("Jaune");
			piece[3][2].setCouleur("Jaune");
			break;
		case FormeS :
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			piece[1][2].setForme(forme);
			piece[2][1].setForme(forme);
			piece[3][1].setForme(forme);
			piece[2][2].setForme(forme);
			piece[1][2].setCouleur("Vert");
			piece[2][1].setCouleur("Vert");
			piece[3][1].setCouleur("Vert");
			piece[2][2].setCouleur("Vert");
			break;
		case PasForme :
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					piece[i][j] = new Cube();
				}
			}
			break;
		default :
			System.err.println("Erreur d'instanciation d'une Piece");
			System.exit(2);
			break;
		}
	}

	//Méthodes de classe
	public static Forme formeAlea() {
		Random r = new Random();
		int valeur = r.nextInt(7);
		switch(valeur){
		case 0 : 
			return Forme.FormeI;
		case 1 : 
			return Forme.FormeT;
		case 2 : 
			return Forme.FormeS;
		case 3 : 
			return Forme.FormeZ;
		case 4 : 
			return Forme.FormeO;
		case 5 : 
			return Forme.FormeL;
		case 6 : 
			return Forme.FormeJ;
		default :
			return Forme.PasForme;
		}
	}

	public static Forme formeVide() {
		return Forme.PasForme;
	}

	//Accesseurs	
	public Angle getAngle(){
		return this.angle;
	}

	public Cube getCubeXY(int x, int y) {
		return this.piece[x][y];
	}

	public Forme getForme(){
		return this.forme;
	}

	public Forme getFormeEnXY(int x, int y){
		return piece[x][y].getForme();
	}

	public Panneau getPanneau() {
		return panneau;
	}

	public Cube[][] getPiece() {
		return piece;
	}

	public Position getPos() {
		return pos;
	}

	public void setAngle(Angle angle) {
		this.angle = angle;
	}

	public void setCubeXY(Cube cube, int x, int y) {
		this.piece[x][y] = cube;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	public void setPanneau(Panneau p){
		this.panneau = p;
	}

	public void setPiece(Cube[][] piece) {
		this.piece = piece;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	//Méthodes
	public boolean testDeplacerPieceEnXY(Piece aDeplacer, Position pos){
		int tmpx, tmpy;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				tmpx = i+aDeplacer.getPos().getX()+pos.getX()-2;
				tmpy = j+aDeplacer.getPos().getY()+pos.getY()-1;
				if(tmpx>=0&&tmpy>=0&&tmpx<10&&tmpy<22){
					if(getPanneau().getFormeXY(tmpx,tmpy)!=Forme.PasForme){
						if(aDeplacer.getFormeEnXY(i,j)!=Forme.PasForme){
							return false;
						}

					}
				}else{
					if(aDeplacer.getFormeEnXY(i,j)!=Forme.PasForme)return false;
				}
			}
		}
		return true;
	}

	public void delPieceDansLePanneau(Piece aVirer){
		int tmpx, tmpy;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				tmpx = i+aVirer.getPos().getX()-2;
				tmpy = j+aVirer.getPos().getY()-1;
				if((aVirer.piece[i][j].getForme()!=Forme.PasForme)&&tmpx>=0&&tmpy>=0&&tmpx<10 &&tmpy<22)getPanneau().setCubeXY(new Cube(),tmpx,tmpy);
			}
		}
	}

	public void deplacerPieceDeXY(Piece aDeplacer,Position pos){
		delPieceDansLePanneau(aDeplacer);
		if(testDeplacerPieceEnXY(aDeplacer,pos)){
			aDeplacer.setPos(new Position(aDeplacer.getPos().getX()+pos.getX(),aDeplacer.getPos().getY()+pos.getY()));
			putPieceDansLePanneau(aDeplacer);
		}else{
			putPieceDansLePanneau(aDeplacer);
		}
	}

	public void putPieceDansLePanneau(Piece aMettre){
		int tmpx, tmpy;
		delPieceDansLePanneau(aMettre);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				tmpx = i+aMettre.getPos().getX()-2;
				tmpy = j+aMettre.getPos().getY()-1;
				if(tmpx>=0&&tmpy>=0&&tmpx<22&&tmpy<22&&aMettre.piece[i][j].getForme()!=Forme.PasForme)getPanneau().setCubeXY(aMettre.piece[i][j],tmpx,tmpy);
			}
		}
		getPanneau().repaint();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Piece other = (Piece) obj;

		boolean estEgal = true;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(this.piece[i][j].equals(other.piece[i][j])==false)estEgal=false;
			}
		}
		if(this.angle!=other.angle)estEgal=false;
		if(this.pos.equals(other.pos)==false)estEgal=false;
		return estEgal;
	}

	public void tournerPieceBas(Piece aTourner,boolean afficher){

		switch(aTourner.getForme()){

		case FormeI:

			switch(aTourner.angle){
			case ZERO :
				tournerPieceHaut(aTourner,afficher);
				break;
			case CENTQUATREVINGT :
				tournerPieceHaut(aTourner,afficher);
				break;
			default :
				break;
			}	
			break;

		case FormeO :
			break;

		case FormeT :

			switch(aTourner.angle){
			case ZERO :
				aTourner.angle = Angle.CENTQUATREVINGT;
				tournerPieceHaut(aTourner,afficher);
				break;
			case QUATREVINGTDIX :
				aTourner.angle = Angle.DEUXCENTSOIXANTEDIX;
				tournerPieceHaut(aTourner,afficher);
				break;
			case CENTQUATREVINGT :
				aTourner.angle = Angle.ZERO;
				tournerPieceHaut(aTourner,afficher);
				break;
			case DEUXCENTSOIXANTEDIX :
				aTourner.angle = Angle.QUATREVINGTDIX;
				tournerPieceHaut(aTourner,afficher);
				break;
			default :
				break;
			}
			break;

		case FormeL :

			switch(aTourner.angle){
			case ZERO :
				aTourner.angle = Angle.CENTQUATREVINGT;
				tournerPieceHaut(aTourner,afficher);
				break;
			case QUATREVINGTDIX :
				aTourner.angle = Angle.DEUXCENTSOIXANTEDIX;
				tournerPieceHaut(aTourner,afficher);
				break;
			case CENTQUATREVINGT :
				aTourner.angle = Angle.ZERO;
				tournerPieceHaut(aTourner,afficher);
				break;
			case DEUXCENTSOIXANTEDIX :
				aTourner.angle = Angle.QUATREVINGTDIX;
				tournerPieceHaut(aTourner,afficher);
				break;
			default :
				break;
			}
			break;

		case FormeJ :

			switch(aTourner.angle){
			case ZERO :
				aTourner.angle = Angle.CENTQUATREVINGT;
				tournerPieceHaut(aTourner,afficher);
				break;
			case QUATREVINGTDIX :
				aTourner.angle = Angle.DEUXCENTSOIXANTEDIX;
				tournerPieceHaut(aTourner,afficher);
				break;
			case CENTQUATREVINGT :
				aTourner.angle = Angle.ZERO;
				tournerPieceHaut(aTourner,afficher);
				break;
			case DEUXCENTSOIXANTEDIX :
				aTourner.angle = Angle.QUATREVINGTDIX;
				tournerPieceHaut(aTourner,afficher);
				break;
			default :
				break;
			}
			break;

		case FormeZ :

			switch(aTourner.angle){
			case ZERO :
				tournerPieceHaut(aTourner,afficher);
				break;
			case CENTQUATREVINGT :
				tournerPieceHaut(aTourner,afficher);
				break;
			default :
				break;
			}
			break;

		case FormeS :

			switch(aTourner.angle){
			case ZERO :
				tournerPieceHaut(aTourner,afficher);
				break;
			case CENTQUATREVINGT :
				tournerPieceHaut(aTourner,afficher);
				break;
			default :
				break;
			}
			break;

		case PasForme :

			System.err.println("Impossible de tourner une Piece n'ayant pas de forme");
			System.exit(3);
			break;

		default :   

			System.err.println("Impossible de tourner une Piece n'ayant pas de type");
			System.exit(4);
			break;
		}
	}

	public void tournerPieceHaut(Piece aTourner, boolean afficher){
		if(afficher==true)delPieceDansLePanneau(aTourner);
		switch(aTourner.getForme()){

		case FormeI:

			switch(aTourner.angle){
			case ZERO :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[2][0].setForme(Forme.FormeI);
				aTourner.piece[2][1].setForme(Forme.FormeI);
				aTourner.piece[2][2].setForme(Forme.FormeI);
				aTourner.piece[2][3].setForme(Forme.FormeI);
				aTourner.piece[2][0].setCouleur("Rouge");
				aTourner.piece[2][1].setCouleur("Rouge");
				aTourner.piece[2][2].setCouleur("Rouge");
				aTourner.piece[2][3].setCouleur("Rouge");
				aTourner.angle = Angle.CENTQUATREVINGT;
				break;
			case CENTQUATREVINGT :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[0][1].setForme(Forme.FormeI);
				aTourner.piece[1][1].setForme(Forme.FormeI);
				aTourner.piece[2][1].setForme(Forme.FormeI);
				aTourner.piece[3][1].setForme(Forme.FormeI);
				aTourner.piece[0][1].setCouleur("Rouge");
				aTourner.piece[1][1].setCouleur("Rouge");
				aTourner.piece[2][1].setCouleur("Rouge");
				aTourner.piece[3][1].setCouleur("Rouge");
				aTourner.angle = Angle.ZERO;
				break;
			default :
				break;
			}
			break;

		case FormeO :
			break;

		case FormeT :

			switch(aTourner.angle){
			case ZERO :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[2][0].setForme(Forme.FormeT);
				aTourner.piece[2][1].setForme(Forme.FormeT);
				aTourner.piece[2][2].setForme(Forme.FormeT);
				aTourner.piece[3][1].setForme(Forme.FormeT);
				aTourner.piece[2][0].setCouleur("Orange");
				aTourner.piece[2][1].setCouleur("Orange");
				aTourner.piece[2][2].setCouleur("Orange");
				aTourner.piece[3][1].setCouleur("Orange");
				aTourner.angle = Angle.QUATREVINGTDIX;
				break;
			case QUATREVINGTDIX :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[2][0].setForme(Forme.FormeT);
				aTourner.piece[1][1].setForme(Forme.FormeT);
				aTourner.piece[2][1].setForme(Forme.FormeT);
				aTourner.piece[3][1].setForme(Forme.FormeT);
				aTourner.piece[2][0].setCouleur("Orange");
				aTourner.piece[1][1].setCouleur("Orange");
				aTourner.piece[2][1].setCouleur("Orange");
				aTourner.piece[3][1].setCouleur("Orange");
				aTourner.angle = Angle.CENTQUATREVINGT;
				break;
			case CENTQUATREVINGT :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][1].setForme(Forme.FormeT);
				aTourner.piece[2][0].setForme(Forme.FormeT);
				aTourner.piece[2][1].setForme(Forme.FormeT);
				aTourner.piece[2][2].setForme(Forme.FormeT);
				aTourner.piece[1][1].setCouleur("Orange");
				aTourner.piece[2][0].setCouleur("Orange");
				aTourner.piece[2][1].setCouleur("Orange");
				aTourner.piece[2][2].setCouleur("Orange");
				aTourner.angle = Angle.DEUXCENTSOIXANTEDIX;
				break;
			case DEUXCENTSOIXANTEDIX :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][1].setForme(Forme.FormeT);
				aTourner.piece[2][1].setForme(Forme.FormeT);
				aTourner.piece[3][1].setForme(Forme.FormeT);
				aTourner.piece[2][2].setForme(Forme.FormeT);
				aTourner.piece[1][1].setCouleur("Orange");
				aTourner.piece[2][1].setCouleur("Orange");
				aTourner.piece[3][1].setCouleur("Orange");
				aTourner.piece[2][2].setCouleur("Orange");
				aTourner.angle = Angle.ZERO;
				break;
			default :
				break;
			}
			break;

		case FormeL :

			switch(aTourner.angle){
			case ZERO :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[2][0].setForme(Forme.FormeL);
				aTourner.piece[2][1].setForme(Forme.FormeL);
				aTourner.piece[2][2].setForme(Forme.FormeL);
				aTourner.piece[3][2].setForme(Forme.FormeL);
				aTourner.piece[2][0].setCouleur("Magenta");
				aTourner.piece[2][1].setCouleur("Magenta");
				aTourner.piece[2][2].setCouleur("Magenta");
				aTourner.piece[3][2].setCouleur("Magenta");
				aTourner.angle = Angle.QUATREVINGTDIX;
				break;
			case QUATREVINGTDIX :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[3][0].setForme(Forme.FormeL);
				aTourner.piece[1][1].setForme(Forme.FormeL);
				aTourner.piece[2][1].setForme(Forme.FormeL);
				aTourner.piece[3][1].setForme(Forme.FormeL);
				aTourner.piece[3][0].setCouleur("Magenta");
				aTourner.piece[1][1].setCouleur("Magenta");
				aTourner.piece[2][1].setCouleur("Magenta");
				aTourner.piece[3][1].setCouleur("Magenta");
				aTourner.angle = Angle.CENTQUATREVINGT;
				break;
			case CENTQUATREVINGT :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][0].setForme(Forme.FormeL);
				aTourner.piece[2][0].setForme(Forme.FormeL);
				aTourner.piece[2][1].setForme(Forme.FormeL);
				aTourner.piece[2][2].setForme(Forme.FormeL);
				aTourner.piece[1][0].setCouleur("Magenta");
				aTourner.piece[2][0].setCouleur("Magenta");
				aTourner.piece[2][1].setCouleur("Magenta");
				aTourner.piece[2][2].setCouleur("Magenta");
				aTourner.angle = Angle.DEUXCENTSOIXANTEDIX;
				break;
			case DEUXCENTSOIXANTEDIX :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][1].setForme(Forme.FormeL);
				aTourner.piece[2][1].setForme(Forme.FormeL);
				aTourner.piece[3][1].setForme(Forme.FormeL);
				aTourner.piece[1][2].setForme(Forme.FormeL);
				aTourner.piece[1][1].setCouleur("Magenta");
				aTourner.piece[2][1].setCouleur("Magenta");
				aTourner.piece[3][1].setCouleur("Magenta");
				aTourner.piece[1][2].setCouleur("Magenta");
				aTourner.angle = Angle.ZERO;
				break;
			default :
				break;
			}
			break;

		case FormeJ :

			switch(aTourner.angle){
			case ZERO :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[2][0].setForme(Forme.FormeJ);
				aTourner.piece[2][1].setForme(Forme.FormeJ);
				aTourner.piece[2][2].setForme(Forme.FormeJ);
				aTourner.piece[3][0].setForme(Forme.FormeJ);
				aTourner.piece[2][0].setCouleur("Blanc");
				aTourner.piece[2][1].setCouleur("Blanc");
				aTourner.piece[2][2].setCouleur("Blanc");
				aTourner.piece[3][0].setCouleur("Blanc");
				aTourner.angle = Angle.QUATREVINGTDIX;
				break;
			case QUATREVINGTDIX :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][0].setForme(Forme.FormeJ);
				aTourner.piece[1][1].setForme(Forme.FormeJ);
				aTourner.piece[2][1].setForme(Forme.FormeJ);
				aTourner.piece[3][1].setForme(Forme.FormeJ);
				aTourner.piece[1][0].setCouleur("Blanc");
				aTourner.piece[1][1].setCouleur("Blanc");
				aTourner.piece[2][1].setCouleur("Blanc");
				aTourner.piece[3][1].setCouleur("Blanc");
				aTourner.angle = Angle.CENTQUATREVINGT;
				break;
			case CENTQUATREVINGT :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][2].setForme(Forme.FormeJ);
				aTourner.piece[2][0].setForme(Forme.FormeJ);
				aTourner.piece[2][1].setForme(Forme.FormeJ);
				aTourner.piece[2][2].setForme(Forme.FormeJ);
				aTourner.piece[1][2].setCouleur("Blanc");
				aTourner.piece[2][0].setCouleur("Blanc");
				aTourner.piece[2][1].setCouleur("Blanc");
				aTourner.piece[2][2].setCouleur("Blanc");
				aTourner.angle = Angle.DEUXCENTSOIXANTEDIX;
				break;
			case DEUXCENTSOIXANTEDIX :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][1].setForme(Forme.FormeJ);
				aTourner.piece[2][1].setForme(Forme.FormeJ);
				aTourner.piece[3][1].setForme(Forme.FormeJ);
				aTourner.piece[3][2].setForme(Forme.FormeJ);
				aTourner.piece[1][1].setCouleur("Blanc");
				aTourner.piece[2][1].setCouleur("Blanc");
				aTourner.piece[3][1].setCouleur("Blanc");
				aTourner.piece[3][2].setCouleur("Blanc");
				aTourner.angle = Angle.ZERO;
				break;
			default :
				break;
			}
			break;

		case FormeZ :

			switch(aTourner.angle){
			case ZERO :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[3][0].setForme(Forme.FormeZ);
				aTourner.piece[3][1].setForme(Forme.FormeZ);
				aTourner.piece[2][1].setForme(Forme.FormeZ);
				aTourner.piece[2][2].setForme(Forme.FormeZ);
				aTourner.piece[3][0].setCouleur("Jaune");
				aTourner.piece[3][1].setCouleur("Jaune");
				aTourner.piece[2][1].setCouleur("Jaune");
				aTourner.piece[2][2].setCouleur("Jaune");
				aTourner.angle = Angle.CENTQUATREVINGT;
				break;
			case CENTQUATREVINGT :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][1].setForme(Forme.FormeZ);
				aTourner.piece[2][2].setForme(Forme.FormeZ);
				aTourner.piece[2][1].setForme(Forme.FormeZ);
				aTourner.piece[3][2].setForme(Forme.FormeZ);
				aTourner.piece[1][1].setCouleur("Jaune");
				aTourner.piece[2][2].setCouleur("Jaune");
				aTourner.piece[2][1].setCouleur("Jaune");
				aTourner.piece[3][2].setCouleur("Jaune");
				aTourner.angle = Angle.ZERO;
				break;
			default :
				break;
			}
			break;

		case FormeS :
			switch(aTourner.angle){
			case ZERO :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[2][0].setForme(Forme.FormeS);
				aTourner.piece[2][1].setForme(Forme.FormeS);
				aTourner.piece[3][1].setForme(Forme.FormeS);
				aTourner.piece[3][2].setForme(Forme.FormeS);
				aTourner.piece[2][0].setCouleur("Vert");
				aTourner.piece[2][1].setCouleur("Vert");
				aTourner.piece[3][1].setCouleur("Vert");
				aTourner.piece[3][2].setCouleur("Vert");
				aTourner.angle = Angle.CENTQUATREVINGT;
				break;
			case CENTQUATREVINGT :
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						aTourner.piece[i][j] = new Cube();
					}
				}
				aTourner.piece[1][2].setForme(Forme.FormeS);
				aTourner.piece[2][1].setForme(Forme.FormeS);
				aTourner.piece[2][2].setForme(Forme.FormeS);
				aTourner.piece[3][1].setForme(Forme.FormeS);
				aTourner.piece[1][2].setCouleur("Vert");
				aTourner.piece[2][1].setCouleur("Vert");
				aTourner.piece[2][2].setCouleur("Vert");
				aTourner.piece[3][1].setCouleur("Vert");
				aTourner.angle = Angle.ZERO;
				break;
			default :
				break;
			}
			break;

		case PasForme :
			System.err.println("Impossible de tourner une Piece n'ayant pas de forme");
			System.exit(3);
			break;

		default :
			System.err.println("Impossible de tourner une Piece n'ayant pas de type");
			System.exit(4);
			break;

		}
		if(afficher==true)putPieceDansLePanneau(aTourner);  
	}

	@Override
	protected Piece clone() throws CloneNotSupportedException {
		Piece o = new Piece(this.getForme(), this.panneau);
		try {
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					o.piece[i][j]= this.piece[i][j].clone();
				}
			}
			o.setAngle(this.getAngle());
			o.setPos(new Position(this.getPos().getX(),this.getPos().getY()));
			o.setForme(this.getForme());
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		return o;

	}

	@Override
	public String toString() {
		return "Piece [piece=" + Arrays.toString(piece) + ", angle=" + angle + ", pos=" + pos + ", panneau=" + panneau
				+ "]";
	}
}

