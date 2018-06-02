package JavaA.the_fifth;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月24日 下午10:48:45
 * 
 */
public class Question02 {
	
	public static int count ;
	
	public static void dfs(int sum, int step, int step_a, int step_b){
		
		if(step > 15 || (step < 15 && sum == 0)){
			
			return ;
		}
		
		if(step == 15 && step_a == 5 && step_b == 10){
			
			if(sum == 0)
			count ++ ;
			
			return ;
			
		}else{
			
			dfs(sum-1, step+1, step_a, step_b+1) ;
			dfs(sum*2, step+1, step_a+1, step_b) ;
			
		}
	}
	
	public static void main(String[] args){
		
		int sum = 2 ;
		
		dfs(sum, 0, 0, 0) ;
		
		System.out.println(count);
	}
}
