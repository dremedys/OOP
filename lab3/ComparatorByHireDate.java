package lab3;

import java.util.Comparator;

public class ComparatorByHireDate implements Comparator<Employee>{
	
	public ComparatorByHireDate() { }

	public int compare(Employee e1, Employee e2) {
			return e1.hireDate.compareTo(e2.hireDate);
	}

}
