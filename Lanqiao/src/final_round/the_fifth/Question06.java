package final_round.the_fifth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月12日 上午10:23:37
 * 
 */
public class Question06 {

	public static int n, m, k ;
	public static double[][] value ;
	
	public static void printResult(){
		
		int max = 0 ;
		
		//循环遍历添加向左水渠，并记录最大值
		for(int i=1 ; i<n ; i++){
			
			//如果该水渠向左为空，则新建一条向左水渠
			if(value[i][i+1] == 0){
				
				ArrayList<Double> threshold = new ArrayList<Double>() ;
				
				if(value[i-1][i] != 0){
					
					threshold.add(value[i-1][i]-1) ;
					threshold.add(value[i-1][i]) ;
					threshold.add(value[i-1][i]+1) ;
					
				}
				
				if(i+2 < n+2 && value[i+1][i+2] != 0){
					
					threshold.add(value[i+1][i+2]-1) ;
					threshold.add(value[i+1][i+2]) ;
					threshold.add(value[i+1][i+2]+1) ;
					
				}
				
				for(int z=0 ; z<threshold.size() ; z++){
					
					int total = 0 ; //记录在本次情况下
					
					value[i][i+1] = threshold.get(z) ;
					
					for(int j=1 ; j<=n ; j++){
						
						total ++ ;
						
						int t = j ;
						
						if(t<n && value[t][t+1] != 0){
							
							total ++ ;
							
							t ++ ;
							
						while(t<n){
							
							if(value[t][t+1] != 0 && value[t][t+1] >= value[t-1][t]){
								
								total ++ ;
								
								t++ ;
								
							}else{
								
								break ;
							}
						}
						
						}
						
						t = j ;
						
						if(value[t][t-1] != 0){
							
							total ++ ;
							
							t -- ;
							
							while(t>=1){
								
								if(value[t][t-1] != 0 && value[t+1][t]<=value[t][t-1]){
									
									total ++ ;
									
									t -- ;
									
								}else{
									
									break ;
								}
							}
						}
					}
					
					
					if(max < total){
						
						max = total ;
					}
					
				}
				
				//释放
				value[i][i+1] = 0 ;
				
			}
			
		}
		
		
		System.out.println(max);
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextInt() ;
		m = scan.nextInt() ;
		k = scan.nextInt() ;
		
		value = new double[n+1][n+1] ;
		
		for(int i=0 ; i<m ; i++){
			
			int x = scan.nextInt() ;
			double y = scan.nextDouble() ;
			int d = scan.nextInt() ;
				
			if(d == 0){
				
				value[x][x-1] = y ;
				
			}else{
				
				value[x][x+1] = y ;
			}
			
		}
		
		printResult();
		
		scan.close() ; 
	}

}
