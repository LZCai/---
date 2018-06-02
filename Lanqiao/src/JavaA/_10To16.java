package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月12日 下午3:14:14
 * 
 */
public class _10To16 {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.close(); 
		
		StringBuilder sb = new StringBuilder() ;
		
		while(true){
			
			if(n < 16){
				
				switch(n){
				
				case 10:
					sb.append("A") ;
					break ;
				case 11:
					sb.append("B") ;
					break ;
				case 12:
					sb.append("C") ;
					break ;
				case 13:
					sb.append("D") ;
					break ;
				case 14:
					sb.append("E") ;
					break ;
				case 15:
					sb.append("F") ;
					break ;
				default:
					sb.append(n) ;
				}
				
				break ;
				
			}else{
				
				int mod = n%16 ;
				
				switch(mod){
				
				case 10:
					sb.append("A") ;
					break ;
				case 11:
					sb.append("B") ;
					break ;
				case 12:
					sb.append("C") ;
					break ;
				case 13:
					sb.append("D") ;
					break ;
				case 14:
					sb.append("E") ;
					break ;
				case 15:
					sb.append("F") ;
					break ;
				default:
					sb.append(mod) ;
				}
				
				n = n/16 ;
				
			}
		}
		
		sb.reverse() ;
		
		System.out.println(sb) ;
	}
}
