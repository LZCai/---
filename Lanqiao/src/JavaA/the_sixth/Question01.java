package JavaA.the_sixth;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 下午3:51:51
 * 
 */
public class Question01 {

	public static void main(String[] args){
		
		int n = 1543 ;
		
		int count = 0 ;
		
		while(n>0){
			
			if(n % 2 == 0){
				
				n = n/2 ;
				
			}else{
				
				n = (n-1)/2 ;
				
				
				count ++ ;
			}
			
		}
		
		System.out.println(count);
		
	}
}
