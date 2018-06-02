package 历届试题;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月4日 上午11:18:22
 * 
 */
public class 发现环_递归 {
	
	public static boolean[] used = new boolean[100005];
	public static int n ;
	public static int[] pre = new int[100005];
	public static int[] ans = new  int[100005];
	public static Vector[] value = new Vector[100005];
	public static int count ;
	public static boolean over ;
	
	public static void dfs(int a, int prev){
		
		for(int i=0 ; i<value[a].size() ; i++){
			
			int next = (Integer) value[a].get(i) ;
			
			if(next == prev) continue ;
			
			pre[next] = a ;
			
			if(used[next] == true){
				
				int end = next ;
				
				do{
					
					ans[count++] = end ;
					end = pre[end] ;
					
				}while(end != next) ;
				
				over = true ;
				return ;
				
			}
			
			used[next] = true ;
			
			dfs(next, a) ;
			
			if(over) return ;
			
		}
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextInt() ;
		
		for(int i=1 ; i<=n ; i++){
			
			value[i] = new Vector<Integer>(5, 2) ;
		}
		
		for(int i=0 ; i<n ; i++){
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			value[a].add(b) ;
			value[b].add(a) ;
			
		}
		
		scan.close();
		
		used[1] = true ;
		
		dfs(1, 0) ;
		
		Arrays.sort(ans, 0, count);
		
		for(int i=0 ; i<count ; i++){
			
			if(i == count-1){
				
				System.out.print(ans[i]);
				
			}else{
				
				System.out.print(ans[i]+" ");
			}
		}
		
	}

}
