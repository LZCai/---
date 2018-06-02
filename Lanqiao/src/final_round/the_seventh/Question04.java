package final_round.the_seventh;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月23日 上午11:21:10
 * 
 */
public class Question04 {
	
	public static int[][] value ;//存放三角形，1代表A，2代表B
	public static int n ; //三角形的层数
	public static int count ;
	public static int numA, numB ;
	
	/**
	 * 校验结果是否符合，题目。
	 * sumA = numA, sumB = numB 
	 */
	public static void check(){
		
		int sumA = 0 ;
		int sumB = 0 ;
		
		/*
		 *根据下层的排序，循环产生上层的排列
		 */
		for(int i=1 ; i<=n-1 ; i++){
			
			for(int j=0 ; j<n-i ; j++){
				
				if(value[n-i][j] == value[n-i][j+1]){
					
					value[n-i-1][j] = 1 ;
					
				}else{
					
					value[n-i-1][j] = 2 ;
					
				}
			}
		}
		
		for(int i=0 ; i<n ; i++){
			
			for(int j=0 ; j<=i ; j++){
				
				if(value[i][j] == 1){
					
					sumA ++ ;
					
				}else if(value[i][j] == 2){
					
					sumB ++ ;
					
				}
			}
		}
		
		if(sumA == numA && sumB == numB){
			
			count ++ ;
			
		}
	}
	
	
	/**
	 * 递归产生每种结果
	 * @param step
	 * @param n
	 */
	public static void dfs(int step){
		
		if(step == n){
			
			check() ;//检验结果是否符合
			
		}else{
			
			/*
			 * 在题目给的三角形中，只要三角形的最后一行确定，则三角形就确定了。
			 * 因此，在本方法中只要确定三角形的最后一行即可。
			 * 由于每个位置只有两种情况，因此递归遍历各种情况。
			 * 1代表A，2代表B。
			 */
			for(int i=1 ; i<=2 ; i++){
				
				value[n-1][step] = i ;
				
				dfs(step + 1) ;
			}
			
		}
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		numA = scan.nextInt() ;  //字符A的个数
		numB = scan.nextInt() ;  //字符B的个数
		
		scan.close(); 
		
		n = (int) ((Math.sqrt(8*(numA+numB)+1) - 1)/2) ;
		
		value = new int[n][n] ;
		
		dfs(0) ;
		
		System.out.println(count);
	}

}
