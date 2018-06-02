package final_round.the_fifth;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月10日 上午8:58:26
 * 
 */
/*
 * 有5个海盗，相约进行一次帆船比赛。

    比赛中天气发生突变，他们被冲散了。

    恰巧，他们都先后经过途中的一个无名的荒岛，并且每个人都信心满满，觉得自己是第一个经过该岛的人。

    第一个人在沙滩上发现了一堆金币。他把金币分成5等份。发现刚好少一个金币。他就从自己口袋拿出一个金币补充进去，然后把属于自己的那份拿走。

    第二个到达的人也看到了金币，他也和第一个人一样，把所有金币5等分，发现刚好缺少一个金币，于是自己补进去一个，拿走了属于自己的那份。

    第三，第四，第五人的情况一模一样。

    等他们到了目的地，都说自己的情况，才恍然大悟，一起去荒岛找金币，然而再也没有找到荒岛。他们都惋惜地说：岛上还有一千多枚金币呢！
    
    请你根据这些信息，推算荒岛上最初有多少金币？
 */

public class Question01 {
	
	public static void main(String[] args){
		
		double rate = 5./4 ;
		
		for(int i=1000 ; i<2000 ; i++){
			
			double total = (i-4)*Math.pow(rate, 5) + 4 ;
			
			
			if(total == (int)total){
				
				System.out.println(total);
				
				System.out.println(i);
			}
			
		}
		
	}

}
