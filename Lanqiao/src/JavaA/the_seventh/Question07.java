package JavaA.the_seventh ;

import java.util.ArrayList;
import java.util.Collections;

public class Question07{
	
	public static ArrayList<String> count = new ArrayList<String>() ;
	
	public static boolean[][] flag ;
	
	public static int[][] nums ;
	
	public static ArrayList<Integer> list = new ArrayList<Integer>() ;
	
	public static boolean check(int i, int j){
		
		if(i<0 || i>2 || j<0 || j>3){
			
			return false ;
		}
		
		return true ;
	}
	
	public static void dfs(int i, int j, int step){
		
		if(i<0 || i>2 || j<0 || j>3) return ;
		
		if(flag[i][j]){
			
			list.add(nums[i][j]) ;
			flag[i][j] = false ;
			
			if(step+1 == 5){
				
				Collections.sort(list) ;
				
				String s = "" ;
				
				for(int n : list){
					
					s += n + " " ;
					
				}
				
				if(!count.contains(s))
				count.add(s) ;
				
				flag[i][j] = true ;
				list.remove(list.size()-1) ;
				
				return ;
			}
			
			dfs(i-1, j, step+1);
			dfs(i+1, j, step+1);
			dfs(i, j-1, step+1);
			dfs(i, j+1, step+1);
			
			flag[i][j] = true ;
			list.remove(list.size()-1) ;
		}
		
		
	}
	
	public static void main(String[] args){
		
		nums = new int[3][4] ;
		flag = new boolean[3][4] ;
		
		int num = 1 ;
		
		for(int i=0 ; i<3 ; i++){
			
			for(int j=0 ; j<4 ; j++){
				
				nums[i][j] = num ;
				flag[i][j] = true ;
				num ++ ;
			}
		}
		
		for(int i=0 ; i<3 ; i++){
			
			for(int j=0 ; j<4 ; j++){
				
				dfs(i, j, 0);
				
			}
		}
		
		System.out.println(count.size());
		
		System.out.println(count);
	}
}
