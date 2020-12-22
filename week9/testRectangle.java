package week9;

import java.util.Collections;
import java.util.Vector;

public class testRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Rectangle> v= new Vector<Rectangle>();
		v.add(new Rectangle(14,1034,"BB"));
		v.add(new Rectangle(5,55,"KK"));
		v.add(new Rectangle(100,1,"ZZ"));
		Collections.sort(v);
		for(Rectangle r: v) {
			System.out.print(r.name);
			System.out.print("\n");
		}
		Collections.sort(v,new WidthCompare());
		for(Rectangle r: v) {
			System.out.print(r.name);
			System.out.print("\n");
		}
	}

}
