package CHESS;

public class Rook extends Piece{
	public Rook(Position position,boolean isBlack){
		super(isBlack,position);
		
		
	}
	
	boolean isLegalMove(Position b) {
		if (( position.getX()==b.getX() || position.getY()==b.getY()) && Piece.isLegalMove( this.position , b) ) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return isBlack? "♜" : "♖" ;
	}
}
