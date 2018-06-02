package JavaA;

import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月16日 下午3:03:04
 * 
 */
public class LantonAnt {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		//方格的长和宽
		int m = scan.nextInt() ;
		int n = scan.nextInt() ;
		
		//定义平面方格
		int[][] cells = new int[m][n] ;
		//获取每个方格的颜色，0白色，1黑色
		for(int i=0 ; i<m ; i++){
			
			for(int j=0 ; j<n ; j++){
				
				cells[i][j] = scan.nextInt() ;
			}
		}
		
		//获得蚂蚁的初始坐标
		int x = scan.nextInt() ;
		int y = scan.nextInt() ;
		
		//蚂蚁的方向
		char s = scan.next().charAt(0) ;
		
		//蚂蚁行走的步数
		int strides = scan.nextInt() ;
		scan.close(); 
		
		//求解蚂蚁行走strides步后的位置
		for(int i=0 ; i<strides ; i++){
			
			//蚂蚁当前处在白格子中,左转90度，将该格改为黑格，并向前移一格。
			if(cells[x][y] == 0){
				
				switch(s){
				
				case 'U':
					s = 'L' ;
					cells[x][y] = 1 ;
					y = y-1 ;
					
					break ;
				case 'D':
					s = 'R' ;
					cells[x][y] = 1 ;
					y = y+1 ;
					
					break ;
				case 'L':
					s = 'D' ;
					cells[x][y] = 1 ;
					x = x+1 ;
					
					break ;
				case 'R':
					s = 'U' ;
					cells[x][y] = 1 ;
					x = x-1 ;
					
				}
				
			}
			
			//蚂蚁当前在黑格子中,右转90度，将该格改为白格，并向前移一格；
			else if(cells[x][y] == 1){
				
				switch(s){
				
				case 'U':
					s = 'R' ;
					cells[x][y] = 0 ;
					y = y+1 ;
					
					break ;
				case 'D':
					s = 'L' ;
					cells[x][y] = 0 ;
					y = y-1 ;
					
					break ;
				case 'L':
					s = 'U' ;
					cells[x][y] = 0 ;
					x = x-1 ;
					
					break ;
				case 'R':
					s = 'D' ;
					cells[x][y] = 0 ;
					x = x+1 ;
					
				}
			}
			
		}
		
		System.out.println(x + " " + y);
	}

}
