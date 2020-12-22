package oop;
import lab1.Student;
import java.util.*;
public class GradeBookTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Course oop= new Course("OOP");
		GradeBook myGradeBook= new GradeBook(oop);
		Student s1=new Student("Darikew");
		Student s2= new Student("Janerke");
		Student s3= new Student("Nazken");
		myGradeBook.addStudent(s1);
		myGradeBook.addStudent(s2);
		myGradeBook.addStudent(s3);
		myGradeBook.displayMessage();
		for (Student key : myGradeBook.grades.keySet())  {
            System.out.print("Student "+key.name+ ":   ");
	        int num = scan.nextInt();
	        myGradeBook.setGrade(key,num);
	        
		}
		scan.close();
		myGradeBook.displayGradeReport();
	}

}
