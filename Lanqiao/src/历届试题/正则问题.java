package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月10日 下午9:08:40
 * 
 */
public class 正则问题 {
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String line = scan.nextLine() ;
		
		StringBuilder sb = new StringBuilder(line) ;
		
		while(sb.toString().contains("(")){
			
			int start = sb.lastIndexOf("(") ;
			int end = start + sb.substring(start).indexOf(")") ;
			
			String subString = sb.substring(start+1, end) ;
			
			String[] x_len = subString.split("\\|") ;
			
			int max_l = -1 ;
			int max_j = -1 ;
			
			for(int j=0 ; j<x_len.length ; j++){
				
				if(x_len[j].length() > max_l){
					
					max_l = x_len[j].length() ;
					
					max_j = j ;
					
				}
				
			}
			
				sb.replace(start, end+1, x_len[max_j]) ;
				
		}
		
		System.out.println(sb.length());
		
		scan.close();
		
		
	}
	
}
