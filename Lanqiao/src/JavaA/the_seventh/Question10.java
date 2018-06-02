package JavaA.the_seventh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月28日 下午8:30:35
 * 
 */
public class Question10 {

	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[] nums = new int[n] ;
		
		ArrayList<Integer> num_list = new ArrayList<Integer>() ;
		
		for(int i=0 ; i<n ; i++){
			
			nums[i] = scan.nextInt() ;
			
		}
		
		scan.close() ;
		
		int[] result = new int[n] ;
		
		for(int i=0 ; i<n ; i++){
			
			if(! num_list.contains(nums[i])){
				
				result[i] = -nums[i] ;
				
				num_list.add(nums[i]) ;
				
			}else{
				
				int prev_index = num_list.lastIndexOf(nums[i]) ;
				
				Set<Integer> num_class = new HashSet<Integer>() ;
				
				for(int j=prev_index+1 ; j<i ; j++){
					
					num_class.add(nums[j]) ;
					
				}
				
				result[i] = num_class.size() ;
				
				num_list.add(nums[i]) ;
			}
		}
		
		for(int num : result){
			
			System.out.print(num + " ");
		}
	}
}
