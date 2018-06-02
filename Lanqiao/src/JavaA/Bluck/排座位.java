package JavaA.Bluck;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月31日 下午2:15:54
 * 
 * 
 * 要安排：3个A国人，3个B国人，3个C国人坐成一排。
要求不能使连续的3个人是同一个国籍。
求所有不同方案的总数？
 */
public class 排座位 {
	
	public static int count ;
	
	public static void swap(int[] num, int i, int j){
		
		int temp = num[i] ;
		num[i] = num[j] ;
		num[j] = temp ;
		
	}
	
	public static void dfs(int[] num, int step){
		
		if(step == 9){
			
			if(check(num)) count ++ ;
			
		}else{
			
			for(int i=step ; i<num.length ; i++){
				
				swap(num, i, step) ;
				
				dfs(num, step+1) ;
				
				swap(num, i, step) ;
			}
		}
	}
	
	public static boolean check(int[] num){
		
		for(int i=0 ; i<num.length-2 ; i++){
			
			if(num[i] == num[i+1] && num[i]==num[i+2]){
				
				return false ;
			}
		}
		
		return true ;
	}
	
	public static void main(String[] args){
		
		int[] num = {1, 1, 1, 2, 2, 2, 3, 3, 3} ;
		
		dfs(num, 0) ;
		
		System.out.println(count);
	}

}
