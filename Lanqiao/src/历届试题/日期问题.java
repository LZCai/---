package 历届试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月7日 下午6:58:32
 * 
 */
public class 日期问题 {
	
	public static boolean isLeap(int m){
		
		if((m%4 == 0 && m%100 != 0) || m%400 == 0){
			
			return true ;
		}
		
		return false ;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String line = scan.nextLine() ;
		
		scan.close(); 
		
		String[] time = line.split("/") ;
		
		int d1 = Integer.valueOf(time[0]) ;
		int d2 = Integer.valueOf(time[1]) ;
		int d3 = Integer.valueOf(time[2]) ;
		
		int[] date = new int[6] ;
		date[0] = (1900+d1) * 10000 + d2*100 + d3 ;
		date[1] = (2000+d1) * 10000 + d2*100 + d3 ;
		date[2] = (1900+d3) * 10000 + d2*100 + d1 ;
		date[3] = (2000+d3) * 10000 + d2*100 + d1 ;
		date[4] = (2000+d3) * 10000 + d1*100 + d2 ;
		date[5] = (1900+d3) * 10000 + d1*100 + d2 ;
		
		int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ; 
		
		Arrays.sort(date); 
		
		ArrayList<String> set = new ArrayList<String>() ;
		
		for(int i=0 ; i<date.length ; i++){
			
			int year = date[i]/10000 ;
			int month = date[i]%10000/100 ;
			int day = date[i]%100 ;
			
			if(year<1960 || year>2059) continue ;
			if(month<1 || month>12) continue ;
			if(isLeap(year))
				
				days[1] = 29 ;
			else 
				days[1] = 28 ;
			
			if(day<1 || day>days[month-1]) continue ;
			
			StringBuilder sb = new StringBuilder(date[i]+"") ;
			sb.insert(4, '-') ;
			sb.insert(7, '-') ;
			
			if(!set.contains(sb.toString()))
				set.add(sb.toString()) ;
			
		}

		for(String s : set){
			
			System.out.println(s);
		}
		
	}

}
