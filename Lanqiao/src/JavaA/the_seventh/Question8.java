package JavaA.the_seventh;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月28日 下午3:35:39
 * 
 */
public class Question8 {
	
	public static int[] a = new int[3] ; //存放每次能取球的个数集合
	public static int[] b = new int[5] ; //每次球的总数
	
	public static int dfs(int b, int user1, int user2){
		
		boolean is0 = false ;
		
		if(b-a[0]<0 && b-a[1]<0 && b-a[2]<0){//表示已经达到终止条件，不能再取球
			
			if(user1%2 == 1 && user2%2 == 0) return 1 ;
			if(user1%2 == 1 && user2%2 == 1) return 0 ;
			if(user1%2 == 0 && user2%2 == 0) return 0 ;
			if(user1%2 == 0 && user2%2 == 1) return -1 ;
			
		}
		
		for(int i=0 ; i<a.length ; i++){
			
			if(b-a[i]>=0){//表示剩余的球大于取球的数量，继续取球
				
				int n = dfs(b-a[i], user2, user1+a[i]) ;
				
				if(n == -1) return 1 ; // 返回-1说明第二个人取球个数为偶数，第一个人为奇数，所以第一个人能获胜，因此直接返回1.
				
				if(n == 0) is0 = true ;// 返回0说明两个人逼平，这时第一个人可以调整策略(for循环的其它情况)，寻找最优解
			}
			
		}
		
		if(is0){ //如果各种情况下，第一个人没有获胜（return 1），并且存在逼平的情况，那么直接返回0.
			
			return 0 ;
		}
		
		return -1 ; //如果医生所有情况下，第一个人不存在获胜和逼平的情况，那么直接返回-1，第二个人获胜。
	}
	
	
	public static void main(String[] args){
		
		boolean is_1 = false ;
		boolean is_0 = false ;
		
		Scanner scan = new Scanner(System.in) ;
		
		for(int i=0 ; i<a.length ; i++){
			
			a[i] = scan.nextInt() ;
		}
		
		for(int j=0 ; j<b.length ; j++){
			
			b[j] = scan.nextInt() ;
		}
		
		scan.close(); 
		
		for(int k=0 ; k<b.length ; k++){
			
			int num_b = b[k] ; 
			int user1 = 0 ;
			int user2 = 0 ;
			
			for(int i=0 ; i<a.length ; i++){
				
				if(num_b-a[i]>=0){
					
					int n = dfs(num_b-a[i], user2, user1+a[i]) ;
					
					if(n == -1){ //返回-1，说明第一个人获胜，运行，直接跳出本次循环。
						
						is_1 = true ;
						
						break ;
					}
					if(n == 0){  //返回0，说明本次情况下，两人逼平，第一个人使用下一种策略
						
						is_0 = true ;
						
						continue ;
					}
				}
			}
			
			if(is_1){//获胜
				
				is_1 = false ;
				is_0 = false ;
				System.out.print("+ ");
				
			}else if(is_0){//平局
				
				is_0 = false ;
				
				System.out.print("0 ");
				
			}else{//输
				
				System.out.print("- ");
			}
		}
	}

}
