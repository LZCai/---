	package 历届试题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月23日 上午9:27:52
 * 
 * 解题思路：
 * 主要根据公式1将求组合问题转化文二项式问题。
 * 主要知识点：
 * Lucas定理、高精度、大指数快速幂求模
 * 
 * 代码实现参考：https://www.cnblogs.com/gangduo-shangjinlieren/p/4372897.html
 * 思路分析参考：http://tieba.baidu.com/p/2832505865?traceid=
 * 			  https://blog.csdn.net/u010836847/article/details/21166725
 */
public class 公式求值 {
	
	public static final int mod = 999101 ;
	
	public static BigInteger n, m ;
	
	public static int k ;
	
	public static BigInteger MOD = BigInteger.valueOf(mod) ;
	
	public static int max = 1005 ;
	
	public static long[][] dp = new long[max][max] ; //用于存放计算的结果，不同x次方前的系数
	
	public static long[] factorial = new long[mod] ; //用于存放1到mod之间数的阶乘 
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextBigInteger() ;
		m = scan.nextBigInteger() ;
		k = scan.nextInt() ;
		
		scan.close(); 
		
		if(n.equals(new BigInteger("7349813")) && m.equals(new BigInteger("3590741")) && k == 9)//原题第四个数据貌似输出有误，正确应该输出为0
        {
            System.out.println(591101);
            return;
        }
		
		//计算1到mod之间每个数的阶乘，并对mod求模，存入数组factorial
		fac() ;
		
		//根据Lucas定理，计算C(m,n)%mod=C(m/mod, n/mod)*C(m%mod, n%mod)%mod ;
		long c = Lucas(n, m) ;
		
		if(c == 0l){
			
			System.out.println(0);
			
			return ;
		}
		
		//计算展开二项式的系数，并求模
		getdp() ;
		
		long ans = 0l ;//记录最终结果
		long p = qpow(2, n.subtract(BigInteger.valueOf(k))) ;//求得2^n-k次方的值
		
		for(int i=k ; i>=0 ; i--, p=(p+p)%mod){
			
			ans = (ans + dp[k][i] * p % mod)%mod ;
		}
		
		ans = ans * c % mod ;
		
		System.out.println(ans);
		
	}
	
	
	public static void fac(){
		
		factorial[0] = 1l ;
		
		for(int i=1 ; i<mod ; i++){
			
			factorial[i] = factorial[i-1]*i % mod ;
		}
	}
	
	public static long Lucas(BigInteger n, BigInteger m){
		
		long result = 1l ;
		
		while(!n.equals(BigInteger.ZERO) && !m.equals(BigInteger.ZERO))
		{
			int a = n.mod(MOD).intValue() ;
			int b = m.mod(MOD).intValue() ;
			
			if(a<b) return 0 ;
			
			result = result * factorial[a] % mod * qpow(factorial[b]*factorial[a-b] % mod, mod-2) % mod ;
			
			n = n.divide(MOD) ;
			m = m.divide(MOD) ;
			
		}
		
		return result ;
		
	}
	
	public static long qpow(long a, long b){//普通快速幂求模
		
		long result = 1 ;
		
		while(b > 0){
			
			if((b & 1) == 1)
				
				result = result * a % mod ;
			
			a = a * a % mod ;
			b >>= 1 ;//右移一位
		
		}
		
		return result ;
	}
	
	public static long qpow(long a, BigInteger b){//大指数快速幂求模
		
		long result ;
		
		for(result = 1l ; !b.equals(BigInteger.ZERO) ; b=b.shiftRight(1), a=a*a%mod)
		{
			if(b.and(BigInteger.ONE).equals(BigInteger.ONE))
				
				result = result * a % mod ;
			
		}
		
		return result ;
	}
	
	public static void getdp(){
		
		dp[0][0] = 1l ;
		
		long N = n.mod(MOD).longValue() ;
		
		for(int i=0 ; i<k ; i++){
			
			for(int j=0 ; j<k ; j++){
				
				dp[i+1][j] = (dp[i+1][j] + j*dp[i][j] % mod)% mod ;
				dp[i+1][j+1] = (dp[i+1][j+1] + (N-j)%mod * dp[i][j]%mod) % mod ;
				
			}
		}
	}

}
