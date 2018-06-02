package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月11日 下午9:15:59
 * 
 */
public class _16To10 {
	
		public static void main(String[] args){
			
			Scanner scan = new Scanner(System.in);
			
			String num = scan.next() ;
			
			int index = 0 ;
			long sum = 0 ;
				
			int lambd = 0 ;
			
			for(int j=num.length()-1; j>=0; j--){
					
					switch(num.charAt(j)){
					
					case '0':
						
						lambd = 0 ;
						break ;
					case '1':
						
						lambd = 1 ;
						break ;
					case '2':
						
						lambd = 2 ;
						break ;
					case '3':
		
						lambd = 3 ;
						break ;
					case '4':
		
						lambd = 4 ;
						break ;
					case '5':
						
						lambd = 5 ;
						break ;
					case '6':
						
						lambd = 6 ;
						break ;
					case '7':
						
						lambd = 7 ;
						break ;
					case '8':
						
						lambd = 8 ;
						break ;
					case '9':
		
						lambd = 9 ;
						break ;
					
					case 'A':
						
						lambd = 10 ;
						break ;
					case 'B':
						
						lambd = 11 ;
						break ;
					case 'C':
						
						lambd = 12 ;
						break ;
					case 'D':
		
						lambd = 13 ;
						break ;
					case 'E':
		
						lambd = 14 ;
						break ;
					case 'F':
						
						lambd = 15 ;
						break ;
					
					}
					
					sum += Math.pow(16, index) * lambd ;
					
					index++ ;
				}
			
			System.out.println(sum);
		}
}