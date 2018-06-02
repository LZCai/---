package final_round.the_fifth;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月11日 下午2:51:24
 * 
 */
public class Question05 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		//创建索引数组
		int[] num = new int[n] ;
		
		for(int i=0 ; i<n ; i++){
			//索引为行标，值为列标（1的行标与列标）
			num[scan.nextInt()-1] = scan.nextInt()-1 ;
		}
		
		boolean[] vis = new boolean[n] ;
		
		//记录遍历次数
		long max = 1 ;
		//从原数组的第0行开始，寻找搜索
		for(int i=0 ; i<n ; i++){
			
			//如果当前行已经被搜索过，直接continue
			if(vis[i]){
				
				continue ;
			}
			
			long count = 1 ;
			
			int s = i ;
			
			vis[s] = true ;
			
			while(num[s] != i){
				
				count ++ ;
				
				s = num[s] ;
				
				vis[s] = true ;
				
			}
			
			if(max%count != 0){
				
				if(max > count){
					
					max = max*count/gcd(max, count) ;
					
				}
				
				if(max < count){
					
					max = max*count/gcd(count, max) ;
				}
			}
		}
		
		System.out.println(max);
		
		scan.close();
		
	}
	
	public static long gcd(long max, long count){
		
		//使用辗转相除法求最大公约数
		if(max%count == 0){
			
			return count ;
		}
		
		return gcd(count, max%count) ;
		
	}

}
