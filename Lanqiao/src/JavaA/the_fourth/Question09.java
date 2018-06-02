package JavaA.the_fourth;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月24日 上午10:32:10
 * 
 * 使用DFS从（0,0）顶点开始遍历
 */
public class Question09 {
	
	public static int[][] move ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}} ;//分别向下上右左移动一步
	
	public static int min = Integer.MAX_VALUE ;//用于存放最终输出结果
	
	public static int sum ;//矩阵中所有元素的和
	
	public static int n ; //矩阵的行
	
	public static int m ; //矩阵的列
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		m = scan.nextInt() ;
		n = scan.nextInt() ;
		
		int[][] nums = new int[n][m] ;
		boolean[][] flag = new boolean[n][m] ; //判断格子是否被遍历
		
		for(int i=0 ; i<n ; i++){
			
			for(int j=0 ; j<m ; j++){
				
				nums[i][j] = scan.nextInt() ;
				
				flag[i][j] = false ;
				
				sum += nums[i][j] ;
			}
		}
		
		if(sum%2 != 0){//当输入的数为奇数时，输出0，直接退出
			
			System.out.println("0");
			
			return ;
		}
		
		dfs(0, 0, flag, 0, 0, nums);
		
		if(min != Integer.MAX_VALUE){
			
			System.out.println(min);
			
		}else{
			
			System.out.println(0);
		}
		
		scan.close() ;
	}
	
	
	public static boolean check(int i, int j){
		
		if(i<0 || i>=n || j<0 || j>=m){
			
			return false ;
		}
		
		return true ;
	}
	
	public static void dfs(int i, int j, boolean[][] flag, int tempSum, int size, int[][] nums){
		
		if(check(i,j)){
			System.out.println(i+" "+j);
			
			//判断该格子是否已经被遍历
			if(flag[i][j]){
				
				return ;
				
			}else{
				
				flag[i][j] = true ;
				tempSum += nums[i][j] ;
				size ++ ;
			}
			
			if(tempSum * 2 == sum){
				
				if(min>size){
					
					min = size ;
				}
				
				return ;
			}
			
			//递归
			for(int k=0 ; k<4 ; k++){
				
				int x = i+move[k][0] ;
				int y = j+move[k][1] ;
				
				dfs(x, y, flag, tempSum, size, nums);
			}
			
			//进行回溯
			flag[i][j] = false ;
			tempSum -= nums[i][j] ;
			size -- ;
			
		}
	}

}
