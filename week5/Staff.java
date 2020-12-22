package week5;

public class Staff extends Person{
	private String school;
	private double pay;
	Staff(String name,String address,String school,double pay){
		
		this.school=school;
		this.pay=pay;
	}
	String getSchool() {
		return school;
	}
	void setSchool(String s) {
		this.school=s;
	}
	double getPay() {
		return pay;
	}
	void setPay(double pay) {
		this.pay=pay;
	}
	public String toString() {
		return "Staff["+super.toString()+"school "+school+ "pay: "+pay+ " ]";
	}

}
