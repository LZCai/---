package acm;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月6日 下午6:42:43
 * 
 */
public class Demo03 {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		Stack<Character> stack = new Stack<Character>() ;
		
		int n = scan.nextInt() ;
		
		scan.nextLine() ;
		
		while(n>0){
			
			String str = scan.nextLine() ;
			
			String[] strs = str.split("C") ;
			
			int row = Integer.parseInt(strs[0].substring(1)) ;
			int col = Integer.parseInt(strs[1]) ;
			
			while(col>0){
				
				if(col%26 == 0){
					stack.push('Z');
					col = col/26 ;
				}else{
					
					stack.push((char)('A'-1+col%26));
					col = col/26 ;
				}
				
			}
			
			while(!stack.empty()){
				System.out.print(stack.pop());
			}
			System.out.println(row);
			
			n -- ;
		}
		
		scan.close(); 
		
	}
	
	public static boolean isGoodBracket(String s){
		
		Stack<Character> stack = new Stack<Character>() ;
		
		for(int i = 0; i < s.length(); i++){
			
			char c = s.charAt(i) ;
			
			if(c == '(') stack.push(')') ;
			
			if(c == '[') stack.push(']') ;
			
			if(c == '{') stack.push('}') ;
			
			if(c == ')' || c == ']' || c == '}'){
				
				if(stack.size() == 0) return false ;
				
				if(c != stack.pop()) return false ;
					
			}
			
		}
		
		if(!stack.empty()) return false ;
		
		return true ;
	}
}
