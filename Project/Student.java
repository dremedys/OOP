package intranet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;


/**
* The Student class that works similarly to real student
* <h1>Student!</h1>
* @author  Dariga Abdikarimova,Adilet Abylaikhan
* 
* @since   2018-11-25
* 
*/
public class Student extends User implements SendingOrder,Serializable {
	/** Used for a serializable object.
	*/
	private static final long serialVersionUID = 1457045536443677740L;
	
	/** Represents the student’s faculty.
	*/
	private Faculty faculty;
	
	/** Represents the grades.
	*/
	HashMap<Course,Mark> grades;
	
	
	{
		grades = new HashMap<Course,Mark>();
		faculty = null;
	}
	
	
	/**
	   * This method is used to create an instance of a student with name and surname
	   * uses a super constructor - argument '_' is used to generate login "firstName_LastName"
	   * @param firstName This is the first parameter First name of student
	   * @param lastName  This is the second parameter Last name
	   * @return created new Student
	   */
	public Student(String firstName, String lastName) {
			super(firstName, lastName,'_');
	}
	
	/**
	   * This method is used to register a student to specific course 
	   * It searches course in DataBase with such id and starts searching a teacher with such ID
	   * Student registers to a random teacher who has such course
	   * @param id This is the first parameter - ID of the course.
	   * @return boolean returns true if student registers successfully, false otherwise
	   */
	public boolean register(String id) {
		for(Course course : DataBase.courseList) {
			if(course.getId().equals(id)) {
				Collections.shuffle(DataBase.teacherList);
				for(Teacher teacher : DataBase.teacherList) { //if there exists teacher who have this course
					if(teacher.getCourses().contains(course)) {  
						teacher.addStudent(this, course); //teacher[course].addStudent
						grades.put(course,new Mark());  //initialize course in list of his grades
						return true;
					}
					
				}
			}
		}
		return false;
		
	}
	
	/**
	   * This method is used to view a file of a course by id of the course and name of the file
	   * It searches course in DataBase with such id and starts searching a file with such name
	   * @param id This is the first parameter - id of course
	   * @param name This is name of the file
	   * @return CourseFile returns found CourseFile. If not found such file,returns null.
	   */
	public CourseFile viewFile(String id,String name) {
		for(Course course : DataBase.courseList) {
			if(course.getId().equals(id)) {
				for(CourseFile c: course.getCourseFiles()) {
					if(c.getName().equals(name)) {
						return c;
					}
				}
			}
		}
		return null;
	}
	
	/**
	   * This method is used get list of courses of the student
	   * It takes set of keys of the field grades
	   * @return ArrayList<Course> returns true if student registers successfully,false otherwise
	   */
	@SuppressWarnings("unchecked")
	public ArrayList<Course> getCourseList() { //view all courses in University
	    Set<Course> keySet =grades.keySet(); 
	     ArrayList<Course> listOfKeys = new ArrayList<Course>(keySet); 
		return listOfKeys;
	}
	
	
	/**
	   * This method calculates GPA of the student according to his grades.
	   * @return double returns a general GPA.
	   */
	public double calculateGpa() {
		int sum = 0;
		int cnt = 0;
		for (Mark mark : grades.values()) {
		    if(mark.finished) {
		    	sum += mark.toGpa();
		    	cnt++;
		    }
		}
		return sum / cnt;
	}
	
	/**
	   * This method is used to show the transcript.
	   * @return String returns a sheet with information.
	   */
	public String getTranscript() {
	    //soon
		String ans = "Code    Name     Credit  Points   GPA   Letter\n";
		for(Course key : grades.keySet()) {
			
			String id = key.getId();
			ans += id + " ".repeat(8-id.length());
			
			String name = key.getName();
			ans += name + " ".repeat(10-name.length());
			int points = grades.get(key).totalMark();
			ans += key.getCreditNumber() + "      " + points + " ".repeat(3-(int)(Math.log10(points)+1)) + 
					"      "+ grades.get(key).toGpa() + "      " + grades.get(key).toString()+"\n";
		}
	
		ans += "Total GPA: " + calculateGpa();
		return ans;
	}
	
	
	/**
	   * This static method is used get info about specific teacher by his login.
	   * @param login login of the Teacher.
	   * @return String returns information about teacher if such exists, not found text otherwise.
	   */
	public static String getInfoAboutTeacher(String login) {
		for(Teacher teacher : DataBase.teacherList) {
			if(teacher.getLogin().equals(login)) {
				return teacher.toString();
			}
		}
		return "Not found\n";
	}
	
	/**
	   * This static method is used to get info about a course.
	   @param id id of course
	   * @return String return Course if found, not found text otherwise.
	   */
	public static String getInfoAboutCourse(String id) {
		for(Course course : DataBase.courseList) {
			if(course.getId()==id) {
				return course.toString();
			}
		}
		return "Not found such course\n";
	}
	
	@Override
	/**
	   * This method is used to send an order to ORManager.
	   * @param order order that will be added
	   * @return nothing
	   */
	public void sendOrderOR(Order order) {
		OR.orders.add(order);
	}
	
	@Override
	/**
	   * This method is used to send an order to Executor.
	   * @param order order that will be added
	   * @return nothing
	   */
	public void sendOrderToEx(Order order) {
	    Executor.orders.add(order);
	}
	
	/** Gets the student's faculty.
	 * @return Faculty representing the student's faculty.
	*/
	public Faculty getFaculty() {
		return faculty;
	}
	
	/** Sets the student's faculty
	 * @param faculty A faculty
	 * @return nothing.
	*/
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	/** Gets the student's grades.
	 * @return HashMap representing the student's grades.
	*/
	public HashMap<Course,Mark> getGrades() {
		return grades;
	}
	
	/** Sets the student's grades.
	 * @param grades A hash map containing the course to its mark.
	*/
	public void setGrades(HashMap<Course,Mark> grades) {
		this.grades = grades;
	}
	


	@Override
	/**
	   * This method is used to calculate a hash code.
	   
	   * @return int code of object
	   */
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
	
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		return result;
	}

	/**
	   * This method is used to know if two students are same.
	   * @param obj Object.
	   * @return boolean true if same, false otherwise
	   */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (faculty != other.faculty) {
			return false;
		}
	
		if (grades == null) {
			if (other.grades != null) {
				return false;
			}
		} else if (!grades.equals(other.grades)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Student [faculty=" + faculty +  "GPA: " + calculateGpa()+ "]";
	}
	
	


	


	
}

