package oop;
import lab1.Student;
import java.util.*;
public class GradeBook {
	Course course;
	Map<Student, Integer> grades = new HashMap<Student, Integer>();
	int sum;     //to store sum of all grades
	int[] cnt= new int[11];     //counter of '*' for each grade
	GradeBook(){
	
	}
	
	GradeBook(Course course){
		this.course=course;
	}
	
	public void addStudent(Student student) {
		this.grades.put(student,null);
	}
	
	
	public void setGrade(Student student,Integer grade) {
		grades.put(student,grade);
	}
	
	public double average() {
		sum = 0;
		for (Student key: grades.keySet()) {
		    sum += grades.get(key);
		}
		return sum/grades.size();
	}
	
	Student highest() {
		return grades.entrySet().stream().max( (entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
	}
	
	Student lowest() {
		return grades.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
	}
	
	public void displayMessage(){
		System.out.print("\t\tHello, Welcome to the grade book for "+course+"\n\n");
		System.out.print("Please, enter grades for students:\n");
	} 
	
	void outputBarChat() {
		for (Student key: grades.keySet()) {
		  cnt[grades.get(key)/10]++;
		}
	}
	
	void displayGradeReport() {
		System.out.print("Class average is "+ average()+
				".Lowest grade is "+ grades.get(lowest())+ lowest()+
				"Highest grade is "+ grades.get(highest())+highest()+"\n"+
				  "Grades distribution:\n");
		outputBarChat();
		for(int i=0;i<10;i++) {
			System.out.print(i*10+"-"+(i*10+9)+":"+ "*".repeat(cnt[i])+"\n");
		}
		System.out.print("100:" + "*".repeat(cnt[10]));
	}
	public String toString() {
		return "This is Grade book for "+course;
	}
	
	
	
	
}
