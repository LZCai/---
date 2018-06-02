package final_round.the_seventh;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月21日 上午11:05:49
 * 
 */
/*
 * 把0~9这10个数字，分成多个组，每个组恰好是一个平方数，这是能够办到的。
比如：0, 36, 5948721

再比如：
1098524736
1, 25, 6390784
0, 4, 289, 15376
等等...

注意，0可以作为独立的数字，但不能作为多位数字的开始。
分组时，必须用完所有的数字，不能重复，不能遗漏。

如果不计较小组内数据的先后顺序，请问有多少种不同的分组方案？
 */
public class Question02 {
	
	public static HashSet<String> list = new HashSet<String>() ;
	
	public static void swap(int[] num, int i, int j){
		
		int temp = num[i] ;
		num[i] = num[j] ;
		num[j] = temp ;
		
	}
	
	public static void dfsAllSort(int[] A, int step){
		
		
		if(step == A.length){
			
			long[] B = new long[A.length] ;
			
			dfsSqrtNum(A, 0, B, 0) ;
			
		}else{
			
			for(int i=step ; i<A.length ; i++){
				
				swap(A, step, i) ;
				dfsAllSort(A, step+1);
				swap(A, step, i) ;
				
			}
		}
		
		
	}
	
	public static void dfsSqrtNum(int[] A, int n1, long[] B, int n2){
		
		//System.out.println(n1);
		
		if(n1 == A.length){
			
			//System.out.println(1);
			
			long[] result = new long[n2] ;
			
			for(int i=0 ; i<n2 ; i++){
				
				result[i] = B[i] ;
				
			}
			
			Arrays.sort(result);
			
			StringBuilder sb = new StringBuilder() ;
			
			for(long n : result){
				
				sb.append(n) ;
				sb.append("-") ;
			}
			
			list.add(sb.toString()) ;
			
			return ;
		}
		
		if(A[n1] == 0){
			
			B[n2] = 0 ;
			
			dfsSqrtNum(A, n1+1, B, n2+1);
			
		}else{
			
			long sum = 0 ;
			
			for(int i=n1 ; i<A.length ; i++){
				
				sum = sum*10 + A[i] ;
				
				double a = Math.sqrt(sum*1.0) ;
				
				long s = (long) a ;
				
				if(a == s){
					
					B[n2] = sum ;
					
					dfsSqrtNum(A, i+1, B, n2+1);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args){
		
		int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} ;
		
		dfsAllSort(A, 0); 
		
		System.out.println(list.size());
	}

}
