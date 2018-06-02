package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月11日 上午10:38:38
 * 
 */
public class Add {
	
	public static void main(String [] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		long n = scan.nextLong() ;
		
		long sum = 0 ;
		
		sum = n + n*(n-1)/2 ;
		
		System.out.println(sum) ;
		
		scan.close();
	}

}


