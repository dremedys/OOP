package Threads;
import java.util.Date;
public class EatingThread  extends Thread{
	static int cakeWeight = 50;
	int max = 0;
	public EatingThread(int m){
		max = m;
	}
	static synchronized void eat(){
		if(cakeWeight<=0) {
			System.out.println("There is no any cake left! Cake was already eaten!!!");
			System.exit(0);
		}
		cakeWeight-=5;
		System.out.println(" "+Thread.currentThread().getName()+" finished eating, at moment... >>>"+(new Date())+", cake weight is "+cakeWeight);

	}
	public void run(){
		for(int i=0; i<max; i++){
			try {
				Thread.sleep(500);
				eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
