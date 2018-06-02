package 历届试题;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月24日 下午10:31:55
 * 
 */
public class 合根植物_并查集 {
	
	public static int[] head ;
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int m = scan.nextInt() ;
		int n = scan.nextInt() ;
		
		int k = scan.nextInt() ;
		
		head = new int[m*n] ;
		
		//初始化，并查集
		for(int i=0 ; i<m*n ; i++){
			
			head[i] = i ;
			
		}
		
		for(int i=0 ; i<k ; i++){
			
			int a = scan.nextInt() - 1 ;
			int b = scan.nextInt() - 1 ;
			
			unionSet(a, b);
			
		}
		
		scan.close(); 
		
		HashSet<Integer> set = new HashSet<Integer>() ;
		
		for(int i=0 ; i<head.length ; i++){
			
			set.add(find(i)) ;
			
		}
		
		System.out.println(set.size());
		
	}
	
	//查找，寻找节点x所在的树的根节点
	public static int find(int a){
		
		if(head[a] == a){
			
			return a ;
			
		}else{
			
			return head[a] = find(head[a]) ;
		}
		
	}
	
	//合并相互独立的集合
	public static void unionSet(int a, int b){
		
		if(find(a) == find(b)){//a和b属于同一颗树，直接返回
			
			return ;
			
		}else{
			
			head[find(a)] = find(b) ; //将树a和并到树b
			
		}
		
	}

}
