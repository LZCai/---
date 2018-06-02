package JavaA.the_fifth;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 下午2:13:13
 * 
 */
public class Question10 {
	
	public static long n, s, a, b ;
	public static long count = 0l ;
	public static long[][] dp ;
	public static int e = 0 ;
	
	public static void getDP(){
		
		dp = new long[2][1000005] ;
		
		dp[e][0] = 1 ;
		
		for(int i=1 ; i<n ; i++){
			
			e = 1-e ;
			
			for(int j=0 ; j <= i*(i+1)/2 ; j++){
				
				if(i > j){
					
					dp[e][j] = dp[1-e][j] ;
					
				}else{
					
					dp[e][j] = (dp[1-e][j] + dp[1-e][j-i]) % 100000007;
					
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
		
		getDP() ;
		
		for(int i=1 ; i<n*(n-1)/2 ; i++){
			
			if((s-a*i-b*(n*(n-1)/2)) % n == 0){
				
				count = (count + dp[e][i]) % 100000007 ;
			}
		}
		
		System.out.println(count);
		
		scan.close() ;
	}

}
