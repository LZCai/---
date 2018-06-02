package final_round.the_seventh;

/**
 * @author 64621 -- lzcai
 * @time 2018年4月21日 下午10:11:31
 * 
 */
public class Question03 {

	 static void move(char[] data, int from, int to)
	    {
	        data[to] = data[from];
	        data[from] = '.';
	    }
	    
	    static boolean valid(char[] data, int k)
	    {
	        if(k<0 || k>=data.length) return false;
	        return true;
	    }
	    
	    static void f(char[] data)
	    {
	        while(true){
	            boolean tag = false;
	            for(int i=0; i<data.length; i++){
	                int dd = 0; // 移动方向
	                if(data[i]=='.') continue;
	                if(data[i]=='A') dd = 1;
	                if(data[i]=='B') dd = -1;
	                
	                if(valid(data, i+dd) && valid(data,i+dd+dd) 
	                && data[i+dd]!=data[i] && data[i+dd+dd]=='.'){ 
	                // 如果能跳...
	                    move(data, i, i+dd+dd);
	                    System.out.println(1 +" "+new String(data));
	                    tag = true;
	                    break;
	                }
	            }
	            
	            if(tag) continue;
	            
	            for(int i=0; i<data.length; i++){
	                int dd = 0; // `移动方向
	                if(data[i]=='.') continue;
	                if(data[i]=='A') dd = 1;
	                if(data[i]=='B') dd = -1;            
	                     
	                if(valid(data, i+dd) && data[i+dd]=='.'){ 
	                // 如果能移动...
	                    //if( valid(data,i+dd+dd) && valid(data, i-dd) &&  ) continue;  //填空位置
	                    move(data, i, i+dd);
	                    System.out.println(2 +" "+new String(data));
	                    tag = true;
	                    break;
	                }
	            }
	            
	            if(tag==false) break;                    
	        }
	    }
	    
	    public static void main(String[] args)
	    {
	        char[] data = "AAA.BBB".toCharArray();    
	        f(data);
	    }
}
