package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月22日 下午10:49:58
 * 
 * 解题思路：
 * 
 * 首先找出所有五位数与六位数的回文（10000-1000000）
 * 然后盘算每个回文各个位上的数字和是否等于给定的数
 * 
 */
public class 回文数字 {
	
	public static boolean isPalindrome(int num){
		
		if(num < 100000){
			
			return num/10000 == num%10 && num/1000%10 == num/10%10 ;
		}
		
		else if(100000<= num && num < 1000000)
			
			return num/100000 == num%10 && num/10000%10 == num/10%10 && num/1000%10 == num/100%10 ;
		
		else
			
			return false ;
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.close();
		
		int[] palindrome = new int[2000] ;
		
		int index = 0 ;
		
		for(int i=10000 ; i<1000000 ; i++){
			
			if(isPalindrome(i))
				
				palindrome[index++] = i ;
			
		}
		
		if(n<5 || n>54)
			
			System.out.println(-1);
		
		else{
			
			for(int i=0 ; i<index ; i++){
				
					int sum = 0;
					
					int m = palindrome[i] ;
					
					while(m != 0){
						
						sum += m%10 ;
						m /= 10 ;
						
					}
						
					if(sum == n){
						
						//System.out.println(sum == n);
						//System.out.println(sum +"---"+ n);
						
						System.out.println(palindrome[i]);
					}
						
			}
		}
		
	}

}
