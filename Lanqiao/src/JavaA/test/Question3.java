package JavaA.test;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月29日 上午8:30:10
 * 
 */
public class Question3 {

	public static long count ;
	public static boolean[] used = new boolean[17] ;
	
	public static long getMulitN(int n){
		
		if(n == 0) return 1 ;
		
		long result = 1l ;
		
		for(int i=1 ; i<=n ; i++){
			
			result *= i ;
		}
		
		return result ;
	}
	
	public static void main(String[] args){
		
		String str = "bckfqlajhemgiodnp" ;
		
		for(int i=0 ; i<str.length() ; i++){
			
			int temp = str.charAt(i) - 'a' ;
			
			int num = 0 ;
			
			used[temp] = true ;
			
			for(int j=0 ; j<temp ; j++){
				
				if(!used[j]) num ++ ;
				
			}
			
			count = count + num * getMulitN(16 - i) ;
		}
		
		System.out.println(count) ;
	}
	
}
