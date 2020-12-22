package oop;
import java.util.Scanner;
public class Analyser {

	public static void main(String[] args) {
		String s="";
		Scanner scan = new Scanner(System.in);
		Data data= new Data();
		double number;
		while(true) {
			s=scan.nextLine();
			if(s.equals("Q")) {
				System.out.print("Maximum: "+data.getMaxi()+'\n');
				System.out.print("Average: "+data.average());
				break;
			}
			 else {
				number = Double.parseDouble(s);
				data.addValue(number);
				}
			}
		scan.close();
	}
	}

	


