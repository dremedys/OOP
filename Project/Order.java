package intranet;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Order implements Serializable, Comparable<Order>{

	private static final long serialVersionUID = 1L;
	
	private  String topic;
	private  String description;
	private  Date  date ;
	private int orderNumber;
	private  OrderStatus  status ;
	static int numberOfOrder = 1;
	
	private String responsibility;
	
	{
		this.orderNumber = numberOfOrder++;
		this.status = OrderStatus.NEW;
		setResponsibility("N/A");
	}
	
	public Order(String topic, String description) {
		this.date = Calendar.getInstance().getTime();
		this.topic = topic;
		this.description = description;
	}
	

	@Override
	public int compareTo(Order o) {
		if (getDate().before(o.getDate())) {
            return 1;
        } 
		if (getDate().after(o.getDate())) {
            return -1;
        } 
            return 0;
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
	this.status = status;
}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + orderNumber;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Order)) {
			return false;
		}
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (orderNumber != other.orderNumber) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (topic == null) {
			if (other.topic != null) {
				return false;
			}
		} else if (!topic.equals(other.topic)) {
			return false;
		}
		return true;
	}


	public String getResponsibility() {
		return responsibility;
	}


	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}


	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return  "order ¹" + orderNumber + (topic != null ? "\ntopic: " + topic + "\n " : "")
				+ (description != null ? "description: " + description + "\n " : "")
				+ (date != null ? "date: " + date.toLocaleString() : "")  
				+ (status != null ? "\nstatus: " + status + "\t" : "")
				+ (responsibility != null ? "\nwas taken by " + responsibility : "") ;
	}
	
	
}

