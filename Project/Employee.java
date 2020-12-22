package intranet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public abstract class Employee extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int salary;
	
	public Employee(String lastName, String firstName) {
		super(lastName,firstName,'.');
		setSalary(200000);
	}
	

    public int getSalary() {
        return salary;
    }
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int hashCode() {
		return super.hashCode() + salary;
	}
	
	public boolean equals(Object obj) {
		if(!super.equals(obj)) 
			return false;
		Employee p = (Employee)obj;
		return salary == p.salary; 
		}



	public void changeOrderStatus(Order order, OrderStatus rejected) {
		// TODO Auto-generated method stub
		
	}



	public ArrayList<Order> viewOrders(OrderStatus new1) {
		// TODO Auto-generated method stub
		return null;
	}



	public TreeSet<Order> getOrders() {
		return null;
	}



}

