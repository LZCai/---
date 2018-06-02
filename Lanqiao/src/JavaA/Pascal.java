package JavaA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月13日 下午1:55:33
 * 
 * 杨辉三角
 */
public class Pascal {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.close() ;
		
		List<Integer> num_list = new ArrayList<Integer>() ;
		
		for(int i=1 ; i<=n ; i++){
			
			List<Integer> temp = new ArrayList<Integer>() ;
			
			for(int j=0 ; j<i ; j++){
				
				if(j == 0){
					
					System.out.print(1+" ");
					
					//num_list.set(j, 1) ;
					temp.add(1) ;
					
				}else if(j == (i-1)){
					
					System.out.print(1);
					//num_list.set(j, 1) ;
					temp.add(1) ;
					
				}else{
					
					int sum = num_list.get(j-1) + num_list.get(j) ;
					
					System.out.print(sum+" ");
					
					temp.add(sum) ;
					
				}
				
			}
			
			num_list.clear();
			num_list.addAll(temp) ;
			
			System.out.println();
		}
	}

}
