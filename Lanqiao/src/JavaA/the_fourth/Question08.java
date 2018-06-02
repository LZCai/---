package JavaA.the_fourth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月24日 上午9:00:20
 * 
 */
public class Question08 {
	
	public static int num ;
	
	public static int count ;

	//校验是否出现过相同的数字
	public static boolean check(int n, int[] data){
		
		for(int i=0 ; i<data.length ; i++){
			
			if(n == data[i]){
				
				return false ;
			}
		}
		
		return true ;
	}
	
	//回溯产生1到9的数字序列
	public static void printResult(int n, int[] data){
		
		if(n>=9){
			
			result(data) ;
		}
		
		for(int i=1 ; i<=9 ; i++){
			
			if(check(i, data)){
				
				data[n] = i ;
				
				printResult(n+1, data) ;
				
				data[n] = 0 ;
			}
			
		}
	}
	
	//给定数列判断是否符合答案
	public static void result(int[] data){
		
		int a = 0 ;
		
		for(int i=0 ; i<data.length ; i++){
			
			a = data[i] + a * 10 ;
			
			if (a>num) break ;
			
			int b = 0 ;
			
			for(int j=i+1 ; j<data.length-1 ; j++){
				
				b = data[j] + b*10 ;
				
				int c=0 ;
				for(int k=j+1 ; k<data.length ; k++){
					
					c = data[k] + c*10 ;
				}
				
				if(b<c) continue ;
				
				if(b%c == 0 && a+b/c == num) count++ ;
				
			}
		}
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		num = scan.nextInt() ;
		
		scan.close(); 
		
		int[] data = new int[9] ;
		
		printResult(0, data) ;
		
		System.out.println(count);
	}
	
}
