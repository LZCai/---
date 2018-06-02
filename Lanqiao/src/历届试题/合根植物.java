package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月23日 下午3:27:30
 * 
 */
public class 合根植物 {
	
	public static int[][] value ; //用于存放给定的数据，为1表示两科植物合根，反之为0
	public static boolean[] used ; //用于判断植物是否被判断过
	
	public static int m ; //行数
	public static int n ; //列数
	
	public static void dfs(int num){
		
		if(used[num]){
			
			return ;
			
		}else{
			
			used[num] = true ;
			
			for(int i=0 ; i<4 ; i++){
				
				if(value[num][i] != 0){
					
					dfs(value[num][i]) ;
					
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		m = scan.nextInt() ;
		n = scan.nextInt() ;
		
		value = new int[m*n+1][4] ;
		used = new boolean[m*n+1] ;
		
		int k = scan.nextInt() ;
		
		for(int i=0 ; i<k ; i++){
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			for(int j=0 ; j<4 ; j++){
				
				if(value[a][j] != 0) continue ;
				
				value[a][j] = b ;
				
				break ;
				
			}
			
			for(int j=0 ; j<4 ; j++){
				
				if(value[b][j] != 0) continue ;
				
				value[b][j] = a ;
				
				break ;
				
			}
		}
		
		scan.close() ;
		
		int count = 0 ;
		
		/*
		 *循环遍历每棵树，找出其所有的合根树，并将其used设置为true 
		 */
		for(int i=1 ; i<=m*n ; i++){
			
			if(used[i]) continue ;//表示该树已被遍历
			
			if(value[i][0] == 0){//表示该树与其它树不关联
				
				count ++ ;
				
				used[i] = true ;
				
				continue ;
			}
			
			dfs(i) ;
			
			count ++ ;
		}
		
		System.out.println(count);
		
	}

}
