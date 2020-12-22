package oop;

public class Person {
	String name;
	Gender gender;
	int age;
	
	Person(){
		age=0;
		name="Not chosen";
	}
	Person(String name,Gender gender){
		this.name=name;
		this.gender=null;
	}

	Person(Gender gender){
		this.gender=gender;
	}

	public String toString() {
		return name;
	}
}
