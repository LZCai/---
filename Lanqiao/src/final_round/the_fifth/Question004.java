package final_round.the_fifth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月11日 上午10:53:29
 * 
 */
public class Question004 {
	
	public static String line ;
	
	public static long getN(int n){
		
		long result = 1 ;
		
		for(int i=1 ; i<= n ; i++){
			
			result *= i ;
			
		}
		
		return result ;
	}

	
	public static void getResult(){
		
		int len = line.length() ;
		
		char[] c_array = line.toCharArray() ;
		
		boolean[] used = new boolean[len] ;
		
		Arrays.sort(c_array);
		
		long count = 0 ;
		
		for(int i=0 ; i<len ; i++){
			
			char c = line.charAt(i) ;
			
			int a = 0 ;
			
			for(int j=0 ; j<len ; j++){
				
				if(used[j]){
					
					continue ;
					
				}
				if(c == c_array[j]){
					
					used[j] = true ;
					
					break ;
				}
				
				a ++ ;
				
			}
			
			count = count + a*getN(len-1-i) ;
		}
		
		System.out.println(count);
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		line = scan.nextLine() ;
		
		getResult();
		
		scan.close(); 
	}
}
