package week2;

public class Time implements Comparable<Time>{
	private int h;
	private int min;
	private int sec;
	public Time(int h,int min,int sec) {
		setH(h);
		setMin(min);
		setSec(sec);
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		if(h<0 || h>23) 
			System.err.print("Put right hour ");
		
		else
			this.h = h;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		if(min<0 || min>59) 
			System.err.print("Put right minute ");
		
		else	
			this.min = min;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		if(sec<0 || sec>59) 
			System.err.print("Put right second ");
		
		else	
			this.sec = sec;
	}
	public String toUniversal() {
		String ans = "";
		if(h<10) ans+="0" + (h); else ans+=(h);
		if(min<10) ans+=":0" + (min); else ans+=":"+min;
		if(sec<10) ans+=":0" + (sec); else ans+=":"+(sec);
		return ans;
	}
	public String toStandart() {
		String ans="";
		String letters;
		if(h - 12 < 0) letters = "AM";
		else letters = "PM";
		int new_hour = Math.abs(h-12);
		if(new_hour<10) ans+="0" + (new_hour); else ans+=(new_hour);
		if(min<10) ans+=":0" + (min); else ans+=":"+(min);
		if(sec<10) ans+=":0" + (sec); else ans+=":"+(sec);
		return ans+" " + letters;
	}
	
	public int compareTo(Time o) {
		if(h > o.h) return 1;
		if(h < o.h) return -1;
	    if(h == o.h) {
	    	if(min > o.min) return 1;
	    	if (min < o.min) return -1;
	    	if (min == o.min) {
	    		if(sec > o.sec) return 1;
	    		if(sec < o.sec) return -1;
	    	}
	    }
	    return 0;
	}
	
	
}
