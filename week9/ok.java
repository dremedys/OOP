package week9;

import java.math.BigInteger;

public class ok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int P = 113;
	    int MOD = 1_000_000_007;
	    int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();
	    System.out.print((Pinv%MOD*P%MOD));
	    
	    
	    
	    
	}

}
