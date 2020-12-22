package intranet;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Teacher extends Employee implements SendingOrder, ManageCourse,Serializable {
	private static final long serialVersionUID = 1L;
	
	private  Title title ;
	private  Faculty faculty;
	private  ArrayList<Message> messages; //messages from OR
	private  HashMap< Course, Vector<Student> >  students ;
	
	{
		messages = new ArrayList<Message>();
		students = new HashMap<Course, Vector<Student>>();
	}
	
	public Teacher(String lastName, String firstName) {
			super(lastName, firstName);
		}


	public boolean putMark(Course course, Student student, int value , MarkType markType) {
		if(!getCourses().contains(course))
			return false;
		for(Course key : students.keySet()) {
			if(key.equals(course)) {
						student.grades.get(course).setMark(value, markType);						
						return true;
					
			}
		}
		return false;
	}
	
	

	public boolean addCourse(String id) {
		for(Course course : DataBase.courseList) {
			if(course.getId().equals(id)) {
				students.put(course, new Vector<Student>());
				return true;
			}
		}
		return false;
	}
	
	public void addStudent(Student student,Course course) {
		
			students.get(course).add(student);
	
	}
	
	public ArrayList<Course> viewCourses() {
	    return DataBase.courseList;
	}
	
	public void addCourseFile(String id, CourseFile file) {
		for(Course c : getCourses()) {
			if(c.getId().equals(id)) {
				c.addCourseFile(file);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Course> getCourses(){
		 Set<Course> keySet =students.keySet(); 
	     ArrayList<Course> listOfKeys = new ArrayList<Course>(keySet); 
		return listOfKeys;
	}
	
	public Student findStudent(String login) {
		for(Student student: DataBase.studentList) {
			if(student.getLogin().equals(login)) {
				return student;
			}
		}
		return null;
	}
	
	public boolean deleteCourseFile(String id, CourseFile file) {
		for(Course key : students.keySet()) {
			if(key.getId().equals(id)) {
				key.deleteCourseFile(file);
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public void sendOrderOR(Order order) {
		OR.orders.add(order);
	}
	
	@Override
	public void sendOrderToEx(Order order) {
		Executor.orders.add(order);
	}
	
	public void receiveMessage(Message message) {
		this.messages.add(message);
	}
	
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public ArrayList<Message> getMessages() {
		return messages;
	}

	public HashMap<Course, Vector<Student>> getStudents() {
		return students;
	}
	public void setStudents(HashMap<Course, Vector<Student>> students) {
		this.students = students;
	}
	
	
	@Override
    public String toString() {
        String facultyInfo;
        try {
            facultyInfo = "Faculty: " + faculty.toString() + '\n';
        }
        catch (Exception e) {
            facultyInfo = "";
        }
        
       
        return "Teacher\n" + super.toString() + facultyInfo;
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((messages == null) ? 0 : messages.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) obj;
		if (faculty != other.faculty) {
			return false;
		}
		if (messages == null) {
			if (other.messages != null) {
				return false;
			}
		} else if (!messages.equals(other.messages)) {
			return false;
		}
		if (students == null) {
			if (other.students != null) {
				return false;
			}
		} else if (!students.equals(other.students)) {
			return false;
		}
		if (title != other.title) {
			return false;
		}
		return true;
	}
}

