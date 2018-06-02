package JavaA.the_fifth;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月25日 下午4:22:14
 * 
 * 
 * 此题的关键是建立递推公式 
f[][]初始化全部为0 
f[1][1]=1; 
f[i][j]=(f[i-1][j]*(2*i-2)+f[i-1][j-1])/(2*i-1); 
公式的推导： 
设f[i][j]表示i条绳结成j个圈的概率，c[i]表示i条绳的2i个端点配对的种数，有c[1]=1，c[i]=c[i-1]*(2i-1)， 
于是有f[i][i]=1/c[i]，f[i][1]=f[i-1][1]*c[i-1]*(i-1)*2/c[i]， 
进一步f[i][j]=(f[i-1][j]*c[i-1]*(i-1)*2+f[i-1][j-1]*c[i-1])/c[i]， 
再根据c[i]和c[i-1]的递推关系将c[i]和c[i-1]约去得到上述递推式 
 */
public class Question07 {
	
	public static void main(String[] args){
		
		double[][] dp = new double[101][101] ;
		
		dp[1][1] = 1 ;
		
		for(int j=2 ; j<101 ; j++){
			
			for(int k=1 ; k<101 ; k++){
				
				if(j<k) continue ;
				
				//dp[j][k] = dp[j-1][k] + dp[j-1][k-1] ;
				dp[j][k] = dp[j - 1][k]*(2*j - 2) / (2*j - 1) + dp[j-1][k -1]/(2*j - 1);
				
			}
		}
		
		double max = 0;
		
		int max_I = -1 ;
		
		for(int i=1 ; i<101 ; i++){
			
			//System.out.println(dp[100][i]);
			
			if(max<dp[100][i]){
				
				max = dp[100][i] ;
				
				max_I = i ;
			}
		}
		
		System.out.println(max_I);
		
	}
	
}
