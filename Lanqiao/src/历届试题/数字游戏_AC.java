package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月22日 上午9:13:18
 * 
 * 
 * 思路1：最高分83
 * 通过求出数列可以看出所得数列会循环，
 * 当k为奇数时循环节为k，当k为偶数时，循环节为2*k
 *
 * 
 * 思路2：
 * 由数列可以看出每个人所说的数字为1, 1+1, 1+1+2, 1+1+2+3, 1+1+2+3+4
 * 即每个人的数字可以简化为1， 1+(1+1)*1/2, 1+(2+1)*2/2, 1+(3+1)*3/2, ...
 *又因为，每间隔n个人东东给出一个数字，因此东东每次给出的数字可以由 prev_num+(start+end)*n/2求得
 *  
 */
public class 数字游戏_AC {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int k = scan.nextInt() ;
		int t = scan.nextInt() ;
		
		scan.close() ;
		
		long sum = 1 ;
		
		long l = 1 ;
		long r = n ;
		
		long num = 1 ;
		
		for(int i=1 ; i<t ; i++){
			
			num += (l+r)*n/2 ;
			
			num = num%k ;
			
			sum += num ;
			
			l += n ;
			r += n ;
		}
		
		System.out.println(sum);
		
	}
}
