package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月13日 上午9:38:18
 * 
 */
public class TeSuHuiWen {
	
	/*
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.close() ;
		
		//产生长度为5的特殊数字回文
		for(int i=1 ; i <=9 ; i ++){
			
			for(int j=0 ; j <=9 ; j ++){
				
				for(int z=0 ; z<=9 ; z ++){
					
					if(2*(i+j)+z == n){
						
						System.out.println(""+i+j+z+j+i);
					}
				}
			}
		}
		
		//产生长度为6的特殊数字回文
		for(int i=1 ; i <=9 ; i ++){
					
			for(int j=0 ; j <=9 ; j ++){
				
				for(int z=0 ; z<=9 ; z ++){
					
					if(2*(i+j+z) == n){
						
						System.out.println(""+i+j+z+z+j+i);
					}
				}
			}
		}
	}
	*/
	
	/*
	// 1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
	public static void main(String[] args){
		
		for(int i=1000 ; i<10000 ; i ++){
			
			int a = i/1000 ;
			int b = (i%1000)/100 ;
			int c = (i%100)/10 ;
			int d = i%10 ;
			
			if(a == d && b == c){
				
				System.out.println("" +a+b+c+d);
			}
		}
		
	}
	*/
	
	// 153是一个非常特殊的数，它等于它的每位数字的立方和，
	// 即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
	
	public static void main(String[] args){
		
		for(int i=100 ; i<1000 ; i ++){
			
			int a = i/100 ;
			int b = i%100/10 ;
			int c = i%10 ;
			
			int sum = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)) ;
			
			if(sum == i){
				
				System.out.println(i);
			}
		}
	}

}
