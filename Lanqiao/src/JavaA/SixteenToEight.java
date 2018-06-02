package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月11日 下午2:45:24
 * 
 */
public class SixteenToEight {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		scan.nextLine() ;
		
		for(int i=0 ; i < n ; i ++){
			
			 String line  = scan.nextLine();
			
			char[] numChar = line.toCharArray() ;
			
			int index = 0 ;
			int sum = 0 ;
			
			int lambd = 0 ;
			
			//将十六进制转换为十进制
			for(int j=numChar.length-1; j>=0; j--){
				
				System.out.println(numChar[j]);
				
				switch(numChar[j]){
				
				case '0':
					
					lambd = 0 ;
					break ;
				case '1':
					
					lambd = 1 ;
					break ;
				case '2':
					
					lambd = 2 ;
					break ;
				case '3':
	
					lambd = 3 ;
					break ;
				case '4':
	
					lambd = 4 ;
					break ;
				case '5':
					
					lambd = 5 ;
					break ;
				case '6':
					
					lambd = 6 ;
					break ;
				case '7':
					
					lambd = 7 ;
					break ;
				case '8':
					
					lambd = 8 ;
					break ;
				case '9':
	
					lambd = 9 ;
					break ;
				
				case 'A':
					
					lambd = 10 ;
					break ;
				case 'B':
					
					lambd = 11 ;
					break ;
				case 'C':
					
					lambd = 12 ;
					break ;
				case 'D':
	
					lambd = 13 ;
					break ;
				case 'E':
	
					lambd = 14 ;
					break ;
				case 'F':
					
					lambd = 15 ;
					break ;
				
				}
				
				sum += Math.pow(16, index) * lambd ;
				
				index++ ;
			}
			
			StringBuilder sb = new StringBuilder() ;
			
			//将十进制转换为八进制
			while(true){
				
				if(sum < 8){
					
					sb.append(sum) ;
					
					break ;
				}else{
					
					sb.append(sum%8) ;
					
					sum = sum/8 ;
					
				}
				
			}
			
			sb.reverse() ;
			System.out.println(sb);
			
		}
		
		
		scan.close() ;
		
		
	}

}
