package JavaA.Bluck;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月30日 上午10:50:11
 * 
 */
public class Question08 {
	
	public static double sum ;
	
	public static ArrayList<Integer> list = new ArrayList<Integer>() ;
	
	public static void dfs(int people, int step){
		
		if(step == 4){
			
			BigDecimal bd = new BigDecimal(sum) ;
			
			bd = bd.setScale(10, BigDecimal.ROUND_HALF_UP) ;
			
			if(people == 0 && bd.doubleValue() == 1){
				
				System.out.println(bd);
				
				System.out.println(sum);
				
				System.out.println(list);
			}
			
		}else if(people == 0){
			
			return ;
			
		}else{
			
			list.add(people) ;
			sum += 1.0/people ;
			
			for(int i=0 ; i<people ; i++){
				
				dfs(i, step+1) ;
				
			}
			
			list.remove(list.size()-1) ;
			sum -= 1.0/people ;
		}
	}
	
	public static void main(String[] args){
		
		for(int i=4 ; i<=20 ; i++){
			
			dfs(i, 0) ;
		}
	}

}
