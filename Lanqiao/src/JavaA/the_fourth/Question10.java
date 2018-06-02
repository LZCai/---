package JavaA.the_fourth;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月24日 下午3:54:06
 * 
 * 大臣的旅费
 */
public class Question10 {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[][] mat = new int[n+1][n+1] ;
		
		for(int i=1 ; i<=n ; i++){
			
			for(int j=1 ; j<=n ; j++){
				
				mat[i][j] = -1 ;//初始化距离矩阵，各城市之间不可达
				
			}
		}
		
		for(int i=1 ; i<n ; i++){
			
			int x = scan.nextInt() ;
			int y = scan.nextInt() ;
			int value = scan.nextInt() ;
			
			mat[x][y] = mat[y][x] = value ;
			
		}
		
		printResult(mat) ;
		
		scan.close(); 
	}
	
	//计算任意两个大城市之间的距离
	public static void floyd(int[][] mat){
		
		int len = mat.length ;
		
		for(int k=1 ; k<len ; k++){
			
			for(int x=1 ; x<len ; x++){
				
				for(int y=1 ; y<len ; y++){
					
					if(x == y) continue ;
					
					if(mat[x][k] != -1 && mat[k][y] != -1){
						
						if(mat[x][y] == -1 || mat[x][y] > mat[x][k] + mat[k][y]){
							
							mat[x][y] = mat[x][k] + mat[k][y] ;
						}
					}
						
				}
			}
		}
	}
	
	public static void printResult(int[][] mat){
		
		floyd(mat) ;
		
		
		int max = 0;
		
		for(int x=1 ; x<mat.length ; x++){
			
			for(int y=1 ; y<mat.length ; y++){
				
				if(mat[x][y] > max){
					
					max = mat[x][y] ;
				}
			}
		}
		
		int cost = 10 * max + max*(1+max)/2 ;
		
		System.out.println(cost);
	}
}
