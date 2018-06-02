package final_round.the_sixth;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月20日 下午2:44:01
 * 
 */
public class Question04 {
	
	public static int min = 10000 ;
	
	public static int n ;
	
	public static boolean[][] used ;
	
	public static boolean checkBorder(int x, int y){
		
		if(x<0 || x>=n || y<0 || y>=n)
			return false ;
		
		return true ;
	}
	
	public static boolean checkNextStep(String prev, String next){
		
		if(next.equals(prev)) return false ;
		
		return true ;
	}
	
	public static void dfs(String[][] map, String prev, int x, int y, int step){
		
		if(checkBorder(x,y)){
			
			String next = map[x][y] ;
			
			if(next.equals("B")){//判断是否到达终点
				
				step ++ ;
				
				if(step < min){
					
					min = step ;
					
					return ;
				}
				
			} 
				
			if(checkNextStep(prev, next) && used[x][y] == false){
				
				step ++ ;
				
				used[x][y] = true ;
				
				dfs(map, next, x-1, y, step) ;
				dfs(map, next, x+1, y, step) ;
				dfs(map, next, x, y-1, step) ;
				dfs(map, next, x, y+1, step) ;
				
				used[x][y] = false ;
				
			}
				
		}
		
	}

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextInt() ;
		
		scan.nextLine() ;
		
		String[][] map = new String[n][n] ;
		
		used = new boolean[n][n] ;
		
		for(int i=0 ; i<n ; i++){
			
			String line = scan.nextLine() ;
			
			map[i] = line.split(" ") ;
			
		}
		
		scan.close(); 
		
		for(int i=0 ; i<n ; i++){
			
			for(int j=0 ; j<n ; j++){
				
				if(map[i][j].equals("A")){
					
					dfs(map, "start", i, j, -1) ;
					
				}
			}
		}
		
		System.out.println(min);
	}
	
}
