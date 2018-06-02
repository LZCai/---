package 历届试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月23日 下午9:02:17
 * 
 */
public class 分考场 {
	
	public static int[][] value ;
	
	public static boolean check(int num, ArrayList<Integer> list){
		
		for(int n : list){
			
			if(value[num][n] == 1 || value[n][num] == 1)
				
				return false ;
		}
		
		return true ;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int k = scan.nextInt() ;
		
		boolean[] used = new boolean[n+1] ;
		
		value = new int[n+1][n+1] ;
		
		for(int i=0 ; i<k ; i++){
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			value[a][b] = value[b][a] = 1 ;
		}
		
		scan.close() ;
		
		int count = 0 ;
		
		int len = 0 ;
		
		for(int i=1 ; i<=n ; i++){
			
			if(len == n) break ;
			
			if(used[i]) continue ;
			
			ArrayList<Integer> list = new ArrayList<Integer>() ;
			
			list.add(i) ;
			
			used[i] = true ;
			
			for(int j=1 ; j<=n ; j++){
				
				if(value[i][j] == 0 && check(j, list) && i != j && !used[j]){
					
					list.add(j) ;
					
					used[j] = true ;
				}
			}
			
			len += list.size() ;
			
			count ++ ;
		}
		
		System.out.println(count);
		
	}

}
