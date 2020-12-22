package Threads;
public class addDollarThread extends Thread{
 static Bank b = new Bank();
 public addDollarThread(){
  
 }
 public  synchronized void run(){
  updateBalance();
 }
  static synchronized void updateBalance(){
  
  int new_balance = b.getBalance()+1;
  try   {  
   Thread.sleep(500);  //Executing thread sleeps for a while :-)  
  }  
  catch (InterruptedException ex)   {  System.out.println(ex);  }  
  b.setBalance(new_balance);
  System.out.println("Bank has : $"+b.getBalance());
 }
}