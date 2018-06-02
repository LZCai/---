package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月7日 上午9:54:02
 * 
 */
public class 九宫幻方 {
	
	public static int[] value ;
	public static boolean[] used ;
	
	public static int count ;
	public static int[] ans = new int[9] ;
	
	public static void find(int n){
		
		if(n>5){
			
			if(value[0] + value[1] + value[2] != value[3] + value[4] + value[5])
				
				return ;
		}
		if(n>6){
			
			if(value[0] + value[1] + value[2] != value[0] + value[3] + value[6] ||
					
					value[0] + value[1] + value[2] != value[2] + value[4] + value[6])
				
				return ;
			
		}
		if(n>7){
			
			if(value[0] + value[1] + value[2] != value[1] + value[4] + value[7])
				
				return ;
			
		}
		if(n>8){
			
			if(value[0] + value[1] + value[2] != value[2] + value[5] + value[8]||
					
					value[0] + value[1] + value[2] != value[6] + value[7] + value[8])
				
				return ;
			
			else{
				
				count ++ ;
				
				if(count == 1)
					
					for(int i=0 ; i<9 ; i++){
						
						ans[i] = value[i] ;
						
					}
				
				return ;
			}
			
		}
		
		if(value[n] != 0){
			
			find(n+1) ;
			
		}
		
		for(int i=1 ; i<=9 ; i++){
			
			if(!used[i] && value[n] == 0){
				
				value[n] = i ;
				
				used[i] = true ;
				
				find(n+1) ;
				
				value[n] = 0 ;
				
				used[i] = false ;
			}
				
		}
		
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		value = new int[9] ;
		used = new boolean[10] ;
		
		for(int i=0 ; i<9 ; i++){
			
			value[i] = scan.nextInt() ;
			
			if(value[i] != 0)
				
				used[value[i]] = true ;
			
		}
		
		scan.close();
		
		find(0) ;
		
		if(count == 1){
			
			int k=0 ;
			
			for(int i=0 ; i<3 ; i++){
				
				for(int j=0 ; j<3 ; j++){
					if(j != 2)
						System.out.print(ans[k]+" ");
					else
						System.out.println(ans[k]);
					k++;
				}
			}
		}else{
			
			System.out.println("Too Many");
		}
		
	}

}
