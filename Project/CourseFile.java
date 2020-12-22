package intranet;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CourseFile implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
    private String text;
    private Date addDate;

    public CourseFile(String name, String text) {
    	this.name = name;
    	this.text = text;
    	this.addDate = Calendar.getInstance().getTime();
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(addDate, name, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CourseFile)) {
			return false;
		}
		CourseFile other = (CourseFile) obj;
		return Objects.equals(addDate, other.addDate) && Objects.equals(name, other.name)
				&& Objects.equals(text, other.text);
	}

	@Override
	public String toString() {
		return "CourseFile [ name: " + name + "\n text=" + text + "\n  addDate=" + addDate;
	}
}

