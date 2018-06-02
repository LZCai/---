package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月24日 下午11:17:46
 * 
 * 解题思路：
 * 0 0 0 1 0 0 1 1 0 0  1  1  0  1  0  1  0  1  1  1  1  1  1  1  1  ……
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 ……
 * 
 * 定义数组，由样例可以发现令糖果数4和7对应的值为1表示，可以买到的数目，那么4x+7y组成的所有和都能买到。
 * 但是观察发现18以后的值都能买到，所以最大不能买到的数目为17。
 * 
 * 那么18以后的数目为什么都能买到呢？
 * 
 * 观察发现只要连续出现4个1或者7个1那么后面的数目都能买到，因为如果i能买到，那么i+4和i+7都能买到。
 * 因此，若连续出现4或7个1后面的就会联系出现1.
 * 
 * 所以，在本题中利用动态规划，不断判断每个数能否被买到，并判断连续的个数是否满足==n(4)或者==7(m),若出现
 * 则其前面一个不能买到的数么就是最大数。
 */
public class 买不到的数_数论_dp {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int m = scan.nextInt() ;
		
		scan.close();
		
		int max = n ;
		if(m>n)
			max = m ;
		
		int[] num = new int[1000*1000] ;
		num[n] = 1 ;
		num[m] = 1 ;
		
		int result = -1 ;
		int count = 0 ;
		
		for(int i=1 ; i<num.length ; i++){
			
			if(num[i] == 1){
				
				num[i+n] = 1 ;
				num[i+m] = 1 ;
				
				count ++ ;
				
			}else{
				
				result = i ;
				count = 0 ;
			}
			
			if(count >= max){
				
				System.out.println(result);
				
				return ;
			}
		}
	}

	
}
