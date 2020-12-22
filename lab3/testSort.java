package lab3;

import java.util.Date;

import week2.Time;


public class testSort {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)  {
		Chocolate choco1 = new Chocolate(1, "Rahat");
		Chocolate choco2 = new Chocolate(2, "YoYo");
		Chocolate choco3 = new Chocolate(5, "Merci");
		Chocolate[] array1 = new Chocolate[3];
		array1[0] = choco1;
		array1[1] = choco2;
		array1[2] = choco3; 
		
		
		Sort.bubbleSort(array1);
		System.out.print("Sorted chocolate:\n");
		for(Chocolate chocos: array1) {
			System.out.println(chocos);
		}
		
		
		Employee[] array2 = new Employee[3];
		
		Employee e1 = new Employee("Jane", "1234",1200,new Date(2002,11,11));
		Employee e2 = new Employee("Dan","763",3000,new Date(2001,1,1));
		Employee e3 = new Employee("Muna","577",600,new Date(2000,12,43));
		
		array2[0] = e1;
		array2[1] = e2;
		array2[2] = e3;
		
		
		Sort.quickSort(array2, 0, array1.length-1);
		System.out.println("sorted employee:\n");
		for(Employee emp: array2) {
			System.out.println(emp);
		}
		
		Time t1 = new Time(23, 5, 6);
		Time t2 = new Time(12, 20, 59);
		Time t3 = new Time(12, 20, 44);
		
		Time[] array3 = new Time[3];
		array3[0] = t1;
		array3[1] = t2;
		array3[2] = t3;
		Sort.quickSort(array3, 0, array3.length-1);
		
		System.out.println("sorted time:\n");
		for(Time time: array3) {
			System.out.println(time.toUniversal());
		}
		
	}

}