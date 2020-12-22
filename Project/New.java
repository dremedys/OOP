package intranet;
import java.io.Serializable;
import java.util.ArrayList;

public class New implements Serializable{
	private static final long serialVersionUID = 1L;

	public String title;

    public String text;
    
    public ArrayList<Message> comments;
    
    public int id;
    
    public static int commonID = 0;
    
    {
    	
    	comments = new ArrayList<Message>();
    }
    
    public New(String title,String text) {
    	commonID++;
    	this.id = commonID;
    	this.title = title;
    	this.text =text;
    }
    
	
	public String viewComments() {
		if(comments.isEmpty()) 
			return "\tNo comments yet.";
		String ans = "";
		for(Message message : comments) {
			ans += "\t";
			ans += message.toString();
		}
		return ans;
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof New)) {
			return false;
		}
		New other = (New) obj;
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	
	public String toString() {
		return  "ID:" + id+ " " + "topic: " + title.toUpperCase() + "\n" + text + "\n" + "Comments:\n" + viewComments() + "\n---------------------------------------";
	}
}

