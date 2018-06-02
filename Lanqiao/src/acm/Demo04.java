package acm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月6日 下午7:44:05
 * 
 */
public class Demo04 {
	
	public static void main(String[] args){
		/*
		String s = "A,2,3,4,5,6,7,8,9,10,J,Q,K" ;
		moveCard(s) ;
		
		gamble();
		
		System.out.println();
		String str ="abcdeefghhgfeiieje444k444lmn" ;
		maxS(str);
		
		
		generatePass();
		*/
		
		
		//question22(10, 90) ;
		question23() ;
		
	}
	
	public static void moveCard(String s){
		
		String[] str = s.split(",") ;
		
		List<String> data = new ArrayList<String>() ;
		
		for(String ss : str){
			
			data.add(ss) ;
		}
		
		List<String> result = new ArrayList<String>() ;
		
		while(data.size() > 0){
			
			data.add(data.remove(0)) ;
			result.add(data.remove(0)) ;
		}
		
		System.out.println(result);
		
	}
	
	public static void gamble(){
		
		int sum = 0 ;
		
		Random rand = new Random() ;
		
		for(int i = 0; i < 500000; i++){
			
			int a = rand.nextInt(6) + 1 ;
			int b = rand.nextInt(6) + 1 ;
			int c = rand.nextInt(6) + 1 ;
			int d = rand.nextInt(6) + 1 ;
			
			if(a==b && a==c && a == d){
				sum -= 6 ;
			}else if((a==b && b==c) || (a==b && b==d) || (a==c && c==d)){
				sum -= 2 ;
			}else if(a==b || a==c || a==d){
				sum -= 1 ;
			}else if((a*b == c*d) || (a*c == b*d) || (a*d == b*c)){
				sum += 0 ;
			}else{
				sum += 1 ;
			}
			
		}
		
		System.out.printf("%.3f", sum/500000f) ;
	}
	
	
	public static void maxS(String s){
		
		char[] c = s.toCharArray() ;
		String maxS = "" ;
		
		for(int i = 0; i < c.length - 1; i++){
			
			int mark = 0 ;
			
			String temp = "" ;
			
			if(c[i] == c[i+1]){
				
				for(; ;){
					if((i-mark < 0) || c[i-mark] != c[i+mark+1]) break ;
					mark ++ ;
				}
				
				temp = s.substring(i-mark+1, i+mark+1) ;
				
			}else if(i < c.length-2 && c[i] == c[i+2]){
				
				for(; ;){
					
					if((i-mark < 0) || c[i-mark] != c[i+mark+2]) break ;
					mark ++ ;
				}
				temp = s.substring(i-mark+1, i+mark+2) ;
			}
			
			if(temp.length() > maxS.length()){
				
				maxS = temp ;
				
			}
			
		}
		
		System.out.println(maxS);
	}

	//取球问题
	public static boolean ball(int n){
		
		if(n >= 1){
			
			switch(n){
				
				case 1 : return false ;
			
				case 3 : return false ;
				
				case 7 : return false ;
				
				case 8 : return true ;
				
				default : 
					
					return (!ball(n-8) || !ball(n-7) || !ball(n-3) || !ball(n-1)) ;
			
			}
			
			
		}else{
			
			return false ;
		}
		
		
	}
	
	//将字符串转化成密码
	public static void generatePass(){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.nextLine() ;
		
		while(n-- > 0){
			
			int one = 0 ;
			int two = 0 ;
			int three = 0 ;
			int four = 0 ;
			int five = 0 ;
			int six = 0 ;
			
			String str = scan.nextLine() ;
			
			char[] c = str.toCharArray() ;
			
			for(int i = 0; i < c.length; i ++){
				
				switch(i % 6){
				
				case 0 : one += c[i] ;
				break ;
				case 1 : two += c[i] ;
				break ;
				case 2 : three += c[i] ;
				break ;
				case 3 : four += c[i] ;
				break ;
				case 4 : five += c[i] ;
				break ;
				case 5 : six += c[i] ;
				
				}
				
			}
			
			while(one/10 != 0){
				one = one/100 + (one%100)/10 + (one%100)%10 ;
			}
			while(two/10 != 0){
				two = two/100 + (two%100)/10 + (two%100)%10 ;
			}
			while(three/10 != 0){
				three = three/100 + (three%100)/10 + (three%100)%10 ;
			}
			while(four/10 != 0){
				four = four/100 + (four%100)/10 + (four%100)%10 ;
			}
			while(five/10 != 0){
				five = five/100 + (five%100)/10 + (five%100)%10 ;
			}
			while(six/10 != 0){
				six = six/100 + (six%100)/10 + (six%100)%10 ;
			}
			
			System.out.println(one+""+two+three+four+five+six);
		}
		
		scan.close() ;
	}
	
	//微生物增殖
	public static void question22(int x, int y){
		
		for(int i = 1; i <= 120; i ++){
			
			if(i%2 == 1){
				
				y -= x ;
				
			}
			if(i%6 == 0){
				
				x = x*2 ;
				
			}
			if(i%4 == 0){
				
				y = y*2 ;
				
			}
		}
		
		System.out.println(y);
		
	}
	
	
	//信用卡号校验
	public static void question23(){
		
		Scanner scan = new Scanner(System.in) ;
		
		String str = scan.nextLine() ;
		
		StringBuilder sb = new StringBuilder() ;
		
		sb.append(str) ;
		
		sb.reverse() ;

		char[] c = sb.toString().toCharArray() ;
		
		int n1 = 0 ;
		int n2 = 0 ;
		
		for(int i = 1; i <= c.length; i ++){
			
			if(i%2 == 0){
				
				int a = (int)(c[i-1] - '0') * 2 ;
				
				if(a/10 != 0){
					a = a-9 ;
				}
				
				n1 += a ;
				
			}else{
				n2 += (int)(c[i-1] - '0') ;
			}
		}
		
		if((n1+n2)%10 == 0){
			
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}
		
		scan.close() ;
	}
}
