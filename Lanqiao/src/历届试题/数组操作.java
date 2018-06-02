package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月4日 下午3:22:53
 * 
 */
public class 数组操作 {
	
	public static void  main(String[] args){
		
		Scanner scan =  new Scanner(System.in) ;
		
		int Case = scan.nextInt() ;
		int n = scan.nextInt() ;
		int m = scan.nextInt() ;
		
		int[] numArr = new int[n+1] ;
		
		for(int i=1 ; i<=n ; i++){
			
			numArr[i] = scan.nextInt() ;
			
		}
		
		for(int j=0 ; j<m ; j++){
			
			int operate = scan.nextInt() ;
			if(operate == 1){
				
				int l = scan.nextInt() ;
				int r = scan.nextInt() ;
				int d = scan.nextInt() ;
				
				for(int i=l ; i<=r ; i++){
				
					numArr[i] += d ;
					
				}
				
			}else if(operate == 2){
				
				int l1 = scan.nextInt() ;
				int r1 = scan.nextInt() ;
				int l2 = scan.nextInt() ;
				int r2 = scan.nextInt() ;
				
				int[] temp = new int[r2-l2+1] ;
				
				for(int i=0 ; i<=r2-l2 ; i++){
					
					temp[i] = numArr[l2+i] ;
					
				}
				
				for(int i=0 ; i<=r1-l1 ; i++){
					
					numArr[l1+i] = temp[i] ;
				}
				
			}else if(operate == 3){
				
				int l = scan.nextInt() ;
				int r = scan.nextInt() ;
				
				long sum = 0 ;
				
				for(int i=l ; i<=r ; i++){
					
					sum += numArr[i] ;
					
				}
				
				System.out.println(sum);
				
			}
		}
		
		scan.close(); 
	}

}


