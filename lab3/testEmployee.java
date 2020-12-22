package lab3;


import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

import java.util.Vector;

import week5.Person;
public class testEmployee {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		HashSet<Person> people = new HashSet<Person>();
		Vector<Manager> peopleArray = new Vector<Manager>();
		peopleArray.add(new Manager("Jane", "1234",1200,new Date(2002,11,11),45));
		peopleArray.add(new Manager("Dan","763",3000,new Date(2001,1,1),55));
		peopleArray.add(new Manager("Muna","577",600,new Date(2000,12,43),66));
		peopleArray.add(new Manager("Peppa","577",600,new Date(2004,3,5),90));
		
	    people.add(new Manager("Mana","555",600,new Date(2010,3,6),45.0));
		
		Collections.sort(peopleArray);
		System.out.print("Default manager sort:\n");
		for(Manager m: peopleArray) {
			System.out.print(m+"\n");
		}
		
		Collections.sort(peopleArray,new ComparatorByHireDate());
		System.out.print("Hire date sort:\n");
		for(Manager m: peopleArray) {
			System.out.print(m+"\n");
		}
		
		Collections.sort(peopleArray,new ComparatorByName());
		System.out.print("Name sort:\n");
		for(Manager m: peopleArray) {
			System.out.print(m+"\n");
		}
		Manager m1 = new Manager("Jane", "1234",1200,new Date(2002,11,11),45);
		Manager copyM = (Manager)(m1).clone();
		System.out.println("\n\n" + m1 + "\n" + copyM);

	}

}
