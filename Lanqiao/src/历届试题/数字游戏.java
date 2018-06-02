package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月22日 上午8:24:04
 * 
 */
public class 数字游戏 {
	
	public static void main(String[] args){
		
		 Scanner scan = new Scanner(System.in) ;
		 
		 int n = scan.nextInt() ;
		 int k = scan.nextInt() ;
		 int t = scan.nextInt() ;
		 
		 scan.close() ;
		 
		 long len = n*(t-1) + 1 ;
		 
		 int sum = 0 ;
		 
		 long a = 0 ;
		 long b = 1 ;
		 
		 for(int i=1 ; i<=len ; i++){
			 
			 b = a+b ;
			 a = i ;
			 
			 if(b >= k){
				 
				 b = b % k ;
			 }
			 
			 if(i%n == 1){
				 
				 sum += b ;
			 }
		 }
		 
		 System.out.println(sum);
	}

}
