package JavaA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月11日 下午2:12:38
 * 
 */
public class Sort {
	
	public static void main(String[] agrs){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[] numArr = new int[n] ;
		
		for(int i=0; i < n; i ++){
			
			numArr[i] = scan.nextInt() ; 
			
		}
		
		numArr = BubbleSort(numArr) ;
		
		System.out.println(Arrays.toString(numArr));
		
		Arrays.sort(numArr);
		
		for(int i=0 ; i < n; i ++){
			
			System.out.print(numArr[i] + " ") ;
		}
		
	}
	
	public static int[] BubbleSort(int[] numArr){
		
		int length = numArr.length ;
		
		for(int i=0 ; i < length-1; i ++){
			
			for(int j=0 ; j < length-1; j ++){
				
				if(numArr[j] > numArr[j + 1]){
					
					int temp = numArr[j] ;
					numArr[j] = numArr[ j+1 ] ;
					numArr[j + 1] = temp ;
				}
			}
		}
		
		return numArr ;
	}

}
