package JavaA.Bluck;

import java.util.ArrayList;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月31日 下午1:00:59
 * 
 */
public class Question09 {
	
	public static ArrayList<Integer> list = new ArrayList<Integer>() ;
	
	public static int sum = 10;

	public static void dfs(int step){
		
		if(step == 10){
			
			for(int i=0 ; i<list.size() ; i++){
				
				if(list.get(i) == 0){
					
					sum = sum - (i+1) ;
					
				}else if(list.get(i) == 1){
					
					sum *= 2 ;
					
				}
			}
			
			if(sum == 100) System.out.println(list);
			
			sum = 10 ;
			
		}else{
			
			for(int i=0 ; i<=1 ; i++){
				
				list.add(i) ;
				
				dfs(step+1) ;
				
				list.remove(list.size()-1) ;
				
			}
			
		}
		
	}
	
	public static void main(String[] args){
		
		dfs(0) ;
		
	}
}
