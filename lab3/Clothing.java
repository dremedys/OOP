package lab3;

import java.util.Objects;

public abstract class Clothing {
	String color;
	int size;
	boolean forMen;
	private String madeIn;
	abstract void wear();
	
	public String toString() {
		return "color=" + color + ", size " + size + ", forMen " + forMen + ", madeIn " + madeIn ;
	}
	public Clothing(String color, int size, boolean forMen, String madeIn) {
		super();
		this.color = color;
		this.size = size;
		this.forMen = forMen;
		this.madeIn = madeIn;
	}
	
	public int hashCode() {
		return Objects.hash(color, forMen, madeIn, size);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Clothing)) {
			return false;
		}
		Clothing other = (Clothing) obj;
		return Objects.equals(color, other.color) && forMen == other.forMen && Objects.equals(madeIn, other.madeIn)
				&& size == other.size;
	}
	
	
}
