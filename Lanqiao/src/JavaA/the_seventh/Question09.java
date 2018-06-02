package JavaA.the_seventh;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月28日 下午7:56:08
 * 
 */
public class Question09 {

	public static void swap(int[] nums, int i, int j){
		
		int temp = nums[i] ;
		nums[i] = nums[j] ;
		nums[j] = temp ;
		
	}
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[] nums = new int[n] ;
		
		for(int i=0 ; i<n ; i++){
			
			nums[i] = scan.nextInt() ;
		}
		
		scan.close() ;
		
		boolean flag = true ;
		
		int count = 0 ;
		
		while(flag){
			
			for(int i=0 ; i<n ; i++){
				
				if(nums[i] != i+1){
					
					swap(nums, i, nums[i]-1) ;
					
					count ++ ;
				}
			}
			
			boolean f = true ;
			
			for(int i=0 ; i<n ; i++){
				
				if(nums[i] != i+1){
					
					f = false ;
					
					break ;
				}
			}
			
			if(f){
				
				flag = false ;
			}
		}
		
		System.out.println(count);
	}
}
