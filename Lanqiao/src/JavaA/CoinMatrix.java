package JavaA;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月15日 下午9:31:16
 * 
 */
public class CoinMatrix {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String a = scan.next() ;
		String b = scan.next() ;
		
		scan.close(); 
		//将a,b转化为BigInteger类型
		BigInteger n = new BigInteger(a) ;
		BigInteger m = new BigInteger(b) ;
		
		int sqrt_m_length = 0 ;
		int sqrt_n_length = 0 ;
		
		//判断n,m方根的长度
		if(a.length()%2 == 0){
			
			sqrt_m_length = a.length()/2 ;
			
		}else{
			
			sqrt_m_length = (a.length()+1)/2 ;
		}
		
		if(b.length()%2 == 0){
			
			sqrt_n_length = b.length()/2 ;
			
		}else{
			
			sqrt_n_length = (b.length()+1)/2 ;
		}
		
		BigInteger sqrt_m_temp = new BigInteger("1") ;
		BigInteger sqrt_n_temp = new BigInteger("1") ;
		BigInteger ten = new BigInteger("10") ;
		
		for(int i=1 ; i<sqrt_m_length ; i++){
			
			sqrt_m_temp = sqrt_m_temp.multiply(ten) ;
		}
		
		for(int i=1 ; i<sqrt_n_length ; i++){
			
			sqrt_n_temp = sqrt_n_temp.multiply(ten) ;
		}
		
		BigInteger seed_n = new BigInteger(sqrt_n_temp.toString()) ;
		BigInteger seed_m = new BigInteger(sqrt_m_temp.toString()) ;
		
		while(seed_n.toString() != "0"){
			
			if(sqrt_n_temp.add(seed_n).multiply(sqrt_n_temp.add(seed_n)).compareTo(n) == -1 || 
					sqrt_n_temp.add(seed_n).multiply(sqrt_n_temp.add(seed_n)).compareTo(n) == 0){
				
				sqrt_n_temp = sqrt_n_temp.add(seed_n) ;
				
			}else{
				
				seed_n = seed_n.divide(ten) ;
			}
		}
		
		
		while(seed_m.toString() != "0"){
			
			if(sqrt_m_temp.add(seed_m).multiply(sqrt_m_temp.add(seed_m)).compareTo(m) == -1 ||
					sqrt_m_temp.add(seed_m).multiply(sqrt_m_temp.add(seed_m)).compareTo(m) == 0){
				
				sqrt_m_temp = sqrt_m_temp.add(seed_m) ;
				
			}else{
				
				seed_m = seed_m.divide(ten) ;
			}
			
			
		}
		
		BigInteger result = new BigInteger(sqrt_n_temp.multiply(sqrt_m_temp).toString()) ;
		
		System.out.println(result.toString());
		
		
	}
	
	public static BigInteger sqrt(BigInteger n){
		
		BigInteger two = BigInteger.valueOf(2) ;
		BigInteger prv = n.divide(two) ;
		BigInteger now = prv.add(n.divide(prv)).divide(two) ;
		
		while(prv.compareTo(now) > 0){
			
			prv = now ;
			
			now = prv.add(n.divide(prv)).divide(two) ;
		}
		
		return now ;
	}
	
	
	public static void practice(BigInteger n){
		
		BigInteger two = BigInteger.valueOf(2) ;
		BigInteger prv = n.divide(two) ;
		BigInteger now = prv.add(n.divide(prv)).divide(two) ;
		
		while(prv.compareTo(now) > 0){
			
			prv = now ;
			
			now = prv.add(n.divide(prv)).divide(two) ;
		}
		
	}
}
