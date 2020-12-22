package intranet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
    private String id;
    private int creditNumber;
    private ArrayList<CourseFile> courseFiles=new ArrayList<CourseFile>();
    
    
    public Course(String id) {
    	this.id = id;
    }
    
    public Course (String id, String courseName, int creditNumber) {
        this(id);
        this.name = courseName;
        this.creditNumber = creditNumber;
    }
    
	
	public void addCourseFile(CourseFile file) {
		courseFiles.add(file);
	}
	
	
	public boolean deleteCourseFile(CourseFile file) {
		if(courseFiles.contains(file)) {
			courseFiles.remove(file);
			return true; 
		}
		return false;
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	public ArrayList<CourseFile> getCourseFiles() {
		return courseFiles;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(courseFiles, creditNumber, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Course)) {
			return false;
		}
		Course other = (Course) obj;
		return Objects.equals(id, other.id) ;
	}


	@Override
	public String toString() {
		return "Course " + (name != null ? "name  " + name + " \n" : "") + (id != null ? "id  " + id + " " : "")
				+ "creditNumber =" + creditNumber;
	}
	
}

