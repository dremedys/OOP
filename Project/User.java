package intranet;

import java.io.Serializable;

public abstract class User extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String login;
    private String password;
    
    private final static String defaultPassword = "1111";
    
    {
    	this.password = defaultPassword;
    }
    
    public User(String firstName  , String lastName,char c) {
    	super(firstName , lastName);
    	setLogin( (firstName  + c + lastName).toLowerCase());
    }
    
    
   
    public static String readNews() {
    	String news = "";
    	if(DataBase.newList.isEmpty()) {
    		return "No new yet\n";
    	}
    	for( New i : DataBase.newList) {
    		news += i ;
    	}
    	return news;
    }

    public boolean leaveComment(int id,String owner,String text) {
    	for(New n : DataBase.newList) {
    		if(n.id == id) {
    			n.comments.add(new Message("",text,owner));
    			return true;
    		}
    	}
    	return false;
    }
    
    
	public int hashCode() {
		int res = super.hashCode();
		res += 17*login.hashCode() + 31;
		return res;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (obj == this) 
	        	return true;
	        if (!(obj instanceof User)) 
	        	return false;
	        
	        User u = (User) obj;
	        return u.login.equals(login);
	    }
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		 String login = "Login : " + this.getLogin() + "\n";
	    return super.toString() + login ;
	}
}

