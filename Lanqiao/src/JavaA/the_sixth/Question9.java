package JavaA.the_sixth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月27日 下午12:07:36
 * 
 */
public class Question9 {
	
	public static int[] backN = {0, 4, 5, 6, 1, 2, 3} ;
	
	public static BigInteger mod = new BigInteger("1000000007") ;
	
	public static BigInteger getAofN(BigInteger a, int n){
		
		BigInteger result = BigInteger.ONE ;
		
		BigInteger temp = a ;
		
		while(n>0){
			
			if((n&1) == 1){
				
				result = result.multiply(temp).mod(mod) ;
			}
			
			temp = temp.abs().multiply(temp).mod(mod) ;
			
			n = n >> 1 ;
		}
		
		return result ;
	}
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int m = scan.nextInt() ;
		
		boolean[][] mat = new boolean[7][7] ;
		
		for(int i=0 ; i<m ; i++){
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			mat[a][b] = mat[b][a] = true ;
		}
		
		BigInteger[][] dp = new BigInteger[n+1][7] ;
		
		for(int i=1 ; i<=n ; i++){
			
			for(int j=1 ; j<=6 ; j++){
				
				dp[i][j] = BigInteger.ZERO ;
			}
		}
		
		for(int i=1 ; i<=6 ; i++){
			
			dp[1][i] = BigInteger.ONE ;
		}
		
		for(int i=2 ; i<=n ; i++){
			
			for(int j=1 ; j<=6 ; j++){
				
				for(int k=1 ; k<=6 ; k++){
					
					if(mat[backN[j]][k] == false){
						
						dp[i][j] = dp[i][j].add(dp[i-1][k]) ;
						dp[i][j] = dp[i][j].mod(mod) ;
					}
				}
			}
		}
		
		BigInteger result = BigInteger.ZERO ;
		
		for(int i=1 ; i<=6 ; i++){
			
			result = result.add(dp[n][i]).mod(mod) ;
		}
		
		BigInteger count = getAofN(new BigInteger("4"), n) ;
		
		result = result.multiply(count).mod(mod) ;
		
		System.out.println(result);
		
		scan.close() ;
	}

}
