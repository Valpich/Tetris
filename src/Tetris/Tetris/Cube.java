package Tetris;

import java.awt.Color;
import java.util.Arrays;

enum Forme{FormeI, FormeO, FormeT, FormeL, FormeJ,
	FormeZ, FormeS, PasForme};

	public class Cube implements Cloneable{

		//Attributs :	
		private Forme forme;
		private Color[] couleur;

		//Constructeur
		public Cube(){
			setForme(Forme.PasForme);
			setCouleur("Noir");
		}
		//Accesseurs :
		public final Forme getForme(){
			return forme;
		}

		public final Color[] getCouleur(){
			return couleur;
		}

		public final Color getCouleurNumero(int numero){

			return couleur[numero];
		}

		public void setForme(Forme forme) {
			this.forme=forme;
		}

		public void setForme(int valeur) {
			switch(valeur){
			case 0 :
				this.setForme(Forme.FormeI);
				this.setCouleur("Rouge");
				break;
			case 1 :
				this.setForme(Forme.FormeO);
				this.setCouleur("Bleu");
				break;
			case 2 :
				this.setForme(Forme.FormeT);
				this.setCouleur("Orange");
				break;
			case 3 :
				this.setForme(Forme.FormeL);
				this.setCouleur("Magenta");
				break;
			case 4 :
				this.setForme(Forme.FormeJ);
				this.setCouleur("Jaune");
				break;
			case 5 :
				this.setForme(Forme.FormeZ);
				this.setCouleur("Vert");
				break;
			case 6 :
				this.setForme(Forme.FormeS);
				this.setCouleur("Vert");
				break;
			default :
				this.setForme(Forme.PasForme);
				this.setCouleur("Default");
				break;
			}
		}


		public void setCouleur(String couleur) {
			switch (couleur)
			{
			case "Rouge":
				Color rouge1 = new Color(255, 0, 0);
				Color rouge2 = new Color(187, 11, 11);
				Color rouge3 = new Color(237, 0, 0);
				Color rouge4 = new Color(233, 56, 63);
				Color[] tmpr={rouge1,rouge2,rouge3,rouge4};
				this.couleur=tmpr;
				break;    
			case "Bleu":
				Color bleu1 = new Color(0, 0, 255);
				Color bleu2 = new Color(121, 248, 248);
				Color bleu3 = new Color(0,127,255);
				Color bleu4 = new Color(30,127,203);
				Color[] tmpb={bleu1,bleu2,bleu3,bleu4};
				this.couleur=tmpb;
				break; 
			case "Orange":
				Color orange1 = new Color(204,85,0);
				Color orange2 = new Color(233,109,20);
				Color orange3 = new Color(237, 127, 16);
				Color orange4 = new Color(244, 102, 27);
				Color[] tmp={orange1,orange2,orange3,orange4};
				this.couleur=tmp;
				break; 
			case "Magenta":
				Color magenta1 = new Color(223, 115, 255);
				Color magenta2 = new Color(255, 0, 255);
				Color magenta3 = new Color(219, 0, 115);
				Color magenta4 = new Color(249, 66, 158);
				Color[] tmpm={magenta1,magenta2,magenta3,magenta4};
				this.couleur=tmpm;
				break; 
			case "Blanc":
				Color blanc1 = new Color(255,255,255);
				Color blanc2 = new Color(251,252,252);
				Color blanc3 = new Color(239,239,239);
				Color blanc4 = new Color(245,245,245);
				Color[] tmpbl={blanc1,blanc2,blanc3,blanc4};
				this.couleur=tmpbl;
				break; 
			case "Jaune":
				Color jaune1 = new Color(255, 255, 0);
				Color jaune2 = new Color(252, 220, 18);
				Color jaune3 = new Color(247, 255, 60);
				Color jaune4 = new Color(255, 215, 0);
				Color[] tmpg={jaune1,jaune2,jaune3,jaune4};
				this.couleur=tmpg;
				break; 
			case "Vert":
				Color vert1 = new Color(0, 255, 0);
				Color vert2 = new Color(135, 233, 144);
				Color vert3 = new Color(127, 221, 76);
				Color vert4 = new Color(1, 215, 88);
				Color[] tmpv={vert1,vert2,vert3,vert4};
				this.couleur=tmpv;
				break; 
			default:
				Color gristmp = new Color (215,215,215);
				Color[] tmpgris={gristmp,gristmp,gristmp,gristmp};      
				this.couleur=tmpgris;
			}

		}

		//Méthodes
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
			Cube other = (Cube) obj;
			return forme == other.forme;
		}

		@Override
		public String toString() {
			return "Cube [forme=" + forme + ", couleur=" + Arrays.toString(couleur) + "]";
		}

		@Override
		protected Cube clone() throws CloneNotSupportedException {
			Cube o = new Cube();
			o.setForme(this.getForme());
			o.couleur=this.getCouleur();
			return o;
		}

	}
