package lab3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends week5.Person implements Comparable<Employee>, Cloneable{
	String insuranceNumber;
	private double salary;
	Date hireDate;
	Employee() {
		super();
	}
	Employee(String name){
		super(name);
	}
	Employee(String name , String insuranceNumber,double salary, Date hireDate){
		super(name);
		this.insuranceNumber = insuranceNumber;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int hashCode() {
		int res = super.hashCode();
		res += 31*res + insuranceNumber.hashCode();
		res += 31*res + (int)salary;
		res +=  31*res+ hireDate.hashCode();
		return res;
		
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) 
			return false;
		if(!(o instanceof Employee))
			return false;
		
		Employee e = (Employee)o;
		return hireDate.equals(e.hireDate) && salary==e.salary && insuranceNumber.equals(e.insuranceNumber);
	}
	
	public String toString() {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		return super.toString() + " and was hired in " + dateFormat.format( hireDate ) + " " + ", salary " + salary;
	}
	
	public int compareTo(Employee other) {
		
		if(this.salary > other.salary) {
			return 1;
		}
		if(this.salary < other.salary) {
			return -1;
		}
		return 0;
		
	}
	
	public Object clone() {
		Employee e = null;
		try {
			e = (Employee)super.clone();
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//e.hireDate = (Date) (hireDate).clone();
		return e;
	}
	
	
	
}
