package week9;

public class Rectangle implements Comparable<Rectangle> {
	int width;
	int length;
	String name;
	Rectangle(int width,int length,String name){
		this.width = width;
		this.length = length ;
		this.name = name;
	}
	public int area() {
		return width*length;
	}
	@Override
	public int compareTo(Rectangle other) {
		if(this.area() > other.area()) {
			return 1;
		}
		if(this.area() < other.area()) {
			return -1;
		}
		return 0;
	}
	
}
