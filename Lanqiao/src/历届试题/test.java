package 历届试题;

import java.util.*;

public class test {

	public static int n;//项目数
	public static int m ;//人数
	
	public static int[] work ; //每个项目的工作量
	public static int[][] effect ; //每个人对每个项目的效率
	public static boolean[] carry ; //记录每个工作是否被开展
	public static int[] time ; //记录每个人的工作时间

   public static void main(String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   
	   int n = in.nextInt() ;
	   int m = in.nextInt() ;
	   
	   work = new int[n] ;
	   carry = new boolean[n] ;
	   effect = new int[m][n] ;
	   time = new int[m] ;
	   
	   for(int i=0 ; i<n ; i++){ //初始化预估工作量
		   
		   work[i] = in.nextInt() ;
	   }
	   
	   for(int i=0 ; i<m ; i++){ //初始化工作效率
		   
		   for(int j=0 ; j<n ; j++){
			   
			   effect[i][j] = in.nextInt() ;
		   }
	   }
	   
	   in.close();
	   
	   for(int i=0 ; i<n ; i++){
		   
		   int max_index = -1 ;
		   int max_e = -1 ;
		   
		   for(int j=0 ; j<m ; j++){
			   
			   if(effect[j][i] > max_e){ //选择效率最高的做当前项目
				   
				   max_e = effect[j][i] ;
				   max_index = j ;
				   
			   }else if(effect[j][i] == max_e){//如果两个人的工作效率相同比较他们的完成时间
				   
				   if(time[j] < time[max_index]){ //当j的总时间小，则j做，否者另外一个人做
					   
					   max_index = j ;
				   }
			   }
		   }
		   
		   carry[i] = true ;
		   time[max_index] += work[i]%max_e != 0 ? work[i]/max_e + 1 : work[i]/max_e;
		   
		   System.out.println(Arrays.toString(time));
	   }
	   
	   
	   int max_time = 0 ;//记录员工的最长工作时间
	   
	   for(int i=0 ; i<time.length ; i++){
		   
		   if(max_time < time[i]){
			   
			   max_time = time[i] ;
		   }
	   }
	   
	   System.out.println(max_time);

    }
}