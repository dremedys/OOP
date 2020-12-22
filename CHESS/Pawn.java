package CHESS;

public class Pawn extends Piece{
	boolean isFirstMove;
	Pawn(Position position,boolean isBlack){
		super(isBlack,position);
		isFirstMove=true;
	}
	boolean isLegalMove(Position b) {
		if(isLegalMove( this.position , b)) {
			if(isBlack) {
				if(isFirstMove) {
					if(position.getX()-b.getX()==-1 || position.getX()-b.getX()==-2 ) 
						isFirstMove=false;
						return true;
				}
				else if(position.getX()-b.getX()==-1 )
					 
						return true;
				}
			else {
				if(isFirstMove) {
					if(position.getX()-b.getX()==1 ||position.getX()-b.getX()==2 ) 
						return true;
				}
				
				
			
			else {if(position.getX()-b.getX()==1 )
				 
					return true;}
			}
			
		}			
		return false;
		}
		
	
	@Override
	public String toString() {
		return isBlack? "♟" : "♙";
	}
}
