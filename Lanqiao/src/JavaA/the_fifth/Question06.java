package JavaA.the_fifth;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月25日 下午2:43:40
 * 
 */
public class Question06 {

	public static int[] data = {1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 8, 0} ;
	
	public static void dfs(int n){
		
		if(n==0 || n== 6 || n==10) dfs(n+1) ;
		
		if(n >= 12){
			
			int num1 = data[0] + data[1] + data[3] + data[4] ;
			int num2 = data[2] + data[3] + data[5] + data[6] ;
			int num3 = data[4] + data[5] + data[7] + data[8] ;
			int num4 = data[6] + data[7] + data[9] + data[10] ;
			int num5 = data[8] + data[9] + data[11] + data[0] ;
			int num6 = data[10] + data[11] + data[1] + data[2] ;
			
			if(num1 == num2 && num2 == num3 && num3==num4 && num4==num5 && num5==num6)
				
				System.out.println(data[9]);
			
		}else{
			
			for(int i=1 ; i<=12 ; i++){
				
				if(data[n] == 0 && check(i)){
					
					data[n] = i ;
					
					dfs(n+1) ;
					
					data[n] = 0 ;
				}
			}
		}
	}
	
	public static boolean check(int n){
		
		for(int i=0 ; i<data.length ; i++){
			
			if(data[i] == n){
				
				return false ;
			}
		}
		
		return true ;
	}
	
	public static void main(String[] args){
		
		dfs(0) ;
	}
}
