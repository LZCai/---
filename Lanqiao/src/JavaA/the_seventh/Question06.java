package JavaA.the_seventh;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月27日 下午3:30:57
 * 
 */
public class Question06 {
	
	public static int count ;

	public static void swap(int[] num, int i, int step){
		
		int temp = num[i] ;
		num[i] = num[step] ;
		num[step] = temp ;
		
	}
	
	public static void dfs(int[] num, int step){
		
		if(step == num.length){
			
			if(num[0] + num[1] == num[2] &&
					num[3] - num[4] == num[5] &&
					num[6] * num[7] == num[8] &&
					num[9] / num[10] == num[11] && num[9]%num[10]==0){
				
				count ++ ;
			}
			
		}else{
			
			for(int i=step ; i<num.length ; i++){
				
				swap(num, i, step) ;
				dfs(num, step+1) ;
				swap(num, i, step) ;
			}
		}
	}
	
	public static void main(String[] args){
		
		int[] num = new int[13] ;
		
		for(int i=0 ; i<13 ; i++){
			
			num[i] = i+1 ;
			
		}
		
		dfs(num, 0) ;
		
		System.out.println(count);
	}
}
