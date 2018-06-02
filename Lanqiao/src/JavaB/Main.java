package JavaB;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月3日 下午9:33:12
 * 
 */
public class Main {
	
	public static void main(String[] args){
		
		question01("12+35*5-2*18/9-3") ;
		question01("354*12+3-14/7*6") ;
		
		question02() ;
		
		System.out.println(question03(2, 3)); 
		
		int[] result = new int[]{7,4,0,0,0,0,4,0,7,0,0,0,0,0} ;
		question04(1, result);
		
		question05() ;
		
	}
	
	public static void question01(String str){
		
		System.out.println(str.split("\\W").length);
		
	}
	
	public static void question02(){
		
		int i = 1 ;
		double sum = 0 ;
		
		while(true){
			
			sum += 1.0/i ;
			
			//System.out.println(sum);
			
			if(sum >= 15.0){
				
				System.out.println(i);
				
				return ;
			}
			
			i ++ ;
		}
		
	}
	
	
	
	public static double question03(double a, double b){
		
		double x = (a+b)/2 ;
		
		BigDecimal bd = new BigDecimal(x) ;
		
		if(Math.pow(x, x) == 10){
			
			return bd.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue() ;
		}
		
		if(Math.pow(x, x) > 10){
			
			return question03(a, x) ;
			
		}else{
			
			return question03(x, b) ;
			
		}
	}
	
	
	public static void question04(int n, int[] result){
		
		if(n == 4) n++ ;
		if(n >= 7) {
			
			System.out.println(Arrays.toString(result));
			
			System.exit(0);
		
		}
		
		for(int i = 2; i < 14; i ++){
			
			if(i==6 || i==8) continue ;
			
			if(i+n+1 < 14 && result[i] == 0 && result[i+n+1] == 0){
				
				result[i] = result[i+n+1] = n ;
				question04(n+1, result) ;
				result[i] = result[i+n+1] = 0 ;
			}
		}
		
		
	}
	
	
	public static void question05(){
	
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int count = 0 ;
		
		for(int i=1; i < n; i++){
			
			for(int j=1; j < n; j ++){
				
				if(Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(n, 2)){
					
					count ++ ;
				}
			}
		}
		
		System.out.println(count/2);
		
		scan.close() ;
		
	}
	
	
	public static void question07(){
		
		
	}

}
