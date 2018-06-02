package JavaA.the_sixth;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 下午9:34:16
 * 
 */
public class Question07 {
	
	public static int count ;
	
	public static void dfs(int step, int sum){
		
		if(step == 13){  //进行13次选择，每次选择一种牌的i张
			
			if(sum == 13){  //保证牌的总数为13张
				
				count ++ ;
			}
			
		}else{
			
			for(int i=0 ; i<5 ; i++){  //每一次DFS选择i张一样点数的牌每一种点数最多4张，最少0张
				
				sum += i ;  //递归
				
				dfs(step+1, sum) ; 
				
				sum -= i ;  //回溯
				
			}
		}
		
	}
	
	public static void main(String[] args){
		
		dfs(0, 0) ;
		
		System.out.println(count);
	}

}
