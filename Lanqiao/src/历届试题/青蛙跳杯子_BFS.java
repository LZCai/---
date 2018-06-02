package 历届试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月6日 下午6:04:39
 * 
 */
public class 青蛙跳杯子_BFS {
	
	public static void swap(char[] ch, int a, int b){
		
		char c = ch[a] ;
		ch[a] = ch[b] ;
		ch[b] = c ;
		
	}
	
	public static int bfs(String start, String end){
		
		ArrayList<String> set = new ArrayList<String>() ;
		
		set.add(start) ;
		
		int index = 0 ;
		int times_index = 1 ;
		int[] times = new int[500000] ;
		while(index <= set.size()){
			
			String line = set.get(index) ;
			
			char[] ch = line.toCharArray() ;
			
			int k = 0 ;//记录星号的位置
			for(int i=0 ; i<ch.length ; i++){
				
				if(ch[i] == '*'){
					
					k = i ;
					
					break ;
				}
				
			}
			
			//1. 跳到相邻的空杯子里。
			if(k-1 >= 0){
				
				swap(ch, k, k-1) ;
				
				String s = new String(ch) ;
				
				if(!set.contains(s)){
					
					times[times_index] = times[index] + 1 ;
					
					if(end.equals(s))
						return times[times_index] ;
					
					set.add(s) ;
					
					times_index ++ ;
				}
				
				swap(ch, k, k-1) ;
				
			}
			
			if(k+1 < ch.length){
				
				swap(ch, k, k+1) ;

				String s = new String(ch) ;
				
				if(!set.contains(s)){
					
					times[times_index] = times[index] + 1 ;
					
					if(end.equals(s))
						return times[times_index] ;
					
					set.add(s) ;
					
					times_index ++ ;
				}
				
				swap(ch, k, k+1) ;
			}
				
			//2. 隔着1只其它的青蛙（随便什么颜色）跳到空杯子里。
			if(k-2 >= 0){
				
				swap(ch, k, k-2) ;
				
				String s = new String(ch) ;
				
				if(!set.contains(s)){
					
					times[times_index] = times[index] + 1 ;
					
					if(end.equals(s))
						return times[times_index] ;
					
					set.add(s) ;
					
					times_index ++ ;
				}
				
				swap(ch, k, k-2) ;
			}
			
			if(k+2 < ch.length){
				
				swap(ch, k, k+2) ;

				String s = new String(ch) ;
				
				if(!set.contains(s)){
					
					times[times_index] = times[index] + 1 ;
					
					if(end.equals(s))
						return times[times_index] ;
					
					set.add(s) ;
					
					times_index ++ ;
				}
				
				swap(ch, k, k+2) ;
			}
			//3. 隔着2只其它的青蛙（随便什么颜色）跳到空杯子里。
			if(k-3 >= 0){
				
				swap(ch, k, k-3) ;

				String s = new String(ch) ;
				
				if(!set.contains(s)){
					
					times[times_index] = times[index] + 1 ;
					
					if(end.equals(s))
						return times[times_index] ;
					
					set.add(s) ;
					
					times_index ++ ;
				}
				
				swap(ch, k, k-3) ;
			}
			
			if(k+3 < ch.length){
				
				swap(ch, k, k+3) ;

				String s = new String(ch) ;
				
				if(!set.contains(s)){
					
					times[times_index] = times[index] + 1 ;
					
					if(end.equals(s))
						return times[times_index] ;
					
					set.add(s) ;
					
					times_index ++ ;
				}
				
				swap(ch, k, k+3) ;
			}
			
			index ++ ;
			
		}
		
		return -1 ;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String start = scan.nextLine() ;
		String end = scan.nextLine() ;
		
		System.out.println(bfs(start, end));
		
		scan.close() ;
	}

}
