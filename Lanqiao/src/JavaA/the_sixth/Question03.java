package JavaA.the_sixth;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 下午4:12:45
 * 
 */
public class Question03 {
	
	public static ArrayList<Integer> A_list = new ArrayList<Integer>() ;
	
	//交换数组中的两个元素的位置
	public static void swap(int[] nums, int i, int j){
		
		int temp = nums[i] ;
		nums[i] = nums[j] ;
		nums[j] = temp ;
		
	}

	//对数组中的数据进行全排列
	public static void dfs(int[] nums, int step){
		
		if(step == nums.length){
			
			check(nums) ;
			
		}else{
			
			for(int i=step ; i<nums.length ; i++){
				
				swap(nums, i, step) ;
				dfs(nums, step+1) ;
				swap(nums, i, step) ;
				
			}
				
		}
	}
	
	public static void check(int[] nums){
		
		int A = nums[0] * 100 + nums[1] * 10 + nums[2] ;
		int B = nums[3] * 100 + nums[4] * 10 + nums[5] ;
		int C = nums[6] * 100 + nums[7] * 10 + nums[8] ;
		
		if(B == A*2 && C == A*3){
			
			A_list.add(A) ;
		}
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9} ;
		
		dfs(nums, 0) ;
		
		Collections.sort(A_list);;
		
		System.out.println(A_list);
	}
}
