package 历届试题;

 import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月24日 下午9:45:31
 * 
 * 
 * 思路分析：
 * 
 * 分析题目所给样例可知，初始状态和目标状态字符串之间不同字符的个数必定为偶数个，不然从初始状态不可能到达目标状态。
 * 1、把初始状态和目标状态的相同之处标记为0，不同之处标记为1。
 * 2、从左到右遇1翻一次即可（贪心）==》等价于：数组中相邻两个1下标差的和
 * 
 * 修改：为降低算法复杂度，可以在比较两字符串中的字符是否相同时，对其下标进行操作，不用先转换成num，再进行操作。
 */
public class 翻硬币_贪心 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String start = scan.nextLine() ;
		String end = scan.nextLine() ;
		
		scan.close();
		
		int n = start.length() ;
		
		int[] num = new int[n] ;
		
		for(int i=0 ; i<n ; i++){
			
			if(start.charAt(i) == end.charAt(i))
				
				num[i] = 0 ;
			
			else
				
				num[i] = 1 ;
		}
		
		int sum = 0 ;
		
		int prev = -1 ;
		boolean flag = false ;
		
		for(int i=0 ; i<n ; i++){
			
			if(num[i] == 1){
				
				if(!flag){
					
					prev = i ;
					
					flag = true ;
				}else{
					
					sum += i-prev ;
					
					flag = false ;
				}
			}
				
		}
		
		System.out.println(sum);
	}

}
