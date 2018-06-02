package 历届试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月23日 下午9:21:33
 * 
 * 
 * 解题思路：
 * 体面看起来像是一个 全排列 问题，遍历所有情况，然后选择路径最短的。实则不然。
 * 
 * 本题实际采用的是BFS算法来进行求解，相应的空白格子有四种移动情况（上下左右）
 * 这道题要求的是最短路径，想到这里就很明显了，把当前9个数的位置信息当成一个节点，
 * 通过移动格子能转换到的状态也就是他的邻接点，把它当成一副图用bfs来做就ok了。
 * 
 * 注意：在使用BFS进行遍历时记得 判重 ，因为重复的状态在后的遍历也是重复的。
 */
public class 九宫重排_BFS {

	public static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}} ;//确定空白格子的移动方向（上下左右）
	
	public static boolean check(int x, int y){//判断能否到达下一种状态
		
		if(x<0 || x>=3 || y<0 || y>=3)
			
			return false ;
		else
			return true ;
	}
	
	public static void swap(int[][] node, int x1, int y1, int x2, int y2){//交换相邻两个格子的元素
		
		int temp = node[x1][y1] ;
		node[x1][y1] = node[x2][y2] ;
		node[x2][y2] = temp ;
	}
	
	public static String intToString(int[][] node){//将每种数字的排列转换成字符串，并返回 
		
		String s = "" ;
		
		for(int i=0 ; i<3 ; i++){
			
			for(int j=0 ; j<3 ; j++){
				
				s += node[i][j] ;
			}
		}
		
		return s ;
	}
	
	public static int bfs(String start, String end){
		
		ArrayList<String> state = new ArrayList<String>() ;//记录遍历过程中不同的状态
		
		state.add(start) ; //将初始状态添加到队列
		
		int index = 0 ;
		int time_index = 1 ;
		int[] times = new int[500000] ; //记录遍历到某种状态所需要转换的次数
		
		while(index < state.size()) //循环遍历队列中的所有状态，知道产生最短时间或者遍历结束
		{
			
			String st = state.get(index) ;
			
			int[][] node = new int[3][3] ;
			
			int x = -1, y = -1 ;
			
			for(int i=0 ; i<3; i++){
				
				for(int j=0 ; j<3 ; j++){
					
					node[i][j] = st.charAt(3*i+ j) - '0' ;
					
					if(node[i][j] == 0){//寻找0的位置
						
						x = i ;
						y = j ;
						
					}
				}
			}
			
			//四种转换状态
			for(int k=0 ; k<4 ; k++){
				
				int x1 = x + move[k][0] ;
				int y1 = y + move[k][1] ;
				
				if(check(x1, y1)){
					
					swap(node, x, y, x1, y1) ;//转换到下一个状态
					
					String s = intToString(node) ;
					
					if(!state.contains(s)){
						
						times[time_index] = times[index] + 1 ; //从上一状态（index）移动到当前状态（time_index)步数+1
						
						if(s.equals(end)){
							
							return times[time_index] ;
						}
						
						state.add(s) ;
						
						time_index ++ ;
					}
						
					swap(node, x, y, x1, y1) ; //回溯到上一个状态
					
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
		
		//将题目中的.转换为0便于计算
		start = start.replace('.', '0');
		end = end.replace('.', '0') ;
		
		System.out.println(bfs(start, end));
		
		scan.close() ;
		
	}
}
