package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月11日 上午9:22:37
 * 
 */
public class Main {
	
	public static void main(String [] args){
		
			Scanner scan = new Scanner(System.in) ;
			
			int n = scan.nextInt() ;
			
			int[] f = new int[n] ;
			
			f[0] = 1 ;
			
			if(n > 1){
				
				f[1] = 1 ;
			}
			
			for(int i = 2; i < n; i ++){
				
					f[i] = (f[i-1]%10007 + f[i-2]%10007)%10007 ;
				
			}
			
			System.out.println(f[n-1]) ;
			
			scan.close() ;
			
		
	}

}
