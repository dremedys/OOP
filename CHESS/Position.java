package CHESS;

public class Position {
	private int x;
	private int y;
	Piece piece;
	Position(String s){
		setX( 8- ( (int) (s.charAt(1)) - 48)); //X is digit (1-8)
		setY((int)(s.charAt(0))- 97); // letter is Y
		
	}
	
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass()!=(o.getClass())) return false;
		Position p = (Position)o;
		return getX() == p.getX() && getY() == p.getY();
	}
	
	boolean inBorder() {
		return getX()>=0 && getX()<=8 && getY()>=0 && getY()<=8 ;
	}
	
	public int hashCode() {
		int ans = 31;
		ans += 17*ans + getX();
		ans += 17*ans + getY();
		return ans;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
