package Threads;

public class testEstimatePi {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("group");  
        Thread []t = new Thread[10000]; 
		for(int i=0; i<t.length; i++) {
			t[i] = new Thread(group, new estimatePi()); 
			t[i].start();}
		
		boolean done = false;
		
		while(!done)  
		{      
			if (group.activeCount() == 0)  
			{  
				done = true;  
			}  
		}  

	}

}
