package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月11日 上午10:27:15
 * 
 */
public class Area {
	
	public static void main(String [] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int r = scan.nextInt() ;
		
		double area = Math.pow(r, 2) * Math.PI;
		
		String result = String.format("%.7f", area) ;
		
		System.out.println(result);
		
		scan.close() ;
		
	}

}
