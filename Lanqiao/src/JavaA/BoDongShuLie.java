package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月22日 下午8:48:27
 * 
 */
public class BoDongShuLie {

	public static long n, s, a, b ;
	
	public static long count = 0L ;
	
	public static long[][] dp ;
	
	public static int e = 0 ;
	
	public static void getDP(){
		
		dp = new long[2][1000000] ;
		
		dp[e][0] = 1 ;
		
		for(int i=1 ; i<n ; i++){
			
			e = 1-e ;
			
			for(int j=0 ; j<=i*(i+1)/2 ; j++){
				
				if(i > j){
					
					dp[e][j] = dp[1-e][j] ;
					
				}else{
					
					dp[e][j] = (dp[1-e][j] + dp[1-e][j-i]) % 100000007 ;
				}
				
			}
		}
	}
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextLong() ;
		s = scan.nextLong() ;
		a = scan.nextLong() ;
		b = scan.nextLong() ;
		
		scan.close() ;
		
		getDP() ;
		
		long maxTimes = n*(n-1)/2 ;
		
		for(int i=0 ; i<=maxTimes ; i++){
			
			long t = s - i*a + (maxTimes-i)*b ;
			
			if(t%n == 0){
				
				count = (count + dp[e][(int)i]) % 100000007 ;
			}
		}
		
		System.out.println(count);
	}
}
