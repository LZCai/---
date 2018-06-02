package JavaA.the_seventh;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月27日 下午3:23:00
 * 
 */
public class Question05 {
	
	public static int count ;
	
	public static void f(int[] a, int k, int n, String s)
    {
        if(k==a.length){ 
            if(n==0) {
            	
            	System.out.println(s);
            	
            	count ++ ;
            }
            
          
            return;
        }
        
        String s2 = s;
        for(int i=0; i<=a[k]; i++){
        	
            f(a, k+1, n-i, s2);//填空位置
            
            s2 += (char)(k+'A');
        }
        
    }
    
    public static void main(String[] args)
    {
        int[] a = {4,2,2,1,1,3};
        
        f(a,0,5,"");
        
        System.out.println(count);
    }

}
