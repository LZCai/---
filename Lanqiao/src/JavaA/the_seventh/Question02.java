package JavaA.the_seventh;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月27日 下午2:53:19
 * 
 */
public class Question02 {

	public static void main(String[] args){
		
		for(int i=1 ; i<=100 ; i++){
			
			int sum = 0 ;
			
			for(int j=i ; j<=100 ; j++){
				
				sum += j ;
				
				if(sum == 236){
					
					System.out.println(i);
					
					return ;
				}
			}
		}
	}
}
