package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月5日 下午4:25:02
 * 
 */
public class 填字母游戏 {
	
	public static int dfs(char[] charArr){
		
		String line = new String(charArr) ;
		
		if(line.contains("LOL")) return -1 ;
		if(!line.contains("*")) return 0 ;
		
		boolean is0 = false ;
		
		for(int i=0 ; i<charArr.length ; i++){
			
			if(charArr[i] == '*'){
				
				try{
					charArr[i] = 'L' ;
					
					switch(dfs(charArr)){
					
					case -1 :
						return 1 ;
					case 0 :
						is0 = true ;
					}
					
					charArr[i] = 'O' ;
					
					switch(dfs(charArr)){
					
					case -1 :
						return 1 ;
					case 0 :
						is0 = true ;
						
					}
				}finally{
					
					charArr[i] = '*' ;
				}
				
			}
		}
		
		if(is0) return 0 ;
		
		return -1 ;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.nextLine() ;
		
		for(int i=0 ; i<n ; i++){
			
			String line = scan.nextLine() ;
			
			System.out.println(dfs(line.toCharArray())) ;
			
		}
		
		scan.close() ;
	}

}
