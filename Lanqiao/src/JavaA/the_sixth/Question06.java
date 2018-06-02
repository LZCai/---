package JavaA.the_sixth;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 下午9:05:51
 * 
 */
public class Question06 {
	
	public static void main(String[] args){
		
		int n = 1225 ;
		
		for(int i=2 ; i<47 ; i++){
			
			for(int j=i+1 ; j<=48 ; j++){
				
				int temp = n-i-(i-1)-j-(j+1) ;
				
				if(temp + i*(i-1) + j*(j+1) == 2015){
					
					System.out.println("i = " + i + " , j = "+ j);
				}
			}
		}
	}

}
