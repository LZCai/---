package 历届试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月5日 下午2:22:04
 * 
 */
public class 区间位移 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		ArrayList<double[]> num_list = new ArrayList<double[]>() ;
		
		for(int i=0 ; i<n ; i++){
			
			double a = scan.nextDouble() ;
			double b = scan.nextDouble() ;
			
			double[] nums = {a, b} ;
			
			boolean flag = false ;
			
			for(int j=0 ; j<num_list.size() ; j++){
				
				if(nums[0] <= num_list.get(j)[0]){
					
					num_list.add(j, nums) ;
					flag = true ;
					break ;
					
				}
					
			}
			
			if(!flag) num_list.add(nums) ;
				
		}
		
		scan.close(); 
		
		double[] dis = new double[n] ;
		
		dis[0] = num_list.get(0)[0] ;
		num_list.get(0)[0] -= dis[0] ;
		num_list.get(0)[1] -= dis[0] ;
		
		dis[n-1] = 10000 - num_list.get(n-1)[1] ;
		
		num_list.get(n-1)[0] += dis[n-1] ;
		num_list.get(n-1)[1] += dis[n-1] ;
		
		for(int i=1 ; i<num_list.size()-1 ; i++){
			
			dis[i] = move(num_list.get(i-1)[1], 
						num_list.get(i)[0], 
						num_list.get(i)[1], 
						num_list.get(i+1)[0]) ;
			
			num_list.get(i)[0] += dis[i] ;
			num_list.get(i)[1] += dis[i] ;
			
		}
		
		double max = 0 ;
		for(int i=0 ; i<dis.length ; i++){
			
			if(max < Math.abs(dis[i])){
				
				max = Math.abs(dis[i]) ;
				
			}
			
		}
		
		if(max == (int)max){
			
			System.out.println((int)max);
			
		}else{
			
			System.out.printf("%.1f", max);
		}
	}
	
	public static double move(double b1, double a2, double b2, double a3){
		
		if(a2 == b1) return 0 ;
		
		if(a2 > b1) return b1-a2 ;
		
		if(a2<b1 && b2>=a3) return 0 ;
		
		if(a2<b1 && b2<a3 && b1-a2>=(a3-b2)/2.0) return (a3-b2)/2.0 ;
		
		else return b1-a2 ;
	}

}
