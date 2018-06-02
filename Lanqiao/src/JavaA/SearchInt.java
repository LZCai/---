package JavaA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月13日 下午2:31:08
 * 
 * 查找数列中给定的某个整数
 */
public class SearchInt {
	
	public static double time = 0 ;
	
	public static double time_part1 = 0 ;

	/*
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		List<Integer> list = new ArrayList<Integer>() ;
		
		for(int i=0 ; i<n ; i++){
			
			list.add(scan.nextInt()) ;
			
		}
		
		int num = scan.nextInt() ;
		
		scan.close(); 
		
		if(list.contains(num)){
			
			System.out.println(list.indexOf(num)+1);
			
		}else{
			
			System.out.println(-1);
		}
	}
	*/
	
	/*
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int max = 0 ;
		int min = 0 ;
		int sum = 0 ;
		
		for(int i=0 ; i<n ; i++){ 
			
			int num = scan.nextInt() ;
			
			if(i == 0){
				
				max = min = num ;
				
			}else{
				
				if(num>max){
					
					max = num ;
					
				}
				
				if(num < min){
					
					min = num ;
				}
				
			}
			
			sum += num ;
		}
		
		scan.close() ;
		
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
		
	}
	*/
	
	/*
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int m = scan.nextInt() ;
		
		scan.close() ;
		
		char A = 'A' ;
		
		for(int i=0 ; i<n ; i++){
			
			for(int j=0 ; j<m ; j++){
				
				if(i == 0){
					
					System.out.print((char)(A+j));
					
				}else{
					
					System.out.print((char)(A+(Math.abs(i-j))));
				}
			}
			
			System.out.println();
		}
	}
	*/
	/*
	public static void main(String[] args){
		
		for(int i=0 ; i<2 ; i++){
			
			for(int j=0 ; j<2 ; j++){
				
				for(int z=0 ; z<2 ; z++){
					
					for(int x=0 ; x<2 ; x ++){
						
						for(int y=0 ; y<2 ; y++){
							
							System.out.println(""+i+j+z+x+y);
						}
					}
				}
			}
		}
	}
	*/
	/*
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int year = scan.nextInt() ;
		
		scan.close() ;
		
		if(((year%4 == 0) && (year%100 != 0)) || (year%400 == 0)){
		
			System.out.println("yes");
			
		}else{
			
			System.out.println("no");
		}
	}
	*/
	
	
	/*
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		
		int m = scan.nextInt() ;
		
		scan.close(); 
		
		System.out.println(itera(n, m));
		
	}
	
	public static int itera(int n, int m){
		
		if(n == 0) return m;
		
		int num = m * (int)Math.pow((m-1), (n-1)) - itera(n-1, m) ;
		
		return num ;
		
	}
	*/
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in) ;
		
		int n = scan.nextInt() ;
		int Case = 1 ;
		
		while(n != 0){
			//存放传送带各节点坐标
			List<double[]> axis = new ArrayList<double[]>() ;
			
			for(int i=0 ; i < n ; i++){
				
				//获取各节点坐标
				double x = scan.nextDouble() ;
				double y = scan.nextDouble() ;
				
				double[] temp = {x, y} ;
				
				axis.add(temp) ;
			}
			
			double p_x = scan.nextDouble() ;
			double p_y = scan.nextDouble() ;
			
			//顾客的坐标
			double[] p_xy = {p_x, p_y} ;
			
			double V_l = scan.nextDouble() ;
			double V_p = scan.nextDouble() ;
			
			//计算相邻两个节点之间的距离
			double[] singel_dis_l = new double[n] ;
			
			for(int i=0 ; i<n ; i++){
				
				if(i == n-1){
					
					singel_dis_l[i] = comDistance(axis.get(i), axis.get(0)) ;
					
				}else{
					
					singel_dis_l[i] = comDistance(axis.get(i), axis.get(i+1)) ;
					
				}
				
			}
			
			//计算各节点到起始节点的距离，长度为5n，当顾客距离传送带较远时，行李会在传送带上运行多次假设最多5圈
			double[] dis_l = new double[5 * n] ;
			//记录行李到达各节点的时间
			double[] time_l = new double[5 * n] ;
			dis_l[0] = 0 ;
			time_l[0] = 0 ;
			
			for(int i=1 ; i < 5*n ; i ++){
				
				dis_l[i] = dis_l[i-1] + singel_dis_l[(i-1)%n] ;
				
				time_l[i] = dis_l[i]/V_l ;
			}
			
			//计算顾客到达各节点的距离
			double[] dis_p = new double[n] ;
			//记录顾客到达各节点的时间
			double[] time_p = new double[n] ;
			
			for(int i=0 ; i<n ; i++){
				
				dis_p[i] = comDistance(p_xy, axis.get(i)) ;
				
				time_p[i] = dis_p[i]/V_p ;
				
			}
			
			//确定顾客和行哪一段传送带相遇,并计算相遇时间
			
			for(int i=0 ; i<5*n ; i++){
				
				if((time_l[i] < time_p[i%n] && time_l[i+1] > time_p[(i+1)%n])){
					
					double start_time = time_l[i] ;
					
					double end_time = time_l[i+1] ;
					
					double[] start_point = axis.get(i%n) ;
					
					double[] end_point = axis.get((i+1)%n) ;
					
					double[] minPoint = getPoint(axis, p_xy, V_p, start_time, end_time, start_point, end_point, V_l) ;
					
					int next = 0 ;
					
					//判断顾客路线是否穿过传动带
					for(int j=0 ; j<n ; j++){
						
						if(j == n-1){
							
							next = 0 ;
						}else{
							
							next = j + 1 ;
						}
						
						if(isIntersect(axis.get(j), axis.get(next), p_xy, minPoint)){
							
							//顾客先到达节点，然后沿着传送带前进
							double dis_part1 = comDistance(p_xy, end_point) ;
							
							time_part1 = dis_part1/V_p ;
							
							p_xy = end_point ;
							
							start_time = start_time - time_part1 ;
							end_time = end_time - time_part1 ;
							
							getPoint(axis, p_xy, V_p, start_time, end_time, start_point, end_point, V_l) ;
							
						}
						
					}
					
					int min = (int)(time+time_part1) ;
					
					double sec = (time+time_part1 - min) * 60 ;
					
					System.out.println("Case "+Case+": Time = "+min + ":"+String.format("%02.0f",sec));
					
				}
			}
			
			
			n = scan.nextInt() ;	
			
			Case ++ ;
		}
		
		scan.close() ;
		
	}
	
	//计算两点之间的距离
	public static double comDistance(double[] a, double[] b){
		
		double distance = Math.sqrt((Math.pow(a[0]-b[0], 2) + Math.pow(a[1]-b[1], 2))) ;
		
		return distance ;
	}
	
	//判断两条线是否相交
	public static boolean isIntersect(double[] a, double[] b, double[] c, double[] d){
		
		if(max(a[0], b[0]) <= min(c[0], d[0]) || max(a[1], b[1]) <= min(c[1], d[1]) ||
				min(a[0], b[0]) >= max(c[0], d[0]) || min(a[1], b[1]) >= max(c[1], d[1])){
			
			return false ;
		}
		
		//跨立实验
		double u=(c[0]-a[0])*(b[1]-a[1])-(b[0]-a[0])*(c[1]-a[1]);//c.b.a//u的正负表示bc在ab的顺时针方向还是逆时针方向.  
		double v=(d[0]-a[0])*(b[1]-a[1])-(b[0]-a[0])*(d[1]-a[1]);//d.b.a//同理  
		double w=(a[0]-c[0])*(d[1]-c[1])-(d[0]-c[0])*(a[1]-c[1]);//a.d.c  
		double z=(b[0]-c[0])*(d[1]-c[1])-(d[0]-c[0])*(b[1]-c[1]);//b.d.c  
		
		return (u*v<=0.00000001 && w*z<=0.00000001);  
	}
	
	
	//判断两条线段是否共线
	public static boolean isParallel(int[] a, int[] b, int[] c, int[] d){
		
		if((a[0]-b[0]) * (c[1]-d[1]) == (a[1] - b[1]) * (c[0] - d[0])){
			
			return true ;
		}
		
		return false ;
	}
	
	
	//通过二分法获得相遇点坐标
	public static double[] getPoint(List<double[]> axis, double[] p_xy, double v_p,double start_time, double end_time, double[] start_point, double[] end_point, double v_l){
		
		double[] minPoint = getMinPoint(start_point, end_point) ;
		
		//获取顾客到坐标中点的距离
		double dis_p = comDistance(p_xy, minPoint) ;
		//获取顾客到坐标中点的时间
		double time_p = dis_p/v_p ;
		
		//计算行李到坐标中点的时间
		double m_time_l = start_time + comDistance(start_point, minPoint)/v_l ;
		
		if(String.format("%.8f", m_time_l).equals(String.format("%.8f", time_p))){
			
			SearchInt.time = time_p ;
			
			return minPoint ;
			
		}else if(m_time_l > time_p){
			
			end_point = minPoint ;
			
			end_time = m_time_l ;
			
			return getPoint(axis, p_xy, v_p, start_time, end_time, start_point, end_point, v_l) ;
			
		}else{
			
			start_point = minPoint ;
			
			start_time = m_time_l ;
			
			return getPoint(axis, p_xy, v_p, start_time, end_time, start_point, end_point, v_l) ;
			
		}
		
	}
	
	//获得中间点坐标
	public static double[] getMinPoint(double[] a, double[] b){
		
		return new double[]{(a[0]+b[0])/2.0, (a[1]+b[1])/2.0} ;
	}
	
	//求最大值
	public static double max(double a, double b){
		
		return a < b ? b : a ;
	}
	
	//求最小值
	public static double min(double a, double b){
		
		return a < b ? a : b ;
	}
}
