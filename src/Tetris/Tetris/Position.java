package Tetris;

public class Position {

	//Attributs
	private int x;
	private int y;

	//Constructeurs
	public Position(){
		setX(0);
		setY(0);
	}

	public Position(int x, int y){
		setX(x);
		setY(y);
	}

	//Accesseurs
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	//Methodes
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
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
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}
}
