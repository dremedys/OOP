package intranet;

public class Admin {

	private  String login ;
	private String password;
	
	{
		login = "admin";
		password = "pass";
	}
	
	public Admin() {
		
	}
	
	public boolean addUser(String firstName, String lastName, UserType userType) {
		switch(userType){
			case STUDENT:
				if(addStudent(firstName,lastName))
					return true;
				break;
			case TEACHER:
				if(addTeacher(firstName,lastName))
					return true;
				break;
			case OR:
				if(addManager(firstName,lastName))
					return true;
				break;
			case EXECUTOR:
				if(addExecutor(firstName,lastName))
					return true;
				break;
		}
				return false;
	}
	
	private boolean addStudent(String firstName, String lastName) {
		
		Student student = new Student(firstName,lastName);
		
		if(DataBase.studentList.contains(student)) 
			return false;
		
		else {
			DataBase.studentList.add(student);
				return true;
		}
	}
	
	private boolean addManager(String firstName, String lastName) {
		
		OR or = new OR(firstName,lastName);
		
		if(DataBase.managerList.contains(or)) 
			return false;

			DataBase.managerList.add(or);
			return true;
		
		
	}
	
	private boolean addExecutor(String firstName, String lastName) {
		Executor executor = new Executor(firstName,lastName);
		if(DataBase.executorList.contains(executor)) 
			return false;
	
		DataBase.executorList.add(executor);
		return true;
		
		
	}
	
	private boolean addTeacher(String firstName, String lastName) {
		Teacher teacher = new Teacher(firstName,lastName);
		if(DataBase.teacherList.contains(teacher)) 
			return false;
	
		DataBase.teacherList.add(teacher);
		return true;
		
		
	}
	
	public boolean deleteUser(String login) {
		for(Student student : DataBase.studentList) {
			if(student.getLogin().equals(login)) {
				DataBase.studentList.remove(student);
					return true;
			}
		}
		for(Executor executor : DataBase.executorList) {
			if(executor.getLogin().equals(login)) {
				DataBase.executorList.remove(executor);
					return true;
			}
		}
		for(Teacher teacher : DataBase.teacherList) {
			if(teacher.getLogin().equals(login)) {
				DataBase.teacherList.remove(teacher);
					return true;
			}
		}
		for(OR or : DataBase.managerList) {
			if(or.getLogin().equals(login)) {
				DataBase.managerList.remove(or);
					return true;
			}
		}
		
	    return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Admin)) {
			return false;
		}
		Admin other = (Admin) obj;
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
				return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
				return false;
		}
				return true;
	}
	
	
	public String getLogin() {
		return login;
	}
	
	
	public String getPassword() {
		return password;
	}
}

