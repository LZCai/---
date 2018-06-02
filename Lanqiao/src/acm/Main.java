package acm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月4日 下午8:30:03
 * 
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		List<Integer> a_list = new ArrayList<Integer>() ;
		List<Integer> b_list = new ArrayList<Integer>() ;
		
		while(true){
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			if(a == 0 && b == 0){
				
				break ;
			}
			
			a_list.add(a) ;
			b_list.add(b) ;
		}
		
		int length = a_list.size() ;
		
		for(int i=0; i < length; i ++){
			
			long num = (long) Math.pow(a_list.get(i), b_list.get(i)) ;
			
			String str = Long.toString(num) ;
			
			if(str.length() <= 3){
				
				System.out.println(str);
				
			}else{
				
				System.out.println(str.substring(str.length() - 3));
			}
		}
		
		scan.close();
		
	}

}
