package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月16日 上午10:32:29
 * 
 */
public class 蚂蚁感冒 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[] ants = new int[100] ;
		
		int one = scan.nextInt() ;
		
		ants[Math.abs(one)] = one ;
		
		for(int i=0 ; i<n-1 ; i++){
			
			int temp = scan.nextInt() ;
			
			ants[Math.abs(temp)] = temp ;
			
		}
		
		scan.close(); 
		
		if(one > 0){//感冒的蚂蚁向右走
			
			/*
			 * 1、判断该蚂蚁是不是最右侧的一个，若是，则直接return 1.
			 * 2、若该蚂蚁不是最右侧一个，但是他的右侧不存在向左的蚂蚁，则也返回 1.
			 */
			int l_count = 0 ;
			for(int i=one+1 ; i<100 ; i++){
				
				if(ants[i] < 0){
					
					l_count ++ ;
				}
			}
			
			if(l_count == 0){
				
				System.out.println(1);
				
				return ;
			}
			
			/*
			 * 若其右侧存在向左走的蚂蚁，那么该蚂蚁的左侧向右走的蚂蚁也会被感染（因为该蚂蚁感染了，右侧第一个后会掉头）
			 */
			int r_count = 0 ;
			for(int i=0 ; i<one ; i++){
				
				if(ants[i] > 0){
					
					r_count ++ ;
				}
			}
			
			System.out.println(l_count + r_count + 1);
			
		}else{
			
			/*
			 * 1、首先判断感冒蚂蚁是否是最左侧一个，若是，则返回 1.
			 * 2、若不是最左侧的一个蚂蚁，判断该蚂蚁的左侧是否有向右走的蚂蚁，若没有，则返回 1.
			 */
			int r_count = 0 ;
			for(int i=0 ; i<Math.abs(one) ; i++){
				
				if(ants[i] > 0){
					
					r_count ++ ;
					
				}
			}
			
			if(r_count == 0){
				
				System.out.println(1);
				
				return ;
			}
			
			int l_count = 0 ;
			for(int i=Math.abs(one)+1 ; i<100 ; i++){
				
				if(ants[i] < 0){
					
					l_count ++ ;
				}
			}
			
			System.out.println(r_count + l_count + 1);
		}
	}

}
