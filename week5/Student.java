package week5;

public class Student extends Person {
	private String program;
	private int year;
	private double fee;
	static int count=0;
	String says="STUDENTPZ";
	Student(){
		count++;
	}
	Student(String name,String address,String program,int year,double fee){
		
		this.program=program;
		this.fee=fee;
		this.year=year;		
	}
	String getProgram() {
		return program;
	}
	double getFee() {
		return fee;
	}
	int getYear() {
		return year;
	}
	void setProgram(String program) {
		this.program= program;
	}
	void setFee(double fee) {
		this.fee=fee;
	}
	void setYear(int year) {
		this.year=year;
	}
	public String toString() {
		return "Student["+super.toString()+"program "+program+ "year: "+year+ " fee: "+fee+ " ]";
	}
	String amandasu() {
		return "SALAM APAILAR";
	}
	void getStudentNumber() {
		System.out.print(count);
	}
	
	

}
