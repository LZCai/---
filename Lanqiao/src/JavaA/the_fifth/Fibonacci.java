package JavaA.the_fifth;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 上午10:13:50
 * 
 */
public class Fibonacci {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int f1 = 1 ;
		int f2 = 1 ;
		int fn = 0 ;
		
		for(int i=1 ; i<=n-2 ; i++){
			
			fn = (f1+f2) % 10007 ;
			
			f1 = f2 ;
			f2 = fn ;
		}
		
		System.out.println(fn);
		
		scan.close() ;
		
		
	}
	
}
