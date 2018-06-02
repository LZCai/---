package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月9日 下午4:09:58
 * 
 */
public class 凑包子数 {
	
	public static int[] num ;
	
	public static boolean[] dp = new boolean[10100] ;
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		num = new int[n] ;
		
		for(int i=0 ; i<n ; i++){
			
			num[i] = scan.nextInt() ;
			
		}
		
		scan.close(); 
		
		//判断所有数字的最小公约数是否为1，如果为1则有限个数，否则为无限个数
		int g = num[0] ;
		for(int i=0 ; i<n ; i++){
			
			g = gcd(g, num[i]) ;
			
		}
		
		if(g != 1){//存在无限个数，不能表示
			
			System.out.println("INF");
			
		}else{//存在有限个数，能表示
			
			dp[0] = true ;
			
			for(int i=0 ; i<n ; i++){
				
				for(int j=0 ; j<10000 ; j++){
					
					if(dp[j]){
						
						dp[j+num[i]] = true ;
						
					}
				}
			}
			
			int count = 0 ;
			
			for(int i=0 ; i<10000 ; i++){
				
				if(!dp[i])
					
					count ++ ;
					
			}
			
			System.out.println(count);
			
		}
		
		
	}
	
	public static int gcd(int a, int b){
		
		if(a%b == 0){
			
			return b ;
			
		}else{
			
			return gcd(b, a%b) ;
		}
	}

}
