package final_round.the_sixth;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月20日 上午10:42:38
 * 
 */
/*
 * 把1~16的数字填入4x4的方格中，使得行、列以

及两个对角线的和都相等，满足这样的特征时称

为：四阶幻方。

四阶幻方可能有很多方案。如果固定左上角为1

，请计算一共有多少种方案。
比如：
  1  2 15 16
 12 14  3  5
 13  7 10  4
  8 11  6  9

以及：
  1 12 13  8
  2 14  7 11
 15  3 10  6
 16  5  4  9
 
就可以算为两种不同的方案。

请提交左上角固定为1时的所有方案数字，
 */
public class Question02 {
	
	public static int[] num = new int[16] ;
	
	public static boolean[] used = new boolean[17] ;//判断该数字是否出现
	
	public static int count ;
	
	public static boolean check(int n){
		
		if(n >= 8){
			
			if(num[0]+num[1]+num[2]+num[3] != num[4]+num[5]+num[6]+num[7])
				
				return false ;
		}
		
		if(n >= 12){
			
			if(num[4]+num[5]+num[6]+num[7] != num[8]+num[9]+num[10]+num[11])
				
				return false ;
		}
		
		if(n >= 13){
			
			if(num[8]+num[9]+num[10]+num[11] != num[3]+num[6]+num[9]+num[12] ||
					num[8]+num[9]+num[10]+num[11] != num[0]+num[4]+num[8]+num[12])
				
				return false ;
		}
		
		if(n >= 14){
			
			if(num[8]+num[9]+num[10]+num[11] != num[1]+num[5]+num[9]+num[13])
				
				return false ;
		}
		
		if(n >= 15){
			
			if(num[8]+num[9]+num[10]+num[11] != num[2]+num[6]+num[10]+num[14])
				
				return false ;
		}
		
		if(n >= 16){
			
			if(num[8]+num[9]+num[10]+num[11] != num[12]+num[13]+num[14]+num[15] ||
					
					num[8]+num[9]+num[10]+num[11] != num[0]+num[5]+num[10]+num[15] ||
					
					num[8]+num[9]+num[10]+num[11] != num[3]+num[7]+num[11]+num[15])
				
				return false ;
		}
		
		return true ;
	}
	
	public static void dfs(int step){
		
		if(!check(step)){
			
			return ;
			
		}
		
		if(step > 15){
			
			if(check(step)){
				
				count ++ ;
				
			}
			
		}else{
			
			for(int i=2 ; i<=16 ; i++){
				
				if(used[i])
					
					continue ;
				
				num[step] = i ;
				used[i] = true ;
				
				dfs(step + 1) ;
				
				used[i] = false ;
				
			}
		}
	}
	
	public static void main(String[] args){
		
		num[0] = 1 ;
		used[1] = true ;
		
		dfs(1) ;
		
		System.out.println(count);
	}
	

}
