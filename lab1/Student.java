package lab1;

public class Student {
	public String name;
	public int id;
	
	private static int nextId=0;
	{
		id=nextId++;
	}
	
	public Student(String name){
		this.name=name;
	}
	public String toString() {
		return "("+name+",ID:"+id+ ").";
	}
}
