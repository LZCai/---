package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月24日 下午8:53:39
 * 
 * 思路分析：
 * 
 * 有定义可以看出，对L、R区间内的数进行递增排序后，该区间的数是公差为1的等差数列
 * 即最大值-最小值 = R-L
 * 
 * 因此，判断某一个区间内最大值-最小值是否等于R-L即可
 */
public class 连号区间数 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[] num = new int[n] ;
		
		for(int i=0 ; i<n ; i++){
			
			num[i] = scan.nextInt() ;
			
		}
		
		scan.close() ;
		
		int sum = 0 ;
		
		for(int i=0 ; i<n ; i++){
			
			int max = num[i] ;
			int min = num[i] ;
			
			for(int j=i ; j<n ; j++){
				
				if(max < num[j]){
					
					max = num[j] ;
				}
				
				if(min > num[j]){
					
					min = num[j] ;
				}
				
				if(max-min == j-i){
					
					sum ++ ;
				}
			}
		}
		
		System.out.println(sum);
	}

}
