package JavaA.the_fourth;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月22日 下午10:12:39
 * 
 * 
 * 标题: 世纪末的星期


    曾有邪教称1999年12月31日是世界末日。当然该谣言已经不攻自破。

    还有人称今后的某个世纪末的12月31日，如果是星期一则会....

    有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一!! 

    于是，“谣言制造商”又修改为星期日......

    1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？

    请回答该年份（只写这个4位整数，不要写12月31等多余信息）

  2299(使用Excel表格解答，选择格式中时间输出为星期几，然后在表格式输入XX99-12-31，输出星晴天则为所求)
 */
public class Question01 {
	
	public static void main(String[] args){
		
		int year = 2099 ;
		
		for(; ; year +=100){
			
			Calendar c = new GregorianCalendar(year, 11, 31) ;
			
			if(c.get(Calendar.DAY_OF_WEEK) == 1){
				
				System.out.println(year);
				
				break ;
			}
		}
		
		execute(); 
	}
	
	public static void execute(){
		
		int year = 2000 ;
		int total = 0 ;
		
		for(; ; year ++){
			
			if(year % 400 ==0 ||(year % 4 == 0 && year % 100 != 0)){
				
				total += 366 ;
			}else{
				
				total += 365 ;
			}
			
			if((total + 5) % 7 == 0 && (year + "").endsWith("99")){
				
				System.out.println(year);
				
				break ;
			}
		}
		
	}

}
