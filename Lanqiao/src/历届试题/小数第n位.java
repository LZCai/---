package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月24日 上午10:22:45
 * 
 */
public class 小数第n位 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		long a = scan.nextLong() ;
		long b = scan.nextLong() ;
		
		long c = scan.nextLong() ;
		
		scan.close() ;
		
		long mod = a%b ;
		
		int count = 1 ;
		
		while(c-10 > 0){
			
			mod *= 1e10 ;
			
			mod %= b ;
			
			c -= 10 ;
			
		}
		
		while(count <= c+2){
			
			if(mod == 0 && count < c){
				
				System.out.println("000");
				
				break ;
				
			}
			
			if(count >= c){
				
				long div = mod*10/b ;
			
				System.out.print(div);
			
			}
			
			mod = mod*10%b ;
			
			count ++ ;
		}
		
	}

}
