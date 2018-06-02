package final_round.the_fifth;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月11日 上午9:58:27
 * 
 */
/*
 * 如果用a b c d这4个字母组成一个串，有4!=24种，如果把它们排个序，每个串都对应一个序号：
  abcd  0
  abdc  1
  acbd  2
  acdb  3
  adbc  4
  adcb  5
  bacd  6
  badc  7
  bcad  8
  bcda  9
  bdac  10
  bdca  11
  cabd  12
  cadb  13
  cbad  14
  cbda  15
  cdab  16
  cdba  17
  ...

    现在有不多于10个两两不同的小写字母，给出它们组成的串，你能求出该串在所有排列中的序号吗？
 */
public class Question04 {
	
	public static String str ;
	
	public static int count ;
	
	public static void swap(char[] seq, int i, int j){
		
		char s = seq[i] ;
		seq[i] = seq[j] ;
		seq[j] = s ;
		
	}
	
	public static void dfs(char[] seq, int step){
		
		if(step == seq.length){
			
			count ++ ;
			
			String s = "" ;
			
			for(int i=0 ; i<seq.length ; i++){
				
				s += seq[i] ;
			}
			
			if(s.equals(str)){
				
				System.out.println(count-1);
				
				return ;
			}
			
		}else{
			
			for(int i=step ; i<seq.length ; i++){
				
				swap(seq, i, step) ;
				dfs(seq, step+1) ;
				swap(seq, i, step) ;
			}
		}
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		str = scan.nextLine() ;
		
		char[] seq = new char[str.length()] ;
		
		char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'} ;
		
		for(int i=0 ; i<seq.length ; i++){
			
			seq[i] = c[i] ;
		}
		
		dfs(seq, 0) ;
		
		scan.close(); 
		
	}

}
