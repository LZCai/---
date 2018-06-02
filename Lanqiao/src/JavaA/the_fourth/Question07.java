package JavaA.the_fourth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月23日 下午9:54:31
 * 
 */
public class Question07 {
	
	public static int[] c ;
	
	public static int min = 100000;
	
	public static int lowbit(int x){
		
		return x & -x ;
		
	}
	
	public static void add(int x){
		
		while(x < c.length){
			
			c[x] ++ ;
			
			x += lowbit(x) ;
			
		}
	}
	
	public static int getsum(int x){
		
		int sum = 0 ;
		
		while(x > 0){
			
			sum += c[x] ;
			
			x -= lowbit(x) ;
		}
		
		return sum ;
	}

	public static void main(String[] args){
		
		c = new int[100005] ;
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.nextLine() ;
		
		for(int i=0 ; i<n ; i++){
			
			String line = scan.nextLine() ;
			
			String[] numArray = line.split(" ") ;
			
			for(String s : numArray){
				
				int num = Integer.valueOf(s) ;
				
				if(num < min){
					
					min = num ;
				}
				
				add(num) ;
			}
		}
		
		scan.close() ;
		
		int count = 0 ;
		
		for(int i=min ; i<c.length ; i++){
			
			if(getsum(i) == getsum(i+1) && getsum(i+1)+1 == getsum(i+2)){
				
				System.out.print(i+1+" ");
				
				count ++ ;
			}
			
			if(getsum(i)+2 == getsum(i+1) && getsum(i+1)+1 == getsum(i+2)){
				
				System.out.print(i+1);
				
				count ++ ;
			}
			
			if(count == 2){
				
				break ;
			}
		}
		
	}
}
