package intranet;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DataBase implements Serializable {
	
    private static final long serialVersionUID = 1L;
	private static final DataBase INSTANCE = new DataBase();
	
	private DataBase() {
		
	}
	
	public static DataBase getInstance() {
		return INSTANCE;
	}
	
    public static final String PATH = "src\\intranet\\data\\";
    private static final String TEACHERS = "teachers.out";
    private static final String STUDENTS = "students.out";
    private static final String ORMANAGERS = "managers.out";
    private static final String EXECUTORS = "executors.out";
    private static final String COURSES = "courses.out";
    private static final String NEWS = "news.out";
    public static final String log = "logs.txt";
	
	static final String EXCEPT_CLASS = "Such class does not exist.";
    static final String EXCEPT_FILE = "File not found.";
    static final String EXCEPT_IO = "Exception in input/output.";
	
    public static ArrayList<Student> studentList  = new ArrayList<Student>() ;
    public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    public static ArrayList<OR> managerList = new ArrayList<OR>();
    public static ArrayList<Executor> executorList = new ArrayList<Executor>();
    public static ArrayList<Course> courseList = new ArrayList<Course>();
    public static ArrayList<New> newList = new ArrayList<New>();
    
  
    public static void getData() { //deserializtion 
    	getStudents();
    	getTeachers();
    	getManagers();
    	getExecutors();
    	getNews();
    	getCourses();
    	OR.getOrdersFile();
    
    }
   
    
	@SuppressWarnings("unchecked")
	private static void getCourses() {
	
    	try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH + COURSES));

            courseList = (ArrayList<Course>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println( COURSES + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println( COURSES + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println( COURSES+ ": " + EXCEPT_IO);
        }
	}

    
	@SuppressWarnings("unchecked")
	private static void getNews() {
    	
    	try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH + NEWS));

            newList = (ArrayList<New>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(NEWS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(NEWS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(NEWS + ": " + EXCEPT_IO);
        }
	}
	
    @SuppressWarnings("unchecked")
	private static void getExecutors() {
    	  try {
              ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH + EXECUTORS));

              executorList = (ArrayList<Executor>) ois.readObject();

              ois.close();

          }
          catch (ClassNotFoundException e) {
              System.out.println(EXECUTORS + ": " + EXCEPT_CLASS);
          }
          catch (FileNotFoundException e) {
              System.out.println(EXECUTORS + ": " + EXCEPT_FILE);
          }
          catch (IOException e) {
              System.out.println(EXECUTORS + ": " + EXCEPT_IO);
          }
		
	}
	
    @SuppressWarnings("unchecked")
	private static void getManagers() {
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH + ORMANAGERS));

            managerList = (ArrayList<OR>) ois.readObject();

            ois.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_IO);
        }
		
	}
	
    @SuppressWarnings("unchecked")
	private static void getTeachers() {
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH + TEACHERS));

            teacherList = (ArrayList<Teacher>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_IO);
        }
		
	}
	
    @SuppressWarnings("unchecked")
	private static void getStudents() {
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH + STUDENTS));

            studentList = (ArrayList<Student>) ois.readObject();

            ois.close();

        }
        catch (ClassNotFoundException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_CLASS);
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_IO);
        }
		
	}
    
	
	//serialization - add new object to file
    public static void saveData() {
		saveStudents();
		saveTeachers();
		saveManagers();
		saveExecutors();
		saveNews();
		saveCourses();
		OR.saveOrderFile();
		Executor.saveOrderFile();
		
    }
	
    private static void saveCourses() {
    	try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(PATH + COURSES));

            oot.writeObject(courseList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(COURSES + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
        	System.out.println(COURSES + ": " + EXCEPT_IO);
		
	}
    }

	private static void saveNews() {
    	try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(PATH + NEWS));

            oot.writeObject(newList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(NEWS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(NEWS + ": " + EXCEPT_IO);
        }
		
	}
    
    
    private static void saveExecutors() {
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(PATH + EXECUTORS));

            oot.writeObject(executorList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(EXECUTORS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(EXECUTORS + ": " + EXCEPT_IO);
        }
		
	}
	
    private static void saveManagers() {
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(PATH + ORMANAGERS));

            oot.writeObject(managerList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(ORMANAGERS + ": " + EXCEPT_IO);
        }
		
	}
	
    private static void saveTeachers() {
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(PATH + TEACHERS));

            oot.writeObject(teacherList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(TEACHERS + ": " + EXCEPT_IO);
        }
		
	}
	
    private static void saveStudents() { 
		try {
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(PATH + STUDENTS));

            oot.writeObject(studentList);

            oot.flush();
            oot.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_FILE);
        }
        catch (IOException e) {
            System.out.println(STUDENTS + ": " + EXCEPT_IO);
        }
		
	}
    

    public static void addLog(String text) {   
    	try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH + log, true));
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
            
            bw.write(dtf.format(LocalDateTime.now())+ " - " + text + "\n");

            bw.flush();
            bw.close();
        }
        catch (IOException e) {
            System.out.println(EXCEPT_IO);
        }
    }
    
}

