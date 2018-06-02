package JavaA.the_sixth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月27日 上午10:17:52
 * 
 */
public class Question09 {
	
	public static int[] backN = {0, 4, 5, 6, 1, 2, 3} ; //定义骰子顶面的反面数组，例如：1的反面为4
	
	public static BigInteger mod = new BigInteger("1000000007") ;
	
	//计算a的n次方，使用二进制进行循环运算
	public static BigInteger getAofN(BigInteger a, int n){
		
		BigInteger temp = a ;
		
		BigInteger result = BigInteger.ONE ;
		
		while(n > 0){
			
			if((n & 1) == 1) result = result.multiply(temp).mod(mod); 
			
			temp = temp.multiply(temp).mod(mod) ;
			
			n = n >> 1 ;
			
		}
		
		return result ;
	}
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;//获取骰子的个数
		
		int m = scan.nextInt() ;//m行数据定义了相互排斥的骰子面
		
		boolean[][] mat = new boolean[7][7] ;//存放相互排斥的点对信息，相互排斥为true
		
		for(int i=0 ; i<m ; i++){ //读取骰面的互斥信息并进行存储
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			
			mat[a][b] = mat[b][a] = true ;
			
		}
		
		BigInteger[][] dp = new BigInteger[n+1][7] ;//存放当有i个骰子，j点数面朝上的方案数
		
		for(int i=1 ; i<=n ; i++){
			
			for(int j=1 ; j<=6 ; j++){
				
				dp[i][j] = BigInteger.ZERO ;
			}
		}
		
		for(int i=1 ; i<=6 ; i++){ //当只有一颗骰子时，每种点数面朝上的方案只有一种，根据方向不同*4（最后实现）
			
			dp[1][i] = BigInteger.ONE ;
		}
		
		//状态转移，根据i-1个骰子的方案数，来推导出i个骰子的方案数
		for(int i=2 ; i<=n ; i++){
			
			for(int j=1 ; j<=6 ; j++){
				
				for(int k=1 ; k<=6 ; k++){
					
					if(mat[backN[j]][k] == false){ //如果第i个骰子的j的反面（j面朝上）与k面不想互斥
						
						dp[i][j] = dp[i][j].add(dp[i-1][k]) ;//j面朝上的方案数，等于（i-1）中所有不与其互斥的方案和
						
						dp[i][j] = dp[i][j].mod(mod) ;
						
					}
				}
			}
		}
		
		BigInteger result = BigInteger.ZERO ;
		
		for(int i=1 ; i<=6 ; i++){
			
			result = result.add(dp[n][i]).mod(mod) ;
			
		}
		
		BigInteger count = getAofN(new BigInteger("4"), n) ;
		
		result = result.multiply(count).mod(mod) ;
		
		scan.close(); 
		
		System.out.println(result);
		
	}

}
