package Tetris;

public class PlayTetris implements Runnable {

	//Attributs
	public Thread monThread;
	private Fenetre maFenetre;
	private boolean suspendu = false;

	//Constructeur
	public PlayTetris(Fenetre Fenetre){
		setMaFenetre(Fenetre);
	}

	//Accesseurs
	public Fenetre getMaFenetre() {
		return maFenetre;
	}

	public Thread getMonThread() {
		return monThread;
	}

	public boolean isSuspendu() {
		return suspendu;
	}

	public void setMaFenetre(Fenetre maFenetre) {
		this.maFenetre = maFenetre;
	}

	public void setMonThread(Thread monThread) {
		this.monThread = monThread;
	}

	public void setSuspended(boolean suspended) {
		this.suspendu = suspended;
	}

	//Méthodes
	public synchronized void reprendre() {
		suspendu = false;
		notify();
	}

	@Override
	public void run() {
		try {
			getMaFenetre().setContentPane(new Panneau(getMaFenetre()));
			getMaFenetre().setVisible(true);
			synchronized(this) {
				while(suspendu) {
					wait();
				}
			}

		} catch (InterruptedException e) {
			System.out.println("Thread suspendu");
		}
	}

	public void start (){
		if (getMonThread() == null){
			setMonThread(new Thread (this));
			getMonThread().start ();
		}
	}

	public void suspendre() {
		suspendu = true;
	}

}
