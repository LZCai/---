package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月24日 下午4:33:06
 *
 * 思路分析：
 * 
 * 首先使用回溯法，产生9个数全排列，然后判断每个9位数排列是否满足带分数的要求
 * 
 * 本题使用全排列的方法也可实现
 */
public class 带分数_回溯 {
	
	public static int[] data = new int[9] ;
	
	public static int count ;
	
	public static boolean check(int num){
		
		for(int i=0 ; i<9 ; i++)
			
			if(num == data[i])
				
				return false ;
		
		return true ;
	}
	
	public static void printResult(int step, int num){
		
		if(step >= 9){
			
			int a= 0 ;
			
			for(int i=0 ; i<9 ; i++){
				
				a = data[i] + a*10 ;
				if(a > num) return ;
				
				int b = 0 ;
				for(int j=i+1 ; j<9-1 ; j++){ //c不能为0
					
					b = data[j] + b*10 ;
					
					int c = 0 ;
					for(int k = j+1 ; k<9 ; k++){
						
						c = data[k] + c*10 ;
						
					}
					
					if(b<c) continue ;
					
					if(b%c == 0 && a+b/c == num) count ++ ;
				}
			}
			
		}else{
			
			for(int i=1 ; i<=9 ; i++){
				
				if(data[step]==0 && check(i)){
					
					data[step] = i ;
					
					printResult(step+1, num) ;
					
					data[step] = 0 ;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int num = scan.nextInt() ;
		
		scan.close(); 
		
		printResult(0, num) ;
		
		System.out.println(count);
	}

}
