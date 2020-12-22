package week9;

import java.util.Arrays;

public class MinMax {
  public static class two{
      int mini;
      int maxa;
      public two(int fir,int sec){
        this.mini = fir;
        this.maxa = sec ;}
      public String toString() {
        return mini+ " " + maxa;
      }
        
    }
    public static two minmax(int a[]) {
    	Arrays.sort(a);
      return new two(a[0],a[a.length-1]);
    }
    
  }

