package acm;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月6日 下午12:56:42
 * 
 */
public class Demo02 {
	
	public static void main(String[] args){
		
		int[] sqe = new int[]{0,0,0,0,0,0,0,0,0} ;
		
		itretor(0, sqe) ;
		
	}
	
	public static void itretor(int n, int[] sqe){
		
		if(n > 8){
			int a = sqe[0]*10 + sqe[1] ;
			int b = sqe[2]*10 + sqe[3] ;
			int c = sqe[4]*10 + sqe[5] ;
			int d = sqe[6]*100 + sqe[7]*10 + sqe[8] ;
			
			if(a*b == c*d && a <= b){
				
				System.out.println(a+" * "+b+" = "+c+" * "+d);
				
			}
			
			return ;
			
		}
		
		
		for(int i = 1; i <= 9; i ++){
			
			if(sqe[n] == 0 && check(i, sqe)){
				
				sqe[n] = i ;
				
				itretor(n+1, sqe);
				
			}
			
			sqe[n] = 0 ;
		}
	}
	
	public static boolean check(int n, int[] data){
		
		for(int num: data){
			
			if(num == n){
				
				return false ;
			}
		}
		
		return true ;
		
	}

}
