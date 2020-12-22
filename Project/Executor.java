package intranet;
import java.io.*;

import java.util.*;

public class Executor extends Employee implements  ManageOrder,Serializable {
	
	public static TreeSet<Order> orders = new TreeSet<Order>();

	private static final long serialVersionUID = 1L;
	
	private static final String ORDERS= "executorOrders.out";
    
	{
		getOrdersFile(); 
	
	}
 
	public Executor(String lastName, String firstName) {
		super(lastName, firstName);
	}


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
    			o.setResponsibility(this.getFullName());
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



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Executor)) {
			return false;
		}
		return true;
	}
}

