package JavaA;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author 64621 -- lzcai
 * @time 2018年3月16日 下午5:34:56
 * 
 */
public class ChildrenQueue {
	
	public static int[] c ;
	
	public static int lowbit(int x){
		
		return x & -x ;
		
	}
	
	//对节点的只进行更新，在本算法中对节点的值进行+1，若该节点已插入数据将该节点的值+1
	public static void add(int x){
		
		while(x < c.length){
			
			c[x] ++ ;
			
			x += lowbit(x) ;
			
		}
		
	}
	
	//树状数组求前i项的和
	public static int getsum(int x){
		
		int sum = 0 ;
		
		while(x > 0){
			
			sum += c[x] ;
			
			x -= lowbit(x) ;
		}
		
		return sum ;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int[] a = new int[n+1] ;
		
		for(int i=1 ; i <= n ; i++){
			
			a[i] = scan.nextInt() ;
			a[i] ++ ;
			
		}
		
		//存储树状数组的值
		c = new int[1000000+1] ;
		//存储每个小朋友身高对应的逆序数
		int[] result = new int[n+1] ;
		
		/*
		 * 1、从序列的最后开始逐个插入小朋友的身高，若其前面已经有值插入，则说明在小朋友i之后有比他矮的
		 * 对其前面所有值进行求和，即得出该小朋友后面比其矮的同学的逆序数。
		 */
		for(int i=n ; i>0 ; i--){
			
			result[i] += getsum(a[i]-1) ;//a[i]-1表示求i之前的和，不包括i本身
			
			add(a[i]) ;//更新树状数组中的值
		}
		
		Arrays.fill(c, 0);//清空树状数组
		
		/*
		 * 2、从序列的最前面开始逐个插入小朋友的身高，若其后面已经有值插入，则表示在小朋友i之前有比他高的
		 * 对其后面的所有值进行求和(i-1-getsum(a[i])，记得出该小朋友前面比其高的同学的逆序数。
		 */
		for(int i=1 ; i<=n ; i++){
			
			result[i] += i-1-getsum(a[i]) ;
			
			add(a[i]) ;
		}
		
		long score = 0 ;
		//求解最小满意度
		for(int i=1 ; i<=n ; i++){
			
			score += 1l * (result[i]+1)*result[i]/2 ;
			
		}
		
		System.out.println(score);
		
		scan.close() ;
		
		
	}
	


}
