package CHESS;

public class Queen extends Piece{
	Queen(Position position,boolean isBlack){
		super(isBlack,position);
	}
	boolean isLegalMove(Position b) {
		Elephant e = new Elephant(this.position,this.isBlack);
		Rook r = new Rook(this.position,this.isBlack);
		if ( e.isLegalMove(b) || r.isLegalMove(b)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return isBlack? "♚" : "♔";
	}
}
