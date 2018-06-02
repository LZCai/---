package 历届试题;

import java.util.Scanner;

public class 正则问题_递归{
	
	public static int index ;
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String line = scan.nextLine() ;
		
		System.out.println(f(line));
		
		scan.close();
		
	}
	
	
	public static int f(String line){
		
		int max = 0 ;
		
		int temp = 0 ;
		
		while(index < line.length()){
			
			if(line.charAt(index) == '('){
				
				index ++ ;
				
				temp += f(line) ;
				
			}else if(line.charAt(index) == ')'){
				
				index ++ ;
				
				break ;
				
			}else if(line.charAt(index) == '|'){
				
				max = max>temp ? max : temp ;
				
				temp = 0 ;
				
				index ++ ;
				
			}else{
				
				temp ++ ;
				index ++ ;
			}
				
		}
		
		if(max < temp)
			
			max = temp ;
		
		return max ;
		
	}
	
}