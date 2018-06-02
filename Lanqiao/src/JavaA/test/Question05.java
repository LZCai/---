package JavaA.test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月29日 下午3:05:07
 * 
 */
public class Question05 {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		    
		double rate = scan.nextDouble()/100/12 ;
		
		int date = scan.nextInt() ;
		
		double money = 10000 ;
		
		double x = money*Math.pow((1+rate), date)/((1-Math.pow((1+rate), date))/-rate);
		
		BigDecimal bd = new BigDecimal(x) ;
		
		System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		System.out.printf("%.2f", 24.036);
				
		scan.close() ; 
	}
}
