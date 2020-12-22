package intranet;

import java.util.Comparator;

public class CompareGPA implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.calculateGpa()>o2.calculateGpa()) return 1;
		if(o1.calculateGpa()<o2.calculateGpa()) return -1;
		else return 0;
	}

}
