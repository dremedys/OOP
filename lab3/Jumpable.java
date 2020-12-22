package lab3;

public interface Jumpable extends Moveable{
	boolean CanJump(int height);
	void prepareReadyToJump();
	void jumpHorizontally(int length);
	void jumpVertically(int length);
}
