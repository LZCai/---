package 历届试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月17日 上午10:58:40
 * 
 */
public class The_merchant {
	
	public static int n ; //城市数量
	public static int[] price ; //不同城市的商品价格
	public static ArrayList[] map ; //城市之间的连接关系
	
	public static int[] ans ; //存储最终结果
	
	public static boolean over = false ;
	
	/**
	 * 使用递归的思想找出从起点到终点道路上的所有城市节点
	 * @param start
	 * @param end
	 */
	public static void dfs(int start, int prev, int end, int step){
		
		if(over) return ;
		
		ans[step] = start ;
		
		for(int i=0 ; i<map[start].size() ; i++){//循环遍历，当前节点的下一个节点
			
			int next = (Integer) map[start].get(i) ;
			
			if(next == prev) continue ;//如果当前节点的下一个节点与当前节点的上一个节点相同，则跳过。
			
			if(next == end){ //找到当前最终节点，遍历完成。
				
				ans[step+1] = next ;
				
				over = true ;
				
				return ;
				
			}else{
				
				dfs(next, start, end, step+1) ;
				
			}
		}
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextInt() ;
		price = new int[n+1] ;
		map = new ArrayList[n+1] ;
		ans = new int[n] ;
		
		for(int i=1 ; i<=n ; i++){
			
			price[i] = scan.nextInt() ;
			
			map[i] = new ArrayList<Integer>() ;
			
		}
		
		for(int i=1 ; i<n ; i++){
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			map[a].add(b) ;
			map[b].add(a) ;
		}
		
		int q = scan.nextInt() ;
		
		for(int i=0 ; i<q ; i++){
			
			int start = scan.nextInt() ; //起点
			int end = scan.nextInt() ; //终点
			
			Arrays.fill(ans, 0);
			over = false ;
			
			dfs(start, 0, end, 0) ;
			
			int max = Integer.MIN_VALUE ;
			int min = Integer.MAX_VALUE ;
			int max_j = -2 ;
			int min_j = -1 ;
			
			for(int j=0; j<ans.length; j++){
				
				if(ans[j] == 0) break ;
				
				if(ans[j] !=0){
					
					if(max < price[ans[j]]){
						
						max = price[ans[j]] ;
						max_j = j ;
						
					}
					
					if(min > price[ans[j]]){
						
						min = price[ans[j]] ;
						min_j = j ;
						
					}
						
				}
				
			}
			
			if(max_j > min_j)
				
				System.out.println(max - min);
			
			else
				
				System.out.println(0);
			
		}
		
		scan.close(); 
		
	}

}
