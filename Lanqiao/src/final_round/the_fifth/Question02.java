package final_round.the_fifth;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月10日 上午9:21:40
 * 
 */
/*
 * 把 1 2 3 ... 19 共19个整数排列成六角形状，如下：

    15 13 *
    * * * *
  -* * * * *-
    * * * * 
     * * *

    要求每个直线上的数字之和必须相等。共有15条直线哦！

    再给点线索吧！我们预先填好了2个数字，第一行的头两个数字是：15 13，参见图【p1.png】，黄色一行为所求。

    请你填写出中间一行的5个数字。数字间用空格分开。

    这是一行用空格分开的整数，请通过浏览器提交答案，不要填写任何多余的内容（比如说明性的文字等）

 */
public class Question02 {
	
	public static boolean[] used = new boolean[20] ;
	
	public static boolean check(int[] num, int step){
		
		if(step >= 7){
			
			int sum = num[0] + num[1] + num[2] ;
			
			if(num[3]+num[4]+num[5]+num[6] != sum)
				
				return false ;
			
		}
		
		if(step >= 8){
			
			int sum = num[0]+num[1]+num[2] ;
			
			if(num[0]+num[3]+num[7] != sum) return false ;
			
		}
		
		if(step >= 12){
			
			int sum = num[0]+num[1]+num[2] ;
			
			if(num[7]+num[8]+num[9]+num[10]+num[11] != sum || num[2]+num[6]+num[11] != sum)
				
				return false ;
		}
		
		if(step >= 13){
			
			int sum = num[0]+num[1]+num[2] ;
			
			if(num[1]+num[4]+num[8]+num[12] != sum) return false ;
			
		}
		
		if(step >=16){
			
			int sum = num[0] + num[1] + num[2] ;
			
			if(num[12]+num[13]+num[14]+num[15] != sum ||num[1]+num[5]+num[10]+num[15] != sum)
				
				return false ;
		}
		
		if(step >= 17){
			
			int sum = num[0]+num[1]+num[2] ;
			
			if(num[2]+num[5]+num[9]+num[13]+num[16] != sum || num[7]+num[12]+num[16] != sum) 
				
				return false ;
			
		}
		
		if(step >= 18){
			
			int sum = num[0]+num[1]+num[2] ;
			
			if(num[3]+num[8]+num[13]+num[17] != sum || num[6]+num[10]+num[14]+num[17] != sum)
				
				return false ;
		}
		
		if(step >= 19){
			
			int sum = num[0]+num[1]+num[2] ;
			
			if(num[16]+num[17]+num[18] != sum || num[11]+num[15]+num[18] != sum
					|| num[0]+num[4]+num[9]+num[14]+num[18] != sum)
				
				return false ;
		}
		
		return true ;
	}

	
	public static void dfs(int[] num, int step){
		
		if(check(num, step)){
			
			if(step == 19){
				
				System.out.println(num[7]+" "+num[8]+" "+num[9]+" "+num[10]+" "+num[11]);
				
			}else{
				
				for(int i=1 ; i<20 ; i++){
					
					if(!used[i]){
						
						used[i] = true ;
						num[step] = i ;
						dfs(num, step+1) ;
						used[i] = false ;
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args){
		
		int[] num = new int[19] ;
		
		num[0] = 15 ;
		num[1] = 13 ;
		
		used[15] = true ;
		used[13] = true ;
		
		dfs(num, 2) ;
	}
}
