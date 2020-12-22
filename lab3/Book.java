package lab3;

import java.util.Vector;

public class Book implements Readable{
	String name;
	int pages;
	String author;
	Vector<String> text = new Vector<String>();
	public void read() {
		for(String s : text) {
			System.out.print(s);
		}
	}
	public int numOfWords(int lineStart,int lineEnd) {
		return text.size();
		
	}
	public boolean hasPalindrome(int indexOfLine) {
		for(String s : text) {
			for(int i = 0 ; i < s.length()/2;i++) {
				if(i==1) return false;
			}
		}
		return true;
	}
}
