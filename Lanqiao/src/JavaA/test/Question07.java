package JavaA.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月29日 下午10:02:25
 * 
 */
public class Question07 {
	
	public static int[][] nodes ;
	
	public static ArrayList<Integer> road = new ArrayList<Integer>() ;
	
	public static ArrayList<String> roads = new ArrayList<String>() ;
	
	public static void dfs(int step, int node, int node_2){
		
		if(node == node_2){
			
			String s = "" ;
			
			for(int n : road){
				
				s += n ;
			}
			
			roads.add(s) ;
			
		}else if(step == nodes.length){
			
			return ;
			
		}else{
			
			for(int i=1 ; i<=nodes.length-1 ; i++){
				
				if(nodes[node][i] == 1){
					
					if(road.contains(i)) continue ;
					
					road.add(i) ;
					
					dfs(step+1, i, node_2) ;
					
					road.remove(road.size()-1) ;
				}
				
			}
		}
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int m = scan.nextInt() ;
		
		nodes = new int[n+1][n+1] ;
		
		for(int i=0 ; i<m ; i++){
			
			int x = scan.nextInt() ;
			int y = scan.nextInt() ;
			
			nodes[x][y] = 1 ;
		}
		
		int node_1 = scan.nextInt() ;
		int node_2 = scan.nextInt() ;
		
		scan.close(); 
		
		dfs(0, node_1, node_2) ;
		
		int result = 0 ;
		
		int count = 0 ;
		
		System.out.println(roads);
		
		String road_1 = roads.get(0) ;
		
		for(int i=0 ; i<road_1.length() ; i++){
			
			char c = road_1.charAt(i) ;
			
			for(int j=1 ; j<roads.size() ; j++){
				
				if(roads.get(j).indexOf(""+c) != -1) count ++ ;
			}
			
			if(count == roads.size()-1) result ++ ;
		}
		
		System.out.println(result);
		
	}

}
