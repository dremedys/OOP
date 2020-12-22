package Threads;
public class estimatePi extends Thread{
	static int  countTotal = 0;
	static int countInside = 0;
	private static boolean inCircle(double x,double y) {
		return x*x+y*y <= 1;
	}
	public estimatePi() {
		
	}
	public synchronized void run() {
		makeAccurater();
	}
	static synchronized void makeAccurater() {
		double x = Math.random();
		double y = Math.random();
		if(inCircle(x,y)) {
			countInside++;
		}
		countTotal++;
			System.out.println("Trying to be accurate..Attempt number "+ countTotal);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
			  System.out.println("\nNow estimation is: "+4*(double)countInside/(double)countTotal);	 
	}
}
