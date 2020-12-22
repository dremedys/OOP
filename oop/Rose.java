package oop;

public class Rose {
	String name;
	private int age;
	private Aroma aroma;
	int id;
	static int nextId=0;
	public final String color;
	
	{
		id=nextId++;
	}
	
	Rose(String name,String color){
		this.name=name;
		this.color=color;
	}
	
	Rose(String name,Aroma aroma,String color){
		this(name,color);
		this.aroma= aroma;
	}
	
	Rose(String name,Aroma aroma,String color,int age){
		this(name, aroma,color);
		this.age= age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public Aroma getAroma() {
		return aroma;
	}
	
	public void setAroma(Aroma aroma) {
		this.aroma=aroma;
	}
	
	public void setAroma(Rose r) {
		this.aroma=r.aroma;
	}
	
}
