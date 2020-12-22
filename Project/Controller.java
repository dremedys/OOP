package intranet;

import java.io.*;
import java.util.*;

public class Controller {
	
	public Controller() {
		DataBase.getInstance(); 
		DataBase.getData(); 
	}
	
	private Admin admin;
    private User user;
    private Teacher teacher;
    private Student student;
    private OR or;
    private Executor executor;
    private MarkType markType;
    
    private static final Scanner sc = new Scanner(System.in);
    
    public void begin() {
    	 System.out.println("Are you admin or user?");

         String ans = sc.nextLine().toLowerCase();

         if (!(ans.equals("user") || ans.equals("admin")))
        	 return; 

         System.out.println("Enter your login and password"); 
        
         String login = sc.nextLine().toLowerCase();
         String password = sc.nextLine();

         switch (ans) {
             case "admin":  
                 workAsAdmin(login, password);
                 break;
             case "user": 
                 workAsUser(login, password);
                 break;
         }
         DataBase.saveData();
     
    }
    

	private void workAsUser(String login, String password) { 
		
		ArrayList<User> list = new ArrayList<>(); 

        boolean found = false;

        list.addAll(DataBase.teacherList);
        list.addAll(DataBase.studentList);
        list.addAll(DataBase.managerList);
        list.addAll(DataBase.executorList);
        
        for (User u: list) { 
        	
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) { 
                user = u;
                System.out.println("Welcome, " +user.getClass().getSimpleName().toLowerCase() + " " + user.getFullName() + " !" );
                System.out.println("What do you want to do ?");
                
                found = true;

                DataBase.addLog("User " + u.getLogin() + " opened intranet!");

                switch (u.getClass().getSimpleName()) { 
                    case "Student":
                        workAsStudent();
                        break;
                    case "Teacher":
                    	workAsTeacher();
                        break;
                    case "OR":
                    	workAsManager();
                        break;
                    case "Executor":
                        workAsExecutor();
                        break;
                    case "exit":
                    	System.out.println("Bye !");
                    	break;
                }
                				
                break;
            }
        }
        if (!found) { 
            System.out.println("Login or password is not correct!");
        }
		
	}

	
	private void workAsStudent() {
		 
		        student = (Student)user; 
		        
		        System.out.println("1. Work with courses");
		        System.out.println("2. View transcript");
		        System.out.println("3. View news");
		        System.out.println("4. Register for a course");
		        System.out.println("5. Send order to OR");
		        System.out.println("6. Send order to Executor");
		        String ans = sc.nextLine();

		        switch (ans) {
		            case "1":
		            	workWithCourses();
		                break;
		            case "2":
		                viewTranscript();
		                break;
		            case "3":
		                viewNews();
		                break;
		            case "4":
		                studentRegistration();
		                break;
		            case "5":
		            	sendOrderToOR(student);
		            	break;
		            case "6":
		            	sendOrderToExecutor(student);
		                break;
		            case "exit":
                    	System.out.println("Bye !");
                    	break;
		        }
		   
		
	}
	
	private void workWithCourses() {
	    
	        String ans = "";
	        
	        while (!ans.equals("exit")) {
	            System.out.println("1. View grades");
	            System.out.println("2. Read courseFile");
	            System.out.println("3. View info about course");
	            System.out.println("4. View info about teacher");

	            ans = sc.nextLine();
	            switch (ans) {
	                case "1":
	                	viewMark();
	                    break;
	                case "2":
	                	readCourseFile();
	                    break;
	                case "3":
	                	viewInfoAboutCourse();
	                    break;
	                case "4":
	                	viewInfoAboutTeacher();
	                    break;
	                case "exit":
	                	System.out.println("Bye");
	                	return;
	                default:
	                    break;
	            }
	        }
	        DataBase.saveData();
		
	}

	private void viewMark() {
		
		DataBase.addLog("Student " + student.getLogin() + " looked at marks!");
		
		System.out.println("Your current courses:"); 
		
		for(Course c : student.getCourseList()) {
			System.out.println(c);
		}
		
		System.out.println("Enter ID of course:"); 
		
		
		String ans = sc.nextLine();
		
		boolean found = false;
		
		for(Course key : student.grades.keySet()) { 
			if(key.getId().equals(ans)) { 
				System.out.println("Your mark : " + student.getGrades().get(key).totalMark());
				found = true;
			}
		}
		if(!found)
			System.err.println("Incorrect data !");
		
		
	}

	private void readCourseFile() {
		
		System.out.println("Enter ID of course and name of file");
		String id= sc.nextLine();
		String name = sc.nextLine();
		System.out.println(student.viewFile(id,name));
	}

	private void viewInfoAboutCourse() {
		
		DataBase.addLog("Student " + user.getLogin() + " viewed info about a course!");
		
		System.out.println("Enter a course id to get info about it"); 
		
		String id = sc.nextLine();
		System.out.println(Student.getInfoAboutCourse(id));

	}

	private void viewInfoAboutTeacher() {
		DataBase.addLog("Student " + student.getLogin() + " viewed info about a teacher!");
		System.out.println("Enter a login of teacher:");
		String login = sc.nextLine();
		System.out.println(Student.getInfoAboutTeacher(login));
		
	}
	
	private void viewTranscript() {
		DataBase.addLog("User " + student.getLogin() + " viewed transcript!");
		
		System.out.println(student.getTranscript());
		
	}

	private void viewNews() {
		
		DataBase.addLog("User " + user.getLogin() + " viewed news!");
		ArrayList<New> news= DataBase.newList;
		if(news.isEmpty())
			System.out.println("Now news yet");
		else {
			for(New n: news ) {
				System.out.println(n);
			}
			System.out.println("Want to leave comment?");
			System.out.println("1. Yes\n2. No");
			String ans = sc.nextLine();
			if(ans.equals("1")) {
				System.out.println("Enter id of new");
				int id = sc.nextInt();
				System.out.println("Enter comment");
				String comm = sc.next();
								user.leaveComment(id, user.getFullName(), comm);
				DataBase.addLog("User " + user.getLogin() + " left comment to a new.");
				System.out.println("Okay.");
			}
		}
		
			
			
	}

	private void studentRegistration() {
		
		System.out.println("enter the id of course:");
		//ENTERING A  COURSE
		String id = sc.nextLine();
		
		if(student.register(id)) {
			System.out.println("Success!");
			DataBase.addLog("User " + student.getLogin() + " registered a course " + id);
			DataBase.saveData();
		}
		else System.err.println("Such course does not exist !");
		
		
	}

	
	private void workAsTeacher() {
		 teacher = (Teacher) user;
	      
	        String ans = "";

	        while (!ans.equals("exit")) {
	            System.out.println("1. Work with courses");
	            System.out.println("2. Send order to OR");
	            System.out.println("3. Send order to Executor");
	            System.out.println("4. View News");
	            System.out.println("5. View messages");
	            System.out.println("6. View info about student");
	            
	            ans = sc.nextLine();

	            switch (ans) {
	                case "1":
	                    TeacherWorkWithCourses();
	                    break;
	                case "2":
	                    sendOrderToOR(teacher);
	                    break;
	                case "3":
	                    sendOrderToExecutor(teacher);
	                    break;
	                case "4":
	                    viewNews();
	                    break;
	                case "5":
	                    viewMessages();
	                    break;
	                case "6":
	                	viewInfoAboutStudent();
	                    break;
	                case "exit":
	                	System.out.println("Bye!");
	                    return;
	                default:
	                    System.out.println("Not valid option!");
	                    break;
	            }
	        }
	    }


	private void TeacherWorkWithCourses() {
	   String ans = "";
		
       while (!ans.equals("exit")) {
           System.out.println("Choose the option you want");
           System.out.println("1. Put mark");
           System.out.println("2. Add course");
           System.out.println("3. View info about course");
           System.out.println("4. Add course file");
           System.out.println("5. Delete course file");

           ans = sc.nextLine();

           switch (ans) {
               case "1":
               	putMark();
                   break;
               case "2":
               	TeacherAddCourses();
                   break;
               case "3":
               	viewInfoAboutCourse();
                   break;
               case "4":
               	addCourseFile();
                   break;
               case "5":
               	deleteCourseFile();
               	break;
           }
       }
		
	}

	private void putMark() {
		System.out.println("Enter course id: ");
		String id = sc.nextLine();
		Course c=null;
		for(Course course:DataBase.courseList) {
			if(course.getId().equals(id)) {
				c = course;
			//	System.out.println("ok1");
			}
		}
		System.out.println("Enter students login:");
		String login = sc.nextLine();
		
		Student s = null;
		for(Student student: DataBase.studentList) {
			if(student.getLogin().equals(login)) {
				s = student;
				//System.out.println("ok2");
			}
		}
		System.out.println("Which attestation?");
		System.out.println("1. First attestation");
		System.out.println("2. Second attestation");
		System.out.println("3. Final");
		String type = sc.nextLine();
		switch(type){
			case "1":
				markType = MarkType.FIRST_ATT;
				break;
			case "2":
				markType = MarkType.SEC_ATT;
				break;
				
			case "3":
				markType = MarkType.FINAL;	
				break;
			default:
				System.err.println("Incorrect input");
				return;
				
		}
		
		System.out.println("What mark?");
		int mark = sc.nextInt();
		System.out.println(s.toString()+" "+c.toString());
		if(teacher.putMark(c, s,mark, markType)) {
			System.out.println("SUCCESS!");
			DataBase.saveData();
			DataBase.addLog("Teacher " + user.getLogin() + "put grade " + mark + " to " + login + " for course " + id);
			return;
		}
		else 
			System.err.println("Something went wrong..");
		
		
	}

	private void TeacherAddCourses() {
		System.out.println("Type id of course you want to register:");
		String id = sc.nextLine();
		if(teacher.addCourse(id)) {
			System.out.println("Success!");
			DataBase.addLog("Teacher " + user.getLogin() + " added course "+ id);
			DataBase.saveData();
		}
		else
			System.err.println("Such course not found! ");
		
		
	}

	private void viewInfoAboutStudent() {
		System.out.println("Enter login of student you want to get info:");
		String login = sc.nextLine();
		if(teacher.findStudent(login)!= null) {
			System.out.println(teacher.findStudent(login));
			DataBase.addLog("Teacher " + user.getLogin() + " viwed info about "+ login);
		}
			
		else
			System.err.println("Such student does not exist..");
	}
	

	private void addCourseFile() {
		System.out.println("Your current courses:");
		
		for(Course course : teacher.getCourses()) {
			System.out.println(course);
		}
		
		System.out.println("Enter ID of course:");
		String id = sc.nextLine();
		System.out.println("Enter name of file:");
		String name = sc.nextLine();
		System.out.println("Enter text:");
		String text = sc.nextLine();
	    if(teacher.deleteCourseFile(id, new CourseFile(name,text)))
	    	System.out.println("Success..better than your life");
	    else
	    	System.err.println("Something went wrong");
	}

	private void deleteCourseFile() {
		// TODO Auto-generated method stub
		
	}

	private void sendOrderToOR(User user) {
		DataBase.addLog("User " + user.getLogin() + " sended order to OR! ");
		System.out.println("Enter a topic of order:include info about you too");
		String topic = sc.nextLine();
		System.out.println("Enter text:");
		String text = sc.nextLine();
		Order order = new Order(topic,text);
		if(user instanceof Teacher)	
			((Teacher) user).sendOrderOR(order);
		else 
			((Student)user).sendOrderOR(order);
		System.out.println("OK");
		
		OR.saveOrderFile();
		
	}

	private void sendOrderToExecutor(User user) {
		DataBase.addLog("User " + user.getLogin() + " sended order to EXECUTOR! ");
		System.out.println("Enter a topic of order:include info about you too");
		String topic = sc.nextLine();
		System.out.println("Enter text:");
		String text = sc.nextLine();
		Order order = new Order(topic,text);
		if(user instanceof Teacher)	
			((Teacher) user).sendOrderToEx(order);
		else 
			((Student)user).sendOrderToEx(order);
		
		System.out.println("OK");
		
	}

	private void viewMessages() {
		DataBase.addLog(user.getLogin() + "checked messages");
		if(teacher.getMessages().isEmpty())
			System.out.println("No messages yet");
		else {
			ArrayList<Message> msg = teacher.getMessages();
			for(Message m:msg)
				System.out.println(m);
		}
		
	}
	
	

	private void workAsExecutor() {
			
		 	executor = (Executor) user;
 
	        String ans = "";

	        while (!ans.equals("exit")) {

	            System.out.println("What you want to do?");
	            System.out.println("1. Work with orders");
	            System.out.println("2. View news");
	            System.out.println("3. View students sorted by GPA");
	            System.out.println("4. View teachers sorted by first name");
	            System.out.println("5. View teachers sorted by second name");
	            System.out.println(". View student sorted by first name");
	            System.out.println("4. View teachers sorted by second name");
	            ans = sc.nextLine();

	            switch (ans) {
	                case "1":
	                    workWithOrders(executor); 
	                    break;
	                case "2":
	                    viewNews();
	                    break;
	                case "exit":
	                    return;
	                default:
	                    System.out.println("Invalid choice!");
	                    break;
	            }
	        }
		
	}

	private void workWithOrders(Employee employee) {
		String ans = "";

        while (!ans.equals("exit")) {
            System.out.println("Choose the option you want");
            System.out.println("1. View all orders");
            System.out.println("2. View new orders");
            System.out.println("3. View done/accepted orders");
            System.out.println("4. Do an order");
            System.out.println("5. View news");

            ans = sc.nextLine();

            switch (ans) {
                case "1":
                	viewAllOrders(employee);
                    break;
                case "2":
                	viewNewOrders(employee);
                    break;
                case "3":
                	viewDoneAcceptedOrders(employee);
                    break;
                case "4":
                	doOrder(employee);
                	break;
                case "5":
                	viewNews();
                	break;
                default:
                    System.out.println("Not valid option!");
                    break;
            }
        }
		
	}


	private void viewAllOrders(Employee employee) { //TO SEE ALL ORDERS
		if(employee.getOrders().isEmpty())
			System.out.println("No orders yet");
		for(Order order : employee.getOrders()) {
			System.out.println(order.toString()); //just iterate and show each of orders
		}
		
	}


	private void viewNewOrders(Employee employee) {
		
		ArrayList<Order> newOrders = employee.viewOrders(OrderStatus.NEW); //get this type of order
		
		if(newOrders.isEmpty()) 
			System.out.print("No orders yet");
		
		for(Order order : newOrders) {
			
			System.out.println(order.toString()); //show every new order
			System.out.println("What do you want to do with this order?");
			System.out.println("1. Reject.");
			System.out.println("2. Accept.");
			String ans = sc.nextLine();
			
			switch(ans) {
			   case "1": //just changing status from new --- > 
				   employee.changeOrderStatus(order, OrderStatus.REJECTED);
				   break;
			   case "2":
				   employee.changeOrderStatus(order, OrderStatus.ACCEPTED);
				   break;
			   default:
				   System.out.println("Invalid choice.");
				   break;
			}
		}
		
	}


	private void viewDoneAcceptedOrders(Employee employee) {
		//to see done and accepted orders
		ArrayList<Order> list = new ArrayList<Order>(); //list to collect them
		
		list.addAll(employee.viewOrders(OrderStatus.ACCEPTED));
		list.addAll(employee.viewOrders(OrderStatus.DONE));
		
		if(list.isEmpty()) 
			System.out.print("No orders yet");
		for(Order order : list)
			System.out.println(order);
		
	}
	
	private void doOrder(Employee employee) { //accepting order change it do done!
		ArrayList<Order> accepted = employee.viewOrders(OrderStatus.ACCEPTED);
		if(accepted.isEmpty()) {
			System.out.println("No accepted orders you have");
			return;
		}
		for(Order order: accepted) {
			System.out.println(order); //first show all accepted orders
		}
		
		System.out.println("Enter a number of order you want to complete:");
		int number = sc.nextInt();
		//order with this number - change his status!
		for(Order order: accepted) {
			if(order.getOrderNumber() == number) {
				employee.changeOrderStatus(order, OrderStatus.DONE);
				System.out.println("Okay,well done!");
				DataBase.addLog(user.getFullName()+" did order,so good.");
				DataBase.saveData();
			}
		}
		
	}

	private void workAsManager() {
		or = (OR) user;
        

        String ans = "";

      //  System.out.println("Welcome, manager!");

        while (!ans.equals("exit")) {
        
            System.out.println("1. Send Message to teacher");
            System.out.println("2. Add news");
            System.out.println("3. Add courses to registration");
            System.out.println("4. Show teachers");
            System.out.println("5. Show students");
            System.out.println("6. Work with orders");

            ans = sc.nextLine();

            switch (ans) {
                case "1":
                    sendMessage();
                    break;
                case "2":
                    addNews();
                    break;
                case "3":
                    addRegister();
                    break;
                case "4":
                    showTeachers();
                    break;
                case "5":
                	showStudents();
                    break;
                case "6":
                    workWithOrders(or);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Not valid option!");
                    break;
            }
           // DataBase.saveData();
        }
		
	}
	
	

	private void sendMessage() {
		
		System.out.println("Enter a login of teacher:");
		String login = sc.nextLine();
		System.out.println("Topic of message:");
		String topic = sc.nextLine();
		System.out.print("Enter a text:");
		String text = sc.nextLine();
		
		if(or.sendMesage(login, new Message(topic,text,or.getFullName()))) 
			System.out.println("Success!");
		
		else
			System.out.println("Not found teacher with login " + login);
		DataBase.saveData();
	}

	private void addNews() {
		
		System.out.println("Enter a name, and text of a new:");
		String name = sc.nextLine();
		String text = sc.nextLine();
		or.addNew(new New(name,text));
		DataBase.saveData();
		DataBase.addLog(or.getLogin()+" added a new.");
		System.out.println("Okay,thanks.");
		
	}

	private void addRegister() {
		System.out.println("You are gonna add new course! Please write id, name , credit number.");
		String id = sc.nextLine();
		String name = sc.nextLine();
		int num = sc.nextInt();
		or.addCourse(new Course(id,name,num));
		System.out.println("Added !");
		DataBase.addLog(or.getLogin()+" added a new course" + name);
		//DataBase.saveData();
	}

	private void showTeachers() {
		System.out.println("Which order?");
		System.out.println("1. By name");
		System.out.println("2. By surname");
		System.out.println("3. By salary");
		String ans = sc.nextLine();
		switch(ans) {
			case "1":
				or.TeacherbyName();
				break;
			case "2":
				or.bySurname();
				break;
			default:
				or.bySalary();
				break;
		}
	}
	




	private void showStudents() {
		System.out.println("Which order?");
		System.out.println("1. By name");
		System.out.println("2. By surname");
		System.out.println("3. By GPA");
		String ans = sc.nextLine();
		switch(ans) {
			case "1":
				or.StudentbyName();
				break;
			case "2":
				or.StudentbySurname();
				break;
			default:
				or.byGPA();
				break;
		}
	}
	

	


	private void workAsAdmin(String login, String password) {
		admin = new Admin();
		if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {   
            String ans = "";

            DataBase.addLog("Admin logged in");

            while (!ans.equals("exit")) {
                System.out.println("Hello, admin! What do you want to do?");
                System.out.println("1. Add new user");
                System.out.println("2. Delete user");
                System.out.println("3. Show log file");
                System.out.println("4.Update info about user");
                ans = sc.nextLine();

                switch (ans) {
                    case "1":
                        addUser();
                        break;
                    case "2":
                        removeUser();
                        break;
                    case "3":
                        viewLogs();
                        break;
                    case "4":
                    	updateInfo();
                    case "exit":
                        return;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            }


        }
        else {
            System.out.println("Invalid login or password!");
        }
		
	}

	private void addUser() {
		while (true) {
            System.out.println("Add who? ");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Manager");
            System.out.println("4. Executor");

            String ans = sc.nextLine();
            UserType userType;

            switch (ans) {
                case "1":
                    userType = UserType.STUDENT;
                    break;
                case "2":
                	userType = UserType.TEACHER;
                    break;
                case "3":
                	userType = UserType.OR;
                    break;
                case "4":
                	userType = UserType.EXECUTOR;
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid option!");
                    continue;
            }
            
            System.out.println("First name:");

            String name = sc.nextLine();
            
            System.out.println("Last name:");

            String lastName = sc.nextLine();

           

            admin.addUser(name, lastName,userType);
            
          DataBase.saveData(); //serialization
            System.out.println("Success! Better than your life..");
            
        }
	}
	
	private void removeUser() {
		System.out.println("You are gonna delete a user. Enter his login. ");

        String login = sc.nextLine();

        if (admin.deleteUser(login)) {
            System.out.println("Deleted! ");
        }
        else {
            System.out.println("Such user doesn't exist...");
        }
		
	}
	
	
	private void viewLogs() {
		try {

            BufferedReader br = new BufferedReader(new FileReader(DataBase.PATH + DataBase.log));

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);

                line = br.readLine();
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println(DataBase.EXCEPT_IO);
        }
		
		
	}
	
	private void updateInfo() {
		System.out.println("Enter login of user");
		String login = sc.nextLine();
		ArrayList<User> list = new ArrayList<>(); 

        boolean found = false;

        list.addAll(DataBase.teacherList);
        list.addAll(DataBase.studentList);
        list.addAll(DataBase.managerList);
        list.addAll(DataBase.executorList);
        
        for (User u: list) { //looking for such user with login and password
            if (u.getLogin().equals(login)) {
            		user = u;
            		found = true;
            }
        }
        if(found) {
        	System.out.println("Which info you want to change?");
    		System.out.println("1. General");
    		System.out.println("2. More spesific");
    		String ans = sc.nextLine();
    		if(ans.equals("1"))
    			updateGeneral();
    		else
    			updateSpecific();
        }
        else System.out.println("User not found");
		
		
	}

	private void updateGeneral() {
		System.out.println("Choose what to change:");
		System.out.println("1. Name\n 2.Surname \n 3.Password \n 4.Gender \n ");
		String ans = sc.nextLine();
		switch(ans) {
			case "1":
				updName();
				break;
			case "2":
				updSurname();
				break;
			case "3":
				updPassword();
				break;
			case "4":
				updGender();
				break;
			default:
				return;
		}
		
	}
	
	private void updName() {
		System.out.println("What name you want?");
		String ans = sc.nextLine();
		user.setFirstName(ans);
		System.out.println("Okay");
	}


	private void updSurname() {
		System.out.println("What surname you want?");
		String ans = sc.nextLine();
		user.setLastName(ans);
		System.out.println("Okay");
	}


	private void updPassword() {
		System.out.println("What password you want?");
		String ans = sc.nextLine();
		user.setPassword(ans);
		System.out.println("Okay");
	}


	private void updGender() {
		System.out.println("Press 0 to female 1 to male");
		String ans = sc.nextLine();
		if(ans.equals("0")) user.setGender(Gender.FEMALE);
		else user.setGender(Gender.MALE);
		System.out.println("Okay");
	}


	private void updateSpecific() {
		switch (user.getClass().getSimpleName()) { 
        case "Student":
            ChangeAsStudent();
            break;
        case "Teacher":
        	ChangeAsTeacher();
            break;
        case "OR":
        	ChangeAsManager();
            break;
        case "Executor":
            ChangeAsExecutor();
            break;
        case "exit":
        	System.out.println("Bye !");
        	break;
    }

		
	}

	

	private void ChangeAsStudent() {
		System.out.println("Choose what to change:");
		System.out.println("1. Faculty\n");
		String ans = sc.nextLine();
		switch(ans) {
			case "1":
				updFaculty();
				break;
			default:
				return;
		}
		
	}


	private void updFaculty() {
		System.out.println("Choose faculty:");
		System.out.println("1. FIT, 2 BS ,3 ISE, 4 KMA, 5 FOGI, 6 MCM");
		String ans = sc.nextLine();
		
	}


	private void ChangeAsTeacher() {
		// TODO Auto-generated method stub
		
	}


	private void ChangeAsManager() {
		// TODO Auto-generated method stub
		
	}


	private void ChangeAsExecutor() {
		// TODO Auto-generated method stub
		
	}


	



	

	
    
    
    
}
