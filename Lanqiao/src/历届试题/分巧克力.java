package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月9日 上午9:55:20
 * 
 */
public class 分巧克力 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int k = scan.nextInt() ;
		
		int[][] shape = new int[n][2] ;
		long[] area = new long[n] ;
		long total_area = 0 ;
		
		for(int i=0 ; i<n ; i++){
			
			int h = scan.nextInt() ;
			int w = scan.nextInt() ;
			
			shape[i][0] = h ;
			shape[i][1] = w ;
			
			area[i] = h*w ;
			
			total_area += area[i] ;
		}
		
		scan.close();
		
		int side = (int)Math.sqrt(total_area/k) ;
		
		int low = 1 ;
		int high = side ;
		
		while(high >= low){
			
			int mid = (low+high)/2 ;
			
			if(solve(mid, k, shape)){
				
				low = mid + 1 ;
				
			}else{
				
				high = mid - 1 ;
			}
		}
		
		
		System.out.println(low - 1);
		
	}
	
	public static boolean solve(int side, int k, int[][] shape){
		
		int total = 0 ;
		
		for(int j=0 ; j<shape.length ; j++){
			
			int a = shape[j][0]/side ;
			int b = shape[j][1]/side ;
			
			total += a*b ;
		}
		
		if(total >= k){
			
			return true ;
		}
		
		return false ;
	}

}
