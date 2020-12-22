package lab3;

public interface Moveable {
	void move();
	void changeX(int x);
	void changeY(int y);
	boolean canGetHere(int x1,int y1);
	int timeToGoPlace(int x1,int x2);
	
}
