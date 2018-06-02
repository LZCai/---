package 历届试题;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月5日 下午10:53:04
 * 
 */
public class 青蛙跳杯子 {
	
	public static int minTimes = Integer.MAX_VALUE ;
	
	public static void swap(char[] ch, int a, int b){
		
		char c = ch[a] ;
		ch[a] = ch[b] ;
		ch[b] = c ;
	}
	
	public static void bfs(String start, String end, int step){
		
		if(step > 100) return ;
		
		if(end.equals(start)){
			
			System.out.println(start);
			
			System.out.println(minTimes);
			
			minTimes = minTimes > step ? step : minTimes ;
			
			return ;
			
		}else{
			
			char[] ch = start.toCharArray() ;
			
			HashSet<String> str = new HashSet<String>() ;
			
			for(int i=0 ; i<ch.length ; i++){
				
				if(ch[i] == '*'){
					
					//1. 跳到相邻的空杯子里。
					if(i-1 >= 0){
						swap(ch, i, i-1) ;
						str.add(new String(ch)) ;
						swap(ch, i, i-1) ;
					}
					
					if(i+1 < ch.length){
						
						swap(ch, i, i+1) ;
						str.add(new String(ch)) ;
						swap(ch, i, i+1) ;
					}
					//2. 隔着1只其它的青蛙（随便什么颜色）跳到空杯子里。
					if(i-2 >= 0){
						swap(ch, i, i-2) ;
						str.add(new String(ch)) ;
						swap(ch, i, i-2) ;
					}
					
					if(i+2 < ch.length){
						
						swap(ch, i, i+2) ;
						str.add(new String(ch)) ;
						swap(ch, i, i+2) ;
					}
					
					//3. 隔着2只其它的青蛙（随便什么颜色）跳到空杯子里。
					if(i-3 >= 0){
						swap(ch, i, i-3) ;
						str.add(new String(ch)) ;
						swap(ch, i, i-3) ;
					}
					
					if(i+3 < ch.length){
						swap(ch, i, i+3) ;
						str.add(new String(ch)) ;
						swap(ch, i, i+3) ;
					}
					
					break ;
				}
			}
			
			Iterator<String> it = str.iterator() ;
			
			while(it.hasNext()){
				
				String s = it.next() ;
				
				bfs(s, end, step+1) ;
				
			}
		}
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String start = scan.nextLine() ;
		String end = scan.nextLine() ;
		
		scan.close() ;
		
		bfs(start, end, 0) ;
		
		System.out.println(minTimes);
		
	}

}
