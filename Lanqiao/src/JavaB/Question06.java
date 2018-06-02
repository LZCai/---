package JavaB;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月4日 上午9:14:12
 * 
 */
public class Question06 {
	
	public static boolean check(int n, int[][] data){
		
		int x = n/9 ;
		int y = n%9 ;
		
		//首先判断填入的数字与所在的行是否有重复
		for(int i = 0; i < 9; i++){
				
			if((data[x][i] == data[x][y]) && i != y){
					
				return false ;
			}
		}
		
		//其次判断填入的数字与所在的列是否有重复
		for(int j = 0; j < 9; j++){
			
			if((data[j][y] == data[x][y]) && j != x){
				
				return false ;
			}
		}
		
		//最后判断填入的数字与所在的最小九宫格内是否有有重复
		int row = 0 ;
		int col = 0 ;
		if(x <= 2){
			row = 0 ;
		}else if(x <=5){
			row = 3 ;
		}else{
			row = 6 ;
		}
		
		if(y <= 2){
			col = 0 ;
		}else if(y <= 5){
			col = 3 ;
		}else{
			col = 6 ;
		}
		
		for(int i=row; i <= row+2; i++){
			
			for(int j=col; j <= col+2; j++){
				
				if((data[i][j] == data[x][y]) && i != x && j != y){
					
					return false ;
				}
			}
		}
		
		return true ;
	}
	
	//填数
	public static void fillNum(int n, int[][] data){
		
		//System.out.println("------------------进入fillNum-----------------");
		
		int row = n/9 ;
		int col = n%9 ;
		
		if(n >= 81){
			
			//System.out.println(Arrays.toString(data));
			printArray(data);
			
			System.exit(0);
		}
		
		if(data[row][col] == 0){
				
			for(int i = 1; i <= 9; i++){
				
				data[row][col] = i ;
				
				//printArray(data) ;
				//System.out.println("-------#----#----#----#-------");
				
				if(check(n, data)){
					
					fillNum(n+1, data) ;
					
				}
				
				data[row][col] = 0 ;
				
			}
		}else{
			
			fillNum(n+1, data) ;
		}
	}
	
	//打印数组
	public static void printArray(int[][] data){
		
		for(int i=0; i<data.length; i++){
			System.out.println(Arrays.toString(data[i]));
		}
	}
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String str = "" ;
		
		char[] a ;
		
		int[][] data = new int[9][9] ;
		
		for(int i = 0; i < 9; i++){
			
			str = scan.nextLine() ;
			a = str.toCharArray() ;
			
			for(int j = 0; j < 9; j++){
				
				data[i][j] = Integer.parseInt(a[j]+"") ;
			}
		}
		
		scan.close() ;
		
		long start = System.currentTimeMillis() ;
		
		fillNum(0, data) ;
		
		long end = System.currentTimeMillis() ;
		
		System.out.println("耗时： " + (end-start));
		
		
	}

}
