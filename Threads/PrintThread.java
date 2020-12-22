package Threads;

public class PrintThread extends Thread{
 public PrintThread(String name){
  this.setName(name);
 }

 public void run(){
  //describe actions that thread must do
  //System.out.println(Thread.NORM_PRIORITY);
  for(int i=0; i<10; i++) {
   System.out.println("extending Thread class  " + i+this.getName());
   // if(i==3) this.suspend();
   try {
    Thread.sleep(10);
   } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
}