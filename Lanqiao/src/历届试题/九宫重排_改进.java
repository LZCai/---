package 历届试题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月24日 下午3:03:04
 * 
 * 
 * 思路分析：
 * 上一次的代码逻辑和结果都是正确的，但是存在时间复杂度较大的问题。40分
 * 
 * 分析发现，主要是在状态转移的过程中，需要实现由字符串到二位数组的转化，占用大量的时间，
 * 因此，考虑直接对字符串进行状态转换操作。
 * 
 * 参考网址：https://blog.csdn.net/qq_23044403/article/details/68951954
 */
public class 九宫重排_改进 {
	
	public static String swap(String s, int i){//交换字符串中的两个字符
		
		char c = s.charAt(i) ;
		
		s = s.replace('.', '*') ;
		s = s.replace(c, '.') ;
		s = s.replace('*', c) ;
		
		return s ;
		
	}
	
	public static int bfs(String start, String end){
		
		ArrayList<String> state = new ArrayList<String>() ;
		
		state.add(start) ;
		
		int index = 0 ;
		int time_index = 1 ;
		int[] times = new int[100000] ;
		
		int[] move = {-3, 3, -1, 1} ;
		
		while(index < state.size())
		{
			String st = state.get(index) ;
			
			int k = 0 ;
			
			for(int i=0 ; i<9 ; i++){//找到.所在位置的下标
				
				if(st.charAt(i) == '.'){
					
					k = i ;
					break ;
				}
					
			}
			
			for(int i=0 ; i<4 ; i++){ //状态转换
				
				int kl = k+move[i] ;
				
				int flag = k*kl ;
				
				if(kl>-1 && kl<9 && flag!=6 && flag!=30){//2-->3,3-->2,5-->6,6-->5跨行了，要去掉  
					
					String s = swap(st, kl) ;
					
					//System.out.println(st);
					//System.out.println(s);
					
					if(!state.contains(s)){
						
						times[time_index] = times[index] + 1 ; //从上一状态（index）移动到当前状态（time_index)步数+1
						
						if(s.equals(end)){
							
							return times[time_index] ;
						}
						
						state.add(s) ;
						
						time_index ++ ;
					}
					
				}
			}
			
			index ++ ;
			
		}
		
		
		return -1 ;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String start = scan.nextLine() ;
		String end = scan.nextLine() ;
		
		scan.close() ;
		
		System.out.println(bfs(start, end)) ;
		
	}

}
