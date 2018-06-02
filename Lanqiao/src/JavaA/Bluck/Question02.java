package JavaA.Bluck;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 64621 -- lzcai
 * @time 2018年3月30日 上午8:59:01
 * 
 */
public class Question02 {
	
	public static void main(String[] args){
		
		int max = 0 ;
		
		int[] max_index = new int[3] ;
		
		for(int i=1 ; i<=19 ; i++){
			
			for(int j=1 ; j<70-i ; j++){
				
				int k = 70-i-j ;
				
				int mul = i*k*j ;
				
				if(max<mul){
					
					max = mul ;
					
					max_index[0] = i ;
					max_index[1] = j ;
					max_index[2] = k ;
				}
			}
		}
		
		Arrays.sort(max_index);
		
		for(int num : max_index){
			
			System.out.print(num+",");
		}
		
		System.out.println();
		
		Question03() ;
		
		Question04() ;
		
		Question05() ;
		
		printResult();
		
		Question07() ;
	}
	
	public static void Question03(){
		
		for(int i=1 ; i<9 ; i++){
			
			for(int j=1 ; j<18 ; j++){
				
				for(int k=1 ; k<=36-i-j ; k++){
					
					if(i*400 + j*200 + k*50 == 3600 && i+j+k == 36)
						
						System.out.println(i+","+j+","+k);
				}
			}
		}
	}
	
	public static void Question04(){
		
		int x = 10 ;
		int y = 90 ;
		
		for(int i=1 ; i<=120 ; i++){
			
			if(i%2 == 1) y = y-x ;
			if(i%4 == 0) y = y*2 ;
			if(i%6 == 0) x = x*2 ;
			
		}
		
		System.out.println(y);
	}
	
	public static void Question05(){
		
		ArrayList<Integer> num_list = new ArrayList<Integer>() ;
		
		for(int i=1 ; i<=10000 ; i++){
			
			num_list.add(i) ;
		}
		
		for(int i=1 ; i<=100 ; i++){
			
			for(int j=2 ; j<=13 ; j++){
				
				int num = (int)Math.pow(i, j) ;
				
				if(num<=10000 && num_list.contains(num)) num_list.remove(Integer.valueOf(num)) ;
				
			}
		}
		
		System.out.println(num_list.size());
	}
	
	 public static void printResult() {
	        ArrayList<Long> list = new ArrayList<Long>();
	        for(long i = 1;i <= 10000;i++)
	            list.add(i);
	        int count = 2;
	        while(true) {
	            for(long i = 1;i <= 100;i++) {
	                long a = (long) Math.pow(i, count);
	                if(a > 10000)
	                    break;
	                if(list.contains(a)) {
	                    list.remove(list.indexOf(a));
	                }
	            }
	            count++;
	            if(count > 50)
	                break;
	        }
	        System.out.println(list.size());
	        return;
	    }
	 
	 
	 public static void Question07(){
		 
		 for(int i=10000 ; i<100000 ; i++){
			 
			 for(int j=1 ; j<10 ; j++){
				 
				 int a = i/10000 ;
				 int b = i%10000/1000 ;
				 int c = i%1000/100 ;
				 int d = i%100/10 ;
				 int e = i%10 ;
				 
				 if(a==b || a==c || a==d || a==e || b==c || b==d || b==e || c==d || c==e || d==e) continue ;
				 
				 if(i*j == e*10000+d*1000+c*100+b*10+a){
					 
					 System.out.println("i="+i+", j="+j);
				 }
			 }
		 }
	 }

}
