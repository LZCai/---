package 历届试题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年5月22日 下午8:31:06
 * 
 * 
 *解题思路：并查集
 *
 *首先根据各个岛屿之间每座桥的使用天数进行降序排序（因为使用天数较小的桥断裂后，居民开始进行抗议），
 *然后使用并查集判断两个岛屿是否连接,分两种情况：
 *1、如两个岛屿之前没有连接，那么抗议+1，因为桥的使用天数是递减的，所以该桥的使用天数为两个岛屿连接的最大天数，
 *当桥断裂时，居民会进行抗议；
 *2、若两个岛屿之间已经进行连接，因为本次连接天数小于上次天数(即使本次连接的桥断裂，还存在使用天数较长的另外一条)，
 *所以不进行抗议。
 *
 *注意：因为求解的是居民的抗议天数，因此再判断两个岛屿是否连接的同时，要判当天是否有居民抗议，若有，则++一次即可。
 */
public class 国王的烦恼 {
	
	public static Bridge[] bs ;
	
	public static int[] head ;
	
	public static int find(int x){
		
		if(head[x] == x)
			
			return x ;
		
		else
			
			return head[x] = find(head[x]) ;
	}
	
	public static boolean Union(int x, int y){
		
		int hx = find(x) ;
		int hy = find(y) ;
		
		if(hx == hy)
			
			return false ;
		
		else{
			
			head[hx] = hy ;
			
			return true ;
		}
			
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int m = scan.nextInt() ;
		
		head = new int[n+5] ;
		bs = new Bridge[m+5] ;
		
		for(int i=1 ; i<=n ; i++){//初始化并查集
			
			head[i] = i ;
		}
		
		for(int i=0 ; i<m ; i++){//初始化桥数据数组
			
			int a = scan.nextInt() ;
			int b = scan.nextInt() ;
			int day = scan.nextInt() ; 
			
			bs[i] = new Bridge(a, b, day) ;
		}
		
		scan.close(); 
		
		Arrays.sort(bs, 0, m);//按照桥的使用天数进行降序排序
		
		int prev_day = -1 ;//前一个抗议的天数，同一天内的抗议只计算一次
		
		int ans = 0 ; //记录居民抗议的天数
		
		for(int i=0 ; i<m ; i++){
			
			if(Union(bs[i].a, bs[i].b) && bs[i].day != prev_day){
				
				ans ++ ;
				prev_day = bs[i].day ;
				
			}
		}
		
		System.out.println(ans);
	}

}

class Bridge implements Comparable<Bridge>{
	
	int a ;  //岛屿a
	int b ;  //岛屿b
 	int day ;  //桥的使用天数
 	
 	public Bridge(int a, int b, int day){
 		
 		this.a = a ;
 		this.b = b ;
 		this.day = day ;
 	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Bridge o) {
		// TODO Auto-generated method stub
		if(this.day > o.day)
			
			return -1 ;
		
		else 
			
			return 1;
	}
	
	public String toString(){
		
		return day+"" ;
	}
}
