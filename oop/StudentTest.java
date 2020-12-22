package oop;
import lab1.Student;
public class StudentTest {

	public static void main(String[] args) {
		Student s1= new Student("Dariga");
		Student s2= new Student("Janerke");
		Student s3= new Student("Nazken");
		Course pp= new Course("PP1");
		GradeBook gb= new GradeBook(pp);
		gb.addStudent(s1);
		gb.addStudent(s2);
		gb.addStudent(s3);
		gb.setGrade(s1,10);
		gb.setGrade(s2, 34);
		gb.setGrade(s3, 55);
		System.out.print(gb.average());
		
		

	}

}
