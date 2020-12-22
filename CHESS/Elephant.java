package CHESS;


public class Elephant extends Piece{
	Elephant(Position position,boolean isBlack){
		super(isBlack,position);
	}
	boolean isLegalMove(Position b) {
		if ( Math.abs(position.getX()- b.getX())== Math.abs(position.getY()- b.getY()) && isLegalMove( this.position , b) ) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return isBlack? "♝" : "♗";
	}
}
