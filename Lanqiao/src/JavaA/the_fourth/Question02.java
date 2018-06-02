package JavaA.the_fourth;


/**
 * @author 64621 -- lzcai
 * @time 2018年3月23日 上午8:18:38
 * 
 * 
 * 振兴中华
 */
public class Question02 {
	
	public static String language = "从我做起振兴中华" ;
	
	public static String[][] words = new String[4][5] ;
	
	public static StringBuilder str = new StringBuilder() ;
	
	public static int count = 0 ;
	
	public static void main(String[] args){
		
		for(int i=0 ; i<4 ; i++){
			
			for(int j=0 ; j<5 ; j++){
				
				words[i][j] = language.substring(i+j, j+i+1) ;
				
			}
			
		}
		
		count(0,0);
		
		System.out.println(count);
	}
	
	
	public static void count(int i, int j){
		
		if(i==3 && j==4){
			
			str.append(words[i][j]) ;
			
			if(str.toString().equals(language)){
				
				count ++ ;
			}
			
			str.deleteCharAt(str.length()-1) ;
			
			return ;
			
		}else if(i<4 && j<5){
					
					str.append(words[i][j]) ;
					
					count(i+1, j) ;
					//str.deleteCharAt(str.length()-1) ;
					count(i, j+1) ;
					
					str.deleteCharAt(str.length()-1) ;
					
				}
				
				
				
	}

}
