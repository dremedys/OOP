package Threads;

public class PrintThreadR implements Runnable{
	String name="";
	public PrintThreadR(String name){
		this.name = name;
	}
	public void run(){
		//describe actions that thread must do
		for(int i=0; i<10; i++) {
			System.out.println("implementing runnable interface  " + i+ " "+this.name);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
