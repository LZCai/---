package 历届试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月7日 上午9:17:28
 * 
 */
public class 拉马车 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String s1 = scan.nextLine() ;
		String s2 = scan.nextLine() ;
		
		scan.close() ;
		
		ArrayList<Character> A = new ArrayList<Character>() ;
		ArrayList<Character> B = new ArrayList<Character>() ;
		ArrayList<Character> C = new ArrayList<Character>() ;
		
		for(int i=0 ; i<s1.length() ; i++){
			
			A.add(s1.charAt(i)) ;
			
		}
		
		for(int j=0 ; j<s2.length() ; j++){
			
			B.add(s2.charAt(j)) ;
			
		}
		
		char flag = 'A' ;
		
		int count = 0 ;
		
		while(A.size()!=0 && B.size()!=0){
			
			count ++ ;
			
			if(count > 10000) break ;
			
			if(flag == 'A'){
				
				char a = A.remove(0) ;
				
				if(C.contains(a)){
					
					C.add(a) ;
					
					int len = C.size() - C.indexOf(a) ;
					
					for(int i=0 ; i<len ; i++){
						
						A.add(C.remove(C.size()-1)) ;
						
					}
					
				}else{
					
					C.add(a) ;
					
					flag = 'B' ;
				}
				
				if(A.size() == 0) break ;
			}
			
			if(flag == 'B'){
				
				char b = B.remove(0) ;
				
				if(C.contains(b)){
					
					C.add(b) ;
					
					int len = C.size() - C.indexOf(b) ;
					
					for(int i=0 ; i<len ; i++){
						
						B.add(C.remove(C.size()-1)) ;
						
					}
					
				}else{
					
					C.add(b) ;
					
					flag = 'A' ;
				}
				
				if(B.size() == 0) break ;
			}
			
			
		}
		
		if(A.size() == 0){
			
			for(char c : B){
				
				System.out.print(c);
			}
		}
		
		else if(B.size() == 0){
			
			for(char c : A){
				
				System.out.print(c);
			}
		}
		
		else
			
			System.out.println(-1);
			
			
	}

}
