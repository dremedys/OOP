package CHESS;


public abstract class Piece {
	Position position ;
	boolean isBlack = true;
	Piece(boolean isBlack,Position position){
		this.isBlack = isBlack;
		this.position = position;
	}
	void changePosition(Position p) {
		this.position = p;
	}
	
	abstract boolean isLegalMove(Position b) ;
	
	
	static boolean isLegalMove(Position a,Position b) {
		if(a.equals(b) || !b.inBorder()) {
			return false;
		}
		return true;
	}
	
	public abstract String toString();
}
