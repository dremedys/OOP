package week9;

public class Parallelogram extends Rectangle{
	int alpha;
	Parallelogram(int width, int length, String name) {
		super(width, length, name);
		// TODO Auto-generated constructor stub
	}
	Parallelogram(int width, int length, String name,int alpha) {
		super(width, length, name);
		this.alpha = alpha;
		// TODO Auto-generated constructor stub
	}
	public int compareTo(Rectangle r) {
		if(r.getClass() == this.getClass()) {
			Parallelogram other = (Parallelogram)r;
			if(super.compareTo(r)==0) {
				if(this.alpha > other.alpha) {
					return 1;
				}
				if(this.alpha< other.alpha) {
					return -1;
				}
			}
		}
		return super.compareTo(r);
	}
	
}
