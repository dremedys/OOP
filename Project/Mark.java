package intranet;

import java.io.Serializable;
/**
* The Mark class that works similarly to real mark.

* @author  Dariga Abdikarimova,Adilet Abylaikhan
* 
* @since   2018-11-25
* 
*/
public class Mark implements Serializable{
	/** Used to keep mark for first attestation
	*/
	int first; 
	/** Used to keep mark for second attestation
	*/
    int second; 
    /** Used to keep mark for final
	*/
    int third; 
    
    /** Used to keep if course is finished
	*/
    boolean finished;
    /** Used for a serializable object.
	*/
    private static final long serialVersionUID = 1L;
    
    /**Method to create an empty mark which is not finished.
     
	*/
    public Mark() { 
    	this.first = 0;
    	this.second = 0;
    	this.third = 0;
    	this.finished = false;
    
    }
	
    /**Method to show letter equivalent of Mark
     * @return String letter value of the mark
	*/
	public String toString() {
		int t = totalMark();
		if(t < 30) 
			return "F";
		
		if(!finished) 
			return "N/A";
		
		if(!finished && getThird() < 20) return "FX";
		if( t <= 55)  return "D";
		if( t <= 60) return "D+";
		if( t <= 65) return "C-";
		if( t <= 70) return "C";
		if( t <= 75) return "C+";
		if( t <= 80) return "B-";
		if( t <= 85) return "B";
		if( t <= 90) return "B+";
		if( t <= 95) return "A-";
		return "A";
	}
	
	
	/**Method to show total sum of the course
     * @return int sum of three marks
	*/
	public int totalMark() {
		return first + second + third;
	}
	
	/**Method to set mark for specific case.
	 * @param val which value to set.
	 * @param markType type of the mark
     
	*/
	public void setMark(int val,MarkType markType) {
		switch(markType) {
			case FIRST_ATT:
				setFirst(val);
				break;
			case SEC_ATT:
				setSecond(val);
				break;
			case FINAL:
				setThird(val);
				break;
		}
	}
	
	/**Method to show GPA of Mark
     * @return double GPA view of the mark
	*/
	public double toGpa() {
		if(!finished) 
			return 0;
		int t = totalMark();
		if(t < 30) 
			return 0.00;
		
		if(!finished) 
			return 0.00;
		
		if( t <= 55)  return 1.00;
		if( t <= 60) return 1.33;
		if( t <= 65) return 1.67;
		if( t <= 70) return 2.00;
		if( t <= 75) return 2.33;
		if( t <= 80) return 2.67;
		if( t <= 85) return 3.00;
		if( t <= 90) return 3.33;
		if( t <= 95) return 3.67;
		return 4.00;
		
	}
	
	
	@Override
	/**Method to calculate hash code for object
     * @return int hash value
	*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		result = prime * result + third;
		return result;
	}

	/**Method to get first att. mark
     * @return int
	*/
	public int getFirst() {
		return first;
	}
	
	/**Method to set second att. mark
   @param first value to set
	*/
	public void setFirst(int first) {
		if(first > 30 || first < 0) {
			System.out.println("Choose a correct number");
			return;
		}
			
		this.first = first;
	}
	
	/**Method to get sec att. mark
    @return int second mark
	*/
	public int getSecond() {
		return second;
	}
	
	/**Method to set second att. mark
	 * @param second second att mark
    
	*/
	public void setSecond(int second) {
		this.second = second;
	}
	
	
	/**Method to get final mark
     * @return int final mark
	*/
	public int getThird() {
		return third;
	}
	
	/**Method to set final mark
	 * @param third which mark to put
    
	*/
	public void setThird(int third) {
		if(third > 40 || third < 0) {
			System.out.println("Choose a correct number");
			return;
		}
			
		this.third = third;
		finished = true;
	}
	
	
	
	
}