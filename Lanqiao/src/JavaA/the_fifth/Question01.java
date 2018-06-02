package JavaA.the_fifth;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月24日 下午10:40:00
 * 
 */
public class Question01 {
	
	public static void main(String[] args){
		
		for(int i=0 ; i<100 ; i++){
			
			for(int j=i+1 ; j<i+8 ; j++){
				
				if(j*i%(j+i) == 0 && j*i/(j+i) == 6){
					
					System.out.println(i+" "+j);
				}
			}
		}
	}

}
