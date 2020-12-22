package week8;


public class Example1 {
	public static void main(String[] args)
    {
		
		int a=5;
		int b=0;
		
		try {
			int ratio = a/b;
			System.out.print(ratio);
		}
		catch(ArithmeticException ex){
			//System.out.print("dont div by zero");
		}
		
		
		
    }
}
