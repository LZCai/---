package JavaA.the_seventh;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月27日 下午2:58:07
 * 
 */
public class Question03 {
	
	public static int count ;
	
	public static void swap(int[] num, int i, int step){
		
		int temp = num[i] ;
		num[i] = num[step] ;
		num[step] = temp ;
		
	}
	
	public static void dfs(int[] num, int step){
		
		if(step == num.length){
			
			if(num[0] < num[1] && num[0]<num[2]
					&& num[1]<num[3] && num[1]<num[4] && num[2]<num[5] && num[2]<num[4]
							&& num[3]<num[6] && num[3]<num[7] && num[4]<num[7] && num[4]<num[8] && num[5]<num[8] && num[5]<num[9]){
				
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
		
		int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} ;
		
		dfs(num, 0) ;
		
		System.out.println(count);
	}

}
