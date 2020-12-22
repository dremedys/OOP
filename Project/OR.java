package intranet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class OR extends Employee implements ManageOrder, SearchInfo,Serializable {
	private static final String ORDERS= "ororders.out";
	public static  TreeSet<Order> orders = new TreeSet<Order>();
	private static final long serialVersionUID = 1L;
	
	
	public OR(String firstName, String lastName) {
			super(firstName, lastName);
			
	}
	
	
	public void  addCourse(Course course) {
		if( !DataBase.courseList.contains(course))
			DataBase.courseList.add(course);
	}
	
	
	public void StudentbyName() {
		Collections.sort(DataBase.studentList,new CompareFirstName());
		for(User u : DataBase.studentList) {
			System.out.println(u);
		}
		
	}


	public void StudentbySurname() {
		Collections.sort(DataBase.studentList,new CompareSecondName());
		for(User u : DataBase.studentList) {
			System.out.println(u);
		}
		
	}


	public void byGPA() {
		Collections.sort(DataBase.studentList,new CompareGPA());
		for(User u : DataBase.studentList) {
			System.out.println(u);
		}
		
	}
	
	
	public void TeacherbyName() {
		Collections.sort(DataBase.teacherList,new CompareFirstName());
		for(User u : DataBase.teacherList) {
			System.out.println(u);
		}
		
	}


	public void bySurname() {
		Collections.sort(DataBase.teacherList,new CompareSecondName());
		for(User u :DataBase.teacherList) {
			System.out.println(u);
		}
	}


	public void bySalary() {
		// TODO Auto-generated method stub
		
	}
	
	public void  addNew(New n) {
		DataBase.newList.add(n);
	}
	
	
	public boolean sendMesage(String login,Message message) {
		for(Teacher teacher : DataBase.teacherList) {
			if(teacher.getLogin().equals(login)) {
				teacher.receiveMessage(message);
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public ArrayList<Order> viewOrders(OrderStatus status) {
		ArrayList<Order> list = new ArrayList<Order>();
		for(Order order : orders) {
			if(order.getStatus().equals(status)) {
				list.add(order);
			}
		}
		return list;
	}
	
	public void changeOrderStatus(Order order, OrderStatus status) {
		for(Order o : orders) {
    		if(o.equals(order)) {
    			o.setStatus(status);
    		}
    	}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static void getOrdersFile() {
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBase.PATH + ORDERS));

            orders = (TreeSet<Order>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(ORDERS + ": " + DataBase.EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(ORDERS + ": " + DataBase.EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(ORDERS + ": " + DataBase.EXCEPT_IO);
        }
		
	}
	
	public static void saveOrderFile() {
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(DataBase.PATH + ORDERS));

            oot.writeObject(orders);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println( ORDERS + ": " + DataBase.EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println( ORDERS + ": " + DataBase.EXCEPT_IO);
        }
		
	}

	
	
	public TreeSet<Order> getOrders() {
		return orders;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public ArrayList<Student> getStudentsByFirstName(){
		Collections.sort(DataBase.studentList,new CompareFirstName());
		return DataBase.studentList;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof OR)) {
			return false;
		}
		return true;
	}
}

