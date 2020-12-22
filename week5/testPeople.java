package week5;

import java.util.*;

public class testPeople {

	public static void main(String[] args) {
		Vector<Person> People= new Vector<Person>();
		
		Student s1= new Student("Darik","Oktem-6","fit",2,26000);
		Staff sf1= new Staff("Kabeo","Oldar","lyceum",200000);

		People.add(s1);
		People.add(sf1);
		Iterator<Person> value = People.iterator(); 
		while (value.hasNext()) { 
            System.out.println(value.next().toString()); 
        }
	
		
		
		
	}

}
