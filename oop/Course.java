package oop;

public class Course {
	String name;
	int credits;
	String description;
	Course prerequisites[];
	Course(String name){
		this.name=name;
	}
	public String toString() {
		return name;
	}
}
