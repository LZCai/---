package 历届试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月25日 上午10:32:14
 * 
 */
public class 对局匹配 {//动态规划dp
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int k = scan.nextInt() ;
		
		int max = 100001 ;
		int[] score = new int[max] ;
		int[] value = new int[max] ;
		int[] dp = new int[max] ;
		
		int max_n = 0 ;
		
		for(int i=0 ; i<n ; i++){
			
			int s = scan.nextInt() ;
			
			score[s] ++ ;
			
			max_n = Math.max(max_n, s) ;
			
		}
		
		scan.close() ;
		
		int count = 0 ;
		
		if(k == 0){
			
			for(int i=0 ; i<=max_n ; i++){
				
				if(score[i] != 0)
					
					count ++ ;
				
			}
			
		}else{
			
			for(int i=0 ; i<k ; i++){
				
				int m = 0 ;
				
				for(int j=i ; j<=max_n ; j+=k){
					
					value[m++] = score[j] ;
					
				}
				
				dp[0] = value[0] ;
				
				for(int j=1 ; j<m ; j++){
					
					if(j == 1) 
						
						dp[j] = Math.max(dp[0], value[1]) ;
					
					else
						
						dp[j] = Math.max(dp[j-2]+value[j], dp[j-1]) ;
				}
				
				count += dp[m-1] ;
				
			}
		}
		
		System.out.println(count);

	}
	
}
