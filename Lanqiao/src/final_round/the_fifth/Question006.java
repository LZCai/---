package final_round.the_fifth;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月12日 下午2:55:12
 * 
 */
public class Question006 {
	
	public static int n, m, k ;
	
	public static double[][] value ;
	
	//模拟算法
	public static void getResult(){
		
		int max = 0 ;
		
		for(int i=1 ; i<n ; i++){
			
			if(value[i][i+1] == 0){
				
				//确定水渠的位置，y值
				ArrayList<Double> th = new ArrayList<Double>() ;
				
				if(value[i-1][i] != 0){
					
					th.add(value[i-1][i] - 1) ;
					th.add(value[i-1][i]) ;
					th.add(value[i-1][i] + 1) ;
				}
				
				if(i+2 <= n && value[i+1][i+2] != 0){
					
					th.add(value[i+1][i+2] - 1) ;
					th.add(value[i+1][i+2]) ;
					th.add(value[i+1][i+2] + 1) ;
				}
				
				for(int j=0 ; j<th.size() ; j++){
					
					value[i][i+1] = th.get(j) ;//对水渠的初始位置进行赋值
					
					int total = 0 ; //记录每种情况下，所有水渠可达的居民点总数
					
					//循环计算每条水渠的可达居民数
					for(int z=1 ; z<=n ; z++){
						
						total ++ ; //直线可达
						
						//向右可达
						int c = z ;
						if(c<n && value[c][c+1] != 0){
							
							total ++ ;
							c ++ ;
							
							while(c<n){
								
								if(value[c][c+1] != 0 && value[c][c+1] >= value[c-1][c]){
									
									total ++ ;
									c++ ;
									
								}else{ 
									
									break ;
								}
									
							}
						}
						
						//向左可达
						c = z ;
						if(value[c][c-1] != 0){
							
							total ++ ;
							c -- ;
							
							while(c>=1){
								
								if(value[c][c-1] != 0 && value[c][c-1] >= value[c+1][c]){
									
									total ++ ;
									c -- ;
									
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
		
		getResult() ;
		
		scan.close() ;
	}

}
