package CHESS;

public class Horse extends Piece {
	Horse(Position position,boolean isBlack){
		super(isBlack,position);
	}
	boolean isLegalMove(Position b) {
		if ( (Math.abs( position.getX() - b.getX())==1 &&  Math.abs( position.getY() - b.getY())==2) ||
				(Math.abs( position.getX() - b.getX())==2 &&  Math.abs( position.getY() - b.getY())==1)
				&&  isLegalMove( this.position , b) ) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return isBlack? "♞" : "♘";
	}
}
