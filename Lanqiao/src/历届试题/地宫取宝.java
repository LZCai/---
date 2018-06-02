package 历届试题;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月11日 上午9:46:10
 * 
 */
public class 地宫取宝 {
	
	public static final int MOD = 1000000007 ;
	public static int[][][][] dp = new int[51][51][15][15] ;;
	public static int[][] value = new int[51][51] ;
	
	public static int n, m, k ;
	
	public static int dfs(int x, int y, int num, int max_val){
		
		if(dp[x][y][num][max_val+1] != -1){//如果该情况已经遍历，则直接输出答案
			
			return dp[x][y][num][max_val+1] ;
		}
		
		if(x==n && y==m){//到达出口
			
			if(num==k || (num==k-1 && max_val<value[x][y])){//两种情况：1.最后一个宝物不取，2.取走最后一个宝物
				
				return dp[x][y][num][max_val+1] = 1 ;
				
			}else{
				
				return dp[x][y][num][max_val+1] = 0 ;
			}
			
		}
		
		long s = 0 ;
		
		if(x+1 <= n){
			
			if(max_val < value[x][y])
				
				s += dfs(x+1, y, num+1, value[x][y]) ;
			
			s += dfs(x+1, y, num, max_val) ;
			
		}
		
		if(y+1 <= m){
			
			if(max_val < value[x][y])
				
				s += dfs(x, y+1, num+1, value[x][y]) ;
			
			s += dfs(x, y+1, num, max_val) ;
		}
		
		return dp[x][y][num][max_val+1] = (int) s%MOD ;
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextInt() ;
		m = scan.nextInt() ;
		k = scan.nextInt() ;
		
		for(int i=1 ; i<=n ; i++){//初始化地宫
			
			for(int j=1 ; j<=m ; j++){
				
				value[i][j] = scan.nextInt() ;
			}
			
		}
		
		for(int x=0 ; x<51 ; x++){
			
			for(int y=0 ; y<51 ; y++){
				
				for(int num=0 ; num<15 ; num++){
					
					for(int val=0 ; val<15 ; val++){
						
						dp[x][y][num][val] = -1 ;
					}
				}
			}
		}
		
		dfs(1, 1, 0, -1) ;
		
		System.out.println(dp[1][1][0][0]);
		
		scan.close();
	}

}
