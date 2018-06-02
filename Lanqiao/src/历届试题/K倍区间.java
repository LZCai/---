package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月7日 下午3:47:20
 * 
 */
public class K倍区间 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int k = scan.nextInt() ;
		
		int[] sum = new int[100001] ;
		int[] ans = new int[100001] ;
		
		long count = 0 ;
		
		for(int i=0 ; i<n ; i++){
			
			if(i==0)
				
				sum[i] = scan.nextInt() % k ;
			
			else 
				
				sum[i] = (sum[i-1] + scan.nextInt()) % k ;
			
			count += ans[sum[i]] ;
			
			ans[sum[i]] ++ ;
			
		}
		
		System.out.println(count + ans[0]);
		
		scan.close();
	}

}
