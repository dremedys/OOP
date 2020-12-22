package oop;
import java.util.*;
public class DragonLaunch {
	static Vector<Person> people= new Vector<Person>();
	public static void kidnap(Person P) {
		people.add(P);
	}
	
	public static boolean willDragonEatOrNot(Vector<Person> people) {
		int balance=0;
		for(int i=0;i < people.size();i++) {
			Gender element=people.elementAt(i).gender;
			if(element.equals(Gender.B) && !people.isEmpty())  {
				balance--;
			}
			else if(element.equals(Gender.G) && balance<0) {
				balance++;
			}
			else if((element.equals(Gender.G) && balance==0) || (element.equals(Gender.B) && people.isEmpty())) {
			return true;
			}
		} 
		if(balance == 0) {
			return false;
		}
		return true;
		}
	
	public static void main(String[] args) {
		Person p1= new Person(Gender.G);
		kidnap(p1);
		if(willDragonEatOrNot(people)) {
			System.out.print("yes");
		}
		else {
			System.out.print("no");
		}
	}
}
