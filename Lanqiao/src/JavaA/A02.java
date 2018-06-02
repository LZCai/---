package JavaA;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2017年11月30日 下午3:12:36
 * 
 * 
 */
public class A02 {
	
	public static void main(String[] args){
		
		// question03() ;
		
		int[] result = new int[]{7,4,0,0,0,0,4,0,7,0,0,0,0,0} ;
		question04(1, result) ;
		
		question05() ;
	}
	
	
	public static void question06(){
		
	
	}
	
	
	/**
	 * 已知直角三角形的斜边是某个整数，并且要求另外两条边也必须是整数。
	 * 求满足这个条件的不同直角三角形的个数。
	 */
	public static void question05(){
		
		int count = 0 ;
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		for(int i = 1; i < n; i ++){
			
			for(int j = 1; j < n; j ++){
				
				if(Math.pow(i,2) + Math.pow(j, 2) == Math.pow(n, 2)){
					
					count ++ ;
				}
			}
		}
		
		System.out.println(count/2);
		
		scan.close() ;
	}
	
	/**
	 * 今有7对数字：两个1，两个2，两个3，...两个7，把它们排成一行。
	 * 要求，两个1间有1个其它数字，两个2间有2个其它数字，以此类推，两个7之间有7个其它数字。如下就是一个符合要求的排列：
	 * 17126425374635
	 * 当然，如果把它倒过来，也是符合要求的。
	 * 请你找出另一种符合要求的排列法，并且这个排列法是以74开头的。
	 * @param n
	 * @param result
	 */
	public static void question04(int n, int[] result){
		
		if(n == 4) n++ ;
		if(n >= 7){
			
			System.out.println(Arrays.toString(result)) ;
			
			return;
			
		}
		
		for(int i = 2; i < 14; i ++){
			
			if(i == 6 || i == 8) continue ;
			
				if(i+n+1 < 14 && result[i] == 0 && result[i+n+1] == 0){
					
					result[i] = result[i+n+1] = n ;
					question04(n+1, result) ;
					//System.out.println(Arrays.toString(result));
					result[i] = result[i+n+1] = 0 ;
				}
				
		}
				
		
	}
	
	
	/**
	 * 如果x的x次幂结果为10，你能计算出x的近似值吗？,,使用二分法
	 */
	public static void question03(){
		
		Random rand = new Random() ;
		
		double data = mid(2,3) ;
		
		BigDecimal bd = new BigDecimal(data) ;
		data = bd.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue() ;
		
		System.out.println(data) ;
	}
	
	
	public static double mid(double a, double b){
		
		double x = (a + b) / 2.0 ;
		
		if(Math.pow(x, x) == 10) return x ;
		
		if(a < b){
			
			if(Math.pow(x, x) < 10){
				
				return mid(x, b) ;
				
			}else{
				
				return mid(a, x) ;
				
			}
			
		}else{
			
			if(Math.pow(x, x) < 10){
				
				return mid(x, a) ;
				
			}else{
				
				return mid(b, x) ;
				
			}
		}
		
	}
	
	
	
	/**
	 * 求解pai = 4 * (1-1/3+1/5-1/7...)
	 */
	public static void question02(){
		
		DecimalFormat df = new DecimalFormat("0.00") ;
		
		double sum = 0.0 ;
		
		for(int i = 0; i < 100; i++){
			
			sum += (1.0/(2*i + 1) * Math.pow(-1, i)) ;
			
		}
		
		System.out.println(df.format(sum * 4));
	}

}
