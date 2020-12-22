package oop;

public class starTriangle {
	int width;
	String s="";
	starTriangle(int width){
		this.width=width;
	}
	public void make() {
		for(int i=0;i<this.width+1;i++) {
				String world= "[+]".repeat(i);
				s+=(world+"\r\n");
		}
	}
	public String toString() {
		this.make();
		return this.s;
	}
	
}