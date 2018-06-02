package JavaA.the_seventh;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月28日 下午4:34:13
 * 
 */
public class Question008 {
	
	public static int[] a = new int[3] ;
	public static int[] b = new int[5] ;
	
	public static int dfs(int num_b, int user_1, int user_2){
		
		boolean is_0 = false ;
		
		if(num_b-a[0]<0 && num_b-a[1]<0 && num_b-a[2]<0){
			
			if(user_1%2 == 1 && user_2%2 == 0) return 1 ;
			if(user_1%2 == 0 && user_2%2 == 0) return 0 ;
			if(user_1%2 == 0 && user_2%2 == 1) return -1 ;
			if(user_1%2 == 1 && user_2%2 == 1) return 0 ;
			
		}
		
		for(int i=0 ; i<a.length ; i++){
			
			if(num_b-a[i] >= 0){
				
				int n = dfs(num_b-a[i], user_2, user_1+a[i]) ;
				
				if(n == -1) return 1 ;
				
				if(n == 0) is_0 = true ;
				
			}
			
		}
		
		if(is_0){
			
			return 0 ;
		}
		
		return -1 ;
		
	}
	
	public static void main(String[] args){
		
		boolean is_1 = false ;
		boolean is_0 = false ;
		
		Scanner scan = new Scanner(System.in) ;
		
		for(int i=0 ; i<a.length ; i++){
			
			a[i] = scan.nextInt() ;
		}
		
		for(int j=0 ; j<b.length ; j++){
			
			b[j] = scan.nextInt() ;
		}
		
		for(int k=0 ; k<b.length ; k++){
			
			int num_b = b[k] ;
			int user_1 = 0 ;
			int user_2 = 0 ;
			
			for(int i=0 ; i<a.length ; i++){
				
				if(num_b-a[i] >= 0){
					
					int n = dfs(num_b-a[i], user_2, user_1+a[i]) ;
					
					if(n == -1){
						
						is_1 = true ;
						
						break ;
					}
					
					if(n == 0){
						
						is_0 = true ;
						
						continue ;
					}
					
				}
				
			}
			
			if(is_1){
				
				is_1 = false ;
				is_0 = false ;
				
				System.out.print("+ ");
				
			}else if(is_0){
				
				is_0 = false ;
				
				System.out.print("0 ");
				
			}else{
				
				System.out.print("- ");
			}
		}
		
	}

}
