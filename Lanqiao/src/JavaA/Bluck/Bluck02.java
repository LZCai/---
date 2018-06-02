package JavaA.Bluck;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月31日 下午1:32:00
 * 
 */
public class Bluck02 {
	
	public static void Question01(){
		
		for(int i=1 ; i<150 ; i++){
			
			double x = 32.0/(150-i) ;
			double y = 24.5/i ;
			
			if(i*x == y*(150-i)){
				
				System.out.println(i+" , "+(150-i));
				
				return ;
			}
		}
	}
	
	public static void Question04(){
		
		int x = 1 ;
		int y = 3 ;
		
		while(true){
			
			int sum = x+y ;
			
			double rate = y*1.0/sum ;
			
			BigDecimal bd = new BigDecimal(rate) ;
			
			bd = bd.setScale(6, BigDecimal.ROUND_HALF_UP) ;
			
			if(bd.doubleValue() == 0.618034){
				
				System.out.println(y+"/"+sum);
				
				return ;
			}
			
			x = y ;
			y = sum ;
		}
	}
	
	public static void Question05(){
		
		BigInteger[] times = new BigInteger[64+1] ;
		
		times[2] = new BigInteger("3") ;
		
		for(int i=3 ; i<=64 ; i++){
			
			times[i] = times[i-1].multiply(new BigInteger("2")).add(BigInteger.ONE) ;
			
		}
		
		System.out.println(times[64]);
	}
	
	
	public static void Question06(){
		
		for(int year=1912 ; year<2012 ; year ++){
			
			for(int day=1 ; day<30 ; day ++){
				
				int sum = year*10000+6*100+day ;
				
				if(sum%2012 == 0 && sum%3 == 0 && sum%12 == 0){
					
					System.out.println(sum);
					
					return ;
				}
			}
		}
		
	}
	
	public static void Question07(){
		
		BigInteger two = new BigInteger("2") ;
		
		BigInteger sum = two.pow(64).subtract(BigInteger.ONE) ;
		
		System.out.println(sum);
		
	}
	
	public static void Question08(){
		
		int count = 0;
		
		for(int i=1949 ; i<=2012 ; i++){
			
			Calendar c = new GregorianCalendar(i, 9, 1) ;
			
			int day = c.get(Calendar.DAY_OF_WEEK);
			
			if(day == 1) count ++ ;
			
		}
		
		System.out.println(count);
	}
	
	public static void Question09(){
		
		int count = 1 ;
		
			for(int i=3 ; ; i++){
				
				System.out.println(i);
				
				boolean flag = true ;
				
				for(int j=2 ; j<i/2 ; j++){
					
					if(i%j == 0){
						
						flag = false ;
						
						break ;
					}
				}
				
				if(flag){
					
					count ++ ;
				}
				
				if(count == 100002){
					
					System.out.println(i);
					
					break ;
					
				}
			}
			
	}
	
	public static void main(String[] args){
		
		Question01() ;
		
		Question04() ;
		
		Question05() ;
		
		Question06() ;
		
		Question07() ;
		
		Question08() ;
		
		Question09() ;
	}

}
