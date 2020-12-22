package week9;

import java.util.Comparator;

public class WidthCompare implements Comparator<Rectangle> {

	@Override
	public int compare(Rectangle o1, Rectangle o2) {
		if(o1.width < o2.width) {
			return -1;
		}
		if(o2.width > o2.width) {
			return 1;
		}
		return 0;
	}
}
