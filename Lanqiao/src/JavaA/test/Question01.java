package JavaA.test;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月28日 下午10:27:10
 * 
 */
public class Question01 {
	
	public static void main(String[] args){
		
		for(int i=1 ; i<=100 ; i++){
			
			if(1800<i*i && i*i<1900){
				
				System.out.println(i*(i-1));
			}
		}
	}

}
