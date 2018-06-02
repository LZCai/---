package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月21日 下午4:13:35
 * 
 * 
 * 问题描述
　　观察这个数列：
　　1 3 0 2 -1 1 -2 ...

　　这个数列中后一项总是比前一项增加2或者减少3。

　　栋栋对这种数列很好奇，他想知道长度为 n 和为 s 而且后一项总是比前一项增加a或者减少b的整数数列可能有多少种呢？
输入格式
　　输入的第一行包含四个整数 n s a b，含义如前面说述。
输出格式
　　输出一行，包含一个整数，表示满足条件的方案数。由于这个数很大，请输出方案数除以100000007的余数。
样例输入
4 10 2 3
样例输出
2
样例说明
　　这两个数列分别是2 4 1 3和7 4 1 -2。
数据规模和约定
　　对于10%的数据，1<=n<=5，0<=s<=5，1<=a,b<=5；
　　对于30%的数据，1<=n<=30，0<=s<=30，1<=a,b<=30；
　　对于50%的数据，1<=n<=50，0<=s<=50，1<=a,b<=50；
　　对于70%的数据，1<=n<=100，0<=s<=500，1<=a, b<=50；
　　对于100%的数据，1<=n<=1000，-1,000,000,000<=s<=1,000,000,000，1<=a, b<=1,000,000。
 */
public class BoDong_Sreies {
	//数列的长度
	public static int n ;
	//数列的和
	public static int s ;
	
	public static int a ;
	
	public static int b ;
	//计数，满足的数列总数
	public static int count ;

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		n = scan.nextInt() ;
		
		s = scan.nextInt() ;
		
		a = scan.nextInt() ;
		
		b = scan.nextInt() ;
		
		scan.close(); 
		
		for(int i=(s-(n*(n-1)/2)*a)/n ; i <=(s+(n*(n-1)/2)*b)/n ; i++){
			
			run(2, i+a, i) ;
			run(2, i-b, i) ;
		}
		
		System.out.println(count%100000007);
		
	}
	
	
	/**
	 * 递归执行
	 * @param i
	 * @param num
	 * @param sum
	 */
	public static void run(int i, long num, long sum){
		
		if(i > n) return ;
		
		sum += num ;
		
		if(i == n && s == sum){
			
			count ++ ;

			return ;
		}
		
		run(i+1, num+a, sum) ;
		run(i+1, num-b, sum) ;
	}
}
