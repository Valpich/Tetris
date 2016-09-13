package Tetris;

public class MenuDuJeu {

	//Attribut
	private boolean continuer = true;

	//Constructeur
	public MenuDuJeu(Fenetre maFenetre){	
		String[] s = null;
		PanneauMenu.main(s,maFenetre);
	}

	//Accesseurs
	public boolean isContinuer() {
		return continuer;
	}

	public void setContinuer(boolean continuer) {
		this.continuer = continuer;
	}

}
