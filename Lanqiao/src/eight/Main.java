package eight;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月7日 下午3:55:46
 * 
 */
public class Main {
	
	public static int sum = 0 ;
	
	public static void main(String[] args){
		
		//question01() ;
		
		int[] data = new int[9] ;
		
		question02(0, data) ;
		
		System.out.println(sum);
		
		System.out.println(question05(1,1,1,2));
		System.out.println(question05(1,2,3,3));
	}
	
	//迷宫
	public static void question01(){
		
		Scanner scan = new Scanner(System.in) ;
		
		char[][] map = new char[10][10] ;
		
		for(int i = 0; i < 10; i ++){
			
			String line = scan.nextLine() ;
			
			char[] c = line.toCharArray() ;
			
			for(int j = 0; j < c.length; j ++){
				
				map[i][j] = c[j] ;
			}
			
		}
		
		int count = 0 ;
		
		for(int i = 0; i < 100; i ++){
			
			int w = 0 ;
			
			int row = i/9 ;
			int col = i%9 ;
			
			if(work(row, col, map, w)){
				
				count ++ ;
			}
			
		}
		
		System.out.println(count);
		
		scan.close() ;
	}
	
	
	public static boolean work(int row, int col, char[][] map, int w){
		
		if(row > 9 || row < 0 || col < 0 || col > 9){
			
			return true ;
			
		}
		
		if(w > 100) return false ;
		
		w ++ ;
		
		if(map[row][col] == 'U'){
			
			return work(row-1, col, map, w) ;
			
		}else if(map[row][col] == 'D'){
			
			return work(row+1, col, map, w) ;
			
		}else if(map[row][col] == 'R'){
			
			return work(row, col+1, map, w) ;
			
		}else{
			
			return work(row, col-1, map, w) ;
			
		}
		
	}

	
	//9字算数
	public static void question02(int num, int[] data){
		
		//跳出
		if(num > 8){
			
			StringBuilder sb = new StringBuilder() ;
			
			for(int n : data){
				
				sb.append(n) ;
			}
			
			String line = sb.toString() ;
			
			for(int i = 0; i < 8; i ++){
				
				int a = Integer.parseInt(line.substring(0, i+1)) ;
				int b = Integer.parseInt(line.substring(i+1)) ;
				int c = a * b ;
				
				String str = String.valueOf(c) ;
				
				Set<Character> num_set = new HashSet<Character>() ;
				
				for(int j = 0; j < str.length(); j ++){
					
					num_set.add(str.charAt(j)) ;
					
				}
				
				if(num_set.size() == 9 && !num_set.contains('0')){
					
					System.out.println(a+" x "+b+" = "+c) ;
					
					sum ++ ;
					
					return ;
				}
			}
			
			return ;
		}
		
		//回溯
		for(int i = 1; i <= 9; i ++){
			
			if(data[num] == 0 && check(i, data)){
				
				data[num] = i ;
				
				question02(num+1, data) ;
				
			}
			
			data[num] = 0 ;
			
		}
		
	}
	
	public static boolean check(int num, int[] data){
		
		for(int n : data){
			
			if(num == n){
				
				return false ;
			}
		}
		
		return true ;
	}
	
	
	public static int question05(int a, int b, int c, int n){
		
		if(a<0 || b<0 || c<0) return 0;
		if(n==0) return 1; 
		
		return question05(a-1, b, c, n-1) + question05(a, b-1, c, n-1) + question05(a, b, c-1, n-1);
		
	}
	
}