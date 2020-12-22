package intranet;
import java.util.ArrayList;

public interface ManageCourse {

	public ArrayList<Course> viewCourses();
	
	public void addCourseFile(String id, CourseFile file);
	
	public boolean deleteCourseFile(String id, CourseFile file);
}

