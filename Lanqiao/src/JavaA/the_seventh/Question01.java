package JavaA.the_seventh;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月27日 下午2:26:02
 * 
 */
public class Question01 {

	public static void main(String[] args){
		
		int sum = 0 ;
		
		int count = 0 ;
		
		for(int i=1 ; i<=100 ; i++){
			
			count += i ;
			
			sum += count ;
			
		}
		
		System.out.println(sum);
	}
	
}
