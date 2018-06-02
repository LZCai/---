package JavaA.the_fourth;

import java.math.BigInteger;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月23日 上午9:29:18
 * 
 * 
 * 注意点：
 * 1、可以将2^11213-1转化为二进制进行计算，即2^0+2^1+……+2^11212
 * 2、最后一百位是计算结果的最后100位，而不是只计算到100位，因为后面的计算为影响到最后100位的值，所以要计算出最终结果后
 * 再进行截取，又因为最后结果值的位数太大BigInteger不好保存，因此在每次计算结果相加的过程中只截取最后的100为数字。
 */
public class Questiuon03 {
	
	public static void main(String[] args){
		
		BigInteger two = new BigInteger("2") ;
		
		BigInteger sum = new BigInteger("0") ;
		
		for(int i = 0 ; i < 11213 ; i++){
			
			sum = sum.add(two.pow(i)) ;
			
			if(sum.toString().length() > 100){
				
				sum = new BigInteger(sum.toString().substring(sum.toString().length()-100)) ;
			}
			
		}
		
		System.out.println(sum);
	}

}
