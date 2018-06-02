package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月25日 下午4:17:56
 * 
 */
public class 发现环 {
	
	public static int[] head ;
	
	public static int[] result ;
	
	public static int[][] value ;
	
	public static int start ;
	
	public static int end ;
	
	public static boolean[] used ;
	
	public static void dfs(int x, int step){
		
		result[step] = x+1 ;
		
		if(x == end && step > 1){
			
			Arrays.sort(result, 0, step+1);
			
			for(int i=0 ; i<=step ; i++){
				
				if(i ==step)
					
					System.out.print(result[i]);
				else
					
					System.out.print(result[i]+" ");
			}
			
			
		}
			
		used[x] = true ;
		
		for(int j=0 ; j<value.length ; j++){
			
			if(value[x][j] == 1 && !used[j]){
				
				dfs(j, step+1) ;
				
			}
				
		}
		used[x] = false ;
	
	}
	
	public static int find(int x){
		
		if(head[x] == x) 
			
			return x ;
		
		else
			
			return head[x] = find(head[x]) ;
	}
	
	public static void main(String[] args){
		
		Scanner scan  = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		result = new int[n] ;
		
		head = new int[n] ;
		
		for(int i=0 ; i<n ; i++){//初始化并查集
			
			head[i] = i ;
		}
		
		used = new boolean[n] ;
		
		value = new int[n][n] ;
		
		for(int i=0 ; i<n ; i++){
			
			int a = scan.nextInt() - 1;
			int b = scan.nextInt() - 1;
			
			value[a][b] = value[b][a] = 1 ;
			
			int head_a = find(a) ;
			int head_b = find(b) ;
			
			if(head_a == head_b){
				
				start = a ;
				end = b ;
				
			}else{
				
				head[head_a] = head_b ;
				
			}
				
		}
		
		scan.close(); 
		
		dfs(start, 0) ;
			
	}

}
