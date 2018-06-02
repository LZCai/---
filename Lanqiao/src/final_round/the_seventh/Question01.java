package final_round.the_seventh;

import java.math.BigInteger;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月21日 上午10:40:47
 * 
 */
/*
 * 阶乘位数

9的阶乘等于：362880
它的二进制表示为：1011000100110000000
这个数字共有19位。

请你计算，9999 的阶乘的二进制表示一共有多少位？
 */
public class Question01 {
	
	public static void main(String[] args){
		
		BigInteger m = new BigInteger("1") ;
		
		for(int i=1 ; i<=9999; i++){
			
			m = m.multiply(new BigInteger(""+i)) ;
			
		}
		
		long count = 0 ;
		BigInteger result = new BigInteger("1") ;
		BigInteger two = new BigInteger("2") ;
		while(result.compareTo(m) < 0){
			
			count ++ ;
			result = result.multiply(two) ;
		}
		
		System.out.println(count);
	}

}
