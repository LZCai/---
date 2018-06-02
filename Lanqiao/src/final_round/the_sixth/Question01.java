package final_round.the_sixth;

import java.util.ArrayList;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月20日 上午9:56:15
 * 
 */
/*
 * 小明家住在一条胡同里。胡同里的门牌号都是连续的正整数，由于历史原因，最小的号码并不是从1开始排的。
有一天小明突然发现了有趣的事情：
如果除去小明家不算，胡同里的其它门牌号加起来，刚好是100！
并且，小明家的门牌号刚好等于胡同里其它住户的个数！

请你根据这些信息，推算小明家的门牌号是多少？

 */
public class Question01 {

	public static void main(String[] args){
		
		for(int i=2 ; i<50 ; i++){
			
			for(int k=2 ; k<50 ; k++){
				
				int sum = 0 ;
				
				ArrayList<Integer> list = new ArrayList<Integer>() ;
				
				for(int j=k ; j<50 ; j++){
					
					if(j == i) continue ;
					
					sum += j ;
					
					list.add(j) ;
					
					if(sum == 100 && (j-k+1 == i || j-k == i)){
						
						System.out.println(i);
						
						System.out.println(list);
						
					}else if(sum > 100){
						
						break ;
					}
					
				}
				
			}
			
		}
		
	}
	
}
