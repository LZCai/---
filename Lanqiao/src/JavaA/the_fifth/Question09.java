package JavaA.the_fifth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 上午10:23:15
 * 
 */
public class Question09 {
	
	public static BigInteger[] num ;
	
	public static BigInteger Fibonacci(BigInteger f1, BigInteger f2, int begin, int n){
		
		BigInteger fn_1 = f1 ;
		BigInteger fn_2 = f2 ;
		
		BigInteger Fn = BigInteger.ZERO ;
		
		for(int i=begin ; i<=n-2 ; i++){
			
			Fn = fn_1.add(fn_2) ;
			
			fn_1 = fn_2 ;
			fn_2 = Fn ;
			
			num[i+2] = Fn ;
			
		}
		
		return Fn ;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int m = scan.nextInt() ;
		BigInteger p = scan.nextBigInteger() ;
		
		num = new BigInteger[n>m ? n+3 : m+3] ;
		
		num[1] = num[2] = BigInteger.ONE ;
		
		BigInteger Fm = Fibonacci(BigInteger.ONE, BigInteger.ONE, 1, m) ;
		
		BigInteger Fn = BigInteger.ZERO ;
		
		if(n+2 > m){
			
			 Fn = Fibonacci(num[m-1], num[m], m-1, n+2).subtract(BigInteger.ONE) ;
			
		}else{
			
			 Fn = num[n+2].subtract(BigInteger.ONE) ;
		}
		
		
		System.out.println(Fn.mod(Fm).mod(p));
		
		scan.close(); 
		
	}

}
