package Threads;
public class testBank {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("group");  
        Thread []t = new Thread[10];
		for(int i=0; i<t.length; i++) {
			t[i] = new Thread(group, new addDollarThread()); 
			t[i].start();}
		
		boolean done = false;
		while(!done)  
		{      
			//Estimate number of active threads in the thread group  
			if (group.activeCount() == 0)  
			{  
				done = true;  
			}  
		}  
	}

	}


