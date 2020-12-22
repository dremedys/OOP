package lab3;

public class Sweather extends Clothing{
	
	int lenOfNeck;
	int levelOfWarmness;
	
	public Sweather(String color, int size, boolean forMen, String madeIn) {
		super(color, size, forMen, madeIn);
	}

	public Sweather(String color, int size, boolean forMen, String madeIn, int lenOfNeck, int levelOfWarmness) {
		super(color, size, forMen, madeIn);
		this.lenOfNeck = lenOfNeck;
		this.levelOfWarmness = levelOfWarmness;
	}

	
	public String toString() {
		return super.toString() + ",  lenOfNeck " + lenOfNeck + ", levelOfWarmness " + levelOfWarmness ;
	}

	@Override 
	void wear() {
		//something wearing
		System.out.print("*wearing swather from neck*");
		
	}
	
}
