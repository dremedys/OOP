package oop;
public class Data {
	private double maximum=-1000000;
	private static double sum;
	private static int length;
	Data(){
		sum=0;
		length=0;
	}
	public void addValue(double n) {
		sum+=n;
		length++;
		if(n>maximum) {
			maximum=n;
		}
	}
	public double average() {
		
		return sum/Double.valueOf(length);
	}
	public double getMaxi() {
		return maximum;
	}
}
