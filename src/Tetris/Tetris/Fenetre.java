package Tetris;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.apple.eawt.Application;

public class Fenetre extends JFrame{

	//Attributs
	private static final long serialVersionUID = 5718737413517809404L;
	private Thread monThread;
	private boolean pauseThread;
	private Panneau monPanneau;

	//Constructeur
	public Fenetre(int x, int y){
		this.setTitle("Tetris");
		//A virer si non compiler sur mac
		if(System.getProperty("os.name").equals("Mac OS X")){
			try{
				Application application = Application.getApplication(); //Récupération de l'application Tetris
				application.setDockIconImage(new ImageIcon(this.getClass().getResource("tetrisLogo.jpg")).getImage());//Ajout de l'icone du doc
			} catch(Exception e) {
                System.out.println("Impossible de charger l'icone");
			}
		}
		if(System.getProperty("os.name").equals("Windows 8.1")){
			try{
				setIconImage(new ImageIcon(this.getClass().getResource("tetrisLogo.jpg")).getImage()); //Ajout de l'icone
			} catch(Exception e) {
				System.out.println("Impossible de charger l'icone");
			}
		}
		if(System.getProperty("os.name").equals("Linux")){
				//Ne rien faire 
		}
		if(x>0&&y>0){
			this.setSize(x,y);
		}else{
			this.setSize(200,100);
		}
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		monThread = new Thread(new PlayTetris(this));
		monThread.start();	
		this.setVisible(true);
	}

	//Accesseurs
	public Thread getMonThread() {
		return monThread;
	}

	public void setMonThread(Thread monThread) {
		this.monThread = monThread;
	}
	public boolean isPauseThread() {
		return pauseThread;
	}

	public void setPauseThread(boolean pauseThread) {
		this.pauseThread = pauseThread;
	}

	public Fenetre(){
		this(200,100);
	}

	public Panneau getMonPanneau() {
		return monPanneau;
	}

	public void setMonPanneau(Panneau monPanneau) {
		this.monPanneau = monPanneau;
	}

	//Méthode
	public void détruire(){
		System.exit(0);
	}
}
