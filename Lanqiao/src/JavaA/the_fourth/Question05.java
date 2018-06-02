package JavaA.the_fourth;

import java.util.Arrays;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月23日 下午8:57:53
 * 
 */
public class Question05 {
	
	public static void main(String[] args){
		
		int[] x = {25,18,-2,0,16,-5,33,21,0,19,-16,25,-3,0} ;
		
		sort(x) ;
		
		System.out.println(Arrays.toString(x));
		
	}

	public static void sort(int[] x)
	    {
	        int p = 0;
	        int left = 0;
	        int right = x.length-1;
	        
	        while(p<=right){
	            if(x[p]<0){
	                int t = x[left];
	                x[left] = x[p];
	                x[p] = t;
	                left++;
	                p++;
	            }
	            else if(x[p]>0){
	                int t = x[right];
	                x[right] = x[p];
	                x[p] = t;
	                right--;            
	            }
	            else{
	                 p++ ; //代码填空位置
	            }
	        }
	    }
}
