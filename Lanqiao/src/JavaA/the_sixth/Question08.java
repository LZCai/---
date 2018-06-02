package JavaA.the_sixth;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 下午9:59:53
 * 
 */
public class Question08 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int w = scan.nextInt() ;
		int m = scan.nextInt() ;
		int n = scan.nextInt() ;
		
		scan.close() ;
		
		int m_x = (m-1)/w ;
		int m_y = (m-1)%w ;
		
		if(m_x % 2 != 0){
			
			m_y = w - m_y -1 ;
		}
		
		
		int n_x = (n-1)/w ;
		int n_y = (n-1)%w ;
		
		if(n_x % 2 != 0){
			
			n_y = w - n_y -1;
		}
		
		System.out.println(Math.abs(n_y-m_y)+Math.abs(n_x-m_x));
		
	}

}
