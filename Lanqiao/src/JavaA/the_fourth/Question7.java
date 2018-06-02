package JavaA.the_fourth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月24日 上午8:36:21
 * 
 */
public class Question7 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.nextLine() ;
		
		String[] numString = new String[n] ;
		
		for(int i=0 ; i<n ; i++){
			
			numString[i] = scan.nextLine() ;
			
		}
		
		printResult(numString) ;
		
		scan.close() ;
	}
	
	
	public static void printResult(String[] s){
		
		ArrayList<Integer> nums = new ArrayList<Integer>() ;
		
		for(int i=0 ; i<s.length ; i++){
			
			String[] numLine = s[i].trim().split(" ") ;
			
			for(int j=0 ; j<numLine.length ; j++){
				
				nums.add(Integer.valueOf(numLine[j])) ;
				
			}
		}
		
		Collections.sort(nums);
		
		for(int i=0 ; i<nums.size()-1 ; i++){
			
			if(nums.get(i)+2 == nums.get(i+1)){
				
				System.out.print((nums.get(i)+nums.get(i+1))/2);
				
			}
			
			else if(nums.get(i) == nums.get(i+1)){
				
				System.out.print(" "+nums.get(i));
			}
		}
	}

}
