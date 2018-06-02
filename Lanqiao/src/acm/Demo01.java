package acm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2017年12月6日 上午10:51:35
 * 
 */
public class Demo01 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		String str = scan.nextLine() ;
		
		String[] words = str.split("\\s") ; //以任意一个空白字符作为分割点，对字符串进行分割
		
		System.out.println(Arrays.toString(words));
		
		for(String word: words){
			
			if(!word.equals("")){
				
				char[] w = word.toCharArray() ;//将每一个单词转化为char数组
				
				for(int i=0; i < w.length; i++){
					
					if(w[i]<'0' || w[i]>'9'){//字母
						
						if(i == 0){//第一个字母
							System.out.print((char)(w[i]-32));
						}else{
							
							if(w[i-1]>='0' && w[i-1]<='9'){
								System.out.print("_");
								System.out.print(w[i]);
							}else{
								System.out.print(w[i]);
							}
							
						}
						
						
					}else{//数字
						
						if(i == 0){
							
							System.out.print(w[i]);
							continue ;
						}
						
						if(w[i-1]>='0' && w[i-1]<='9'){
							System.out.print(w[i]);
						}else{
							System.out.print("_");
							System.out.print(w[i]);
						}
					}
					
				}
				
				System.out.print(" ");
				
			}
		}
		
		scan.close(); 
	}

}
