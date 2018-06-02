package JavaA.the_sixth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月26日 下午4:04:15
 * 
 */
public class Question02 {
	
	public static void main(String[] args){
		
		Calendar c = new GregorianCalendar(2014, 10, 9) ;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd") ;
		
		System.out.println(df.format(c.getTime()));
		
		c.add(Calendar.DAY_OF_YEAR, 1000);
		
		Date date = c.getTime() ;
		
		System.out.println(df.format(date)) ;
	}

}
