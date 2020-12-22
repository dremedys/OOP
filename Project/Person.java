package intranet;

import java.io.Serializable;

public class Person implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private String firstName;
    private String lastName;
    private Gender gender;
    
    {
    	firstName = "";
        lastName = "";
        gender = null;
    }
    
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	 public String toString() {
	        String genderInfo;
	        try {
	            genderInfo = "Gender: " + gender.toString() + '\n';
	        }
	        catch (Exception e) {
	            genderInfo = "";
	        }
	        String nameInfo = "Name: " + this.getFullName() + '\n';
	        return nameInfo + genderInfo;
	    }

	@Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        
        if (!(obj instanceof Person)) return false;
        
        Person p = (Person) obj;
        
        return ( p.firstName.equals(firstName)) &&
                ( p.lastName.equals(lastName));
               
    }
	
	public int hashCode() {
		int sum = 17;
		sum = 31* firstName.hashCode() + sum*17;
		return sum;
	}
    
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {

		this.gender = gender;
	}
	
	
	public String getFullName() {
        return this.getLastName() + " " + this.getFirstName();
    }
	
	public String getFullNameRev() {
		return this.getFirstName() + " " + this.getLastName();
	}
}


