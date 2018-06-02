package JavaA.test;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月29日 下午4:40:57
 * 
 */
public class Question6 {

	public static ArrayList<Integer> node_list = new ArrayList<Integer>() ;
	
	public static int[][] midNode = new int[10][10] ;
	
	public static int count ;
	
	public static int result ;
	
	
	public static boolean check_mid(){ //检查相邻两点是否能够到达（中间是否存在没有使用过的点，若存在则返回false）
		
		boolean[] used = new boolean[10] ;//初始化每个节点used为false表示该节点没有被使用
		
		for(int i=0 ; i<node_list.size()-1 ; i++){
			
			used[node_list.get(i)] = true ;//表示节点i被使用
			
			int x = node_list.get(i) ;
			int y = node_list.get(i+1) ;
			
			if(midNode[x][y] != 0){//若节点i和节点i+1之间存在中间点，并且中间点未被使用，则返回false
				
				if(!used[midNode[x][y]]) return false ;
			}
		}
		
		return true ;//所有的节点中所存在中间节点，并且中间节点已被使用，则返回true
		
	}
	
	
	public static boolean check_edge(int[][] edge){//检查当前集合中的结果是否满足已给条件，即：已给路线
		
		if(node_list.size() > 3 && node_list.size() >= count && check_mid()){
			
			for(int i=0 ; i<edge.length ; i++){
				
				if(node_list.contains(edge[i][0]) && node_list.contains(edge[i][1])){
					
					int a = node_list.indexOf(edge[i][0]) ;
					int b = node_list.indexOf(edge[i][1]) ;
					
					if(Math.abs(a-b) != 1)  return false ;
					
				}else{
					
					return false ;
				}
			}
			
		}else{
			
			return false ;
		}
		
		
		return true ;
	}
	
	public static void dfs(int[][] edge, int step){
		
		if(step == 9){
			
			return ;
			
		}else{
			
			for(int i=1 ; i<10 ; i++){
				
				if(node_list.contains(i)){
					
					continue ;
				}
				
				node_list.add(i) ;
				
				if(check_edge(edge)) result ++ ;
				
				dfs(edge, step+1) ;
				
				node_list.remove(node_list.size()-1) ;
			}
			
			
		}
	}
	
	
	public static void main(String[] args){
		
		midNode[1][3] = midNode[3][1] = 2;
        midNode[1][7] = midNode[7][1] = 4;
        midNode[1][9] = midNode[9][1] = 5;
        midNode[2][8] = midNode[8][2] = 5;
        midNode[3][7] = midNode[7][3] = 5;
        midNode[3][9] = midNode[9][3] = 6;
        midNode[4][6] = midNode[6][4] = 5;
        midNode[7][9] = midNode[9][7] = 8;
    
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[][] edge = new int[n][2] ;
		
		HashSet<Integer> prev_node = new HashSet<Integer>() ;
		
		for(int i=0 ; i<n ; i++){
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			edge[i][0] = a ;
			edge[i][1] = b ;
			
			prev_node.add(a) ;
			prev_node.add(b) ;
			
		}
		
		count = prev_node.size() ;
		
		dfs(edge, 0) ;
		
		System.out.println(result);
		
		scan.close() ;
		
	}
}
