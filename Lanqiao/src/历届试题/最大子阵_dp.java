package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月16日 下午3:50:42
 * 
 */
public class 最大子阵_dp {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int[][] value = new int[505][505] ;//存储原始矩阵行 
		int[] s = new int[505] ; //存储子阵中每列的和
		int[] dp = new int[505] ; 
		int max = Integer.MIN_VALUE ;
		
		int n = scan.nextInt() ;
		int m = scan.nextInt() ;
		
		for(int i=1 ; i<=n ; i++){ //对原始矩阵的行进行
			
			for(int j=1 ; j<=m ; j++){
				
				value[i][j] = scan.nextInt() ;
			}
		}
		
		scan.close();
		
		for(int i=1 ; i<=n ; i++){
			
			Arrays.fill(s, 0);
			
			for(int j=i ; j<=n ; j++){
				
				for(int k=1; k<=m ; k++){
					
					s[k] += value[j][k] ;
					
					if(dp[k-1]+s[k] > s[k]){
						
						dp[k] = dp[k-1]+s[k] ;
						
					}else{
						
						dp[k] = s[k] ;
						
					}
					
					if(max < dp[k]){
						
						max = dp[k] ;
					}
						
				}
			}
		}
		
		System.out.println(max);
	}

}
