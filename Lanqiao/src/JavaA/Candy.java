package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月16日 下午4:07:40
 * 
 */
public class Candy {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int student_num = scan.nextInt() ;
		
		int[] candy_num = new int[student_num] ;
		
		int sum = 0 ;
		
		for(int i=0 ; i<student_num ; i++){
			
			candy_num[i] = scan.nextInt() ;
			
			sum += candy_num[i] ;
		}
		
		int add_num = 0 ;
		
		while(isAverage(candy_num, sum+add_num)){
			
				for(int i=0 ; i<student_num ; i++){
					
					if(candy_num[i]%2 != 0){
						
						candy_num[i] += 1 ;
						
						add_num ++ ;
					}
				}
				
				if(isAverage(candy_num, sum+add_num)){
					
					int last_num = candy_num[student_num-1] ;

					for(int i=student_num-1 ; i>=0 ; i--){
						
						if(i == 0){
							
							candy_num[i] = (candy_num[i]+last_num)/2 ;
							
						}else{
							
							candy_num[i] = (candy_num[i]+candy_num[i-1])/2 ;
							
						}
						
					}
					
				}
					
		}
		
		System.out.println(add_num);
		
		scan.close();
		
	}
	
	
	public static boolean isAverage(int[] candy_num, int sum){
		
		int mod = sum%candy_num.length ;
		int student_num = candy_num.length ;
		
		if(mod == 0){
			
			int count = 0 ;
			
			for(int i=0 ; i<student_num-1 ; i++){
				
				if(candy_num[i] != candy_num[i+1]){
					
					break ;
					
				}else{
					
					count ++ ;
				}
				
			}
			
			if(count == student_num -1){
				
				return false ;
			}
			
		}
		
		return true ;
	}
		

}
