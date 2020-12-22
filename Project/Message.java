package intranet;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalQuery;
import java.util.*;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private String topic;
    private String text;
    private Date date;
    private String owner;
    
    public Message(String topic, String text) {
		this.date = Calendar.getInstance().getTime(); 
		this.topic = topic;
		this.text= text;
		this.owner = "OR Manager"; 
	}
    
    public Message(String topic,String text,String owner) {
    	this(topic,text);
    	this.setOwner(owner);
    }
    
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Message)) {
			return false;
		}
		Message other = (Message) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@SuppressWarnings("deprecation")
	public String toString() {
			
       // bw.write(dtf.format(LocalDateTime.now())+ " - " + text + "\n");
         return owner + ": " + topic + "\n" + text + "\t\t\n" +  date.toLocaleString();
	}
}

