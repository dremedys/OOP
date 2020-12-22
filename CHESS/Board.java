package CHESS;

import java.util.Scanner;
import java.util.Vector;


public class Board {
	Vector <Piece> elements = new Vector<Piece>();
	{
			Rook br1 = new Rook(new Position("a8"),true);				elements.add(br1);
			Rook br2 = new Rook(new Position("h8"),true);				elements.add(br2);
			Horse bh1 = new Horse(new Position("b8"),true);		 		elements.add(bh1);
			Horse bh2 = new Horse(new Position("g8"),true);				elements.add(bh2);
			Elephant be1 = new Elephant(new Position("c8"),true);		elements.add(be1);
			Elephant be2 = new Elephant(new Position("f8"),true);		elements.add(be2);
			King bk = new King(new Position("e8"),true);				elements.add(bk);
			Queen bq = new Queen(new Position("d8"),true);				elements.add(bq);
			for(int i = 97 ; i<= 8+97 ; i++ ) {       //PAWS
				String huh = "";
				huh += (char)i;
				huh+='7';
				elements.add(new Pawn(new Position(huh),true));
			}
			Rook wr1 = new Rook(new Position("a1"),false);				elements.add(wr1);
			Rook wr2 = new Rook(new Position("h1"),false);				elements.add(wr2);
			Horse wh1 = new Horse(new Position("b1"),false);		 	elements.add(wh1);
			Horse wh2 = new Horse(new Position("g1"),false);			elements.add(wh2);
			Elephant we1  = new Elephant(new Position("c1"),false);		elements.add(we1);
			Elephant we2 = new Elephant(new Position("f1"),false);		elements.add(we2);
			King wk = new King(new Position("e1"),false);				elements.add(wk);
			Queen wq = new Queen(new Position("d1"),false);				elements.add(wq);
			for(int i = 97 ; i<= 8+97 ; i++ ) {   //PAWS
				String huh = "";
				huh += (char)i;
				huh+='2';
				elements.add(new Pawn(new Position(huh),false));
			}
			
			
			
	}
	
	
	public void showGame() {
		System.out.print("   a  b  c  d  e  f  g  h\n");
		for(int i = 0 ; i < 8 ; i++) {
			System.out.print(8-i);
			System.out.print(" ");
			out: for(int j = 0 ; j < 8 ; j++) {
				for(Piece p: elements) {
					if (p.position.getX() ==i && p.position.getY()== j) {
						
						System.out.print("[" + p + "]");
						continue out;
						}
				}
				
				System.out.print("[ ]");
						
			}
			System.out.print("\n");
		}
	}
	
	
	
	void eaten(Piece p) {
		System.out.print("oops...you ate it!\n");
		elements.remove(p);
	}
	
	void makeMove(Piece piece,Position pos,boolean isBlack) {
		if (piece.isBlack != isBlack) System.out.print("Not your color or spacy place...\n");
		
		else {
			if(piece.isLegalMove(pos)) {

				for(Piece checkPiece : elements) {
					if (checkPiece.position.equals(pos) && piece.isBlack!=checkPiece.isBlack) {
						eaten(checkPiece); //eat enemy
						break ;
					}
					else if(!checkPiece.equals(piece) &&   checkPiece.position.equals(pos) && piece.isBlack==checkPiece.isBlack) {
						System.out.print("I see you wanna go to busy place...\n");
						break;  //just busy place
					}
				
					piece.changePosition(pos);   //else just go there..
					
				}
			}
			else {
				System.out.print("You gonna make such a mistaky move..I mean illegal move:\n");
			}
		}
	}
	
	Piece findByPos(Position p) {
		
		for(Piece pi : elements) {
			if(pi.position.equals(p)) {
				return pi;
			}
		}
		return new Pawn(new Position("z9"),true);
	}
	
	void nextPlayer(boolean isBlack) {


		String s = isBlack ? "black" : "white" ;
		System.out.print("Go ahead, " + s+ "\n");
	}
	
	boolean isRunning() {
		int black = 0;
		int white = 0;
		for(Piece p : elements) {
			if(p.isBlack) {
				black += 1;
			}
			else {
				white+=1;
		
			}
		}
		return white>0 && black>0;
	}

	void showWinner() {
		String s = "idk";
		for(Piece p: elements) {
			s = p.isBlack? "black" : "white";
			break;
		}
		System.out.print("WINNER IS..."+ s);
	}
	void game() {
		Scanner scan = new Scanner(System.in);
		boolean isBlack = true;
		while(isRunning()) {   //just checking if there exist both colors
			showGame();
			
			nextPlayer(isBlack);
			System.out.print("Enter position of piece you want to move: ");
			String from = scan.next();
			System.out.print("Enter position where you want it to move ");
			String go = scan.next();
			
			makeMove(findByPos(new Position(from)),new Position(go),findByPos(new Position(from)).isBlack);
			isBlack = isBlack? false : true;  //just turn of next player
		}
		scan.close();
		showWinner();
	}



}
