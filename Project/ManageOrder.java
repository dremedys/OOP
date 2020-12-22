package intranet;

import java.util.ArrayList;

public interface ManageOrder {
   
    public ArrayList<Order> viewOrders(OrderStatus status);
    public void changeOrderStatus(Order order, OrderStatus status);
    
	
}

