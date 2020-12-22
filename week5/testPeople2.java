package week5;

import java.util.Vector;

public class testPeople2 {

	public static void main(String[] args) {
		Person p = new Person();
		Student s = new Student();
		Person ps = new Student();
		
		p = ps; //OKAY CAUSE STUDENT CAN BECOME PERSON
		p = s;   //OKAY LIKE PREV
		//s = p; //not every person is student. REFERENCE TO STUDENT CANT REFER TO PESRON
		//s = ps;  //cannot make person(decl class bolsada  tek)
 		ps = s;   //student isstudent
		ps = p;  //  it is declared as person
		//ps.getStudentNumber();  //personda zhok metod koi 
		
		
		Vector<Person> People= new Vector<Person>();
		//Person p1= new Person("Zaure","Koktem");
	//	People.add(p1);
		Student s1= new Student("Dariga","Almaty","FIT",2,26000);
		People.add(s1);
		//Person p2=s1;
		//System.out.print(p2.says+"\n");  //when you call field DECLARED TYPE works
		System.out.print(s1.says);   // s1 own field
		//System.out.print(p2.amandasu()+"\n");  //when you call method ACTUAL CLASS WORKS
		System.out.print(s1.amandasu());   //SO THEY ARE SAME
		//Student s3= p1; //Type mismatch: cannot convert from Person to Student

	}

}
