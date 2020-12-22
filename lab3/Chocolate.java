package lab3;

public class Chocolate implements Comparable<Chocolate> {
	String name;
	double weight;
	public Chocolate(int weight,String name) {
		this.weight= weight;
		this.name = name;
	}
	public String toString() {
		return "This is " + name + " with weight " + weight; 
	}


	public int compareTo(Chocolate c ) {
		
		if(this.weight > c.weight) {
			return 1;
		}
		if(this.weight < c.weight) {
			return -1;
		}
		return 0;
	}
}
