package oop;

public class RoseTest {

	public static void main(String[] args) {
		Rose r1= new Rose("Lolita","black");
		r1.setAroma(Aroma.AIDA);
		Rose r2= new Rose("Honey",null,"black",56);
		r2.setAroma(r1);
		System.out.print(r2.getAroma());
		

	}

}
