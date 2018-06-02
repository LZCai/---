package JavaA.test;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月28日 下午11:22:03
 * 
 */
public class Question03 {
	
	public static int count = 0 ;
	
	public static void swap(String[] s, int i, int j){
		
		String temp = s[i] ;
		s[i] = s[j] ;
		s[j] = temp ;
	}
	
	public static void dfs(String[] s, int step){
		
		if(step == s.length){
			
			String result = "" ;
			
			for(String str : s){
				
				result += str ;
			}
			
			if(result.equals("bckfqlajhemgiodnp")){
				
				System.out.println(count);
				
			}
			count ++ ;
			
			//System.out.println(count+"---");
		}else{
			
			for(int i=step ; i<s.length ; i++){
				
				swap(s, i, step) ;
				dfs(s, step+1) ;
				swap(s, i, step) ;
			}
		}
	}

	public static void main(String[] args){
		
		String[] s = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
				"j", "k", "l", "m", "n", "o", "p", "q"} ;
		
		dfs(s, 0) ;
	}
}
