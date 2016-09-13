package Tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Panneau extends JPanel implements Affichable{

	//Attributs :
	private static final long serialVersionUID = 6959962704014642324L;
	private int chute;
	private int lignesSupprime;
	private int niveau;
	private Cube panneau[][] = new Cube[10][22];
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private int score;
	private Position tampon;
	private boolean tombe;
	private int xActu = 4;
	private int yActu = 0;
	private int difficultee = 1;
	private Fenetre maFenetre;

	//Constructeur :
	public Panneau(Fenetre maFenetre){
		setBackground((new Color (215,215,215))); 
		setFocusable(true);
		setTombe(false);
		setNiveau(1);
		setLignesSupprime(0);
		setChute(0);
		setScore(0);
		setPieceActuelle(new Piece(Piece.formeAlea(),this));
		setPieceSuivante(new Piece(Piece.formeAlea(),this));
		for(int i=0;i<10;i++){
			for(int j=0;j<22;j++){
				this.panneau[i][j]= new Cube();
				this.panneau[i][j].setForme(Forme.PasForme);
			}
		}
		Object cleGauche = new Object();
		Object cleDroite = new Object();
		Object cleBas = new Object();
		Object cleHaut = new Object();
		Object cleEchap = new Object();
		Object cleEspace = new Object();
		InputMap inputMap = this.getInputMap();
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), cleGauche);
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), cleDroite);
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), cleBas);
		inputMap.put(KeyStroke.getKeyStroke("UP"), cleHaut);	
		inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), cleEchap);
		inputMap.put(KeyStroke.getKeyStroke("SPACE"), cleEspace);	
		getActionMap().put(cleGauche, new GaucheTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleDroite, new DroiteTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleBas, new BasTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleHaut, new HautTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleEspace, new EspaceTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleEchap, new EchapTyped((Fenetre) SwingUtilities.getWindowAncestor(this)));
		maFenetre.setMonPanneau(this);
		setMaFenetre(maFenetre);
	}

	//Début de l'implémentation de l'interface Affichable
	@Override
	public void afficherChaines(Graphics g){
		String score="Score";
		String niveau="Niveau";
		String suivant="Suivant";
		String ligne="Lignes supprimées";
        ((Fenetre) SwingUtilities.getWindowAncestor(this)).repaint();
		afficheString(g,2*this.getWidth()/20,10*this.getHeight()/30,score,Color.red);
		afficheString(g,2*this.getWidth()/20,20*this.getHeight()/30,niveau,Color.blue);
		afficheString(g,17*this.getWidth()/20,10*this.getHeight()/30,suivant,Color.green);
		afficheString(g,(int)(16.5*this.getWidth()/20),20*this.getHeight()/30,ligne,Color.yellow);
		afficheString(g,2*this.getWidth()/20,12*this.getHeight()/30,((Integer)(getScore())).toString(),Color.red);
		afficheString(g,(int )(2.25*this.getWidth()/20),22*this.getHeight()/30,((Integer)(getNiveau())).toString(),Color.blue);
		afficheString(g,(int)(17.5*this.getWidth()/20),22*this.getHeight()/30,((Integer)(getLignesSupprime())).toString(),Color.yellow);
	}

	@Override
	public void afficherCube(Graphics g,double x,double y,Cube piece){
		int a = (int) ((5+x)*this.getWidth()/20);
		int b = (int) ((5+y)*this.getHeight()/30);
		int c = (int) ((6+x)*this.getWidth()/20);
		int d = (int) ((6+y)*this.getHeight()/30);
		int e = (int) ((5.5+x)*this.getWidth()/20);
		int f = (int) ((5.5+y)*this.getHeight()/30);
		int nb = 3;
		int alpha[] = {a,c,e};
		int beta[] = {b,b,f};
		int gamma[] = {a,e,a};
		int delta[] = {b,f,d};
		int epsilon[] = {a,e,c};
		int zeta[] = {d,f,d};
		int eta[] = {c,e,c};
		int theta[] = {d,f,b};
		Color couleur[] = piece.getCouleur();
		g.setColor(couleur[0]);
		g.fillPolygon(alpha, beta, nb);
		g.setColor(couleur[1]);
		g.fillPolygon(gamma, delta, nb);
		g.setColor(couleur[2]);
		g.fillPolygon(epsilon,zeta, nb);
		g.setColor(couleur[3]);
		g.fillPolygon(eta, theta, nb);
	}

	@Override
	public void afficheRect(Graphics g,boolean plein,int x, int y){
		if(plein){   
			g.fillRect(x, y, this.getWidth()/20, this.getHeight()/30);
		}else{
			g.drawRect(x, y, this.getWidth()/20, this.getHeight()/30);
		}
	}

	@Override
	public void afficherPieceSuivante(Graphics g, Piece aAfficher) {		
		g.setColor(Color.black);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				this.afficherCube(g,10.5+i,6+j,aAfficher.getCubeXY(i,j));
			}
		}
		g.drawRect((int) (15.5*this.getWidth()/20), 11*this.getHeight()/30, 4*this.getWidth()/20, 4*this.getHeight()/30);
		for(int i=0;i<4;i++){
			g.drawLine((int) ((15.5+i)*this.getWidth()/20), 11*this.getHeight()/30,(int) ((15.5+i)*this.getWidth()/20), 15*this.getHeight()/30);
		}
		for(int i=0;i<4;i++){
			g.drawLine((int) ((15.5)*this.getWidth()/20),(11+i)*this.getHeight()/30,(int) ((19.5)*this.getWidth()/20),(11+i)*this.getHeight()/30);
		}
	}

	@Override
	public void afficherPlateau(Graphics g){
		g.setColor(Color.gray);
		g.drawRect(5*this.getWidth()/20, 5*this.getHeight()/30, 10*this.getWidth()/20, 20*this.getHeight()/30);
		for(int i=1;i<10;i++){
			g.drawLine((5+i)*this.getWidth()/20,5*this.getHeight()/30 ,(5+i)*this.getWidth()/20,25*this.getHeight()/30);
		}
		for(int i=1;i<20;i++){
			g.drawLine(5*this.getWidth()/20,(5+i)*this.getHeight()/30 ,15*this.getWidth()/20,(5+i)*this.getHeight()/30);
		}
		afficherPieceSuivante(g,getPieceSuivante());
	}

	@Override
	public void afficheString(Graphics g,int x, int y,final String string, Color c){
		int taille =(int) (Math.sqrt(this.getWidth()*this.getWidth()+this.getHeight()*this.getHeight())/100);
		Font font  = new Font("Courier", Font.BOLD,taille);
		g.setFont(font);
		g.setColor(c);
		g.drawString(string,x,y);
		g.setColor(Color.black);
	}

	@Override
	public void nettoyerJeu(){
		setBackground((new Color (215,215,215))); 
		setFocusable(true);
		setTombe(false);
		setNiveau(1);
		setLignesSupprime(0);
		setChute(0);
		setScore(0);
		setPieceActuelle(new Piece(Piece.formeAlea(),this));
		setPieceSuivante(new Piece(Piece.formeAlea(),this));
		for(int i=0;i<10;i++){
			for(int j=0;j<22;j++){
				this.panneau[i][j]= new Cube();
				this.panneau[i][j].setForme(Forme.PasForme);
			}
		}
		Object cleGauche = new Object();
		Object cleDroite = new Object();
		Object cleBas = new Object();
		Object cleHaut = new Object();
		Object cleEchap = new Object();
		Object cleEspace = new Object();
		InputMap inputMap = this.getInputMap();
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), cleGauche);
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), cleDroite);
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), cleBas);
		inputMap.put(KeyStroke.getKeyStroke("UP"), cleHaut);	
		inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), cleEchap);
		inputMap.put(KeyStroke.getKeyStroke("SPACE"), cleEspace);	
		getActionMap().put(cleGauche, new GaucheTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleDroite, new DroiteTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleBas, new BasTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleHaut, new HautTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleEspace, new EspaceTyped(this,new Position(getXActu(), getYActu())));
		getActionMap().put(cleEchap, new EchapTyped((Fenetre) SwingUtilities.getWindowAncestor(this)));
		getMaFenetre().setMonPanneau(this);
	}

	//Fin de l'implémentation de l'interface Affichable

	//Accesseurs
	public Fenetre getMaFenetre() {
		return maFenetre;
	}

	public void setMaFenetre(Fenetre maFenetre) {
		this.maFenetre = maFenetre;
	}

	public int getDifficultee() {
		return difficultee;
	}

	public void setDifficultee(int difficultee) {
		this.difficultee = difficultee;
	}

	public int getChute() {
		return chute;
	}

	public Cube getCubeXY(int x, int y ){
		return this.panneau[x][y];
	}

	public Forme getFormeXY(int x,int y){
		return getCubeXY(x,y).getForme();
	}

	public int getLignesSupprime() {
		return lignesSupprime;
	}

	public int getNiveau() {
		return niveau;
	}

	public Cube[][] getPanneau() {
		return panneau;
	}

	public Piece getPieceActuelle() {
		return pieceActuelle;
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	public int getScore() {
		return score;
	}

	public Position getTampon() {
		return tampon;
	}

	public int getxActu() {
		return xActu;
	}

	public int getXActu() {
		return xActu;
	}

	public int getyActu() {
		return yActu;
	}

	public int getYActu() {
		return yActu;
	}

	public boolean isTombe() {
		return tombe;
	}

	public void majNiveau(){
		setNiveau((getScore()/10000)+1);
	}

	public void setChute(int chute) {
		this.chute = chute;
	}

	public void setCubeXY(Cube nouveauCube,int x, int y ){
		this.panneau[x][y]=nouveauCube;
		repaint();
	}

	public void setFormeXY(int x ,int y, Forme forme){
		getCubeXY(x,y).setForme(forme);
	}

	public void setLignesSupprime(int lignesSupprime) {
		this.lignesSupprime = lignesSupprime;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setPanneau(Cube[][] panneau) {
		this.panneau = panneau;
	}

	public void setPieceActuelle(Piece pieceActuelle) {
		this.pieceActuelle = pieceActuelle;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		this.pieceSuivante = pieceSuivante;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setTampon(Position tampon) {
		this.tampon = tampon;
	}

	public void setTombe(boolean tombe) {
		this.tombe = tombe;
	}

	public void setxActu(int xActu) {
		this.xActu = xActu;
	}

	public void setXActu(int xActu) {
		this.xActu = xActu;
	}

	public void setyActu(int yActu) {
		this.yActu = yActu;
	}

	public void setYActu(int yActu) {
		this.yActu = yActu;
	}
	//Méthodes
	@Override
	public void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
		if(((Fenetre) SwingUtilities.getWindowAncestor(this)).isPauseThread() == false){
			for(int i=0;i<10;i++){
				for(int j=2;j<22;j++){
					this.afficherCube(g,i,j-2,panneau[i][j]);
				}
			}
			afficherChaines(g);
			afficherPlateau(g);
			g.dispose();
			if(this.tombe == false){
				repaint();
				suppressionDesLignes();  
				setPieceActuelle(pieceSuivante);
				setPieceSuivante(new Piece(Piece.formeAlea(),this));
				try{
					boolean deplacementValide = true;
					getPieceActuelle().delPieceDansLePanneau(getPieceActuelle());
					try {
						Piece pieceTest = getPieceActuelle().clone();
						pieceTest.tournerPieceBas(pieceTest,false);
						int tmpx, tmpy;
						for(int i=0;i<4;i++){
							for(int j=0;j<4;j++){
								tmpx = i+pieceTest.getPos().getX()-2;
								tmpy = j+pieceTest.getPos().getY()-1;
								if((tmpx<0||tmpy<0|| tmpx>=10||tmpy>=22)&&(pieceTest.getFormeEnXY(i,j)!=Forme.PasForme)){
									deplacementValide = false;   
								}
								if(((tmpx>=0&&tmpy>=0&&tmpx<10&&tmpy<22))){
									if((this.getFormeXY(tmpx,tmpy)!=Forme.PasForme)&&(pieceTest.getFormeEnXY(i,j)!=Forme.PasForme)){
										deplacementValide = false;
									}
								}
							}
						}
					} catch (CloneNotSupportedException e1) {
						System.err.println("Erreur de clonage de la piece");
					}
					if(deplacementValide==true){
						getPieceActuelle().putPieceDansLePanneau(getPieceActuelle());
					}else{
						throw new DefaiteException();
					}
				} catch(DefaiteException e){
					getMaFenetre().setPauseThread(true);
					getMaFenetre().setVisible(false);
					new MenuDuJeu(maFenetre);                  
				}
				Object cleGauche = new Object();
				Object cleDroite = new Object();
				Object cleBas = new Object();
				Object cleHaut = new Object();
				Object cleEchap = new Object();
				Object cleEspace = new Object();
				InputMap inputMap = this.getInputMap();
				inputMap.put(KeyStroke.getKeyStroke("LEFT"), cleGauche);
				inputMap.put(KeyStroke.getKeyStroke("RIGHT"), cleDroite);
				inputMap.put(KeyStroke.getKeyStroke("DOWN"), cleBas);
				inputMap.put(KeyStroke.getKeyStroke("UP"), cleHaut);	
				inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), cleEchap);
				inputMap.put(KeyStroke.getKeyStroke("SPACE"), cleEspace);	
				getActionMap().put(cleGauche, new GaucheTyped(this,new Position(getXActu(), getYActu())));
				getActionMap().put(cleDroite, new DroiteTyped(this,new Position(getXActu(), getYActu())));
				getActionMap().put(cleBas, new BasTyped(this,new Position(getXActu(), getYActu())));
				getActionMap().put(cleHaut, new HautTyped(this,new Position(getXActu(), getYActu())));
				getActionMap().put(cleEspace, new EspaceTyped(this,new Position(getXActu(), getYActu())));
				getActionMap().put(cleEchap, new EchapTyped((Fenetre) SwingUtilities.getWindowAncestor(this)));
				setChute(0);
				setTombe(true);
			}
			setChute(getChute()+1*getDifficultee());
			if(getChute()>=(150/getNiveau())){
				try{
					setTampon(getPieceActuelle().getPos());
					getPieceActuelle().deplacerPieceDeXY(pieceActuelle, new Position(0,1));
					if(getTampon().equals(getPieceActuelle().getPos())){
						this.setTombe(false);
					}
				}			
				catch (ArrayIndexOutOfBoundsException e1){
					getPieceActuelle().deplacerPieceDeXY(pieceActuelle, new Position(0,0));
				}
			}
			if(getChute()>=(150/getNiveau())){
				setChute(0);
			}
			repaint();
		}else{
			;
		}
	}

	public void suppressionDesLignes(){
		boolean supprimerUneLigne = true;
		int nbLignesEnUnCoup = 0;
		for(int j=21;j>1;j--){
			for(int i=0;i<10;i++){
				if(this.getFormeXY(i,j)==Forme.PasForme)supprimerUneLigne = false;
			}
			if(supprimerUneLigne == true){
				supprimerLaLigne(j);
				j++;
				setLignesSupprime(getLignesSupprime()+1);
				nbLignesEnUnCoup++;
			}
			setScore(getScore()+(int)(java.lang.Math.exp(nbLignesEnUnCoup)*10)+getDifficultee()*10);
			majNiveau();
			supprimerUneLigne = true;
		}
	}

	public void supprimerLaLigne(int numeroLigneAVirer){
		for(int i=0;i<4;i++){
			if((getPieceActuelle().getPos().getY()+1)==numeroLigneAVirer){
				getPieceActuelle().setCubeXY(new Cube(),i,numeroLigneAVirer-getPieceActuelle().getPos().getY()+1);
			}
		}
		int numeroL = numeroLigneAVirer;
		for(;numeroL>1;numeroL--){
			for(int i=0;i<10;i++){
				this.setCubeXY(this.getCubeXY(i,numeroL-1),i,numeroL);
			}
		}
		for(int i=0;i<10;i++){
			this.setCubeXY(new Cube(),i,0);
		}
	}

	@Override
	public String toString() {
		return "Panneau [panneau=" + Arrays.toString(panneau) + "]";
	}

}
