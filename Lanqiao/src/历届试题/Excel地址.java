package 历届试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月7日 上午11:20:59
 * 
 */
public class Excel地址 {
	
	public static char find(int n){
		
		switch(n){
		
		case 0:
			return 'Z' ;
		case 1:
			return 'A' ;
		case 2:
			return 'B' ;
		case 3:
			return 'C' ;
		case 4:
			return 'D' ;
		case 5:
			return 'E' ;
		case 6:
			return 'F' ;
		case 7:
			return 'G' ;
		case 8:
			return 'H' ;
		case 9:
			return 'I' ;
		case 10:
			return 'J' ;
		case 11:
			return 'K' ;
		case 12:
			return 'L' ;
		case 13:
			return 'M' ;
		case 14:
			return 'N' ;
		case 15:
			return 'O' ;
		case 16:
			return 'P' ;
		case 17:
			return 'Q' ;
		case 18:
			return 'R' ;
		case 19:
			return 'S' ;
		case 20:
			return 'T' ;
		case 21:
			return 'U' ;
		case 22:
			return 'V' ;
		case 23:
			return 'W' ;
		case 24:
			return 'X' ;
		case 25:
			return 'Y' ;
		default:
			return '@' ;
				
		}
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int num = scan.nextInt() ;
		
		scan.close() ;
		
		ArrayList<Integer> mod = new ArrayList<Integer>() ;
		
		while(num != 0){
			
			if(num%26 == 0){
				
				mod.add(num%26) ;
				
				num = num/26 ;
				
				num --;
				
			}else{
				
				mod.add(num%26) ;
				
				num = num/26 ;
			}
			
		}
		
		for(int i=mod.size()-1 ; i>=0 ; i--){
			
			System.out.print(find(mod.get(i)));
		}
	}

}
